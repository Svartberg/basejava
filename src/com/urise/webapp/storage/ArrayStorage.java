package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int lastResumePosition;

    private int getIndex(String uuid) {
        for (int i = 0; i < lastResumePosition; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < lastResumePosition; i++) {
            storage[i] = null;
        }
        lastResumePosition = 0;
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exists;");
        } else if (lastResumePosition >= storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[lastResumePosition] = r;
            lastResumePosition++;
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not found;");
        } else {
            storage[index] = r;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not found;");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not found;");
        } else {
            System.arraycopy(storage, index + 1, storage, index, lastResumePosition - index);
            storage[lastResumePosition] = null;
            lastResumePosition--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] storageCopy = new Resume[lastResumePosition];
        System.arraycopy(storage, 0, storageCopy, 0, lastResumePosition);
        return storageCopy;
    }

    public int size() {
        return lastResumePosition;
    }
}
