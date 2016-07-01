package br.unesc.topicos.movile.controle;

import br.unesc.topicos.movile.bean.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fabricio
 */
public class LoginDAO {

    public void insert(Login login) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = Conexao.getConnection();

            String sql = "insert into Login ("
                    + "usuario,"//1
                    + "senha,"//2        
                    + " values(?,?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, login.getCodigo());
            ps.setString(2, login.getUsuario());
            ps.setString(3, login.getSenha());

            ps.execute();

            conn.commit();

        } catch (SQLException e) {
            
            //TODO: Passar erros de banco pro Persi gravar no log
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

    public void delete(Login login) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from Login where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, login.getCodigo());
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

    public List<Login> getAll() {
        List<Login> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select codigo, descricao from Login";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int codigo = rs.getInt("codigo");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");

                Login login = new Login();
                login.setCodigo(codigo);
                login.setUsuario(usuario);
                login.setSenha(senha);

                lista.add(login);
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

    public Login getLogin(Integer codbusca) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select codigo, descricao from Login where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codbusca);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                int codigo = rs.getInt("codigo");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");

                Login login = new Login();
                login.setCodigo(codigo);
                login.setUsuario(usuario);
                login.setSenha(senha);

                return login;
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
        return null;
    }

    public void update(Login login) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();

            String sql = "update Login set "
                    + "usuario = ?,"//1
                    + "senha = ?,"//2            
                    + "where codigo = ?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, login.getCodigo());
            ps.setString(2, login.getUsuario());
            ps.setString(3, login.getSenha());

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
