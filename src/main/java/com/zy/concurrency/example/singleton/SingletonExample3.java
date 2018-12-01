package com.zy.concurrency.example.singleton;

import com.zy.concurrency.annotations.NotRecommend;
import com.zy.concurrency.annotations.ThreadSafe;

/**
 * Created by Horizon Time: 下午1:35 2018/11/11 Description:饿汉模式(添加线程安全)，单例实例在类装载的时候进行创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造函数
    private SingletonExample3() {

    }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态的工厂方法
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }

}
