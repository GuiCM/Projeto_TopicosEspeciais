package br.unesc.topicos.movile.controle;

import br.unesc.topicos.movile.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void insert(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = Conexao.getConnection();

            String sql = "insert into Cliente ("
                    + "nome,"
                    + "idade,"
                    + "dataNascimento,"
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

    public void delete(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from Cliente where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getCodigo());
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

    public List<Cliente> getAll() {
        List<Cliente> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select * from Cliente";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Integer codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Integer idade = rs.getInt("idade");
                String dataNascimento = rs.getString("dataNascimento");
                Character sexo = rs.getString("sexo").toCharArray()[0];
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                String rua = rs.getString("rua");
                Integer numero = rs.getInt("numero");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String bairro = rs.getString("bairro");

                Cliente cliente = new Cliente();
                cliente.setCodigo(codigo);
                cliente.setNome(nome);
                cliente.setIdade(idade);
                cliente.setDataNascimento(dataNascimento);
                cliente.setSexo(sexo);
                cliente.setCpf(cpf);
                cliente.setRg(rg);
                cliente.setRua(rua);
                cliente.setNumero(numero);
                cliente.setCep(cep);
                cliente.setCidade(cidade);
                cliente.setEstado(estado);
                cliente.setBairro(bairro);

                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
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
        return lista;
    }
    
    public List<Cliente> getAll(String nomeRegistro) {
        List<Cliente> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select * from Cliente where nome like '%"+nomeRegistro+"%'";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Integer codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Integer idade = rs.getInt("idade");
                String dataNascimento = rs.getString("dataNascimento");
                Character sexo = rs.getString("sexo").toCharArray()[0];
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                String rua = rs.getString("rua");
                Integer numero = rs.getInt("numero");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String bairro = rs.getString("bairro");

                Cliente cliente = new Cliente();
                cliente.setCodigo(codigo);
                cliente.setNome(nome);
                cliente.setIdade(idade);
                cliente.setDataNascimento(dataNascimento);
                cliente.setSexo(sexo);
                cliente.setCpf(cpf);
                cliente.setRg(rg);
                cliente.setRua(rua);
                cliente.setNumero(numero);
                cliente.setCep(cep);
                cliente.setCidade(cidade);
                cliente.setEstado(estado);
                cliente.setBairro(bairro);

                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
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
        return lista;
    }


    public void update(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            
            String sql = "update Cliente set "
                    + "nome = ?,"
                    + "idade = ?,"
                    + "dataNascimento = ?,"
                    + "sexo = ?,"
                    + "cpf = ?,"
                    + "rg = ?,"
                    + "rua = ?,"
                    + "numero = ?,"
                    + "cep = ?,"
                    + "cidade = ?,"
                    + "estado = ?,"
                    + "bairro = ?"
                    + "where codigo = ?";
            
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
            ps.setInt(13, cliente.getCodigo());

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
