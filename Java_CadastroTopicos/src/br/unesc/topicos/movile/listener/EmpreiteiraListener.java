package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.bean.Empreiteira;
import br.unesc.topicos.movile.controle.EmpreiteiraDAO;
import br.unesc.topicos.movile.file.Persistencia;
import br.unesc.topicos.movile.view.EmpreiteiraJIF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;

public class EmpreiteiraListener implements ActionListener {

    private EmpreiteiraJIF frame;

    public EmpreiteiraListener(EmpreiteiraJIF frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Empreiteira empreiteira = null;
        EmpreiteiraDAO empreiteiraDAO = new EmpreiteiraDAO();
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
                empreiteira = frame.getDadosCampos();

                if (empreiteira == null) {
                    return;
                }

                empreiteiraDAO.delete(empreiteira);
                persistencia.salvarArquivoGeral("Cadastro de empreiteira " + empreiteira.getNome() + " removido.");
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
