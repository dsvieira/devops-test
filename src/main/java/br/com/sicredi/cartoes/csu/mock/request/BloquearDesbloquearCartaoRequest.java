package br.com.sicredi.cartoes.csu.mock.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BloquearDesbloquearCartaoRequest {

    @JsonProperty("Cartao")
    private String numeroCartao;

    @JsonProperty("CodigoBloqueio")
    private String codigoBloqueio;

    public BloquearDesbloquearCartaoRequest(){}

    public BloquearDesbloquearCartaoRequest(String numeroCartao, String codigoBloqueio) {
        this.numeroCartao = numeroCartao;
        this.codigoBloqueio = codigoBloqueio;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoBloqueio() {
        return codigoBloqueio;
    }

    public void setCodigoBloqueio(String codigoBloqueio) {
        this.codigoBloqueio = codigoBloqueio;
    }
}

