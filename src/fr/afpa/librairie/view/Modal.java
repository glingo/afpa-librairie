/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.view;

import java.awt.Component;
import java.awt.Dialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author cdi305
 */
public class Modal extends JDialog {
    
    private Component currentContent;
    
    private Runnable onDispose;

    public Modal(JFrame owner) {
        super(owner, Dialog.ModalityType.APPLICATION_MODAL);
    }
    
    public void setContent(Component component) {
        
        if (currentContent != null) {
            getContentPane().remove(currentContent);
        }
        
        currentContent = component;
        if(currentContent != null) {
            getContentPane().add(currentContent);
        }
    }

    @Override
    public void dispose() {
        if(this.onDispose != null) {
            this.onDispose.run();
        }
        super.dispose();
    }

    public Component getContent() {
        return currentContent;
    }

    public void onDispose(Runnable onDispose) {
        this.onDispose = onDispose;
    }
    
}
