package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapStorage extends AbstractStorage {
    @Override
    protected Object getSearchID(String uuid) {
        return null;
    }

    @Override
    protected void doSave(Resume r, Object searchID) {

    }

    @Override
    protected void doUpdate(Resume r, Object searchID) {

    }

    @Override
    protected boolean isExist(Object searchID) {
        return false;
    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
