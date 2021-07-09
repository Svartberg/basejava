package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

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
    protected void doSave(Resume r, Integer searchID) {
        list.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Integer searchID) {
        list.set(searchID,r);

    }

    @Override
    protected boolean isExist(Integer searchID) {
        return searchID != null;
    }

    @Override
    protected void doDelete(Integer searchKey) {
        //Поиск не по Integer а по int;
        list.remove((searchKey).intValue());
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return list.get(searchKey);
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
