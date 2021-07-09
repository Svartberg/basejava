package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getSearchID(String uuid);

    protected abstract void doSave(Resume r, SK searchID);

    protected abstract void doUpdate(Resume r, SK searchID);

    protected abstract boolean isExist(SK searchID);

    protected abstract void doDelete(SK searchKey);

    protected abstract List<Resume> doCopyAll();

    protected abstract Resume doGet(SK searchKey);

    private SK getExistID(String uuid) {
        SK searchID = getSearchID(uuid);
        if (!isExist(searchID)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchID;
    }

    private SK getNotExistID(String uuid) {
        SK searchID = getSearchID(uuid);
        if (isExist(searchID)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchID;
    }

    public void update(Resume r) {
        LOG.info("Update " + r);
        SK searchKey = getExistID(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        LOG.info("Save " + r);
        SK searchKey = getNotExistID(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getExistID(uuid);
        doDelete(searchKey);

    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistID(uuid);
        return doGet(searchKey);
    }
}
