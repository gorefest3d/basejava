import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i <= size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        int storageIndex = 0;
        for (int i = 0; i < size(); i++) {
            //storageIndex = storage[i].uuid.equals(uuid) ? i : 2;
            if (storage[i].uuid.equals(uuid)) {
                storageIndex = i;
            }
        }
        return storage[storageIndex];
    }

    void delete(String uuid) {
       int indexDelete = 0;
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                indexDelete = i;
            }
        }
        for (int i = indexDelete + 1; i <= size(); i++) {
            storage[i - 1] = storage[i];
            storage[i] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                size++;
            }
        }
        return size;
    }
}
