package br.com.dio.desafio.dominio.conta;

import br.com.dio.desafio.dominio.movimentacao.TipoMovimentacao;

public interface IConta {

     void incluirMovimentacao(TipoMovimentacao tipoMovimentacao, double valor, String descricao) ;

     void depositar(double valor);

     void sacar(double valor);

     void transferir(double valor, Conta contaDestino);

     void imprimirTipoConta();
     void imprimirExtrato();

}
