package app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MaxConcurrency {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(25);

        for (int i = 0; i < 100; i++) {
            ItemRunnable itemRunnable = new ItemRunnable(i);
            // queuing tasks
            executorService.submit(itemRunnable);
        }

        // no new tasks are accepted
        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
