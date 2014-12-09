import java.util.Arrays;

public class Luke09 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int svar = 0;
        outer:
        for (int a = 123; a <= 654; a++) {
            for (int b = 456; b <= 987; b++) {
                if (a + b < 1000)
                    continue;
                String s = a + "" + b + "" + (a + b);
                if(hasNoDoupes(s)){
                    svar = a;
                    break outer;
                }
            }
        }

        System.out.println("Svar: " + svar + " " + (System.currentTimeMillis() - start) + "ms");

    }

    private final static char[] B = "0123456789".toCharArray();

    private static boolean hasNoDoupes(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return Arrays.equals(a, B);
    }
}
