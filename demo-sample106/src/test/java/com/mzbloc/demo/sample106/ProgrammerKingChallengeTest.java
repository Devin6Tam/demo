package com.mzbloc.demo.sample106;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 程序员王者挑战测试
 *
 * @author tanxw
 * @date 2019/6/21
 */
public class ProgrammerKingChallengeTest {

    @Test
    public void floatPrimitiveTest() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    @Test
    public void floatWrapperTest () {
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(0.9f - 0.8f);
        if (a.equals(b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    @Test
    public void switchTest () {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }

    @Test
    public void bigDecimalTest () {
        BigDecimal a = new BigDecimal(0.88);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.88");
        System.out.println(b);
    }


    @Test
    public void reentrantLockTest () {
        /**非公平锁*/
        final Lock lock = new ReentrantLock();
        try {
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
