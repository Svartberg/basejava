package com.urise.webapp.storage;


import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

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
    public void doUpdate(Resume r, Integer index) {
        storage[index] = r;
    }

    @Override
    public void doSave(Resume r, Integer index) {
        if (lastResumePosition == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertResume(r, index);
            lastResumePosition++;
        }
    }

    @Override
    public void doDelete(Integer index) {
        deleteResume(index);
        storage[lastResumePosition] = null;
        lastResumePosition--;
    }

    @Override
    public Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, lastResumePosition));
    }

    protected abstract void insertResume(Resume r, int index);

    protected abstract void  deleteResume(int index);

    protected abstract Integer getSearchID(String uuid);
}
