import java.sql.DriverManager;
import java.sql.SQLException;

public class PrepareStatementDB {

	public static void main(String[] args) {
		try {
			
			java.util.Scanner input = new java.util.Scanner(System.in);
			String Name;
			int Age;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localHost:< port >/<databaseName>", "Username", "Password");
			
			
			
			java.sql.PreparedStatement sdisplay = con.prepareStatement("select * from mytable");
			java.sql.PreparedStatement psSearchN = con.prepareStatement("select * from mytable where Name=?");
			java.sql.PreparedStatement psSearchA = con.prepareStatement("select * from mytable where Age=?");
			java.sql.PreparedStatement psinsert = con.prepareStatement("insert into mytable(Name,Age) values(?,?)");
			java.sql.PreparedStatement psupdateN = con.prepareStatement("update mytable set Name=? where Age=?");
			java.sql.PreparedStatement psupdateA = con.prepareStatement("update mytable set Age=? where Name=?");
			java.sql.PreparedStatement psdelete = con.prepareStatement("delete from mytable where Name=? && Age=?");
			
			java.sql.ResultSet rs = null;

	            while(true) 
	            { 
		        	System.out.println("\n");
		            System.out.println("\t\t+------------------------------------------+");
		            System.out.println("\t\t|                                          |");
		            System.out.println("\t\t|  *_* Well come to DataBase Software *_*  |");
		            System.out.println("\t\t|                                          |");
		            System.out.println("\t\t|                           - Devesh Patil |");
		            System.out.println("\t\t+------------------------------------------+");
		            System.out.println("\t\t|   Using  : PrepareStatement              |");
		            System.out.println("\t\t+------------------------------------------+");
		            System.out.println("\t1 : Display Contents of DataBase");
		            System.out.println("\t2 : Insert Value to DataBase");
		            System.out.println("\t3 : Update Value from Databse");
		            System.out.println("\t4 : Delete Value from Databse");
		            System.out.println("\t5 : Search Name from Databse");
		            System.out.println("\t6 : Search Age from Databse");
		            System.out.println("\t7 : Exit\n");
		
		            System.out.print("Select the Approprate Option : ");   
		            int option = input.nextInt() ;
		            System.out.println();
		            if(option==7) {
		            	System.out.println("Thank you for using this Software");
		            	break;
		            }
		            
		            switch(option) 
		            {
		            	
			            case 1:
			            		       
			            		rs = sdisplay.executeQuery();
			            		System.out.println("+------\t+------\t+-----+");
			            		System.out.println("| Sr.No\t| Name \t| Age |");
			            		System.out.println("+------\t+------\t+-----+");
			            		
			            		while(rs.next()) {
			            			
			            			System.out.println("| "+rs.getInt(1)+"\t|"+rs.getString(2)+"\t| "+rs.getInt(3)+"  |");	
			            			
			            		}
			            		System.out.println("+------\t+------\t+-----+");
			            		rs.close();
			            	
			            	break;
			            				            
			            case 2:
			            		System.out.print("Enter the Name : ");
			            		Name = input.next();
			            		System.out.print("Enter the Age : ");
			            		Age = input.nextInt();
			            		
			            		psinsert.setString(1,Name);       
			            		psinsert.setInt(2, Age);       
			            		
			            		int i = psinsert.executeUpdate();
			            		
			            		if (i==1) { System.out.println("Value Inserted !"); }
			            		
			            		else { System.out.println("Value Not Intserted"); }
			            	
			            	break;
			            	
			            case 3:
			            		
				            	System.out.println(" Select Optiong for Update Values ");	
			            		System.out.println("1 : Update Age by Name");	
			            		System.out.println("2 : Update Name by Age");
			            		System.out.print("Enter the Option : ");
			            		int opt = input.nextInt();
			            		
			            		if(opt==1) {
			            			// 	Set Age by the Name
			            			System.out.print("\nEnter the Name : ");
			            			Name = input.next();
			            			System.out.print("Enter the Upgradable Age : ");
			            			Age = input.nextInt();
			            			
			            			psupdateA.setInt(1, Age);
			            			psupdateA.setString(2, Name);
			            			
			            			int u = psupdateA.executeUpdate();
				            						            		
				            		if (u==1) {  System.out.println("Value Updated !");   }
					            		
					            	else { System.out.println("Update Operation fail !"); }
			            			                   			
			            		}
			            		else if (opt==2){
			            			System.out.print("Enter the Age : ");
			            			Age = input.nextInt();
			            			System.out.print("Enter the Upgradable Name : ");
			            			Name = input.next();
			            			
			            			psupdateN.setString(1, Name);
			            			psupdateN.setInt(2, Age);
			            			
			            			int u = psupdateN.executeUpdate();
				            						            		
				            		if (u==1) {  System.out.println("Value Updated !");   }
				            		
				            		else { System.out.println("Update Operation fail !"); }
			            		}
			            		
			            		else { System.out.println("Invalied Option !"); }
			            					            		
			            	break;
			            
			            case 4: //		Code for the Delete Operation form DataBase
			            		
			            		System.out.println("Enter Details for Delete");
			            		System.out.print("Enter the Name : ");
			            		Name = input.next();
			            		System.out.print("Enter the Age : ");
			            		Age = input.nextInt();
			            		
			            		psdelete.setString(1, Name);
			            		psdelete.setInt(2, Age);
			            		
			            		int d = psdelete.executeUpdate();
			            		
			            		if (d==1) {	System.out.println("Record Deleted !");	}
			            		
			            		else { System.out.println("Delete Operation fail !"); }
			            		
			            	break;
			            	
			            case 5:
			            	System.out.println("\t\tSearch Name from Databse");
			            	System.out.print("Enter the Name to Search : ");
				            Name = input.next();
				            
				            psSearchN.setString(1, Name);
				            
			            	rs = psSearchN.executeQuery();
				            System.out.println(rs);
				            
				            if (rs == null) {
				            	System.out.println("Invalied Name ! Cannot found in DataBase !");
				            }
				            else {
				            	System.out.println("+------\t+------\t+-----+");
			            		System.out.println("| Sr.No\t| Name \t| Age |");
			            		System.out.println("+------\t+------\t+-----+");
			            		while (rs.next()) {
			            		System.out.println("| "+rs.getInt(1)+"\t|"+rs.getString(2)+"\t| "+rs.getInt(3)+"  |");	
			            		}
			            		System.out.println("+------\t+------\t+-----+");
			            		rs.close();
					            
				            }
			            	
				            break;
				            
			            case 6:
			            	System.out.println("\t\tSearch Age from Databse");
			            	System.out.println("Enter the Age to Search : ");
			            	Age = input.nextInt();
			            	
			            	psSearchA.setInt(1, Age);
			            	
			            	rs = psSearchA.executeQuery();
			            	
			            	if (rs == null) {
				            	System.out.println("Invalied Age ! Cannot found in DataBase !");
				            }
				            else {
				            	System.out.println("+------\t+------\t+-----+");
			            		System.out.println("| Sr.No\t| Name \t| Age |");
			            		System.out.println("+------\t+------\t+-----+");
			            		while(rs.next()) {
			            			System.out.println("| "+rs.getInt(1)+"\t|"+rs.getString(2)+"\t| "+rs.getInt(3)+"  |");	
			            		}
			            		System.out.println("+------\t+------\t+-----+");
			            		rs.close();
				            }
			            	
				            break;
			           
			            default : 
			            	System.out.println("Invilied Option !");
			            	break;
		            
		           }                                     
	            
	           }
	           input.close();
	           con.close();
	           sdisplay.close();
	           psinsert.close();
	           psupdateN.close();
	           psupdateA.close();
	           psdelete.close();
		}
		catch(ClassNotFoundException cnfe) { cnfe.printStackTrace(); } 
		catch (SQLException e) { e.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }

	}

}
