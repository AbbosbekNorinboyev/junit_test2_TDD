package uz.pdp.junit_test1;

public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        if (b < 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return a / b;
    }
}
