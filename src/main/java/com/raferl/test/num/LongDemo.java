package com.raferl.test.num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raferlyan
 * @date 2022/9/6 15:11
 **/
public class LongDemo {
    public static void main(String[] args) {
//        System.out.println(sum());
//        System.out.println(useFor());
        test01();
    }

    /**
     * 求和01
     */
    public static long sum(){
        long count = 20;

        long number = 100;

        count = count + number;
        return count;
    }

    /**
     * 求和02
     */
    public static long useFor(){
        long count = 0;
        List<Long> longs = new ArrayList<>();
        longs.add(100L);
        longs.add(200L);
        longs.add(300L);
        longs.add(400L);
        for (Long aLong : longs) {
            count = count + aLong;
        }
        return count;
    }

    public static void test01(){
        float timePointData = Float.parseFloat("2.1");
        System.out.println(timePointData);
        float start = Float.parseFloat("1");
        float end = Float.parseFloat("4");
        if (timePointData > start && timePointData < end) {
            System.out.println("ok");
        }
        if (timePointData > 1.9){
            System.out.println(">");
        }
    }
}
