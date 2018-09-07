import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * JUnit test case for test ListUnit class.
 * 
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
		
		list = makeList(5, 9, 5, 5, 5, 5, 5, 9, 9, 9, 9, 9, 9, 5, 9);
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
	
	@Test
	public void testBasicBinarySearch() {
		String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		assertEquals(8, ListUtil.binarySearch(str, "i"));
		
		Integer[] x = {60, 80, 90, 50, 120, 100, 10};
		assertEquals(0, ListUtil.binarySearch(x, 10));
	}
	
	@Test
	public void testArrayOneSize() {
		String[] s = {"hello"};
		assertEquals(0, ListUtil.binarySearch(s, "hello"));
	}
	
	@Test
	public void testNotInArray() {
		String[] s = {"a", "b", "c"};
		assertEquals(-1, ListUtil.binarySearch(s, "d"));
		assertEquals(-1, ListUtil.binarySearch(s, "A"));
		
		Integer[] x = {100, 200, 0};
		assertEquals(-1, ListUtil.binarySearch(x, 120));
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testElementIsNull() {
		Integer[] x = {1, 2, 3};
		ListUtil.binarySearch(x, null);
	}
	
	@Test
	public void testDuplicatesValue() {
		String[] s = {"a", "c", "a", "a", "z", "g"};
		assertNotEquals(0, ListUtil.binarySearch(s, "a"));
		assertNotEquals(1, ListUtil.binarySearch(s, "a"));
		assertEquals(2, ListUtil.binarySearch(s, "a"));
		
		Integer[] x = {2, 1, 2};
		assertNotEquals(0, ListUtil.binarySearch(x, 2));
		assertEquals(1, ListUtil.binarySearch(x, 2));
	}
	
}
