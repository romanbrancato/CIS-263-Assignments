package com.company;

import java.util.Arrays;

class Partition {

    // FOLLOWING CODE WAS REFERENCED FROM: https://www.geeksforgeeks.org/partition-problem-dp-18/
    // Returns true if the array can be partitioned into two subsets of equal sum, else false
    static boolean findPartition(int[] array, int n) {
        int sum = 0;
        int i;
        int j;

        // Calculate sum of all elements
        for(i = 0; i < n; i++){
            sum += array[i];
        }

        // If the sum is odd, an even partition of the sum is impossible
        if(sum % 2 != 0){
            return false;
        }

        boolean[][] partition = new boolean[sum / 2 + 1][n + 1];

        // Initialize top row
        for(i = 0; i <= n; i++){
            partition[0][i] = true;
        }

        // Initialize leftmost column, except partition[0][0], as 0
        for(i = 1; i <= sum / 2; i++){
            partition[i][0] = false;
        }

        // Fill the partition table in bottom up manner
        for(i = 1; i <= sum / 2; i++){
            for(j = 1; j <= n; j++) {
                partition[i][j] = partition[i][j - 1];
                if(i >= array[j - 1]){
                    partition[i][j] = partition[i][j] || partition[i - array[j - 1]][j - 1];
                }
            }
        }
        return partition[sum / 2][n];
    }

    public static void canBePartitioned(int[] array, int n){
        if(findPartition(array, n)){
            System.out.println(Arrays.toString(array) + " CAN be partitioned");
        }else{
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
