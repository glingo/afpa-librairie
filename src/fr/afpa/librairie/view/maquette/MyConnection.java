package fr.afpa.librairie.view.maquette;

import java.sql.*;

public class MyConnection {

    Connection connect = null;

    public Connection opening() {

        try {//connexion universelle
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:ClassNotFound:" + ex.getMessage());
        }

        try {//identification
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=bdd_librairie;user=sa;password=sa";
            connect = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.err.println("Oops:SQLConnexion:" + ex.getMessage());
        }

        return connect;
    }

    public void closing() {
        try {//fermeture de la connexion
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQLclose:" + ex.getMessage());
        }
    }
}
