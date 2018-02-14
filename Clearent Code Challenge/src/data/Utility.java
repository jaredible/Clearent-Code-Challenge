package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Utility {
	public static <K, V> List<V> mapToList(Map<K, V> map) {
		List<V> result = new ArrayList<V>();

		for (Entry<K, V> m : map.entrySet()) {
			result.add(m.getValue());
		}

		return result;
	}
}
