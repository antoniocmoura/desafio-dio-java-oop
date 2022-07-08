package br.com.dio.desafio.dominio.movimentacao;

import java.time.LocalDateTime;

public class Movimentacao {

    private static int SEQUENCIAL = 1;
    private int id;
    private LocalDateTime dataHora;
    private String descricao;

    private Double valor;
    private TipoMovimentacao tipoMovimentacao;

    public Movimentacao(TipoMovimentacao tipoMovimentacao, Double valor, String descricao) {
        this.id = SEQUENCIAL++;
        this.dataHora = LocalDateTime.now();
        this.tipoMovimentacao = tipoMovimentacao;
        this.valor = valor;
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

}
