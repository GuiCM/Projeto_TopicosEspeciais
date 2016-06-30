package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.view.ImovelJIF;
import br.unesc.topicos.movile.bean.Imovel;
import br.unesc.topicos.movile.controle.ImovelDAO;
import br.unesc.topicos.movile.file.Persistencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;

public class ImovelListener implements ActionListener {

    private ImovelJIF frame;

    public ImovelListener(ImovelJIF frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Imovel imovel = null;
        ImovelDAO imovelDAO = new ImovelDAO();
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
                imovel = frame.getDadosCampos();

                if (imovel == null) {
                    return;
                }
                imovelDAO.delete(imovel);

                persistencia.salvarArquivoGeral("Cadastro de imóvel do endereço "
                        + imovel.getRua() + ", "
                        + Integer.toString(imovel.getNumero()) + " removido.");
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
