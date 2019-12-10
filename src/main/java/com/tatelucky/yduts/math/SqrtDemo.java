package com.tatelucky.yduts.math;

/**
 * 迭代
 * 作用：求数值的精确或者近似解、在一定范围内查找目标值（二分法）、机器学习算法中的迭代
 *
 * @author tangsheng
 * @since 2019-12-10
 */
public class SqrtDemo {
    public static void main(String[] args) {
        System.out.println(mySqrt(11, 0.00001));
    }

    /**
     * sqrt
     *
     * @param n          => 1
     * @param threshould 误差
     * @return
     */
    public static double mySqrt(int n, double threshould) {
        if (n <= 1) {
            return 1;
        }
        double min = 1.0;
        double max = (double) n;

        while (true) {
            double middle = (min + max) / 2;
            double square = middle * middle;
            double delta = Math.abs((square / n) - 1);
            if (delta <= threshould) {
                return middle;
            } else {
                if (square > n) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }
    }
}
