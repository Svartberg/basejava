package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> list = new ArrayList<>();


    @Override
    protected Integer getSearchID(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doSave(Resume r, Object searchID) {
        list.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Object searchID) {
        list.set((Integer) searchID,r);

    }

    @Override
    protected boolean isExist(Object searchID) {
        return searchID != null;
    }

    @Override
    protected void doDelete(Object searchKey) {
        //Поиск не по Object а по int;
        list.remove(((Integer) searchKey).intValue());
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return list.get((Integer) searchKey);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(list);
    }

    @Override
    public int size() {
        return list.size();
    }
}
