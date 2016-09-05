package fr.afpa.librairie.view.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class FormPanel extends JPanel {

//    String[] labels;
//    int[] widths;
//    Class<JComponent>[] types;
    Map<String, JComponent> fields;
    
    public FormPanel() {
        init();
    }
    
//    public FormPanel(String[] labels, int[] widths, Class[] types) {
//        this.labels = labels;
//        this.widths = widths;
//        this.types = types;
//        init();
//    }
    
    public Map<String, JComponent> getFields(){
        if(this.fields == null) {
            this.fields = new HashMap<>();
        }
        
        return this.fields;
    }
    
    public void addField(String label, JComponent component) {
        getFields().put(label, component);
    }
    
    public <T> T getField(String name) {
        return (T) getFields().get(name);
    }
    
    public void verify() {
        getFields().values().forEach((JComponent field) -> {
            if(field.getInputVerifier() != null) {
                field.getInputVerifier().verify(field);
            }
        });
    }
    
    public void reset() {
        getFields().values().forEach((JComponent field) -> {
            if(field instanceof JTextComponent) {
                ((JTextComponent) field).setText("");
            }
            
            if(field instanceof JRadioButton) {
                ((JRadioButton) field).setEnabled(false);
            }
            
            field.setBackground(Color.white);
            
            repaint();
        });
    }
    
    public void createForm(){
        
        JPanel labelPanel = new JPanel(new GridLayout(getFields().size(), 1));
        JPanel fieldPanel = new JPanel(new GridLayout(getFields().size(), 1));
        
        for (Map.Entry<String, JComponent> entry : getFields().entrySet()) {
            String label = entry.getKey();
            JComponent field = entry.getValue();
            
            JLabel lab = new JLabel(label, JLabel.RIGHT);
            lab.setLabelFor(field);
            labelPanel.add(lab);
            
//            JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));
            
            JPanel flow = new JPanel(new FlowLayout(FlowLayout.CENTER));
            flow.add(field);
            fieldPanel.add(flow);
//            fieldPanel.add(field);
            
        }
        
        add(labelPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);
        
        repaint();
    }

    private void init() {
        setLayout(new BorderLayout());
    }
}
