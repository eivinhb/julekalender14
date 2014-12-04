import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import static java.lang.Double.parseDouble;

public class Luke04 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Luke04 luke = new Luke04();

        Temp laveste = luke.reader.lines()
                .filter(s -> s.startsWith("   18700 "))
                .map(s -> new Temp(s))
                .filter(temp -> temp.Dato.split("\\.")[1].equals("12"))
                .reduce((t1, t2) -> t1.TAN < t2.TAN ? t1 : t2).get();

        System.out.println("Laveste temp: " + laveste);
    }

    public final BufferedReader reader;


    public Luke04() throws IOException {
        String file = "https://dl.dropboxusercontent.com/u/45621/kilma_data_blindern.txt";
        URLConnection connection = new URL(file).openConnection();
        this.reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }

    public static class Temp {

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