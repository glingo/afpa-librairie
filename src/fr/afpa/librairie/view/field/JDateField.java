package fr.afpa.librairie.view.field;

import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;

public class JDateField extends JFormattedTextField {

    public JDateField(boolean strict) {
        super(new SimpleDateFormat("dd-MM-yyyy"));
        if(strict) {
            setInputVerifier(new StrictInputVerifier());
        }
    }

    @Override
    public Date getValue() {
        return (Date) super.getValue(); //To change body of generated methods, choose Tools | Templates.
    }
}
