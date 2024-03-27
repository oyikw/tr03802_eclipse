package Tag;

import java.util.Collection;

public class ListFunction {
	public static Integer size(Collection coll) {
		if(coll == null) return 0;
		return coll.size();
	}
}
