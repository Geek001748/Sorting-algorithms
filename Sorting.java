import java.util.Scanner;

public class Sorting {
    public static void printArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] initArr(Scanner sc) {
        System.out.println("How many elements will be in your array:");
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Write " + i + " element of array");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static void clearArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0; // Or any default value you want
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void bubbleSorting(int[] array, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void heapify(int[] array, int size, int i) {
        int largest = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if ((l < size) && array[largest] < array[l]) largest = l;
        if ((r < size) && array[largest] < array[r]) largest = r;

        if (largest != i) {
            swap(array, i, largest);

            heapify(array, size, largest);

        }
    }

    public static void heapSorting(int[] array, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, size, 0);
        }
    }

    public static void mergeSorting(int[] array, int size) {
        sort(array, 0, size - 1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            sort(array, start, middle);
            sort(array, middle + 1, end);

            merge(array, start, end, middle);
        }
    }

    public static void merge(int[] array, int start, int end, int middle) {
        int firstHalf = middle - start + 1;
        int secondHalf = end - middle;

        int[] a = new int[firstHalf];
        int[] b = new int[secondHalf];

        for (int i = 0; i < firstHalf; i++) {
            a[i] = array[start + i];
        }
        for (int j = 0; j < secondHalf; j++) {
            b[j] = array[middle + 1 + j];
        }
        int i = 0, j = 0;
        int k = start;
        while (i < firstHalf && j < secondHalf) {
            if (a[i] <= b[j]) {
                array[k] = a[i];
                i++;
            } else {
                array[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < firstHalf) {
            array[k] = a[i];
            i++;
            k++;
        }
        while (j < secondHalf) {
            array[k] = b[j];
            j++;
            k++;
        }
    }
    public static void quickSorting(int[] array, int size) {
        sort(array, 0, size - 1);
    }
}
