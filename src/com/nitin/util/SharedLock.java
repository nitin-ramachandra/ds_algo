package com.nitin.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedLock {

    public static Lock lock = new ReentrantLock();
}
