package com.raferl.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author raferlyan
 * @date 2022/9/7 08:47
 **/
public class StreamDemo {

    public static void main(String[] args) {
        test01();
    }


    /**
     * 测试流中的布尔值判断是否生效
     */
    public static void test01(){
        List<String> strList = new ArrayList<>();
        strList.add("yjc.001");
        strList.add("yjc.002");
        strList.add("yjc.003");
        strList.add("test.004");
        List<String> finalList = strList.stream().filter(s -> !s.contains("yjc")).collect(Collectors.toList());
        System.out.println(finalList);
    }
}
