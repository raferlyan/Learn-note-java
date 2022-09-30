package com.raferl.test.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author raferlyan
 * @date 2022/9/26 08:17
 **/
@Component
@EnableScheduling
public class TaskDemo {
    public static void main(String[] args) throws InterruptedException {
        task1();
        task2();
    }
    /**
     * 每分钟的第30秒跑一次
     */
    @Scheduled(cron = "30 * * * * ?")
    public static void task1() throws InterruptedException {
        System.out.println("hello cron");
    }


    /**
     * 每隔5秒跑一次
     */
    @Scheduled(fixedRate = 5000)
    public static void task2() throws InterruptedException {
        System.out.println("hello fixedRate");
    }


    /**
     * 上次跑完隔3秒再跑
     */
    @Scheduled(fixedDelay = 3000)
    public void task3() throws InterruptedException {
        System.out.println("hello fixedDelay");
    }
}
