package java_cadastrotopicos.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java_cadastrotopicos.MDIContainer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EventosLogin implements ActionListener {
    
    private final String mensagemSaida = "Você sairá de programa. Deseja realizar esta ação?";
    
    private JFrameLogin frame;
    
    public EventosLogin(JFrameLogin frame){
        this.frame = frame;
    }
    
    public void actionPerformed(ActionEvent ev) {
        switch (ev.getActionCommand()) {
            case "Sair":
                int result;
                result = JOptionPane.showConfirmDialog(null, mensagemSaida, "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);
                
                if (result == 0) 
                    System.exit(0);
                break;
            case "Entrar":
                JFrame principal = new MDIContainer();
                principal.setVisible(true);
                frame.dispose();                
                break;
        }
        
    }
}
