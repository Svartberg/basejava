package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected  static final int STORAGE_LIMIT = 100000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected  int lastResumePosition;

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
            System.out.println("Resume " + r.getUuid() + " not found;");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exists;");
        } else if (lastResumePosition >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            insertResume(r, index);
            lastResumePosition++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not found;");
        } else {
            deleteResume(index);
            storage[lastResumePosition] = null;
            lastResumePosition--;
        }
    }
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not found;");
            return null;
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
