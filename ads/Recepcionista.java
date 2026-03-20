package com.fatec.ads;

public class Recepcionista {
    String nome;
    String cpf;
    String telefone;
    String senha;
    Paciente paciente;
    Consulta consulta;

    public void acessar(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
         if(nome==null || nome.length()<=0)
            throw new Exception("Informe o nome!");
     
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setPaciente(){
        this.paciente=paciente;
    } 
    public void getPaciente(){
        return paciente;
    }
    
    public void setExame(){
        this.exame=exame;
    }
    public void getExame(){
        return exame;
    }

    public Recepcionista(String nome, String cpf, String telefone,
        String senha,Paciente paciente,Exame exame) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
        this.paciente=paciente;
        this.exame=exame;
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
