
package br.com.pdv.model;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Utilitarios {
    //metodo para limpar todos os campos de texto em um container e seus componetes
   
   
    public void LimpaTela(Component container) {
            if (container instanceof JTextField){ 
            ((JTextField)container).setText(null);
            } else if (container instanceof JPanel){
                Component[] components = ((JPanel) container).getComponents();
                for (Component component : components){
                    LimpaTela(component);//Chamada recursiva para componentes aninhados
                }
            }else if (container instanceof JTextPane){ 
            ((JTextPane)container).setText(null); 
            }
        }   
    }

