
package Clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EventosCadastroCliente implements ActionListener {
    private InternalFrameCadastroCliente frame;
    
    public EventosCadastroCliente(InternalFrameCadastroCliente frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
    
        }
    }
}
