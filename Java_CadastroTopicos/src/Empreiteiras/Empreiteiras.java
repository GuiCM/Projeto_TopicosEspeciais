package Empreiteiras;

public class Empreiteiras {

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
    private String getNome() {
        return this.nome;
    }

    private String getProprietario() {
        return this.proprietario;
    }

    private String getCnpj() {
        return this.cnpj;
    }

    private String getTelefone() {
        return this.telefone;
    }

    private String getFax() {
        return this.fax;
    }

    private String getEmail() {
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
    private void setNome(String nome) {
        this.nome = nome;
    }
    
    private void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    
    private void setCnpj(String cnpj) {
        this.cnpj = cnpj;                
    }
    
    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    private void setFax(String fax) {
        this.fax = fax;
    }
    
    private void setEmail(String email) {
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
