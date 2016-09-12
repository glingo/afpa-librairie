package fr.afpa.librairie.view.maquette;

import fr.afpa.librairie.data.bean.Genre;
import java.sql.*;
import java.util.*;

public class VectorGenerator {

    public Vector genererVector( String table, String id, String colonne1) {

        Vector v = new Vector();
        MyConnection myConnect = new MyConnection();

        Connection connect = myConnect.opening();

        try {//requete

            Statement s = connect.createStatement();//initie une saisie
            String query = "select * from "+table+" order by "+colonne1;//saisie de la commande en sql
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                v.add(new ClasseConstructorPourVector(table,
                        rs.getLong(id),
                        rs.getString(colonne1)));
            }

            rs.close();
            s.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL :" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        myConnect.closing();
        return v;
    }   
    
    public Vector genererVector( String table, String id, String colonne1, String colonne2) {

        Vector v = new Vector();
        MyConnection myConnect = new MyConnection();

        Connection connect = myConnect.opening();

        try {//requete

            Statement s = connect.createStatement();//initie une saisie
            String query = "select * from "+table+" order by "+colonne1;//saisie de la commande en sql
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                v.add(new ClasseConstructorPourVector(table,
                        rs.getLong(id),
                        rs.getString(colonne1), 
                        rs.getString(colonne2)));
            }

            rs.close();
            s.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL :" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        myConnect.closing();
        return v;
    }
      
}