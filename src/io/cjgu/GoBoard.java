package io.cjgu;

public class GoBoard {

    // 计算前缀和
    public static int findMinimumDifference(int[][] board) {
        int n = board.length;
        int[][] rowPrefixSum = new int[n][n + 1];
        int[][] colPrefixSum = new int[n][n + 1];

        // 计算每一行的前缀和
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefixSum[i][j + 1] = rowPrefixSum[i][j] + board[i][j];
            }
            System.out.println();
        }

        // 计算每一列的前缀和
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                colPrefixSum[j][i + 1] = colPrefixSum[j][i] + board[i][j];
            }
            System.out.println();
        }

        int minDifference = Integer.MAX_VALUE;

        // 横向划分
        for (int i = 1; i < n; i++) {
            int sumA = rowPrefixSum[i - 1][n];
            int sumB = rowPrefixSum[n - 1][n] - sumA;
            minDifference = Math.min(minDifference, Math.abs(sumA - sumB));
        }

        // 纵向划分
        for (int j = 1; j < n; j++) {
            int sumA = colPrefixSum[j - 1][n];
            int sumB = colPrefixSum[n - 1][n] - sumA;
            minDifference = Math.min(minDifference, Math.abs(sumA - sumB));
        }



        return minDifference;
    }

    public static void main(String[] args) {
        int[][] board = {
                {23, 45, 67, 89, 12},
                {34, 56, 78, 90, 21},
                {45, 67, 89, 12, 34},
                {56, 78, 90, 21, 43},
                {67, 89, 12, 34, 56}
        };
        System.out.println("最小差值为: " + findMinimumDifference(board));
    }

}
