//program uses mergeSort, binarySearch to first order and then 
//search the array for a given target value.

//file chapter_11_13.java contains my implementation of this same program but 
//using strings instead of integers, with both binarysearch and mergesort algorithms.

import java.util.Random;

public class chapter_11_12 {
    //main driver function
    public static void main(String[] args) {
        
        //creates new random number generator, fills array with random numbers between 0 and 100
        Random rand = new Random();
        int array[] = new int[100];

        System.out.print("Unsorted array is: ");
        for(int i = 0; i < 100; i++) {
            array[i] = rand.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println();



        //array is sorted using mergesort algorithm in ascending order
        array = mergeSort(array);

        System.out.print("Sorted array is: ");
        for(int i = 0; i < 100; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println();


        //selects a random element from the unsorted array to target with binary search
        int target = array[rand.nextInt(array.length)];
        System.out.println("target is: " + target);
        System.out.println();
        //calls binary search on the sorted array
        int acquiredTarget = binarySearch(array, 0, (array.length - 1), target);

        System.out.println(array[acquiredTarget] + " is found at index: " + acquiredTarget);
        
    }


    //implements binary search algorithm
    public static int binarySearch(int[] arr, int first, int last, int target) {
        int mid;
        int index;

        System.out.printf(" first=%d, last=%d,", first, last);
        if(first == last) {
            if(arr[first] == target) {
                index = first;
                System.out.println("target acquired");
            } else {
                index = -1;
                System.out.println("target lost");
            }
        }
        else {
            mid = (first + last) / 2;
            if(target > arr[mid]) {
                first = mid + 1;
            }  else {
                last = mid;
            }
            index = binarySearch(arr, first, last, target);
        }
        return index;
    }

    //implements merge sort algorithm
    public static int[] mergeSort(int[] arr) {
        int half1 = arr.length / 2;
        int half2 = arr.length - half1;
        int[] sub1 = new int[half1];
        int[] sub2 = new int[half2];

        if(arr.length <= 1) {
            return arr;
        }
        else {
            System.arraycopy(arr, 0, sub1, 0, half1);
            System.arraycopy(arr, half1, sub2, 0, half2);

            sub1 = mergeSort(sub1);
            sub2 = mergeSort(sub2);
            arr = merge(sub1, sub2);
            return arr;
        }
    }

    // accessory function to merge two sorted arrays
    public static int[] merge(int[] sub1, int[] sub2) {
        int[] array = new int[sub1.length + sub2.length];
        int i1 = 0, i2 = 0;

        for(int i = 0; i < array.length; i++) {
            if (i1 < sub1.length && i2 < sub2.length) {
                if(sub1[i1] <= sub2[i2]) {
                    array[i] = sub1[i1];
                    i1++;
                } else {
                    array[i] = sub2[i2];
                    i2++;
                }
            }
            else {
                if(i1 < sub1.length) {
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
}