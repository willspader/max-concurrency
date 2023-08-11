package app;

public class ItemRunnable implements Runnable {

    private Integer item;

    public ItemRunnable(Integer item) {
        this.item = item;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("running item = " + item);
    }
}
