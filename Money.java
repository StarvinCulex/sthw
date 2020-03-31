package st;

import java.util.ArrayList;
import java.util.List;

public class Money {
	public final int[] cashes;
	public Money() {
		cashes = new int[] {50, 20, 10, 5, 5, 1, 1, 1};
	}
	
	public List<Integer> pay(int value) {
		List<Integer> result = new ArrayList<>();
		for (int cash : cashes) {
			if (value >= cash) {
				value -= cash;
				result.add(cash);	
			}
		}	
		if (value != 0) {
			return null;
		} else {
			return result;
		}
	}
}
