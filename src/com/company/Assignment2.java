package com.company;

import static java.lang.Math.log;

public class Assignment2 {

    public static void main(String[] args) {

        //number of times to iterate
        int n = 100;
        testRunTimes(n);

    }
    public static void testRunTimes(int n){

        //CODE FRAGMENT A//////////////////////////////////////////////////////
        float someVariable = 0;

        long startTime = System.nanoTime();

        for(int i = 0; i < n; i++){
            someVariable = (float) (log(someVariable) + 3);
        }

        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Execution Time of Loop A for " + n + " iterations: " + elapsedTime + "ns");


        //CODE FRAGMENT B//////////////////////////////////////////////////////
        someVariable = 0;

        startTime = System.nanoTime();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                someVariable = (float) (log(someVariable) + 3);
            }
        }

        elapsedTime = System.nanoTime() - startTime;

        System.out.println("Execution Time of Loop B for " + n + " iterations: " + elapsedTime + "ns");


        //CODE FRAGMENT C//////////////////////////////////////////////////////
        someVariable = 0;

        startTime = System.nanoTime();

        for(int i = 0; i < n; i++){
            for(int j=0; j < i; j++){
                someVariable = (float) (log(someVariable) + 3);
            }
        }
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("Execution Time of Loop C for " + n + " iterations: " + elapsedTime+ "ns");


        //CODE FRAGMENT D//////////////////////////////////////////////////////
        someVariable = 0;

        startTime = System.nanoTime();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(j % 2 == 0){
                    someVariable = (float) (log(someVariable) + 3);
                }
            }
        }
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("Execution Time of Loop D for " + n + " iterations: " + elapsedTime + "ns");
    }
}
