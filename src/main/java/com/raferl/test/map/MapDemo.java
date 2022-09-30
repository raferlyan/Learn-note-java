package com.raferl.test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raferlyan
 * @date 2022/9/26 13:54
 **/
public class MapDemo {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        Map<String, String> map = new HashMap<>();
        map.put("METER_ID","8000000020012784");
        map.put("METER_ID","8000000044483164");
        System.out.println(map);
    }
}
