public class CalculatorThread extends Thread {
    private int start;
    private int end;
    private long result;

    public CalculatorThread(int start, int end) {
        this.start = start;
        this.end = end;
        this.result = 0;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                result += i * i;
            }
        }
    }

    public long getResult() {
        return result;
    }
}
