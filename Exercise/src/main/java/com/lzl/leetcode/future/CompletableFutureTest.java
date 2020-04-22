package com.lzl.leetcode.future;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/31
 */
public class CompletableFutureTest {


    public static void main(String[] args) throws Throwable {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("11111111");
//            throw new IllegalArgumentException("err1");

        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("222222");
            throw new IllegalArgumentException("err2");

        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Throwable error = null;
        try {
            future1.get();
            future2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
//            System.out.println("exception");
//            e.printStackTrace();
            error = e.getCause();
        }
        if (Objects.nonNull(error)) throw error;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
