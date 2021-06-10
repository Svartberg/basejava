package com.urise.webapp.storage;


import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 1000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int lastResumePosition;

    public int size() {
        return lastResumePosition;
    }

    public void clear() {
        Arrays.fill(storage, 0, lastResumePosition, null);
        lastResumePosition = 0;
    }

    @Override
    public void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

    @Override
    public void doSave(Resume r, Object index) {
        if (lastResumePosition == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertResume(r, (Integer) index);
            lastResumePosition++;
        }
    }

    @Override
    public void doDelete(Object index) {
        deleteResume((Integer) index);
        storage[lastResumePosition] = null;
        lastResumePosition--;
    }

    @Override
    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, lastResumePosition);
    }

    protected abstract void insertResume(Resume r, int index);

    protected abstract void  deleteResume(int index);

    protected abstract Integer getSearchID(String uuid);
}
