package br.unesc.topicos.movile.controle;

import br.unesc.topicos.movile.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void insert(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = Conexao.getConnection();

            String sql = "insert into Produtos ("
                    + "nome,"
                    + "idade,"
                    + "dataNascimento,"
                    + "char,"
                    + "sexo,"
                    + "cpf,"
                    + "rg,"
                    + "rua,"
                    + "numero,"
                    + "cep,"
                    + "cidade,"
                    + "estado,"
                    + "bairro)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getIdade());
            ps.setString(3, cliente.getDataNascimento());
            ps.setString(4, String.valueOf(cliente.getSexo()));
            ps.setString(5, cliente.getCpf());
            ps.setString(6, cliente.getRg());
            ps.setString(7, cliente.getRua());
            ps.setInt(8, cliente.getNumero());
            ps.setString(9, cliente.getCep());
            ps.setString(10, cliente.getCidade());
            ps.setString(11, cliente.getEstado());
            ps.setString(12, cliente.getBairro());

            ps.execute();

            conn.commit();

        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

}
