package br.unesc.topicos.movile.bean;

public class Cliente {
    private String nome;
    private int idade;
    private String dataNascimento;
    private char sexo;
    private String cpf;
    private String rg; 
    private String rua;
    private int numero;
    private String cep;
    private String cidade;
    private String estado;
    private String bairro;

    /**
     * ***** GET'S ******
     */
    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public char getSexo() {
        return this.sexo;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getRg() {
        return this.rg;
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
    
    /******* SET'S *******/
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
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
