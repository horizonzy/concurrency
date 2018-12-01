package com.zy.concurrency.example.synccontainer;

import com.zy.concurrency.annotations.NotThreadSafe;
import java.util.Vector;
@NotThreadSafe
public class VectorExample1 {

    private static Vector<Integer> vector = new Vector<>();


    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < vector.size(); i++) {
                vector.add(i);
            }
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }


}
