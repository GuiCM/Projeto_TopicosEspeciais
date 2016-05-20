package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.view.LoginJIF;
import br.unesc.topicos.movile.bean.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.movile.iniciar.MainFrame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginListener implements ActionListener {

    private final String mensagemSaida = "Você sairá de programa. Deseja realizar esta ação?";

    private LoginJIF frame;
    private String usuario;
    private String senha;

    public LoginListener(LoginJIF frame) {
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()) {
            case "Sair":
                int result;
                result = JOptionPane.showConfirmDialog(null, mensagemSaida, "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);

                if (result == 0) {
                    System.exit(0);
                }
                break;

            case "Entrar":                
                this.usuario = frame.getUsuario();
                this.senha = frame.getSenha();
                           
                if (usuario.equals(Login.usuario) && senha.equals(Login.senha)) {
                    JFrame principal = new MainFrame();
                    principal.setVisible(true);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Login ou senha errado!");
                }
                break;
        }
    }
}