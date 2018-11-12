package com.zy.concurrency.singleton;

import com.zy.concurrency.annotations.NotThreadSafe;

/**
 * Created by Horizon Time: 下午1:30 2018/11/11 Description:懒汉模式，单例实例在第一次使用的时候实现
 */
@NotThreadSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1() {

    }

    //单例对象
    private static SingletonExample1 instance = null;

    //静态工厂方法
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }

}
