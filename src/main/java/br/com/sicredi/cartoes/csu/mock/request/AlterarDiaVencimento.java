package br.com.sicredi.cartoes.csu.mock.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlterarDiaVencimento {

    @JsonProperty("NumeroRelacionamento")
    private String numeroConta;

    @JsonProperty("DiaVencimento")
    private String diaVencimento;

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(String diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public static synchronized AlterarDiaVencimento create() {
        return new AlterarDiaVencimento();
    }

    public AlterarDiaVencimento withNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
        return this;
    }

    public AlterarDiaVencimento withDiaVencimento(String diaVencimento) {
        this.diaVencimento = diaVencimento;
        return this;
    }

}