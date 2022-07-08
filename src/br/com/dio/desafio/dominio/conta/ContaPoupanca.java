package br.com.dio.desafio.dominio.conta;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Correntista correntista) {
        super(correntista);
    }

    @Override
    public void imprimirTipoConta() {
        System.out.println("Extrato Conta Poupança");
    }


}
