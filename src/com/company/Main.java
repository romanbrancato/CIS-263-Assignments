package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> sortedNumsArray = new ArrayList<>();
        int maxSize = 5;
        Scanner scanner = new Scanner(System.in);

        //iterate to accept inputs
        for (int i = 0; i < maxSize; i++) {

            //get number input from user
            System.out.print("Enter Int: ");
            int enteredNum = scanner.nextInt();
            //add number to array
            sortedNumsArray.add(enteredNum);

            //Start of Insertion Sort

            //begin loop at second element in array
            for (int j = 1; j < sortedNumsArray.size(); j++) {
                //setting the "key" to the second element
                int key = sortedNumsArray.get(j);
                //setting currentPosition as the element before the key
                int currentPosition = j - 1;
                //while current position does not go below index 0 and the element before the key is greater than the key
                while (currentPosition > -1 && sortedNumsArray.get(currentPosition) > key) {
                    //element at current position shifts up 1 index to put the lower value before it
                    sortedNumsArray.set(currentPosition + 1, sortedNumsArray.get(currentPosition));
                    //decrement current position to check if the same is true in the new position
                    currentPosition = currentPosition - 1;
                }
                //set the element after current position to the key
                sortedNumsArray.set(currentPosition + 1, key);
            }

            //End of Insertion Sort

            //print out sorted array
            System.out.println(sortedNumsArray);
        }
    }
}

