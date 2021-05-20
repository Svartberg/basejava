/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;
    int storageLastValue = 0;

    void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
        storageSize = 0;
        storageLastValue = 0;
    }

    void save(Resume r) {
        storageSize++;
        if (storageSize < 10000) {
            storage[storageLastValue] = r;
            storageLastValue++;
        }
    }

    Resume get(String uuid) {
        Resume getReturn = null;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().equals(uuid))
                getReturn = storage[i];
        }
        return getReturn;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().equals(uuid)) {
                if (storageSize - i >= 0) {
                    System.arraycopy(storage, i + 1, storage, i, storageSize - i);
                    break;
                }
            }
        }
        storage[storageLastValue] = null;
        storageSize--;
        storageLastValue--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] getStorage = new Resume[storageSize];
        System.arraycopy(storage, 0, getStorage, 0, storageSize);
        return getStorage;
    }

    int size() {
        return storageSize;
    }
}
