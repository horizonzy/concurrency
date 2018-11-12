package com.zy.concurrency.immutable;

import com.google.common.collect.Maps;
import com.zy.concurrency.annotations.NotThreadSafe;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Horizon Time: 下午3:41 2018/11/11 Description:
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        map.put(1,3);
        log.info("{}",map.get(1));
    }
}
