package br.com.pdv.model;

import java.awt.Component;
import javax.swing.JPanel;
import java.awt.Container;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;

public class Utilitarios {
    //metodo para limpar todos os campos de texto em um container e seus componetes

public void LimpaTela(JPanel container) {
        limpaComponentes(container);
    }
    
    private void limpaComponentes(Component container) {
        if (container instanceof JTextField) {
            ((JTextField) container).setText(null);
        } else if (container instanceof JTextPane) {
            ((JTextPane) container).setText(null);
        } else if (container instanceof JTabbedPane) {
            JTabbedPane tabbedPane = (JTabbedPane) container;
            int count = tabbedPane.getTabCount();
            for (int i = 0; i < count; i++) {
                Component tabComponent = tabbedPane.getComponentAt(i);
                if (tabComponent instanceof JPanel) {
                    limpaComponentes(tabComponent);
                }
            }
        } else if (container instanceof JPanel) {
            Component[] components = ((JPanel) container).getComponents();
            for (Component component : components) {
                limpaComponentes(component); // Chama recursivamente para lidar com subcontêineres
            }
        }
    }
}
