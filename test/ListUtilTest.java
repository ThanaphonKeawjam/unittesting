import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * JUnit test for test countUnique in ListUnit class.
 * @author Thanaphon Keawjam
 *
 */
public class ListUtilTest {
	
	private List<?> makeList(Object ... element){
		return java.util.Arrays.asList(element);
	}
	
	@Test
	public void testEmptyList() {
		assertEquals(0, ListUtil.countUnique(new ArrayList<>()));
	}
	
	@Test
	public void testSizeOfOne() {
		assertEquals(1, ListUtil.countUnique(makeList("banana")));
	}
	
	@Test
	public void testListOfTwoItemsManyOrder() {
		List<?> list = makeList("a", "a", "b", "a", "b", "b");
		assertEquals(2, ListUtil.countUnique(list));
		
		list = makeList(5, 9);
		assertEquals(2, ListUtil.countUnique(list));
	}
	
	@Test
	public void testAddNullToList() {
		List<?> list = new ArrayList<>();
		list.add(null);
		assertEquals(1, ListUtil.countUnique(list));
	}
	
	@Test (expected = NullPointerException.class)
	public void testListIsNull() {
		ListUtil.countUnique(null);
	}
	
	@Test
	public void testHugeList() {
		List<?> list = makeList(5, 6, 50, 60, 70, 90, 5, 100, 500, 
				1000, 0, 967, 90, 60, 2130, 888, 888, 888, 888, 888, 888, 907, 567, 111111);
		assertEquals(16, ListUtil.countUnique(list));
	}
	
	@Test
	public void testMultiTypeOfValue() {
		List<?> list = makeList(2, 45, "a", "a", "b", "45");
		assertEquals(5, ListUtil.countUnique(list));
	}

}
