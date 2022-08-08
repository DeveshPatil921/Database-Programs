

import java.sql.DriverManager;


public class datadb {

	public static void main(String[] args) throws ClassNotFoundException {
		
				
		try
        {
            java.util.Scanner input = new java.util.Scanner(System.in);
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("\tIntialized the Drivers !");
            
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localHost:< port >/<databaseName>", "Username", "Password");
            System.out.println("\t\tConnected to Database !");
            
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet rs = null;

            while(true) 
            { 
	        	System.out.println("\n");
	            System.out.println("\t\t[------------------------------------------]");
	            System.out.println("\t\t[                                          ]");
	            System.out.println("\t\t[  *_* Well come to DataBase Software *_*  ]");
	            System.out.println("\t\t[                                          ]");
	            System.out.println("\t\t[------------------------------------------]");
	            System.out.println("\t1 : Display Contents of DataBase");
	            System.out.println("\t2 : Insert Value to DataBase");
	            System.out.println("\t3 : Update Value from Databse");
	            System.out.println("\t4 : Delete Value from Databse");
	            System.out.println("\t5 : Exit\n");
	
	            System.out.print("Select the Approprate Option : ");   
	            int option = input.nextInt() ;
	            System.out.println();
	            if(option==5) {
	            	System.out.println("Thank you for using this Software");
	            	break;
	            }
	            
	            switch(option) 
	            {
	            	
		            case 1:
		            		String Display = "select * from mytable";       
		            		rs = stm.executeQuery(Display);
		            		System.out.println("_______\t_______\t_____\t");
		            		System.out.println("| Sr.No\t| Name \t| Age\t|");
		            		System.out.println("+------\t+------\t+----\t+");
		            		
		            		while(rs.next()) {
		            			
		            			System.out.println("| "+rs.getInt(1)+"\t|"+rs.getString(2)+"\t| "+rs.getInt(3)+"\t|");	
		            			
		            		}
		            		System.out.println("+------\t+------\t+----\t+");
		            		rs.close();
		            		break;
		            	
		            
		            case 2:
		            		System.out.print("Enter the Name : ");
		            		String name = input.next();
		            		System.out.print("Enter the Age : ");
		            		int age = input.nextInt();
		            		String Insert = "insert into mytable(Name,Age) values('"+name+"',"+age+")";       
		            		int i = stm.executeUpdate(Insert);
		            		if (i==1) {
		            			System.out.println("Value Inserted !");
		            			System.out.println(Insert);
		           			
		            		}
		            		else {
		            			System.out.println("Value Not Intserted");
		            		}
		            		break;
		
		            
		            case 3:
		            		String Update = "Update mytable setAge=18 where X='x'";
		            		System.out.println("1 : Update Age by Name");	
		            		System.out.println("2 : Update Name by Age");
		            		System.out.print("Enter the Optiong : ");
		            		int opt = input.nextInt();
		            		if(opt==1) {
		            			System.out.print("Enter the Name : ");
		            			String n = input.next();
		            			System.out.print("Enter the Upgradable Age : ");
		            			int a = input.nextInt();
		            			Update = "update mytable set Age="+a+" where Name='"+n+"'";                   			
		            		}
		            		else if (opt==2){
		            			System.out.print("Enter the Age : ");
		            			int a = input.nextInt();
		            			System.out.print("Enter the Upgradable Name : ");
		            			String n = input.next();
		            			Update = "update mytable set Name='"+n+"' "+"where Age="+a;       
		            		}
		            		else { System.out.println("Invalied Option !");}
		            		
		            		int u = stm.executeUpdate(Update);
		            		System.out.println(u);
		            		
		            		if (u==1) {  System.out.println("Value Updated !");   }
		            		
		            		else { System.out.println("Update Operation fail !"); }
		            		break;
		            
		            case 4: //		Code for the Delete Operation form DataBase
		            		System.out.print("Enter the Name which have to Delete : ");
		            		String nm = input.next();
		            		String Delete = "delete from mytable where Name='"+nm+"'";       
		            		int d = stm.executeUpdate(Delete);
		            		
		            		if (d==1) {
		            			System.out.println("Record Deleted !");            			
		            			System.out.println(Delete);		            				         			
		            		}
		            		else {
		            			System.out.println("Delete Operation fail !");
		            		}
		            		break;
		           
		            default : 
		            	System.out.println("Invilied Option !");
		            	break;
	            
	            
	           }                                     
            
           }
           input.close();
            stm.close();
            con.close();
            
        } 
        catch(ClassNotFoundException ex){ ex.printStackTrace(); }
		catch(Exception e){ System.out.println(e); }
		

	}

}
