package com.tatelucky.yduts.math;

/**
 * hash其实可以简单的理解为取余
 * <p>
 * hash + slat 在日常的场景中经常用到，一方面加大散列，另一方面可以加密解密使用
 *
 * @author tangsheng
 * @since 2019-12-10
 */
public class HashDemo {
    public static void main(String[] args) {

        //5
        System.out.println(50 % 9);
        //48657
        System.out.println("111".hashCode());

//        private int hash; // Default to 0
//        public int hashCode() {
//            int h = hash;
//            if (h == 0 && value.length > 0) {
//                char val[] = value;
//
//                for (int i = 0; i < value.length; i++) {
//                    h = 31 * h + val[i];
//                }
//                hash = h;
//            }
//            return h;
//        }
    }
}
