package Tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IteratorTag extends SimpleTagSupport{
	private Collection collection;
	private String item;
	
	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public void doTag() throws JspException, IOException {
		for(Object obj: this.collection) {
			this.getJspContext().setAttribute(this.item, obj);
			this.getJspBody().invoke(null);
		}
	}
}
