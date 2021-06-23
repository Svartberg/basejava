package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchID(String uuid);

    protected abstract void doSave(Resume r, Object searchID);

    protected abstract void doUpdate(Resume r, Object searchID);

    protected abstract boolean isExist(Object searchID);

    protected abstract void doDelete(Object searchKey);

    protected abstract List<Resume> doCopyAll();

    protected abstract Resume doGet(Object searchKey);

    private Object getExistID(String uuid) {
        Object searchID = getSearchID(uuid);
        if (!isExist(searchID)) {
            throw new NotExistStorageException(uuid);
        }
        return searchID;
    }

    private Object getNotExistID(String uuid) {
        Object searchID = getSearchID(uuid);
        if (isExist(searchID)) {
            throw new ExistStorageException(uuid);
        }
        return searchID;
    }

    public void update(Resume r) {
        Object searchKey = getExistID(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        Object searchKey = getNotExistID(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistID(uuid);
        doDelete(searchKey);

    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }

    public Resume get(String uuid) {
        Object searchKey = getExistID(uuid);
        return doGet(searchKey);
    }
}
