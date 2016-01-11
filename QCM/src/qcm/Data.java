/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rayanmehdi1
 */
public class Data {
    Connection c;
    ArrayList<Professeur> prof = new ArrayList<>();
    
    /*public void recupProf () throws SQLException{
        Statement st=c.createStatement();
    //    ResultSet rs=st.executeQuery("Select * from Professeur");
       // while(rs.next())
           // prof.add(new Professeur())
            
        
        
  //  }*/
   
    
    public Data() throws SQLException, InstantiationException, IllegalAccessException{
        try
        {
            Class.forName( "org.sqlite.JCBD").newInstance();
        }
        catch(ClassNotFoundException e){                
        }
        catch(InstantiationException e){
            
        }
        catch(IllegalAccessException e){
            
        }
        c=DriverManager.getConnection("jdbc:sqlite:QCM.sqlite");
              
    }
    
}
