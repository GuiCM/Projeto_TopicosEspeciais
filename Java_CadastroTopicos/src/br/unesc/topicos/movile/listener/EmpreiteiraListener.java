package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.bean.Empreiteira;
import br.unesc.topicos.movile.view.EmpreiteiraJIF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EmpreiteiraListener implements ActionListener {
    private EmpreiteiraJIF frame;
    
    public EmpreiteiraListener(EmpreiteiraJIF frame){
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
                Empreiteira empreiteira = new Empreiteira(); //Salvar 
                frame.dispose();
                break;
                
            case "Excluir":
                
                break;
        }
    }
}
