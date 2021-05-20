/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int lastResumePosition;

    void clear() {
        for (int i = 0; i < lastResumePosition; i++) {
            storage[i] = null;
        }
        lastResumePosition = 0;
    }

    void save(Resume r) {
        if (lastResumePosition < storage.length) {
            storage[lastResumePosition] = r;
            lastResumePosition++;
        }
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < lastResumePosition; i++) {
            if (storage[i].toString().equals(uuid))
                resume = storage[i];
        }
        return resume;
    }

    void delete(String uuid) {
        for (int i = 0; i < lastResumePosition; i++) {
            if (storage[i].toString().equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, lastResumePosition - i);
                storage[lastResumePosition] = null;
                lastResumePosition--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storageCopy = new Resume[lastResumePosition];
        System.arraycopy(storage, 0, storageCopy, 0, lastResumePosition);
        return storageCopy;
    }

    int size() {
        return lastResumePosition;
    }
}
