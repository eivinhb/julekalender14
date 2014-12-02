import static java.lang.Integer.toOctalString;

public class Luke01 {

    private static boolean isPalindrome(int t) {
        return isPalindrome((t+"").toCharArray());
    }

    private static boolean isPalindrome(String s) {
        return isPalindrome(s.toCharArray());
    }

    private static boolean isPalindrome(char[] s) {
        for (int i = 0; i < (s.length / 2); i++) {
            char first = s[i];
            char last = s[s.length - (i + 1)];
            if (first != last)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        int ant = 0;
        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(i) && isPalindrome(toOctalString(i))) {
                ant++;
            }
        }
        System.out.println("Antall: " + ant + " " + (System.nanoTime() - start) / 1000000 + "ms");
    }
}