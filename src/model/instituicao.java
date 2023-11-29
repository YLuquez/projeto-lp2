package model;

public class instituicao {
    private int codigoMEC;
    private String nome;
    private int anoFundacao;

    public instituicao(int codigoMEC, String nome, int anoFundacao) {
        this.codigoMEC = codigoMEC;
        this.nome = nome;
        this.anoFundacao = anoFundacao;
    }

    public int getCodigoMEC() {
        return this.codigoMEC;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAnoFundacao() {
        return this.anoFundacao;
    }

    public void setCodigoMEC(int codigoMEC) {
        this.codigoMEC = codigoMEC;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }
}
