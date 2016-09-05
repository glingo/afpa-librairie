package fr.afpa.librairie.model.verifier;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

public class StrictInputVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        
        if (!(input instanceof JTextComponent)) {
          return true;
        }
        
        String text = ((JTextComponent) input).getText();
        
        Color color = "".equals(text) ? Color.red : Color.green;
        
        input.setBackground(color);
        
        return !"".equals(text);
    }
    
}
