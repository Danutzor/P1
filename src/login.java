import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danut
 */
     class demo {
    public static void main(String[] args) throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        String user = "root";
        String password="";
        try{
            myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/nba", user, password);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery("select * from player");
            while(myRs.next()) {
                System.out.println(myRs.getString("Nume") +","+myRs.getString("Prenume"));
            }
        }  catch (Exception exc) {
            exc.printStackTrace();
        } finally{
            if(myRs != null) {
            myRs.close();
        }
            if(myStmt !=null){
                myStmt.close();
            }
            if(myConn !=null){
                myConn.close();
            }
        }
    }
}

