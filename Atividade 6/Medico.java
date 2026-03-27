package com.fatec.ads;

public class Medico extends funcionario{
    String crm;
    String especialidade;
    

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) throws Exception{
        if(crm==null || crm.length()<7) throw new Exception("Crm obrigatorio !");
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }



    public Medico(String nome, String crm, String telefone, String especialidade, String senha) {
        this.nome = nome;
        this.crm = crm;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.senha = senha;
    }

    public Medico() {
        this.crm="";
        this.especialidade="";
    }

   
    public void mostrar() {
       var s =  "Medico [getNome()=" + getNome() + ", getCrm()=" + getCrm() + ", getTelefone()=" + getTelefone()
                + ", getEspecialidade()=" + getEspecialidade() + ", getSenha()=" + getSenha() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
        System.out.println(s);
    }




    
}
