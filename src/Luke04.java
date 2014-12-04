import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;

public class Luke04 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Luke04 luke = new Luke04();

        String file = "https://dl.dropboxusercontent.com/u/45621/kilma_data_blindern.txt";
        URLConnection connection = new URL(file).openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        Supplier<Stream<Temp>> supplier =
                () -> reader.lines()
                        .filter(s -> luke.filterWeatherDataBlindern(s))
                        .map(s -> new Temp(s))
                        .filter(temp -> luke.filterDesember(temp.Dato));

        Temp temp1 = supplier.get()
                .reduce((t1, t2) -> t1.TAN < t2.TAN ? t1 : t2).get();

        System.out.println("Laveste temp: " + temp1);
    }

    private boolean filterWeatherDataBlindern(String s) {
        return s.startsWith("   18700 ");
    }
    private boolean filterDesember(String s){
        return s.split("\\.")[1].equals("12");
    }

    public static class Temp{

        public final double TAN;
        public final String Dato;

        public Temp(String s) {
            String[] split = s.trim().split("\\s+");
            this.Dato = split[1];
            this.TAN = parseDouble(split[3].replace(",", "."));
        }

        @Override
        public String toString() {
            return Dato + " " + TAN;
        }
    }

}