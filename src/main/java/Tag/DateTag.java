package Tag;

import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import yaoping.loginSeverLet;

public class DateTag extends SimpleTagSupport{
	private String pattern;                   
	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}



	@Override
	public void doTag() throws JspException, IOException {
		//定义一个输出流，用于存储标签体内容
		StringWriter sw = new StringWriter();
		//将标签体的内容保存到sw输出流
		//输出标签体中的内容
		this.getJspBody().invoke(sw);//为空就写到浏览器，不为空就写到sw
		String s = sw.toString();
		
		
		Date now = new Date();
		//格式化日期
		DateFormat fmt = new SimpleDateFormat(this.pattern);
		String str = fmt.format(now);
		
		JspWriter out = this.getJspContext().getOut();
		out.print(str);
	}
}
