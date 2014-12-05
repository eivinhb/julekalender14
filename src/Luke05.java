import java.util.*;
import java.util.stream.StreamSupport;

public class Luke05 {

	public static final String SEED = "123456789";

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		OptionalInt min = StreamSupport.intStream(Spliterators.spliteratorUnknownSize(
				new Permutation(SEED.toCharArray()),
				Spliterator.SIZED), true).map(Luke05::primfaktorer).min();

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

	public static class Permutation implements PrimitiveIterator.OfInt {
		private char[] word;
		private int nextInt;

		public Permutation(char[] _word) {
			word = _word;
		}

		boolean nextPermutation() {
			this.nextInt = Integer.parseInt(new String(word));
			int next = word.length;
			if (next-- <= 1)
				return false;
			for (; ; ) {
				int next1 = next;
				if (word[--next] < word[next1]) {
					int mid = word.length;
					for (; !(word[next] < word[--mid]); )
						;
					swap(next, mid);
					reverse(next1, word.length);
					return true;
				}
				if (next == 0)
					return false;
			}
		}

		boolean swap(int left, int right) {
			char c = word[right];
			word[right] = word[left];
			word[left] = c;
			return true;
		}

		boolean reverse(int first, int last) {
			for (; first != last && first != --last; ++first)
				swap(first, last);
			return true;
		}

		@Override
		public boolean hasNext() {
			return nextPermutation();
		}

		@Override
		public int nextInt() {
			return this.nextInt;
		}

		@Override
		public Integer next() {
			return this.nextInt;
		}
	}
}
