package br.com.dio.desafio.dominio.conta;

public class Correntista {

    private static int SEQUENCIAL = 1;
    private int id;
    private String nome;

    private String cpf;

    public Correntista(String nome, String cpf) {
        this.id = this.SEQUENCIAL++;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}
