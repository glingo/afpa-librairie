package fr.afpa.librairie.view.maquette;

public class ClasseConstructorPourVector {

    private String classe;
    private long id;
    private String colonne1;
    private String colonne2;

    public ClasseConstructorPourVector(){
        
    }
    
    public ClasseConstructorPourVector(String classe, long id, String colonne1) {
        this.classe = classe;
        this.id = id;
        this.colonne1 = colonne1;
    }

    public ClasseConstructorPourVector(String classe, long id, String colonne1, String colonne2) {
        this.classe = classe;
        this.id = id;
        this.colonne1 = colonne1;
        this.colonne2 = colonne2;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColonne1() {
        return colonne1;
    }

    public void setColonne1(String colonne1) {
        this.colonne1 = colonne1;
    }

    public String getColonne2() {
        return colonne2;
    }

    public void setColonne2(String colonne2) {
        this.colonne2 = colonne2;
    }

    public String toString() {
        String str = "";
        if (colonne2==null) {
            str = colonne1;
        } else {
            str = colonne1 + " " + colonne2;
        }
        return str;
    }
}
