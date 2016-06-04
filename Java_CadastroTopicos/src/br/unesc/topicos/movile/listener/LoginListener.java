package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.start.LoginJF;
import br.unesc.topicos.movile.bean.Login;
import br.unesc.topicos.movile.file.Persistencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.movile.start.MainJF;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginListener implements ActionListener {
    
    private final String mensagemSaida = "Você sairá de programa. Deseja realizar esta ação?";
    
    private LoginJF frame;
    private String usuarioCampo;
    private String senhaCampo;
    
    public LoginListener(LoginJF frame) {
        this.frame = frame;
        
    }
    
    public boolean isAlpha(String name) {
        
        return name.matches("[a-zA-Z-0-9]+");
    }
    
    public boolean isOnlyNum(String name) {
        return name.matches("[0-9]+");
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
                this.usuarioCampo = frame.getUsuario();
                this.senhaCampo = frame.getSenha();
               
                if (usuarioCampo.equals("") || senhaCampo.equals("")) {
                     JOptionPane.showMessageDialog(frame, "Preencha seu usuário e senha.");
                    return;
                }
                //Evita o login começar com número
                if (isOnlyNum(usuarioCampo.substring(0, 1))) {
                    JOptionPane.showMessageDialog(frame, "Login não pode começar com número");
                    return;
                }

                //Não permite símbolos no login
                if (!isAlpha(usuarioCampo)) {
                    JOptionPane.showMessageDialog(frame, "Login tem que ser alfanúmerico");
                    return;
                }
                
                if (usuarioCampo.equals(Login.usuarioMock) && senhaCampo.equals(Login.senhaMock)) {
                    JFrame principal = new MainJF();
                    principal.setVisible(true);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Login ou senha errado!");
                    return;
                }
                
                Persistencia persistencia = new Persistencia();
                persistencia.salvarArquivoGeral("Novo login no sistema, ID: " + this.usuarioCampo);
                persistencia.salvarArquivoDadosLogin(this.usuarioCampo);
                
                break;
        }
    }
}
