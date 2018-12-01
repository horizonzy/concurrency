package com.zy.concurrency.example.singleton;

import com.zy.concurrency.annotations.Recommend;
import com.zy.concurrency.annotations.ThreadSafe;

/**
 * Created by Horizon Time: 下午2:01 2018/11/11 Description: 枚举单例模式 最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {

    }


    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只被调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }

}
