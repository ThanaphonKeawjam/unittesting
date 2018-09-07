import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Count number of distinct elements in list and search index of element by binary search.
 * 
 * @author Thanaphon Keawjam
 *
 */
public class ListUtil {

	/**
     * Count the number of distinct elements in a list.
     * The list may be empty but not null.
     *
     * @param list a list of elements
     * @return the number of distinct elements in list
     */
    public static int countUnique(List<?> list) {
    	int count = 0;
    	List<Object> result = new ArrayList<>();
    	
    	if(list == null) throw new NullPointerException();
    	
    	for(Object x : list) {
    		if(!result.contains(x)) {
    			result.add(x);
    		}
    	}
    	
    	count = result.size();

    	return count;
    }
    
    /**
     * Use Binary Search algorithm search element in an array that already sorted.
     * Binary Search compare the target value to middle element of the array.
     * If they are not equal, this half will eliminated and search continues on the another half
     * until they find index of the matching element and return it.
     * If the value to find is null, throw an exception.
     * 
     * @param array is array of element.
     * @param element is the target that want to know index in array.
     * @return index of the matching element or -1 if the search element is not in array.
     * @throws IllegalArgumentException if element is null.
     */
    public static <T extends Comparable<? super T>> int binarySearch(T[] array, T element) {
    	if(element == null) throw new IllegalArgumentException("Search element must not be null");
    	
    	int start = array.length - 1;
    	int last = 0;
    	int mid = 0;
    	
    	Arrays.sort(array);
    	
    	while(last <= start) {
    		mid = (start + last) / 2;
    		if(array[mid].compareTo(element) < 0) {
    			last = mid + 1;
    		}else if(array[mid].compareTo(element) > 0) {
    			start = mid - 1;
    		}else {
    			return mid;
    		}
    	}
    	
    	return -1;
    }
    
}
