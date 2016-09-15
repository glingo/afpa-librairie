
package fr.afpa.librairie.view.field;

import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;

public class JIntegerField extends JFormattedTextField {
    public JIntegerField(boolean strict) {
        super(NumberFormat.getInstance());
        if(strict){
            setInputVerifier(new StrictInputVerifier());
        }
    }

    @Override
    public Integer getValue() {
       if(super.getValue() == null) {
            return null;
        }
        
        return ((Number) super.getValue()).intValue();
    }
    
    
}
