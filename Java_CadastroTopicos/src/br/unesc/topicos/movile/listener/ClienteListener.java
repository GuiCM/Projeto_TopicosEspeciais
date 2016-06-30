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

        Cliente cliente = null;
        ClienteDAO clienteDAO = new ClienteDAO();
        Persistencia persistencia = new Persistencia();

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
                cliente = frame.getDadosCampos();

                if (cliente == null) {
                    return;
                }

                clienteDAO.insert(cliente);
                //Salva um log de cadastro

                persistencia.salvarArquivoGeral("Novo cliente cadastrado.");

                frame.dispose();
                break;
            case "Excluir":
                //TODO: habilitar apenas quando tem registro na tela

                cliente = frame.getDadosCampos();
              
                if (cliente == null) {
                    return;
                }
                
                clienteDAO.delete(cliente);

                 persistencia.salvarArquivoGeral("Cadastro de cliente " + cliente.getNome()+  " removido.");
                break;

            case "Buscar":
                System.out.println("buscar");
                break;
            case "<":
                System.out.println("ant");
                break;
            case ">":
                System.out.println("prox");
                break;
        }
    }

}
