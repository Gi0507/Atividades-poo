package com.fatec.ads;

public class Recepcionista {
    String nome;
    String cpf;
    String telefone;
    String senha;

    public void acessar(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {

        if (cpf.length()<11) 
            throw new  Exception("O telefone deve haver 11 digitos");
        else this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        if (telefone.length()<11) 
            throw new  Exception("O telefone deve haver 11 digitos");
        else this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha)throws Exception{
        if (senha.length()<6)
            throw new  Exception("A senha deve haver no minmo 6 digitos");
        else this.senha = senha;
    }

    public Recepcionista(String nome, String cpf, String telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Recepcionista() {
    }

   
    public void mostrar() {
        var s = "Recepcionista [getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getTelefone()=" + getTelefone()
                + ", getSenha()=" + getSenha() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
        System.out.println(s);
    };

    
}
