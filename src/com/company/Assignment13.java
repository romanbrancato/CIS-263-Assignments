package com.company;

import java.util.Arrays;

class Partition {

    // FOLLOWING CODE WAS REFERENCED FROM: https://www.geeksforgeeks.org/partition-problem-dp-18/
    // Returns true if the array can be partitioned into two subsets of equal sum, else false
    public static boolean findPartition(int[] array, int numElements) {
        int sum = 0;
        int i;
        int j;

        // Sum all elements in array
        for(i = 0; i < numElements; i++) {
            sum += array[i];
        }

        // If sum is odd, then an equal partition is not possible, return false
        if(sum % 2 != 0) {
            return false;
        }

        boolean[] partition = new boolean[sum / 2 + 1];

        // Initialize the partition array as 0
        for(i = 0; i <= sum / 2; i++) {
            partition[i] = false;
        }

        // Fill the partition table in bottom up manner
        for(i = 0; i < numElements; i++) {

            // The element to be included in the sum !> sum
            for(j = sum / 2; j >= array[i]; j--) {

                // Checks if sum - array[i] could be formed from a subset using elements before index i
                if(partition[j - array[i]] == true || j == array[i]) {
                    partition[j] = true;
                }
            }
        }
        return partition[sum / 2];
    }

    public static void canBePartitioned(int[] array, int n){
        if(findPartition(array, n)) {
            System.out.println(Arrays.toString(array) + " CAN be partitioned");
        }else {
            System.out.println(Arrays.toString(array) + "  CANNOT be partitioned");
        }
    }

    public static void main(String[] args) {

        // Checks for uneven set
        int[] array = { 1, 3, 3, 7, 3, 2 };
        int n = 6; //number of elements

        canBePartitioned(array, n);

        // Checks for even set with unpartitionable sum
        int[] array1 = { 1, 3, 3, 4, 3, 200 };
        int n1 = 6;

        canBePartitioned(array1, n1);

        // Checks for even, partitionable set
        int[] array2 = { 3, 1, 1, 2, 2, 1 };
        int n2 = 6;

        canBePartitioned(array2, n2);
    }
}
