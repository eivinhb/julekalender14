public class Luke06 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        boolean[] myset = new boolean[(8000 + 1) * (8000 + 1)];

        for (int i = 1; i <= 8000; i++) {
            for (int p = i; p <= 8000; p++) {
                myset[i * p] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < myset.length; i++) {
            if (myset[i]) count++;
        }


        System.out.println("Antall: " + count + " " + (System.currentTimeMillis() - start) + "ms");

    }
}
