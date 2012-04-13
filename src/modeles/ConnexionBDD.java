package modeles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBDD {
	
	public static Connection Con ;
	static Statement St ;

	public ConnexionBDD(){
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mydb";
		String login="root";
		String pswd="";
		        
		try
		   {
		       	Class.forName(driver);
		       	System.out.println("Driver OK");
		   }
		catch(ClassNotFoundException E)
	    	{
				System.out.println("Problème de chargement de driver");
	    	}
		try
		    {
		        Con = DriverManager.getConnection(url,login ,pswd );
		        System.out.println("Connexion établie");
		    }
		catch(SQLException E)
		    {
		        System.out.println("Problème de connexion");
		    }
				
	}

}
