package SharedResource;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Task extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private Semaphore semaphore;
    private Resource resource_1;
    private Resource resource_2;

    public Task(Resource r1, Resource r2) {
        this.resource_1 = r1;
        this.resource_2 = r2;
    }

    public Task(Resource r1) {
        this(r1, null);
    }

    @Override
    public void run() {
        for (;;) {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(2));
                if (resource_2 == null) {
                    resource_1.semaphore.acquire();
                    System.out.println(ANSI_PURPLE + this.getName() + ANSI_RED + " has " + resource_1.getName() + ANSI_RESET);
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    resource_1.semaphore.release();
                    System.out.println(ANSI_PURPLE + this.getName() + ANSI_GREEN + " released " + resource_1.getName() + ANSI_RESET);
                } else {
                    resource_1.semaphore.acquire();
                    resource_2.semaphore.acquire();
                    System.out.println(ANSI_PURPLE + this.getName() + ANSI_RED + " has " + resource_1.getName() + " and " + resource_2.getName() + ANSI_RESET);
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    resource_1.semaphore.release();
                    resource_2.semaphore.release();
                    System.out.println(ANSI_PURPLE + this.getName() + ANSI_GREEN + " released " + resource_1.getName() + " and " + resource_2.getName() + ANSI_RESET);
                }
            } catch (InterruptedException e) {
                System.out.println(ANSI_CYAN + this.getName() + " has been terminated" + ANSI_RESET);
                break;
            }
        }
    }
}
