package br.unesc.topicos.movile.controle;

import br.unesc.topicos.movile.bean.Empreiteira;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpreiteiraDAO {
    
    //INSERIR
    public void insert(Empreiteira empreiteira) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConnection();
            String sql = "insert into Empreiteira (nome, proprietario, cnpj, telefone, fax, email, rua, numero, cep, cidade,"
                    + "estado, bairro) values(?,?,?,?,?,?,?,?,?,?,?,?)";
                      
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, empreiteira.getNome());
            ps.setString(2, empreiteira.getProprietario());
            ps.setString(3, empreiteira.getCnpj());
            ps.setString(4, empreiteira.getTelefone());
            ps.setString(5, empreiteira.getFax());
            ps.setString(6, empreiteira.getEmail());
            ps.setString(7, empreiteira.getRua());
            ps.setInt(8, empreiteira.getNumero());
            ps.setString(9, empreiteira.getCep());
            ps.setString(10, empreiteira.getCidade());
            ps.setString(11, empreiteira.getEstado());
            ps.setString(12, empreiteira.getBairro());
                        
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
    
    //DELETAR
    public void delete(Empreiteira empreiteira) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from Empreiteira where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empreiteira.getCodigo());
            ps.execute();

            conn.commit();
        } catch(SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }
    
    //MODIFICAR EMPREITEIRA
    public void update(Empreiteira empreiteira) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConnection();

            String sql = "update Empreiteira set nome = ?, proprietario = ?, cnpj = ?, telefone = ?, fax = ?, email = ?,"
                    + "rua = ?, numero = ?, cep = ?, cidade = ?, estado = ?, bairro = ? "
                    + "where codigo = ?";
            
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, empreiteira.getNome());
            ps.setString(2, empreiteira.getProprietario());
            ps.setString(3, empreiteira.getCnpj());
            ps.setString(4, empreiteira.getTelefone());
            ps.setString(5, empreiteira.getFax());
            ps.setString(6, empreiteira.getEmail());
            ps.setString(7, empreiteira.getRua());
            ps.setInt(8, empreiteira.getNumero());
            ps.setString(9, empreiteira.getCep());
            ps.setString(10, empreiteira.getCidade());
            ps.setString(11, empreiteira.getEstado());
            ps.setString(12, empreiteira.getBairro());
            
            ps.execute();

            conn.commit();
        } catch(SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }
    
    //PESQUISAR EMPREITEIRA
    public Empreiteira getEmpreiteira(Integer codigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConnection();
            String sql = "select * from Empreiteira where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
   
            if(rs.next()) {
                Integer cod = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String proprietario = rs.getString("proprietario");
                String cnpj = rs.getString("cnpj");
                String telefone = rs.getString("telefone");
                String fax = rs.getString("fax");
                String email = rs.getString("email");
                String rua = rs.getString("rua");
                Integer numero = rs.getInt("numero");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String bairro = rs.getString("bairro");
                
                Empreiteira e = new Empreiteira();
                e.setCodigo(cod);
                e.setNome(nome);
                e.setProprietario(proprietario);
                e.setCnpj(cnpj);
                e.setTelefone(telefone);
                e.setFax(fax);
                e.setEmail(email);
                e.setRua(rua);
                e.setNumero(numero);
                e.setCep(cep);
                e.setCidade(cidade);
                e.setEstado(estado);
                e.setBairro(bairro);
                
                return e;
            }
        } catch(SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return null;
    }
    
    //LISTAR EMPREITEIRAS
    public List<Empreiteira> getAll() {
        List<Empreiteira> lista = new ArrayList<Empreiteira>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select * from Empreiteira";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Integer cod = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String proprietario = rs.getString("proprietario");
                String cnpj = rs.getString("cnpj");
                String telefone = rs.getString("telefone");
                String fax = rs.getString("fax");
                String email = rs.getString("email");
                String rua = rs.getString("rua");
                Integer numero = rs.getInt("numero");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String bairro = rs.getString("bairro");
                
                Empreiteira e = new Empreiteira();
                e.setCodigo(cod);
                e.setNome(nome);
                e.setProprietario(proprietario);
                e.setCnpj(cnpj);
                e.setTelefone(telefone);
                e.setFax(fax);
                e.setEmail(email);
                e.setRua(rua);
                e.setNumero(numero);
                e.setCep(cep);
                e.setCidade(cidade);
                e.setEstado(estado);
                e.setBairro(bairro);
                
                lista.add(e);
            }
        } catch(SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return lista;
    }
}
