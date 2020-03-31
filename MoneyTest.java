package st;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MoneyTest {
	private int sum;
	private List<Integer> expected;
	public MoneyTest(int[] list) {
		this.sum = list[0];
		if (list.length > 1) {
			this.expected = new ArrayList<>();
			for (int i = 1; i < list.length; i++) {
				this.expected.add(list[i]);
			}
		} else {
			this.expected = null;
		}
	}
	
	@Parameters
	public static Collection<int[]> getData() {
		return Arrays.asList(
				new int[] {-1},
				new int[] {1, 1},
				new int[] {4},
				new int[] {33, 20, 10, 1, 1, 1},
				new int[] {29},
				new int[] {93, 50, 20, 10, 5, 5, 1, 1, 1},
				new int[] {100});
	}
	
	static Money money = new Money();
	@Test
	public void test() {
		assertEquals(expected, money.pay(sum));
	}

}
