package br.unesc.topicos.movile.listener;

import br.unesc.topicos.movile.view.ImovelJIF;
import br.unesc.topicos.movile.bean.Imovel;
import br.unesc.topicos.movile.file.Persistencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ImovelListener implements ActionListener {

    private ImovelJIF frame;

    public ImovelListener(ImovelJIF frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cancelar":
                int result;
                result = JOptionPane.showConfirmDialog(null, "Deseja salvar alterações?", "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);

                if (result == 0)
                {
                    frame.dispose();
                } else {
                    frame.dispose();
                }
                break;
            case "Salvar":
                Imovel imovel = frame.getFieldData();
                
                //Salva um log de cadastro
                Persistencia persistencia = new Persistencia();
                persistencia.salvarArquivoGeral("Novo imóvel cadastrado.");
                
                frame.dispose();
                break;
        }
    }
}
