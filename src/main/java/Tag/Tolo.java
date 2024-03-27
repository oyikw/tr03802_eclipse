package Tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Tolo extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		this.getJspBody().invoke(sw);
		String s = sw.toString().trim();
		StringBuffer sbf = new StringBuffer();
		char[] c = s.toCharArray();
		for(int i = 0;i < c.length;i++) {
			if(Character.isUpperCase(c[i])) {
				sbf.append(Character.toLowerCase(c[i]));
			}else if(Character.isLowerCase(c[i])) {
				sbf.append(Character.toUpperCase(c[i]));
			}else {
				sbf.append(c[i]);
			}
		}
		this.getJspContext().getOut().write(sbf.toString());
	}
}
