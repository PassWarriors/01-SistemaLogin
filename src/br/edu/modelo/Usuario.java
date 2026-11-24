package br.edu.modelo;


public class Usuario {

    private String nome;
    private String senhaHash;

    public Usuario(String nome, String senhaHash) {
        this.nome = nome;
        this.senhaHash = senhaHash;
    }

    public String getNome() {
        return nome;
    }

    public String getSenhaHash() {
        return senhaHash;
    }
}
