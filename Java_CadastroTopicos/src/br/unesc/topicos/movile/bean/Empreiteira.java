package br.unesc.topicos.movile.bean;

public class Empreiteira {

    private int codigo;
    private String nome;
    private String proprietario;
    private String cnpj;
    private String telefone;
    private String fax;
    private String email;
    
    private String rua;
    private int numero;
    private String cep;
    private String cidade;
    private String estado;
    private String bairro;

    /****** GET'S ******/
    public int getCodigo() {
        return this.codigo;
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getProprietario() {
        return this.proprietario;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getFax() {
        return this.fax;
    }

    public String getEmail() {
        return this.email;
    }
    
    public String getRua() {
        return this.rua;
    }
    
    public int getNumero() {
        return this.numero;
    }
    
    public String getCep() {
        return this.cep;
    }
    
    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }
    
    public String getBairro() {
        return this.bairro;
    }

    /****** SET'S ******/
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;                
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
