package Tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ColorTag extends SimpleTagSupport {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public void doTag() throws JspException, IOException {
        StringWriter sw = new StringWriter();
        this.getJspBody().invoke(sw);
        String s = sw.toString().trim();
        int num = Integer.parseInt(s);
        String color = "";

        if (value != null && !value.isEmpty()) {
            color = value;
        } else if (num < 0) {
            color = "red";
        } else if (num < 1000) {
            color = "green";
        } else {
            color = "blue";
        }

        String span = "<span style='color:" + color + ";'>" + s + "</span>";
        this.getJspContext().getOut().write(span);
    }
}
