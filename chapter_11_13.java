//contains answers for both chapter 11 exercises 12 and 13. 
//binary search and merge sort are implemented to use strings 
//rather than integers.

import java.util.Arrays;
import java.util.Random;

public class chapter_11_13 {
    // Main driver function
    public static void main(String[] args) {
        // Creates new random number generator, fills array with random strings
        Random rand = new Random();
        String[] array = new String[100];

        System.out.print("Unsorted array is: ");
        for (int i = 0; i < 100; i++) {
            array[i] = generateRandomString(rand);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println();

        // Array is sorted using mergesort algorithm in ascending order
        array = mergeSort(array);

        System.out.print("Sorted array is: ");
        for (int i = 0; i < 100; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println();

        // Selects a random element from the unsorted array to target with binary search
        String target = array[rand.nextInt(array.length)];
        System.out.println("Target is: " + target);
        System.out.println();

        // Calls binary search on the sorted array
        int acquiredTarget = binarySearch(array, target);

        if (acquiredTarget != -1) {
            System.out.println(array[acquiredTarget] + " is found at index: " + acquiredTarget);
        } else {
            System.out.println("Target not found.");
        }
    }

    // Implements binary search algorithm for strings
    public static int binarySearch(String[] arr, String target) {
        int first = 0;
        int last = arr.length - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            int comparison = target.compareTo(arr[mid]);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        return -1; // Not found
    }

    // Implements merge sort algorithm for strings
    public static String[] mergeSort(String[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int half1 = arr.length / 2;
        String[] sub1 = Arrays.copyOfRange(arr, 0, half1);
        String[] sub2 = Arrays.copyOfRange(arr, half1, arr.length);

        sub1 = mergeSort(sub1);
        sub2 = mergeSort(sub2);

        return merge(sub1, sub2);
    }

    // Accessory function to merge two sorted arrays of strings
    public static String[] merge(String[] sub1, String[] sub2) {
        String[] array = new String[sub1.length + sub2.length];
        int i1 = 0, i2 = 0;

        for (int i = 0; i < array.length; i++) {
            if (i1 < sub1.length && i2 < sub2.length) {
                if (sub1[i1].compareTo(sub2[i2]) <= 0) {
                    array[i] = sub1[i1];
                    i1++;
                } else {
                    array[i] = sub2[i2];
                    i2++;
                }
            } else {
                if (i1 < sub1.length) {
                    array[i] = sub1[i1];
                    i1++;
                } else {
                    array[i] = sub2[i2];
                    i2++;
                }
            }
        }
        return array;
    }

    // Generates a random string of length 5
    public static String generateRandomString(Random rand) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char c = (char) (rand.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }
}
