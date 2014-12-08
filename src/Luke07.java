import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;

public class Luke07 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        BufferedImage read = ImageIO.read(new URL("https://dl.dropboxusercontent.com/u/42659711/Santa.png"));

        TreeMap<Integer, Color> res = new TreeMap<>();

        System.out.println("Hentet bilde " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int w = 0; w < read.getWidth(); w++) {
            for (int h = 0; h < read.getHeight(); h++) {
                int rgb = read.getRGB(w, h);
                Color color = new Color(rgb);
                if (res.containsKey(color.getRGB())) {
                    res.get(color.getRGB()).add();
                } else {
                    res.put(color.getRGB(), color);
                }
            }
        }

        Collection<Color> values = res.values();
        TreeSet<Color> colors = new TreeSet<>(values);
        int count = 0;
        for (Color c : colors) {
            if (++count == 10) {
                System.out.println("Fargen 10-ende mest brukt er:" + c.count + " - " + c.toString());
                break;
            }
        }
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }


    public static class Color extends java.awt.Color implements Comparable {

        private Integer count = 1;

        public void add() {
            this.count++;
        }


        public Color(int rgb) {
            super(rgb);
        }

        @Override
        public int compareTo(Object o) {
            return ((Color) o).count.compareTo(this.count);
        }
    }
}
