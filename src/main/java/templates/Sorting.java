package templates;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Sorting {

    // Sort two arrays - Sorting both arrays based on the first array's values
    private void sortBothArraysBasedOnFirstArray(int[] arr1, int[] arr2) {
        int[][] temp = new int[arr1.length][2];
        for(int i = 0; i < arr1.length; i++)
            temp[i] = new int[] {arr1[i], arr2[i]};

//        Sort2D.sort2D_type3(temp, 0); // Ascending order
        Arrays.sort(temp, Comparator.comparingInt(a -> a[0])); // Ascending order

        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = temp[i][0];
            arr2[i] = temp[i][1];
        }
    }

    // Sorting three arrays based on the first array's values
    // Tested in - https://leetcode.com/problems/maximum-profit-in-job-scheduling/submissions/1138475857?envType=daily-question&envId=2024-01-06
    private void sortThreeArraysBasedOnFirstArray(int[] arr1, int[] arr2, int[] arr3) {
        int[][] temp = new int[arr1.length][2];
        for(int i = 0; i < arr1.length; i++)
            temp[i] = new int[] {arr1[i], arr2[i], arr3[i]};

        Arrays.sort(temp, Comparator.comparingInt(a -> a[0])); // Ascending order

        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = temp[i][0];
            arr2[i] = temp[i][1];
            arr3[i] = temp[i][2];
        }
    }


    public class Sort2D {

        // Sort 2D array - in ascending order based on the (index+1)th element of the array.
        public void sort2D_type1(int[][] arr, int index) {
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[index] - b[index];
                }
            });
        }

        // Sort 2D array - in ascending order based on the (index+1)th element of the array.
        public void sort2D_type2(int[][] arr, int index) {
            Arrays.sort(arr, (a, b) -> a[index] - b[index]);
        }

        // Sort 2D array - in ascending order based on the (index+1)th element of the array.
        public void sort2D_type3(int[][] arr, int index) {
            Arrays.sort(arr, Comparator.comparingInt(a -> a[index]));
        }

    }

    // https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    // Shuffle an array randomly
    // Implementing Fisher–Yates shuffle
    private static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}
