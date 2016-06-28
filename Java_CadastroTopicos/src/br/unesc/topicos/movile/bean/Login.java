package br.unesc.topicos.movile.bean;

import javax.swing.JOptionPane;

public class Login {

    private int codigo;
    private String usuario;
    private String senha;

    public int getCodigo() {
        return this.codigo;
    }

    public String getUsuario() {

        return this.usuario;
    }

    public String getSenha() {

        return this.senha;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
