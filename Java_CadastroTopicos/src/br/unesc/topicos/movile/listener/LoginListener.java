package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.start.LoginJF;
import br.unesc.topicos.movile.bean.Login;
import br.unesc.topicos.movile.controle.LoginDAO;
import br.unesc.topicos.movile.file.Persistencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.movile.start.MainJF;
import java.util.List;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Login login = null;
        LoginDAO loginDAO = new LoginDAO();

        switch (e.getActionCommand()) {
            case "Sair":
                int result;
                result = JOptionPane.showConfirmDialog(null, mensagemSaida, "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);

                if (result == 0) {
                    System.exit(0);
                }
                break;
            case "Entrar":
                login = frame.getDadosCampos();

                if (login.getUsuario().length() == 0) {
                    return;
                }

                for (Login l : loginDAO.getAll()) {
                    if (login.getUsuario().equals(l.getUsuario())
                            && login.getSenha().equals(l.getSenha())) {

                        JFrame principal = new MainJF();
                        principal.setVisible(true);
                        frame.dispose();

                        Persistencia persistencia = new Persistencia();
                        persistencia.salvarArquivoGeral("Novo login no sistema, ID: " + this.usuarioCampo);
                        persistencia.salvarArquivoDadosLogin(this.usuarioCampo);

                        break;
                    }

                }

                JOptionPane.showMessageDialog(frame, "Seu usuário e senha estão incorretos, "
                        + "ou este usuário não existe no sistema!");
                break;
            case "Registrar":
                login = frame.getDadosCamposRegistrar();

                if (login.getUsuario().length() == 0) {
                    return;
                }              

                loginDAO.insert(login);
                break;

        }
    }
}
