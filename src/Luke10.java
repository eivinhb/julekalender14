import java.util.ArrayList;
import java.util.LinkedList;

public class Luke10 {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();


        LinkedList<Person> personer = new LinkedList<>();
        for (int i = 1; i <= 1500; i++) {
            personer.add(new Person(i));
        }

        while (personer.size() > 1) {
            ArrayList<Object> fjern = new ArrayList<>();

            int i = 0;
            for (Person p : personer) {
                if (i++ % 2 == 1) {
                    fjern.add(p);
                } else {
                    if (p.getSeat() == personer.getLast().getSeat()) {
                        fjern.add(personer.getFirst());
                    }
                }
            }

            personer.removeAll(fjern);
        }

        System.out.println("Antall igjen " + personer.size() + " Seat: " + personer.getFirst().getSeat() + " " + (System.currentTimeMillis() - start) + "ms");
    }


    private static class Person {

        private int seat;

        private Person(int seat) {
            this.seat = seat;
        }

        public int getSeat() {
            return seat;
        }
    }
}
