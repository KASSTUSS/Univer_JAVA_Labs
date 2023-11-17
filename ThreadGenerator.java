public class ThreadGenerator {
    private int numThreads;
    private String operation;
    private int lowerBound;
    private int upperBound;
    private CalculatorThread[] threads;  // Добавленная переменная

    public ThreadGenerator(int numThreads, String operation, int lowerBound, int upperBound) {
        this.numThreads = numThreads;
        this.operation = operation;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.threads = new CalculatorThread[numThreads];  // Инициализация массива потоков
    }

    public void execute() throws InterruptedException {
        int range = (upperBound - lowerBound + 1) / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = lowerBound + i * range;
            int end = (i == numThreads - 1) ? upperBound : start + range - 1;

            threads[i] = new CalculatorThread(start, end);
            threads[i].start();
        }

        for (CalculatorThread thread : threads) {
            thread.join();
        }
    }

    public long getResult() {
        long finalResult = 0;

        for (CalculatorThread thread : threads) {
            if ("1".equalsIgnoreCase(operation)) {
                finalResult += thread.getResult();
            } else if ("2".equalsIgnoreCase(operation)) {
                finalResult -= thread.getResult();
            } else if ("3".equalsIgnoreCase(operation)) {
                finalResult *= thread.getResult();
            }
        }

        return finalResult;
    }
}