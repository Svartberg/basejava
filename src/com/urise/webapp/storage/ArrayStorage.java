package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertResume(Resume r, int index) {
        storage[lastResumePosition] = r;
    }

    @Override
    protected void deleteResume(int index) {
        storage[index] = storage[lastResumePosition-1];
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < lastResumePosition; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
