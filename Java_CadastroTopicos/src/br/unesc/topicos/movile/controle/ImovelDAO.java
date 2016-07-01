/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesc.topicos.movile.controle;

import br.unesc.topicos.movile.bean.Imovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabricio
 */

public class ImovelDAO {

    public void insert(Imovel imovel) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = Conexao.getConnection();

            String sql = "insert into Imovel ("
                    + "tipoImovel,"//1
                    + "dimensoes,"//2
                    + "valor,"//3
                    + "tipoMaterial,"//4
                    + "alugado,"//5
                    + "rua,"//6
                    + "numero,"//7
                    + "cep,"//8
                    + "cidade,"//9
                    + "estado,"//10
                    + "bairro)"//11
                    + " values(?,?,?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, imovel.getTipoImovel());
            ps.setFloat(2, imovel.getDimensoes());
            ps.setFloat(3, imovel.getValor());
            ps.setString(4, imovel.getTipoMaterial());
            ps.setBoolean(5, imovel.getAlugado());
            ps.setString(6, imovel.getRua());
            ps.setInt(7, imovel.getNumero());
            ps.setString(8, imovel.getCep());
            ps.setString(9, imovel.getCidade());
            ps.setString(10, imovel.getEstado());
            ps.setString(11, imovel.getBairro());

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

    public void delete(Imovel imovel) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from Imovel where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, imovel.getCodigo());
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

    public List<Imovel> getAll() {
        List<Imovel> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select * from Imovel";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer codigo = rs.getInt("Codigo");
                String tipoImovel = rs.getString("tipoImovel");
                float dimensoes = rs.getFloat("dimensoes");
                float valor = rs.getFloat("valor");
                String tipoMaterial = rs.getString("tipoMaterial");
                boolean alugado = rs.getBoolean("alugado");
                String rua = rs.getString("rua");
                int numero = rs.getInt("numero");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String bairro = rs.getString("bairro");

                Imovel imovel = new Imovel();
                imovel.setCodigo(codigo);
                imovel.setTipoImovel(tipoImovel);
                imovel.setDimensoes(dimensoes);
                imovel.setValor(valor);
                imovel.setTipoMaterial(tipoMaterial);
                imovel.setAlugado(alugado);
                imovel.setRua(rua);
                imovel.setNumero(numero);
                imovel.setCep(cep);
                imovel.setCidade(cidade);
                imovel.setEstado(estado);
                imovel.setBairro(bairro);

                lista.add(imovel);
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

    
    public List<Imovel> getAll(String nomeRegistro) {
        List<Imovel> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
           
            String sql = "select * from Imovel where rua like '%" + nomeRegistro+ "%'";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer codigo = rs.getInt("Codigo");
                String tipoImovel = rs.getString("tipoImovel");
                float dimensoes = rs.getFloat("dimensoes");
                float valor = rs.getFloat("valor");
                String tipoMaterial = rs.getString("tipoMaterial");
                boolean alugado = rs.getBoolean("alugado");
                String rua = rs.getString("rua");
                int numero = rs.getInt("numero");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String bairro = rs.getString("bairro");

                Imovel imovel = new Imovel();
                imovel.setCodigo(codigo);
                imovel.setTipoImovel(tipoImovel);
                imovel.setDimensoes(dimensoes);
                imovel.setValor(valor);
                imovel.setTipoMaterial(tipoMaterial);
                imovel.setAlugado(alugado);
                imovel.setRua(rua);
                imovel.setNumero(numero);
                imovel.setCep(cep);
                imovel.setCidade(cidade);
                imovel.setEstado(estado);
                imovel.setBairro(bairro);

                lista.add(imovel);
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



    public void update(Imovel imovel) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();

            String sql = "update Imovel set "
                    + "tipoImovel = ?,"//1
                    + "dimensoes = ?,"//2
                    + "valor = ?,"//3
                    + "tipoMaterial = ?,"//4
                    + "alugado = ?,"//5
                    + "rua = ?,"//6
                    + "numero = ?,"//7
                    + "cep = ?,"//8
                    + "cidade = ?,"//9
                    + "estado = ?,"//10
                    + "bairro = ?"//11
                    + "where codigo = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, imovel.getTipoImovel());
            ps.setFloat(2, imovel.getDimensoes());
            ps.setFloat(3, imovel.getValor());
            ps.setString(4, imovel.getTipoMaterial());
            ps.setBoolean(5, imovel.getAlugado());
            ps.setString(6, imovel.getRua());
            ps.setInt(7, imovel.getNumero());
            ps.setString(8, imovel.getCep());
            ps.setString(9, imovel.getCidade());
            ps.setString(10, imovel.getEstado());
            ps.setString(11, imovel.getBairro());
            ps.setInt(12, imovel.getCodigo());

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
