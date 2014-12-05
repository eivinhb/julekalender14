import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Luke05 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        OptionalInt min = IntStream.range(123456789, 987654321 + 1)
                .filter(arr -> isSTORTTALL(arr)).parallel()
                .map(n -> primfaktorer(n))
                .min();

        System.out.println("Minste: " + min.getAsInt() + " " + (System.currentTimeMillis() - start) + "ms");

    }

    public static Integer primfaktorer(int tall) {
        int n = tall;
        List<Integer> faktorer = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                faktorer.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            faktorer.add(n);
        }
        return faktorer.get(faktorer.size() - 1);
    }


    private static boolean isSTORTTALL(int i) {
        char[] arr = (i + "").toCharArray();
        char[] chars = new char[9];

        for (char c : arr) {
            if (c == 48) return false;
            if (chars[c - 49] == 1) return false;
            chars[c - 49]++;
        }
        return true;
    }
}
