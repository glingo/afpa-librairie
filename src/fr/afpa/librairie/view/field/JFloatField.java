
package fr.afpa.librairie.view.field;

import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;

public class JFloatField extends JFormattedTextField {

    public JFloatField(boolean strict) {
        super(NumberFormat.getNumberInstance());
        if(strict){
            setInputVerifier(new StrictInputVerifier());
        }
    }

}
