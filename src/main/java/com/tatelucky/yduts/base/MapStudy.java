package com.tatelucky.yduts.base;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author tangsheng
 * @since 2020-01-07
 */
public class MapStudy {
    public static void main(String[] args) {
        //hash % length = hash & (length -1)
        //hash后  求余操作的优化 但是 length必须是2的n次方
        //2的次方是因为 二进制只有一位为1，减1后，低位全是1，获取到位置
        // length如果是16，那么减一之后就是15(0000 1111)，正是这种高位都为0，
        // 低位都为1的二级制数才保证了可以对任意一个hashcode经过逻辑与操作后得到的结果是我们想要的数组下标。
        // 这就是为什么在真初始化HashMap的时候，对于数组的长度一定要是二次方数，
        // 二次方数和算数组下标是息息相关的，而这种位运算是要比取模更快的。另外就是可以分的更均匀
        System.out.println(100 % 8);
        System.out.println(100 & (8 - 1));


        HashMap map = new HashMap();
        map.put(null, "b");
        System.out.println(map.get(null));
        System.out.println(map.get("c"));


//        当我们把 table[i] 位置的所有 Node 迁移到 newtab 中去的时候：
//        这里面的 node 要么在 newtab 的i位置（不变），要么在 newtab 的 i + n 位置。
//        也就是我们可以这样处理：把 table[i] 这个桶中的 node 拆分为两个链表 l1 和 l2：
//        如果hash & n == 0，那么当前这个 node 被连接到 l1 链表；否则连接到 l2 链表。
//        这样下来，当遍历完 table[i] 处的所有 node 的时候，我们得到两个链表 l1 和 l2，
//        这时我们令 newtab[i] = l1，newtab[i + n] = l2，
//        这就完成了 table[i] 位置所有 node 的迁移（rehash），
//        这也是 HashMap 中容量一定的是2的整数次幂带来的方便之处。

        String a = "bug";
        System.out.println(a.hashCode());


        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 7) {
                System.out.println("找到7了");
                break;
            }
        }

        System.out.println(1 % 10);
        System.out.println(7 % 5);


        //弱引用
        WeakHashMap weakHashMap = new WeakHashMap();
        Integer aa = new Integer(1);
        weakHashMap.put(aa, "aaa");
        //1
        System.out.println(weakHashMap.size());

        aa = null;
        //1
        System.out.println(weakHashMap.size());

        //发现有时候没gc上
        System.gc();
        System.gc();
        System.gc();
        //0
        System.out.println(weakHashMap.size());

    }
}
