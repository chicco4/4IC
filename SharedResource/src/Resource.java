package SharedResource;

import java.util.concurrent.Semaphore;

public class Resource {

    protected Semaphore semaphore;
    private final String name;

    public Resource(String name) {
        this.name = name;
        this.semaphore = new Semaphore(1, true);
    }

    public String getName() {
        return name;
    }

}
