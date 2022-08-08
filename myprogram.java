
public class myprogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		write a jdbc program to fetch employee recored by using type 1 jdbc drvier
		try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
				java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:odbc:orddsn","Username","password");
				
				java.sql.Statement stm = con.createStatement();
				
				java.sql.ResultSet rs = stm.executeQuery("select * from Employee");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
					
				}
				rs.close();
				stm.close();
				con.close();
		
		}
		catch(ClassNotFoundException ex) { System.out.println(ex); }
		catch(java.sql.SQLException sqlex) { System.out.println(sqlex); }
		
	}

}
