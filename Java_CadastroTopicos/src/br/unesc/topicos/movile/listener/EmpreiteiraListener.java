package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.bean.Empreiteira;
import br.unesc.topicos.movile.controle.EmpreiteiraDAO;
import br.unesc.topicos.movile.file.Persistencia;
import br.unesc.topicos.movile.view.EmpreiteiraJIF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpreiteiraListener implements ActionListener {

    private EmpreiteiraJIF frame;
    private EmpreiteiraDAO empreiteiraDAO = new EmpreiteiraDAO();
    private List<Empreiteira> lista;
    private int posRegistro = 0;
    

    public EmpreiteiraListener(EmpreiteiraJIF frame) {
        this.frame = frame;
        
        //Quando abre a janela puxa todas as empreiteiras
        lista = empreiteiraDAO.getAll();
    }

    public void load() {
       preencherCampos(lista, posRegistro); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Empreiteira empreiteira = null;       
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
                empreiteira = frame.getDadosCampos();

                if (empreiteira == null) {
                    return;
                }

                empreiteiraDAO.insert(empreiteira);

                persistencia.salvarArquivoGeral("Nova empreiteira cadastrada.");

                frame.dispose();
                break;
            case "Excluir":
                //TODO: habilitar apenas quando tem registro na tela
                empreiteira = lista.get(posRegistro);

                if (empreiteira.getNome().length() == 0) {
                    return;
                }

                empreiteiraDAO.delete(empreiteira);
                persistencia.salvarArquivoGeral("Cadastro de empreiteira: " + empreiteira.getNome() + " removido.");
                lista = empreiteiraDAO.getAll();
                posRegistro = 0;
                preencherCampos(lista, posRegistro);   
                break;

            case "Buscar":
                String textoBusca = frame.getDadosBusca();
                if (textoBusca.length() > 0) {
                    lista = empreiteiraDAO.getAll(textoBusca);
                } else
                    lista = empreiteiraDAO.getAll();
                
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
    
    private void preencherCampos(List<Empreiteira> lista, int pos) {
        frame.setDadosCampos(lista.get(pos));
    }
}
