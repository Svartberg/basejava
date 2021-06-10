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
        System.arraycopy(storage, index + 1, storage, index, lastResumePosition - index);
    }

    @Override
    protected Integer getSearchID(String uuid) {
        for (int i = 0; i < lastResumePosition; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        //Возвращает значение из кэша, не создавая новый объект;
        return Integer.valueOf(-1);
    }
}