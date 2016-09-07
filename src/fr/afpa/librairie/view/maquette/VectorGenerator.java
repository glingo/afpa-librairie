package fr.afpa.librairie.view.maquette;

import fr.afpa.librairie.data.bean.Genre;
import java.sql.*;
import java.util.*;

public class VectorGenerator {

    public Vector genererVector(String table, String id, String colonneAAfficher) {

        Vector vGenre = new Vector();
        MyConnection myConnect = new MyConnection();

        Connection connect = myConnect.opening();

        try {//requete

            Statement s = connect.createStatement();//initie une saisie
            String query = "select * from "+table;//saisie de la commande en sql
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                vGenre.add(new Genre(rs.getLong(id),
                        rs.getString(colonneAAfficher)));
            }

            rs.close();
            s.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL :" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        myConnect.closing();
        return vGenre;
    }
}
