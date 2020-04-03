package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
       int[] value = {60,120, 100};
       int[] weight = {10,40, 20};
       int  capacity  = 55;
       int n = value.length;
        System.out.println(Knapsack(capacity, weight, value,  n));
    }

    private static int Knapsack(int w, int[] weight, int[] value, int n) {
        int i;
        int[][] k = new int[n + 1][w + 1];
        for (i = 0; i <= n; i++)
        {
            int b;
            for (b = 0; b <= w; b++)
            {
                if (i==0 || b==0)
                {
                    k[i][b] = 0;
                }
                else if (weight[i - 1] <= b)
                {
                    k[i][ b] = Math.max(value[i - 1] + k[i - 1][ b - weight[i - 1]], k[i - 1][ b]);
                }
                else
                {
                    k[i][ b] = k[i - 1][ b];
                }
            }
        }
        return k[n][w];
    }
}
