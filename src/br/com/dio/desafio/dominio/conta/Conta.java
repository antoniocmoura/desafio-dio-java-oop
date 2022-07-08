package br.com.dio.desafio.dominio.conta;

import br.com.dio.desafio.dominio.movimentacao.Movimentacao;
import br.com.dio.desafio.dominio.movimentacao.TipoMovimentacao;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Correntista correntista;

    protected List<Movimentacao> movimentacoes;

    public Conta(Correntista correntista) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.correntista = correntista;
        this.movimentacoes = new ArrayList<Movimentacao>();
    }

    @Override
    public void incluirMovimentacao(TipoMovimentacao tipoMovimentacao, double valor, String descricao){
        if (tipoMovimentacao == TipoMovimentacao.DESPESA) valor *= -1;
        Movimentacao movimentacao = new Movimentacao(tipoMovimentacao, valor, descricao);
        this.movimentacoes.add(movimentacao);
        this.saldo += valor;
    }

    @Override
    public void depositar(double valor) {
        incluirMovimentacao(TipoMovimentacao.RECEITA, valor, "DEPÓSITO");
    };

    @Override
    public void sacar(double valor) {
        incluirMovimentacao(TipoMovimentacao.DESPESA, valor, "SAQUE");
    };

    @Override
    public void transferir(double valor, Conta contaDestino) {
        incluirMovimentacao(TipoMovimentacao.DESPESA, valor, "TRANSFERÊNCIA");
        contaDestino.incluirMovimentacao(TipoMovimentacao.RECEITA, valor, "TRANSFERÊNCIA");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=======================================================================");
        imprimirTipoConta();
        System.out.println("=======================================================================");
        imprimirDadosConta();
        imprimirMovimentacao();
    }

    private void imprimirDadosConta() {
        System.out.println(String.format("Correntista: %s", correntista.getNome()));
        System.out.println(String.format("Agência: %d", agencia));
        System.out.println(String.format("Número.: %d", numero));
        System.out.println("=======================================================================");
    }

    private void imprimirMovimentacao() {
        for (int i = 0; i < this.movimentacoes.size(); i++) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = this.movimentacoes.get(i).getDataHora().format(formatter);
            String valorFormatado = String.format("%.02f", this.movimentacoes.get(i).getValor());
            System.out.println(dataFormatada + " " + String.format("%-35s", this.movimentacoes.get(i).getDescricao()) + " " + String.format("%15s", valorFormatado));
        }
        System.out.println("=======================================================================");
        System.out.println(String.format("Saldo..: %.2f", saldo));
        System.out.println("=======================================================================\n");
    }
}
