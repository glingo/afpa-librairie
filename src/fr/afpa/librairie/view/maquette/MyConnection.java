package fr.afpa.librairie.view.maquette;

import java.sql.*;


public class MyConnection {

    Connection connect = null;

    
    public Connection opening (){
        
        
          try {//connexion universelle
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:ClassNotFound:" + ex.getMessage());
        }

        try {//identification
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=bd_librairie;user=sa;password=sa";
            connect = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.err.println("Oops:SQLConnexion:" + ex.getMessage());
        }

        
        /*
        try {//requete
            Statement stmt = connexion.createStatement();//initie une saisie
            String query = "select libelle from Genre ";//saisie de la commande en sql
             ResultSet rs = stmt.executeQuery(query);
                      while (rs.next()) {
                System.out.println(rs.getString("libelle"));              
            }

            rs.close();
            stmt.close();
                                              
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQL x :"+ex.getErrorCode() + "/"+ ex.getMessage());
        }
        //*/
        return connect;
//        try {//fermeture de la connexion
//            connect.close();
//        } catch (SQLException ex) {
//            System.err.println("Oops:SQLclose:" + ex.getMessage());
//        }
    }
    
    public void closing(){
        try {//fermeture de la connexion
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQLclose:" + ex.getMessage());
        }
    }
}
