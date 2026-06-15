package com.biblioteca.Bean;

public class Funcionários extends Pessoa {
   
    private String cargo;

    public Funcionários(String nome, String CPF, String telefone, String cargo) {
        super(nome, CPF, telefone);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

   
}