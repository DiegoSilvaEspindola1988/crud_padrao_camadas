package com.arquitetura.camadas.camadas.entities;

public class Mensagem {
    private String mensagem;
    private Integer id;
    private String nome;

    public Mensagem(String mensagem, Integer id, String nome) {
        this.mensagem = mensagem;
        this.id = id;
        this.nome = nome;
    }
    public Mensagem() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "mensagem='" + mensagem + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
