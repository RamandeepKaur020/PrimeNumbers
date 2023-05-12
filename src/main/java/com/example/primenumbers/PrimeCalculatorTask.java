package com.example.primenumbers;
import java.util.Arrays;
import javafx.concurrent.Task;
//reference: Java9 for Programmers -by Paul Deitel and Harvey Deitel
//Chapter 21 Concurrency and Multi-code Performance
//Page 693 - 699
public class PrimeCalculatorTask extends Task<Integer> {
    private final boolean[] primes;

    public PrimeCalculatorTask(int max) {
        primes = new boolean[max];
        Arrays.fill(primes, true);
    }

    @Override
    protected Integer call() {
        int count = 0;

        for (int i = 2; i < primes.length; i++) {
            if (isCancelled()) {
                updateMessage("Cancelled");
                return 0;
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    updateMessage("Interrupted");
                    return 0;
                }
                updateProgress(i + 1, primes.length);
                if (primes[i]) {
                    ++count;
                    updateMessage(String.format("Found %d primes", count));
                    updateValue(i);

                    for (int j = i + i; j < primes.length; j += i) {
                        primes[j] = false;
                    }
                }
            }
        }
        return 0;
    }
}
