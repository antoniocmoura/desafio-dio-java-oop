package br.com.dio.desafio.dominio.conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<Conta>();
    }

    public void abrirConta(Conta conta) {
        contas.add(conta);
    }

    public void imprimirContas() {
        System.out.println(this.nome);
        for (int i = 0; i < this.contas.size(); i++) {
            this.contas.get(i).imprimirExtrato();
        }
    }
}
