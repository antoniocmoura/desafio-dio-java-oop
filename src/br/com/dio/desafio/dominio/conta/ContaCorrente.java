package br.com.dio.desafio.dominio.conta;

public class ContaCorrente extends Conta {
    public ContaCorrente(Correntista correntista) {
        super(correntista);
    }

    @Override
    public void imprimirTipoConta() {
        System.out.println("Extrato Conta Corrente");
    }
}
