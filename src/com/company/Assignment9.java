package com.company;

import java.util.Random;
public class Assignment9 {

    public static Integer linearProbe(int[] arr, Integer num){
        int collisions = 0;
        int hash = num % 300;
        while(arr[hash] != 0) {
            hash = (hash + 1) % 10001;
            ++collisions;
        }
        arr[hash] = num;

        return collisions;
    }

    public static Integer quadraticProbe(int[] arr, Integer num){
        int collisions = 0;
        int hash = num % 300;
        int n = 1;
        while(arr[hash] != 0) {
            hash = (hash + n*n) % 10001;
            ++collisions;
            ++n;
        }
        arr[hash] = num;

        return collisions;
    }

    public static Integer doubleHash(int[] arr, Integer num){
        int collisions = 0;
        int hash = num % 300;
        int n = 1;
        while(arr[hash] != 0) {
            hash = (hash + n * (9973 - (num % 9973))) % 10001;
            ++collisions;
            ++n;
        }
        arr[hash] = num;

        return collisions;
    }


    public static void main(String[] args) {
        int[] linearProbeHashTable = new int[10001];
        int[] quadraticProbeHashTable = new int[10001];
        int[] doubleHashTable = new int[10001];

        int totalCollisions = 0;
        for(int i = 0; i <= 500; i++){
            Random random = new Random();
            int num = random.nextInt(100001);
            totalCollisions += linearProbe(linearProbeHashTable, num);
        }
        System.out.println("Linear Probing Total Collisions: " + totalCollisions);

        totalCollisions = 0;
        for(int i = 0; i <= 500; i++){
            Random random = new Random();
            int num = random.nextInt(100001);
            totalCollisions += quadraticProbe(quadraticProbeHashTable, num);
        }
        System.out.println("Quadratic Probing Total Collisions: " + totalCollisions);

        totalCollisions = 0;
        for(int i = 0; i <= 500; i++){
            Random random = new Random();
            int num = random.nextInt(100001);
            totalCollisions += doubleHash(doubleHashTable, num);
        }
        System.out.println("Double Hash Total Collisions: " + totalCollisions);


    }
}