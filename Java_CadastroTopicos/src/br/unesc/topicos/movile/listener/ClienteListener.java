package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.bean.Cliente;
import br.unesc.topicos.movile.controle.ClienteDAO;
import br.unesc.topicos.movile.file.Persistencia;
import br.unesc.topicos.movile.view.ClienteJIF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;

public class ClienteListener implements ActionListener {

    private ClienteJIF frame;

    public ClienteListener(ClienteJIF frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cliente cliente = frame.getFieldData();
        ClienteDAO clienteDAO = new ClienteDAO();
        switch (e.getActionCommand()) {
            case "Cancelar":
                int result;
                result = JOptionPane.showConfirmDialog(null, "Deseja salvar alterações?", "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);

                if (result == 0) //TODO: salvar
                {
                    frame.dispose();
                } else {
                    frame.dispose();
                }
                break;
            case "Salvar":

                clienteDAO.insert(cliente);

                if (cliente == null) {
                    return;
                }

                //Salva um log de cadastro
                Persistencia persistencia = new Persistencia();

                persistencia.salvarArquivoGeral("Novo cliente cadastrado.");

                frame.dispose();
                break;
            case "Excluir":

                clienteDAO.delete(cliente);
                break;
        }
    }

}
