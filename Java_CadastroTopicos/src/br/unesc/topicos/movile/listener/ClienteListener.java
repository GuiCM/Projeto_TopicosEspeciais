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
    private ClienteDAO clienteDAO = new ClienteDAO();   
    private List<Cliente> lista; //Receber a lista de clientes do banco
    private int posRegistro; //Posicao do registro

    public ClienteListener(ClienteJIF frame) {
        this.frame = frame;
    }

    //Carregar todos os dados quando a janela é aberta
    public void load() {
       posRegistro = 0;
       lista = clienteDAO.getAll();
       preencherCampos(lista, posRegistro);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Cliente cliente = null;
        Persistencia persistencia = new Persistencia();

        switch (e.getActionCommand()) {
       
            case "Salvar":
                cliente = frame.getDadosCampos();
                clienteDAO.insert(cliente);
                load();
                break;
            case "Cancelar":
                frame.dispose();
                break;
            case "Atualizar":
                int codigo = lista.get(posRegistro).getCodigo();
                cliente = frame.getDadosCampos();
                cliente.setCodigo(codigo);
                
                if (cliente.getNome().length() == 0) {
                    return;
                }

                clienteDAO.update(cliente);
                persistencia.salvarArquivoGeral("Cliente: " + cliente.getCodigo() + ", " + cliente.getNome() + " atualizado!");
                load();
                break;
            case "Excluir":
                //TODO: habilitar apenas quando tem registro na tela
                cliente = lista.get(posRegistro);
              
                if (cliente.getNome().length() == 0) {
                    return;
                }
                
                clienteDAO.delete(cliente);
                persistencia.salvarArquivoGeral("Cadastro de cliente: " + cliente.getNome() +  " removido.");
                load();
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
