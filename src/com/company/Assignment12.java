package com.company;

class Knapsack {

    static int knapSack(int maxCapacity, int[] weights, int[] values, int numItems){
        int i;
        int w;
        int[][] K = new int[numItems + 1][maxCapacity + 1];

        //builds table K[][] bottom up
        for (i = 0; i <= numItems; i++) {
            for (w = 0; w <= maxCapacity; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                }else if (weights[i - 1] <= w) {
                    K[i][w] = Math.max(values[i - 1] + K[i - 1][w - weights[i - 1]], K[i - 1][w]);
                }else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[numItems][maxCapacity];
    }

    public static void main(String[] args){
        int[] values1 = new int[]{ 60, 100, 120};
        int[] weights1 = new int[]{ 10, 20, 30 };
        int maxCapacity1 = 50;
        int numItems1 = values1.length;

        System.out.println("First Problem Max Value: ");

        System.out.println(knapSack(maxCapacity1, weights1, values1, numItems1));

        int[] values2 = new int[]{ 16808, 50074, 8931, 27545, 77924, 64441, 84493, 7988, 82328, 78841, 44304, 17710,
                29561, 93100, 51817, 99098, 13513, 23811, 80980, 36580, 11968, 1394, 25486, 25229, 40195, 35002, 16709,
                15669, 88125, 9531, 27723, 28550};
        int[] weights2 = new int[]{ 250, 659, 273, 879, 710, 166, 43, 504, 730, 613, 170, 158, 934, 279, 336, 827, 268,
                634, 150, 822, 673, 337, 746, 92, 358, 154, 945, 491, 197, 904, 667, 25};
        int maxCapacity2 = 10000;
        int numItems2 = values2.length;

        System.out.println("Second Problem Max Value: ");

        System.out.println(knapSack(maxCapacity2, weights2, values2, numItems2));
    }
}
