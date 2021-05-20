/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int storageLastValue = 0;

    void clear() {
        for (int i = 0; i < storageLastValue; i++) {
            storage[i] = null;
        }
        storageLastValue = 0;
    }

    void save(Resume r) {
        if (storageLastValue < 10000) {
            storage[storageLastValue] = r;
            storageLastValue++;
        }
    }

    Resume get(String uuid) {
        Resume getReturn = null;
        for (int i = 0; i < storageLastValue; i++) {
            if (storage[i].toString().equals(uuid))
                getReturn = storage[i];
        }
        return getReturn;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageLastValue; i++) {
            if (storage[i].toString().equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, storageLastValue - i);
                storage[storageLastValue] = null;
                storageLastValue--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storageCopy = new Resume[storageLastValue];
        System.arraycopy(storage, 0, storageCopy, 0, storageLastValue);
        return storageCopy;
    }

    int size() {
        return storageLastValue;
    }
}
