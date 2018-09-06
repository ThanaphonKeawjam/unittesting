import java.util.ArrayList;
import java.util.List;

/**
 * Count number of distinct elements in list.
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
    
}
