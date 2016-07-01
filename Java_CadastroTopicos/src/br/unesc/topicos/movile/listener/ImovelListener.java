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
    private List<Imovel> lista; //Receber a lista de imoveis do banco
    private int posRegistro; //Posicao do registro

    public ImovelListener(ImovelJIF frame) {
        this.frame = frame;
    }
    
    //Carregar todos os dados quando a janela é aberta
    public void load() {
       posRegistro = 0;
       lista = imovelDAO.getAll();
       preencherCampos(lista, posRegistro); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Imovel imovel = null;       
        Persistencia persistencia = new Persistencia();

        switch (e.getActionCommand()) {
            case "Novo":              
                break;
            case "Salvar":
                imovel = frame.getDadosCampos();
                imovelDAO.insert(imovel);
                load();
                break;
            case "Cancelar":
                frame.dispose();
                break;
            case "Atualizar":
                int codigo = lista.get(posRegistro).getCodigo();
                imovel = frame.getDadosCampos();
                imovel.setCodigo(codigo);
                System.out.println(posRegistro);
                
                if (imovel.getRua().length() == 0) 
                    return;
                
                imovelDAO.update(imovel);
                persistencia.salvarArquivoGeral("Novo imóvel cadastrado.");
                load();
                break;

            case "Excluir":
                imovel = lista.get(posRegistro);

                if (imovel.getRua().length() == 0) {
                    return;
                }
                imovelDAO.delete(imovel);

                persistencia.salvarArquivoGeral("Cadastro de imóvel: Endereço " + imovel.getRua() + ", "
                        + Integer.toString(imovel.getNumero()) + " removido.");
                load();
                break;
            case "Buscar":
                String textoBusca = frame.getDadosBusca();
                if (textoBusca.length() > 0) 
                    lista = imovelDAO.getAll(textoBusca);
                else
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
