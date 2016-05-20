package Imoveis;

public class Imovel {

    private String  tipoImovel;
    private float   dimensoes;
    private float   valor;
    private String  tipoMaterial;
    private boolean alugado;

    private String  rua;
    private int     numero;
    private String  cep;
    private String  cidade;
    private String  estado;
    private String  bairro;   

    /******* GET'S *******/
    public String getTipoImovel() {
        return this.tipoImovel;
    }

    public float getDimensoes() {
        return this.dimensoes;
    }

    public float getValor() {
        return this.valor;
    }

    public String getTipoMaterial() {
        return this.tipoMaterial;
    }

    public boolean getAlugado() {
        return this.alugado;
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
    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public void setDimensoes(float dimensoes) {
        this.dimensoes = dimensoes;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
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
