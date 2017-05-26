package test3;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.text.DateFormat;


public class CurrentDateTag extends TagSupport {
  
	private static final long serialVersionUID = 1L;

	@Override
    public int doStartTag() throws JspException {
        Date currentDate = new Date();
        DateFormat dfs = DateFormat.getDateInstance(DateFormat.SHORT);
        String currentDateFormatted = dfs.format(currentDate);

        try {
            JspWriter out = pageContext.getOut();
            out.print(currentDateFormatted);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }
}
