package com.raferl.test.stopwatch;

/**
 * @author raferlyan
 * @date 2022/9/26 07:59
 **/
public class StopWatchDemo {

    public static void main(String[] args) {
        test01();
    }

    /**
     * 计时 Spring
     */
    public static void test01(){
        // 创建一个 StopWatch 实例
        org.springframework.util.StopWatch sw = new org.springframework.util.StopWatch("沉默王二是傻 X");
        // 开始计时
        sw.start("任务1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 停止计时
        sw.stop();
        System.out.printf("任务1耗时：%d%s.\n", sw.getLastTaskTimeMillis(), "ms");

        sw.start("任务2");
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sw.stop();

        System.out.printf("任务2耗时：%d%s.\n", sw.getLastTaskTimeMillis(), "ms");
        System.out.printf("任务数量：%s，总耗时：%ss.\n", sw.getTaskCount(), sw.getTotalTimeSeconds());
    }

    /**
     * 计时 commons-lang3
     */
//    public static void test02(){
//        org.apache.commons.lang3.time.StopWatch sw = new org.apache.commons.lang3.time.StopWatch("沉默王二是傻 X");
//        // 开始计时
//        sw.start();
//
//        // 暂停计时
//        sw.suspend();
//        System.out.printf("暂停耗时：%dms.\n", sw.getTime());
//
//        // 恢复计时
//        sw.resume();
//        System.out.printf("恢复耗时：%dms.\n", sw.getTime());
//
//        // 停止计时
//        sw.stop();
//        System.out.printf("总耗时：%dms.\n", sw.getTime());
//
//        // 重置计时
//        sw.reset();
//
//        System.out.printf("重置耗时：%dms.\n", sw.getTime());
//    }

}
