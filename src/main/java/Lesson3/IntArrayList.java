package Lesson3;

import java.util.Arrays;

public class IntArrayList implements IntList {
    private static final int DEFAULT_CAPACITY = 10;


    private int[] arr = new int[DEFAULT_CAPACITY];
    private int size = 0;

    @Override
    public void add(int element) {
        if (size >= arr.length) {
            int newSize = arr.length * 3 / 2 + 1;
            int[] newArr = new int[newSize];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
        arr[size] = element;
        size++;
    }

    @Override
    public boolean add(int index, int element) {
        int[] newArr = new int[size + 1];
        if (index >= 0) System.arraycopy(arr, 0, newArr, 0, index);
        for (int i = newArr.length - 1; i >= index; i--) {
            if (i == index) {
                newArr[index] = element;
                arr = newArr;
                size++;
                return true;
            }
            newArr[i] = arr[i - 1];
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(arr, 0);
        size = 0;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        int[] newArr = new int[size - 1];
        if (index >= 0) System.arraycopy(arr, 0, newArr, 0, index);
        for (int i = newArr.length - 1; i >= index; i--) {
            if (i == index) {
                newArr[index] = arr[index + 1];
                arr = newArr;
                size--;
                return true;
            }
            newArr[i] = arr[i + 1];
        }

        return false;
    }

    @Override
    public boolean removeByValue(int value) {
        int[] newArr = new int[size - 1];
        int indexOfSearchingElement = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == value) {
                indexOfSearchingElement = i;
                break;
            }
        }
        System.arraycopy(arr, 0, newArr, 0, indexOfSearchingElement);
        for (int i = newArr.length - 1; i >= indexOfSearchingElement; i--) {
            if (i == indexOfSearchingElement) {
                newArr[indexOfSearchingElement] = arr[indexOfSearchingElement + 1];
                arr = newArr;
                size--;
                return true;
            }
            newArr[i] = arr[i + 1];
        }
        return false;
    }

    @Override
    public boolean set(int index, int element) {
        for (int i = 0; i < arr.length-1; i++) {
            if(i == index){
                arr[i] = element;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return "IntArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}
