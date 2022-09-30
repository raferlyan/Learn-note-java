package com.raferl.test.string;

import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author raferlyan
 * @date 2022/9/7 16:56
 **/
public class StringDemo {
    public static void main(String[] args) {
        test06();
    }

    /**
     * 截取字符串
     */
    public static void test01(){
        String origin = "sdfg jkjchw";

        System.out.println(origin.substring(5));
    }

    public static void test02(){
        String str = "         560          496           96308431 /hbase\\n";
        String trim = str.trim();
        String[] shellResult = trim.split(" ");
        System.out.println(Arrays.toString(shellResult));
        List<String> results = new ArrayList<>();
        for (String s : shellResult) {
            if (!Objects.equals("", s)){
                results.add(s);
            }
        }
        System.out.println(results.get(2));
    }

    /**
     *
     */
    public static void test03(){
        String str = "pages/video/video?avid=549117845";
        int lastIndexOf = str.lastIndexOf("=");
        String aid = str.substring(lastIndexOf+1);
        System.out.println(aid);
    }

    public static void test04(){
        String timePoint = "U";
        String coll_time = "2022-08-19 01:01:01";
        String time = DateUtil.formatTime(DateUtil.parse(coll_time));
        String[] split = time.split(":");
        List<String> times = new ArrayList<>(Arrays.asList(split));
        String hour = times.get(0);
        System.out.println(hour);
        String minute = "";
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        try {
            Date parse = df.parse(time);
            long initTime = parse.getTime();
            if (initTime >= getTime(hour + ":07:31") && initTime <= getTime(hour + ":22:30")){
                minute = "15";
            }else if(initTime >= getTime(hour + ":22:31") && initTime <= getTime(hour + ":37:30")){
                minute = "30";
            }else if(initTime >= getTime(hour + ":37:31") && initTime <= getTime(hour + ":52:30")){
                minute = "45";
            }else {
                minute = "00";
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        timePoint = timePoint + hour + minute;
        System.out.println(timePoint);
    }

    public static long getTime(String time){
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        try {
            return df.parse(time).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断字符串为空
     */
    public static void test05(){
        String str = "";
        if (str.isEmpty()){
            System.out.println("空");
        }
    }

    public static void test06(){
        String owner = "140500";
        String SQL1 = "select meter_id from \"SX_METER_R_CONS_GC\" where owner = '140500'";
        System.out.println(SQL1);
        String SQL2 = "select meter_id from \"SX_METER_R_CONS_GC\" where owner = " + owner;
        System.out.println(SQL2);
        String SQL3 = "select meter_id from \"SX_METER_R_CONS_GC\" where owner = '" + owner + "'";
        System.out.println(SQL3);

    }
}
