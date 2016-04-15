package Empreiteiras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EventosCadastroEmpreiteiras implements ActionListener {
    private InternalFrameCadastroEmpreiteiras frame;
    
    public EventosCadastroEmpreiteiras(InternalFrameCadastroEmpreiteiras frame){
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
                Empreiteiras empreiteira = new Empreiteiras(); //Salvar 
                frame.dispose();
                break;
        }
    }
}
