package com.biblioteca.Bean;

public class Funcionários extends Pessoa {
   
    private String cargo;

    public Funcionários(int id, String nome, String CPF, String cargo) {
        super(id, nome, CPF);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}