package com.raferl.test.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author raferlyan
 * @date 2022/10/3 21:11
 **/
public class ListsDemo {
    public static void main(String[] args) {
        demo01();
    }

    /**
     * 初始化集合
     */
    public static void demo01() {
        ArrayList<Integer> integers1 = Lists.newArrayList(1, 2, 3, 4);
        System.out.println(integers1);
    }
}
