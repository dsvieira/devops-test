package br.com.sicredi.cartoes.csu.mock.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncluirFilaAtendimentoRequest {

    private static final long serialVersionUID = 7231779290642368561L;

    @JsonProperty("Conta")
    private String conta;

    @JsonProperty("Cartao")
    private String cartao;

    @JsonProperty("CodigoAcao")
    private String codigoAcao;

    @JsonProperty("Descricao")
    private String descricao;

    public IncluirFilaAtendimentoRequest(){}

    public IncluirFilaAtendimentoRequest(String conta, String cartao, String codigoAcao, String descricao) {
        this.conta = conta;
        this.cartao = cartao;
        this.codigoAcao = codigoAcao;
        this.descricao = descricao;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
