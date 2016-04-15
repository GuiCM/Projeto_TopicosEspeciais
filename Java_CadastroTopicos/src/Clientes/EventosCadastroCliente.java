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
            case "Cancelar":
                int result;
                result = JOptionPane.showConfirmDialog(null, "Deseja salvar alterações?", "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);
                
                if (result == 0) 
                    //TODO: salvar
                    frame.dispose();
                else
                    frame.dispose();
                break;            
            case "Salvar":
                Clientes cliente = new Clientes(); //Salvar  
                frame.dispose();
                break;
        }
    }
}
