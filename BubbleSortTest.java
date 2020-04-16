import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class BubbleSortTest {
	private BubbleSort bubble =null;
	
	@Before
	public void setup() {
		bubble=new BubbleSort();
	}
	
	@Test
	public void test() {
		int arr[] = new int[]{1,6,2,2,5};
		int result[] = new int[] {1,2,2,5,6};
        BubbleSort.BubbleSort(arr);
        assertEquals(result[0], arr[0]);
        assertEquals(result[1], arr[1]);
        assertEquals(result[2], arr[2]);
        assertEquals(result[3], arr[3]);
        assertEquals(result[4], arr[4]);
	}
}
