public class CustomArrayList<T extends Comparable<T>>
        implements CustomList<T> {

    private Object[] array;
    private int arraySize;
    private int arrayCapacity;
    private final int DEFAULT_INITIAL_CAPACITY = 10;
    private final int CAPACITY_INCREASE_MULTIPLIER = 2;

    public CustomArrayList() {
        this.arrayCapacity = DEFAULT_INITIAL_CAPACITY;
        this.array = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public CustomArrayList(int arrayCapacity) {
        if (arrayCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity <= 0: " + arrayCapacity);
        }
        this.arrayCapacity = arrayCapacity;
        this.array = new Object[arrayCapacity];
    }

    private boolean isArrayCapacityFilled() {
        return this.arrayCapacity == this.arraySize;
    }

    private boolean isArrayIndexOutOfBounds(int index) {
        return index < 0 || index > this.arraySize;
    }

    private void increaseArrayCapacity() {
        Object[] resizedArray = new Object[arrayCapacity * CAPACITY_INCREASE_MULTIPLIER];
        System.arraycopy(array, 0, resizedArray, 0, arrayCapacity);
        array = resizedArray;
    }
    
    @Override
    public void add(T value) {
        if (isArrayCapacityFilled()) {
            increaseArrayCapacity();
        }
        array[arraySize] = value;
        arraySize++;
    }

    @Override
    public void add(T value, int index) {
        if (isArrayIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (isArrayCapacityFilled()) {
            increaseArrayCapacity();
        }
        System.arraycopy(array, index, array, index + 1, arraySize - index);
        array[index] = value;
        arraySize++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (isArrayIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (T) array[index];
    }

    @Override
    public void remove(T value) {
        for (int i = 0; i < arraySize; i++) {
            if (this.array[i].equals(value)) {
                this.remove(i);
                return;
            }
        }
    }

    public void remove(int index) {
        if (isArrayIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        int movedElementsQuantity = this.arraySize - index - 1;
        if (movedElementsQuantity > 0) {
            System.arraycopy(this.array, index + 1, this.array, index, movedElementsQuantity);
        }
        this.array[arraySize - 1] = null;
        arraySize--;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.arraySize; i++) {
            this.array[i] = null;
        }
        this.arraySize = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        for (int i = 1; i < arraySize - 1; i++) {
            for (int j = i; j > 0; j--) {
                if (((T) array[j - 1]).compareTo((T) array[j]) > 0) {
                    T tmp = (T) array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arraySize; i++) {
            sb.append("Object ");
            sb.append(i);
            sb.append(" : ");
            sb.append(array[i].toString());
            sb.append(" \n");
        }
        return sb.toString();
    }
}
