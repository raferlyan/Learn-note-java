package com.raferl.test.enumdemo;

/**
 * @author raferlyan
 * @date 2022/9/4 22:55
 * 注意构造方法
 **/
public enum Constant {
    APPLE(1), ORANGE(20);

    private int value = 0;

    Constant(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
