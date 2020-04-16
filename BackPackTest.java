import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class BackPackTest {
	private BackPack back=null;
	
	@Before
	public void setup() {
		back=new BackPack();
	}
	@Test
	public void test() {
		 //最大容量为10
        int m = 10;
        int n = 3;
        /*
        放入的三个物体重量分别为3， 4， 5；价值分别为4， 5， 6
         */
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = back.BackPack_Solution(m, n, w, p);
        assertEquals(11, c[n][m]);
	}
}
