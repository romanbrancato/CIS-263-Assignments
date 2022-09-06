package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] sortedNumsArray = new int[5];
        Scanner scanner = new Scanner(System.in);

        //iterate to accept as many inputs as the array can hold
        for (int i = 0; i < sortedNumsArray.length; i++) {

            //get number input from user
            System.out.print("Enter Int: ");
            int enteredNum = scanner.nextInt();
            //add entered number to array
            sortedNumsArray[i] = enteredNum;

            //Start of Insertion Sort

            //begin loop at second element in array
            for (int j = 1; j < sortedNumsArray.length; j++) {
                //setting the "key" to the second element
                int key = sortedNumsArray[j];
                //setting g as the number before the key
                int g = j - 1;
                //while g does not go below index 0 and the element before the key is greater than the key
                while (g > -1 && sortedNumsArray[g] > key) {
                    //element at index g shift up 1 index to put the lower value before it
                    sortedNumsArray[g + 1] = sortedNumsArray[g];
                    //decrement g to check if the same is true in the new position
                    g = g - 1;
                }
                //set the element after g to the key
                sortedNumsArray[g + 1] = key;
            }

            //End of Insertion Sort

            //print out sorted array
            System.out.println(Arrays.toString(sortedNumsArray));
        }
    }
}

