package com.nitin.model;
import com.nitin.util.SharedLock;

import java.util.HashMap;

public class BaseCache<String, V> {

    private HashMap<String, V>  cache;
    private int                 capacity;

    public BaseCache(int capacity) {
        this.cache    = new HashMap<>(this.capacity);
        this.capacity = capacity;
    }

    public void store(String key, V value) throws Exception {

        try {
            if (currentSizeOfCache() == getCapacity()) {
                throw new Exception("Capacity Full");
            } else {
                SharedLock.lock.lock();

                System.out.println(Thread.currentThread().getName() + " -> Lock acquired");
                this.cache.put(key, value);
                System.out.println(Thread.currentThread().getName() + " -> Value added to cache");

                Thread.sleep(3000);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            SharedLock.lock.unlock();
            System.out.println(Thread.currentThread().getName() + " -> Lock released");
        }
    }

    public V get(String key) {
        V returnVal = null;
        if (SharedLock.lock.tryLock()) {
            returnVal = this.cache.get(key);
            SharedLock.lock.unlock();
        }
        return returnVal;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int currentSizeOfCache() {
        return this.cache.size();
    }

}
