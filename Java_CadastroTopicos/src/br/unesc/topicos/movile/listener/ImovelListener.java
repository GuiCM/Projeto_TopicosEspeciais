package br.unesc.topicos.movile.listener;
import br.unesc.topicos.movile.view.ImovelJIF;
import br.unesc.topicos.movile.bean.Imovel;
import br.unesc.topicos.movile.controle.ImovelDAO;
import br.unesc.topicos.movile.file.Persistencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class ImovelListener implements ActionListener {
    private ImovelJIF frame;
    private ImovelDAO imovelDAO = new ImovelDAO();
    private List<Imovel> lista;
    private int posRegistro = 0;

    public ImovelListener(ImovelJIF frame) {
        this.frame = frame;
        
        lista = imovelDAO.getAll();
    }
    
    public void load() {
       preencherCampos(lista, posRegistro); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Imovel imovel = null;       
        Persistencia persistencia = new Persistencia();

        switch (e.getActionCommand()) {
            case "Cancelar":
                int result;
                result = JOptionPane.showConfirmDialog(null, "Deseja salvar alterações?", "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);

                if (result == 0) {
                    frame.dispose();
                } else {
                    frame.dispose();
                }
                break;
            case "Salvar":
                imovel = frame.getDadosCampos();
                //Salva um log de cadastro

                if (imovel == null) {
                    return;
                }

                imovelDAO.insert(imovel);
                persistencia.salvarArquivoGeral("Novo imóvel cadastrado.");

                frame.dispose();
                break;

            case "Excluir":
                //TODO: habilitar apenas quando tem registro na tela
                imovel = lista.get(posRegistro);

                if (imovel.getRua().length() == 0) {
                    return;
                }
                imovelDAO.delete(imovel);

                persistencia.salvarArquivoGeral("Cadastro de imóvel: Endereço "
                        + imovel.getRua() + ", "
                        + Integer.toString(imovel.getNumero()) + " removido.");
                lista = imovelDAO.getAll();
                posRegistro = 0;
                preencherCampos(lista, posRegistro);   
                break;
            case "Buscar":
                String textoBusca = frame.getDadosBusca();
                if (textoBusca.length() > 0) {
                    lista = imovelDAO.getAll(textoBusca);
                } else
                    lista = imovelDAO.getAll();
                
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
    
    private void preencherCampos(List<Imovel> lista, int pos) {
        frame.setDadosCampos(lista.get(pos));
    }
}
