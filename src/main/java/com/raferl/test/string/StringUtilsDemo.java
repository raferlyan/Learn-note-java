package com.raferl.test.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author raferlyan
 * @date 2022/10/3 20:15
 **/
public class StringUtilsDemo {
    public static void main(String[] args) {
        demo02();
    }

    /**
     * 字符串判空
     */
    public static void demo01(){
        String str = " ";
        // 不为空，有空格
        boolean res1 = StringUtils.isNotBlank(str);
        System.out.println(res1);
        // 为空，无实质内容
        boolean res2 = StringUtils.isBlank(str);
        System.out.println(res2);

        // 不为空，有内容，为空格字符
        boolean res3 = StringUtils.isNotEmpty(str);
        System.out.println(res3);
        // 不为空，有一个空格字符串
        boolean res4 = StringUtils.isEmpty(str);
        System.out.println(res4);
    }

    /**
     * 分隔字符串
     * 相较于 String 的 split 方法来说，StringUtils 的 split 方法不会有空指针异常
     */
    public static void demo02(){
        String str2 = "1-2-3";
        String[] split = StringUtils.split(str2,"-");
        System.out.println(Arrays.toString(split));
    }
}
