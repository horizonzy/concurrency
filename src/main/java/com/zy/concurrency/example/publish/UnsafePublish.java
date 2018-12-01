package com.zy.concurrency.example.publish;

import com.zy.concurrency.annotations.NotThreadSafe;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Horizon Time: 下午1:16 2018/11/11 Description:发布不安全
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }
}
