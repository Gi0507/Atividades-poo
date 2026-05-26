package com.biblioteca.Bean;

public class Pessoa {
    private int id;
    private String nome;
    private String CPF; 

    public Pessoa(int id, String nome, String CPF) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public int getId() {
        return id;
    } 
    public String getNome() {
        return nome;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }    
}
