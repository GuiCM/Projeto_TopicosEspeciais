package java_cadastrotopicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginEventos implements ActionListener {
    
    private final String mensagemSaida = "Você sairá de programa. Deseja realizar esta ação?";
    
    public void actionPerformed(ActionEvent ev) {
        switch (ev.getActionCommand()) {
            case "Sair":
                int result;
                result = JOptionPane.showConfirmDialog(null, mensagemSaida, "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);
                
                if (result == 0) 
                    System.exit(0);
                break;
        }
        
    }
}
