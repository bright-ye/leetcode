package com.knowledge.closeable;

import org.junit.Test;

import java.io.Closeable;

public class CloseMain {
    @Test
    public void test2() {
        try (Resource2 r2 = new Resource2()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        try (Resource1 r1 = new Resource1()) {

        }
    }
}

class Resource1 implements Closeable {
    @Override
    public void close() {
        System.out.println("r1 close...");
    }
}

class Resource2 implements AutoCloseable{
    @Override
    public void close() {
        System.out.println("r2 close...");
    }
}
