package form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Select extends SimpleTagSupport {

	private String cssClass;
	private String value;
	private boolean checked;
	
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		if(cssClass != null) {
			list.add(String.format("class=\"%s\"", cssClass));
		}
		if(value != null) {
			list.add(String.format("value=\"%s\"", value));
		}
		if(checked) {
			list.add("checked=\"checked\"");
		}
		
		String str = String.join(" ", list);
		JspWriter jw = getJspContext().getOut();
		jw.write(String.format("<input type=\"checkbox\" %s>", str));
	
	}
	
}
