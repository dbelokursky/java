package ru.dbelokursky.memory;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(String.format("pid: %s", ManagementFactory.getRuntimeMXBean().getName()));
        Runtime runtime = Runtime.getRuntime();

        int size = 200_000_000;

        System.gc();
        Thread.sleep(10);

        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(String.format("Memory used: %d", memoryUsed));

        ArrayList<Integer> list = new ArrayList<>(size);
        memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(String.format("Memory used: %d", memoryUsed));

        IntStream.range(1, size).mapToObj(list::add);
        memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(String.format("Memory used: %d", memoryUsed));
    }
}
