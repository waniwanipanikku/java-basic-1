import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeCheck {

    public static void main(String[] args) {
        int limit = 100000;
        List<Integer> primes = generatePrimes(limit);
        Map<Integer, List<Integer>> primeGroups = classifyPrimesByLastDigit(primes);
        Map<String, Integer> pairCounts = countLastDigitPairs(primes);
        printPrimeGroups(primeGroups);
        printPairCounts(pairCounts);
    }
    public static List<Integer> generatePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i] && i >= 3) {
                primes.add(i);
            }
        }
        return primes;
    }
    public static Map<Integer, List<Integer>> classifyPrimesByLastDigit(List<Integer> primes) {
        Map<Integer, List<Integer>> primeGroups = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            primeGroups.put(i, new ArrayList<>());
        }
        for (int prime : primes) {
            int lastDigit = prime % 10;
            if (lastDigit != 5) {
                primeGroups.get(lastDigit).add(prime);
            }
        }
        return primeGroups;
    }
    public static Map<String, Integer> countLastDigitPairs(List<Integer> primes) {
        Map<String, Integer> pairCounts = new HashMap<>();
        String[] pairs = {"1-1", "1-3", "1-7", "1-9", "3-1", "3-3", "3-7", "3-9","7-1", "7-3", "7-7", "7-9", "9-1", "9-3", "9-7", "9-9"};
        for (String pair : pairs) {
            pairCounts.put(pair, 0);
        }
        for (int i = 0; i < primes.size() - 1; i++) {
            int lastDigit1 = primes.get(i) % 10;
            int lastDigit2 = primes.get(i + 1) % 10;
            if (lastDigit1 != 5 && lastDigit2 != 5) {
                String pair = lastDigit1 + "-" + lastDigit2;
                if (pairCounts.containsKey(pair)) {
                    pairCounts.put(pair, pairCounts.get(pair) + 1);
                }
            }
        }
        return pairCounts;
    }
    public static void printPrimeGroups(Map<Integer, List<Integer>> primeGroups) {
        for (int lastDigit : primeGroups.keySet()) {
            if (lastDigit != 5) {
                System.out.println("下一桁が " + lastDigit + " の素数: " + primeGroups.get(lastDigit));
            }
        }
    }
    public static void printPairCounts(Map<String, Integer> pairCounts) {
        pairCounts.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> System.out.println("ペア " + entry.getKey() + " の出現回数: " + entry.getValue()));
    }
}
