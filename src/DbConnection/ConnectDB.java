package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB 
{
	public static Connection con = null;
	public static Connection dbCon()
	{
try
{
	if(con==null){
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver loaded");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm_for_ispdb","root","");
	System.out.println("connection establish:"+con);
	}
}
catch(Exception e)
{
	e.printStackTrace();
}
return con;
}
}
