package Tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PhoneTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		this.getJspBody().invoke(sw);
		String s = sw.toString().trim();
		if(s.length() > 7) {
			StringBuffer sbf = new StringBuffer();
			sbf.append(s.substring(0,3));
			for (int i = 3; i < s.length() - 4; i++) {
		        sbf.append("*"); 
		    }
		    sbf.append(s.substring(s.length() - 4)); 
		    s = sbf.toString(); 
		}else {
			StringBuffer sbf = new StringBuffer();
			sbf.append(s.substring(0,1));
			for (int i = 1; i < s.length() - 2; i++) {
		        sbf.append("*"); 
		    }
		    sbf.append(s.substring(s.length() - 2)); 
		    s = sbf.toString(); 
		}
		this.getJspContext().getOut().write(s);
	}
}
