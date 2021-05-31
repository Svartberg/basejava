package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int lastResumePosition;

    public int size() {
        return lastResumePosition;
    }

    public void clear() {
        Arrays.fill(storage, 0, lastResumePosition, null);
        lastResumePosition = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (getIndex(r.getUuid()) >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else if (lastResumePosition == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertResume(r, index);
            lastResumePosition++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(index);
            storage[lastResumePosition] = null;
            lastResumePosition--;
        }
    }
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, lastResumePosition);
    }

    protected abstract void insertResume(Resume r, int index);

    protected abstract void  deleteResume(int index);

    protected abstract int getIndex(String uuid);
}
