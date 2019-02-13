package com.nitin.test;

import com.nitin.model.BaseCache;

public class CacheRunner {

    public static void main(String[] args) {
        BaseCache<String, Integer> integerCache = new BaseCache<>(10);
        BaseCache<String, String> stringCache   = new BaseCache<>(10);

        Runnable runnable1 = getRunnable(integerCache);
        Runnable runnable2 = getRunnable(stringCache);

        Thread t1 = new Thread(runnable1, "AddThread1");
        Thread t2 = new Thread(runnable2, "AddThread2");

        t1.start();
        t2.start();

    }

    private static Runnable getRunnable(BaseCache cache) {
        return new Runnable() {
            @Override
            public void run() {
                int i = 1;

                try {
                    while (i <= cache.getCapacity()) {

                        cache.store("Val" + i, i);
                        i++;
                    }
                } catch (Exception e) {
                    System.out.println("ERROR -> " + e.getMessage());
                }

            }
        };
    }
}
