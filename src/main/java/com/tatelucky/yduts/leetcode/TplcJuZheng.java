package com.tatelucky.yduts.leetcode;

/**
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * 暴力遍历
 *
 * @author tangsheng
 * @since 2019-10-11
 */
public class TplcJuZheng {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 1 || matrix[0].length == 1) {
            return true;
        }
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 10}};
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(matrix));
    }
}
