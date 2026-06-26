package com.fatec.ads;

public class Medico {
    String nome;
    String crm;
    String telefone;
    String especialidade;
    String senha;

    public void acessar(){
        //TODO
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome=="") 
            throw new Exception("Campo obrigatorio!");
        else this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        if (telefone.length()<11) 
            throw new  Exception("O telefone deve haver 11 digitos");
        else this.telefone = telefone;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception{
        if (senha.length()<6)
            throw new  Exception("A senha deve haver no minmo 6 digitos");
        this.senha = senha;
    }

    public Medico(String nome, String crm, String telefone, String especialidade, String senha) {
        this.nome = nome;
        this.crm = crm;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.senha = senha;
    }

    public Medico() {
    }

   
    public void mostrar() {
       var s =  "Medico [getNome()=" + getNome() + ", getCrm()=" + getCrm() + ", getTelefone()=" + getTelefone()
                + ", getEspecialidade()=" + getEspecialidade() + ", getSenha()=" + getSenha() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
        System.out.println(s);
    }


    
}
