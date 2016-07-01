package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.bean.Cliente;
import br.unesc.topicos.movile.controle.ClienteDAO;
import br.unesc.topicos.movile.file.Persistencia;
import br.unesc.topicos.movile.view.ClienteJIF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteListener implements ActionListener {
    private ClienteJIF frame;
    private List<Cliente> lista;
    private ClienteDAO clienteDAO = new ClienteDAO();
    private int posRegistro = 0;

    public ClienteListener(ClienteJIF frame) {
        this.frame = frame;
        
        //Quando abre a janela puxa todos os clientes
        lista = clienteDAO.getAll();
    }

    public void load() {
       preencherCampos(lista, posRegistro); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Cliente cliente = null;
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

                if (cliente.getNome().length() == 0) {
                    return;
                }

                clienteDAO.insert(cliente);
                //Salva um log de cadastro

                persistencia.salvarArquivoGeral("Novo cliente cadastrado.");
                frame.dispose();
                break;
            case "Excluir":
                //TODO: habilitar apenas quando tem registro na tela
                cliente = lista.get(posRegistro);
              
                if (cliente.getNome().length() == 0) {
                    return;
                }
                
                clienteDAO.delete(cliente);
                persistencia.salvarArquivoGeral("Cadastro de cliente: " + cliente.getNome() +  " removido.");
                lista = clienteDAO.getAll();
                posRegistro = 0;
                preencherCampos(lista, posRegistro);                    
                break;

            case "Buscar":
                String textoBusca = frame.getDadosBusca();
                if (textoBusca.length() > 0) {
                    lista = clienteDAO.getAll(textoBusca);
                } else
                    lista = clienteDAO.getAll();
                
                posRegistro = 0;
                preencherCampos(lista, posRegistro);
                break;
            case "<":
                posRegistro--;
                if (posRegistro < 0)
                    posRegistro = lista.size() - 1;
                preencherCampos(lista, posRegistro);
                break;
            case ">":       
                posRegistro++;
                if (posRegistro >= lista.size())
                    posRegistro = 0;
                preencherCampos(lista, posRegistro);
                break;
        }
    }
    
    private void preencherCampos(List<Cliente> lista, int pos) {
            frame.setDadosCampos(lista.get(pos));
    }

}
