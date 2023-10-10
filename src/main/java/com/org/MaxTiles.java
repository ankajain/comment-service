package com.org;

public class MaxTiles {
    public static int maxSumWithThreeTiles(int[] array) {
      int n = array.length;
      if (n == 0) {
        return 0;
      }

      int[] dp = new int[n + 1];
      dp[0] = 0;

      for (int i = 1; i <= n; i++) {
        // Option 1: Use one tile starting at i-1
        int option1 = dp[i - 1] + array[i - 1];

        // Option 2: Use two tiles starting at i-2
        int option2 = (i >= 2) ? dp[i - 2] + array[i - 2] + array[i - 1] : 0;

        // Option 3: Use three tiles starting at i-3
        int option3 = (i >= 3) ? dp[i - 3] + array[i - 3] + array[i - 2] + array[i - 1] : 0;

        // Choose the maximum of the three options
        dp[i] = Math.max(option1, Math.max(option2, option3));
      }

      return dp[n];
    }

    public static void main(String[] args) {
      int[] array = {1, 2, 3, 4, 5};
      int maxSum = maxSumWithThreeTiles(array);
      System.out.println("Maximum sum using at most three tiles: " + maxSum);
    }


}
