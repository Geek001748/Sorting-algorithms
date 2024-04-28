import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        sortingAlgorithmsImplementation();
    }

    public static void sortingAlgorithmsImplementation() {
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        System.out.println("Hello, if you want to see implementation of different sorting algorithms:");
        do {
            options();
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    go = false;
                    break;
                case 1:
                    System.out.println("==================================Bubble Sort==================================");
                    int[] array = Sorting.initArr(sc);
                    int size = array.length;
                    System.out.println("==================================Original Array==================================");
                    Sorting.printArray(array, size);

                    double startTime = System.nanoTime();
                    Sorting.bubbleSorting(array, size);
                    double endTime = System.nanoTime();
                    double duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds

                    System.out.println("==================================Sorted Array==================================");
                    Sorting.printArray(array, size);
                    System.out.println("Time taken: " + duration + " milliseconds");
                    Sorting.clearArray(array);
                    break;
                case 2:
                    System.out.println("==================================Heap Sort==================================");
                    array = Sorting.initArr(sc);
                    size = array.length;
                    System.out.println("==================================Original Array==================================");
                    Sorting.printArray(array, size);

                    startTime = System.nanoTime();
                    Sorting.heapSorting(array, size);
                    endTime = System.nanoTime();
                    duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds

                    System.out.println("==================================Sorted Array==================================");
                    Sorting.printArray(array, size);
                    System.out.println("Time taken: " + duration + " milliseconds");
                    break;
                case 3:
                    System.out.println("==================================Merge Sort==================================");
                    array = Sorting.initArr(sc);
                    size = array.length;
                    System.out.println("==================================Original Array==================================");
                    Sorting.printArray(array, size);

                    startTime = System.nanoTime();
                    Sorting.mergeSorting(array, size);
                    endTime = System.nanoTime();
                    duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds

                    System.out.println("==================================Sorted Array==================================");
                    Sorting.printArray(array, size);
                    System.out.println("Time taken: " + duration + " milliseconds");
                    break;
                case 4:
                    System.out.println("==================================Quick Sort==================================");
                    array = Sorting.initArr(sc);
                    size = array.length;
                    System.out.println("==================================Original Array==================================");
                    Sorting.printArray(array, size);

                    startTime = System.nanoTime();
                    Sorting.quickSorting(array, size);
                    endTime = System.nanoTime();
                    duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds

                    System.out.println("==================================Sorted Array==================================");
                    Sorting.printArray(array, size);
                    System.out.println("Time taken: " + duration + " milliseconds");
                    break;
            }
        } while (go == true);
        sc.close();
    }

    public static void options() {
        System.out.println("Enter your choice:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Heap Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Quick Sort");
        System.out.println("0. Exit");
    }

}
