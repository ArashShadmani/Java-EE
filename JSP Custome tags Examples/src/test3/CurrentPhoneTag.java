package test3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CurrentPhoneTag extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn= null;
    private int id;
    private String phone;

	public void setId(int id) {
		this.id = id;
	}

	public String setPhone(String phone) {
		return this.phone = phone;
	}

	public CurrentPhoneTag(int id, String phone) {
		super();
		this.id = id;
		this.phone = phone;
	}

	public CurrentPhoneTag() {
		super();
	}
    
	@Override
    public int doStartTag() throws JspException {
	   CurrentPhoneTag cp = new CurrentPhoneTag();
	   String phone = cp.SelectByID(1);
        try {
            JspWriter out = pageContext.getOut();
            out.print(phone);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }  
	
	
	public Connection getConnection() throws ClassNotFoundException {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "hr";
			String password = "oracle";
			conn = DriverManager.getConnection(url, username, password);
		}
		catch(SQLException e){
	       System.out.println("Error in DaoImplement.Connection : " + e);		
		}
		return conn;
	}
	
	public String SelectByID(int id) {
		CurrentPhoneTag s=null;
		String phone=null;
		try
		{
		  PreparedStatement ps = getConnection().prepareStatement
				("select * from person where id= ?");
		  ps.setInt(1, id);
		  ResultSet rs= ps.executeQuery();
		  rs.next();
		  s= new CurrentPhoneTag();
		  s.setId(rs.getInt("id"));
		  phone= s.setPhone(rs.getString("phone"));
		  rs.close();
		  conn.close();
		  ps.close();
		}
		catch(Exception e){
			System.out.println("Error in DAOStudentImp.SelectById : " + e);
		}
		return phone;
	}

}
