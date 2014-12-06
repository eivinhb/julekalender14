import java.util.HashSet;
import java.util.Set;

public class Luke06 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Set<Integer> products = new HashSet<>();

        for(int i = 1; i <= 8000; i++){
            for(int p = 1; p <= 8000; p++){
                products.add(i*p);
            }
        }

        System.out.println("Antall: " + products.size() + " " + (System.currentTimeMillis() - start) + "ms");

    }
}
