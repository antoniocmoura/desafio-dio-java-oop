package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.conta.*;

public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco("BANCO DIGITAL");

        Correntista correntista = new Correntista("ANTONIO CARLOS DE MOURA", "000.000.000-00");

        Conta contaPoupanca = new ContaPoupanca(correntista);
        banco.abrirConta(contaPoupanca);

        Conta contaCorrente = new ContaCorrente(correntista);
        banco.abrirConta(contaCorrente);

        contaCorrente.depositar(100);
        contaCorrente.transferir(50, contaPoupanca);
        contaPoupanca.sacar(10);

        banco.imprimirContas();
    }

}
