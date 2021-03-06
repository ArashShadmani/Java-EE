package test3;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.text.DateFormat;


public class IfWeekdayTag extends TagSupport {
  
	private static final long serialVersionUID = 1L;

	@Override
    public int doStartTag() throws JspException {
        Calendar currentDate= new GregorianCalendar();
        int day= currentDate.get(Calendar.DAY_OF_WEEK);
        if (day==Calendar.SATURDAY || day==Calendar.SUNDAY){
        	return SKIP_BODY;
        } else{
        	return EVAL_BODY_INCLUDE;
        }
    }
}
