package be.lmagnette;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadsMain {
    public static void main(String[] args) {
        System.out.println("---- VirtualThreads START ----");
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    System.out.println("i = " + i);
                    return i;
                });
            });
        }  // executor.close() is called implicitly, and waits
        System.out.println("---- VirtualThreads STOP ----");
    }
}
