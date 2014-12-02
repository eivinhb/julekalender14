public class Luke02 {

    public static final int CHAR0 = 48;

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private int[] getPrimesWithTwoDigits() {
        int[] primes = new int[21];
        int nr = 0;
        for (int i = 10; i < 100; i++) {
            if (isPrime(i))
                primes[nr++] = i;
        }
        return primes;
    }

    private String getM(int n) {
        int[] primes = this.getPrimesWithTwoDigits();

        int curr = n;

        StringBuilder sb = new StringBuilder();

        for (int c = 0; c < n; c++) {
            for (int q = 0; q < primes.length; q++) {
                int p = primes[q];
                if (p == -1)
                    continue;

                char[] pri = (p + "").toCharArray();
                if (pri[0] == curr + CHAR0) {
                    primes[q] = -1;
                    sb.append(pri[0]);
                    curr = pri[1] - CHAR0;
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Luke02 l = new Luke02();

        for (int n = 1; n <= 9; n++) {
            System.out.println("N: " + n + " M: " + l.getM(n));
        }
    }
}