import java.util.Scanner;

public class Sorting {
    /**
     * Prints the elements of an array up to the specified size.
     *
     * @param array The array whose elements are to be printed.
     * @param size  The number of elements from the array to print.
     */
    public static void printArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Initializes an array with elements input by the user.
     *
     * @param sc The Scanner object to read input from the console.
     * @return The initialized array filled with user input.
     */
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

    /**
     * Clears the given array by setting all elements to zero.
     *
     * @param arr The array to be cleared.
     */
    public static void clearArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0; // Or any default value you want
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param array  The array where elements will be swapped.
     * @param index1 The index of the first element to swap.
     * @param index2 The index of the second element to swap.
     */
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Sorts an array using the bubble sort algorithm.
     * Time Complexity: O(n^2) in all cases.
     * Memory Complexity: O(1) - in-place sorting.
     *
     * @param array The array to be sorted.
     * @param size  The size of the array.
     */
    public static void bubbleSorting(int[] array, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * Reorganizes a subtree rooted at index i into a max heap. This method assumes that
     * the binary trees rooted at left child 2i + 1 and right child 2i + 2 are max heaps,
     * but the element at i might be smaller than its children, violating the max heap property.
     * This method corrects the violation by "floating down" the element at i as needed, so the subtree
     * rooted at i satisfies the max heap property.
     *
     * @param array The array representing the heap.
     * @param size  The number of elements in the heap that are being sorted. This can be less than
     *              or equal to the length of the array, allowing for efficient in-place sorting.
     * @param i     The index of the root of the subtree to be heapified.
     */
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

    /**
     * Builds a heap from an array and sorts it using the heap sort algorithm.
     * Time Complexity: O(n log n) for all cases.
     * Memory Complexity: O(1) - in-place sorting.
     *
     * @param array The array to be sorted.
     * @param size  The size of the array.
     */
    public static void heapSorting(int[] array, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, size, 0);
        }
    }

    /**
     * Sorts an array using the merge sort algorithm.
     * Time Complexity: O(n log n) for all cases.
     * Memory Complexity: O(n) - requires additional space proportional to the size of the array.
     *
     * @param array The array to be sorted.
     * @param size  The size of the array.
     */
    public static void mergeSorting(int[] array, int size) {
        mergeSort(array, 0, size - 1);
    }

    /**
     * Recursively divides and merges an array to sort it.
     *
     * @param array The array to sort.
     * @param start The starting index of the segment of the array to be sorted.
     * @param end   The ending index of the segment of the array to be sorted.
     */
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);

            merge(array, start, end, middle);
        }
    }

    /**
     * Merges two halves of an array into a single sorted segment.
     *
     * @param array  The original array containing both halves.
     * @param start  The starting index of the first half.
     * @param end    The ending index of the segment of the array to be merged.
     * @param middle The middle index that divides the array segment into two halves.
     */
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

    /**
     * Sorts an array using the quick sort algorithm.
     * Time Complexity: O(n log n) on average, O(n^2) in the worst case.
     * Memory Complexity: O(log n) - recursive stack space in the best and average case, O(n) in the worst case.
     *
     * @param array The array to be sorted.
     * @param size  The size of the array.
     */
    public static void quickSorting(int[] array, int size) {
        quickSort(array, 0, size - 1);
    }

    /**
     * Recursively sorts an array using the quick sort method by partitioning the array around a pivot.
     *
     * @param array The array to be sorted.
     * @param start The starting index of the segment to be sorted.
     * @param end   The ending index of the segment to be sorted.
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pi = partition(array, start, end);
            quickSort(array, start, pi - 1);
            quickSort(array, pi + 1, end);
        }
    }

    /**
     * Partitions the array into two parts around a pivot, with smaller elements on the left and larger on the right.
     *
     * @param array The array to be partitioned.
     * @param start The starting index for the partition.
     * @param end   The ending index for the partition.
     * @return The index position of the pivot element after partitioning.
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, j, i);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }
}

