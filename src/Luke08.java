import static java.lang.Math.pow;

public class Luke08 {

    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int perfektTall(int prime) {
        return (int) (pow(2, prime - 1) * (pow(2, prime) - 1));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int n = 2; n < 10; n++) {
            if (isPrime(n)) {
                System.out.print(perfektTall(n) + ",");
            }
        }

        System.out.println("\nDone: " + (System.nanoTime() - start) / 1000 + "μs");

    }
}
