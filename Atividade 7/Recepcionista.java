package com.fatec.ads;

public class Recepcionista extends funcionario{
    String cpf;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception{
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


    public Agenda marcarAgenda() throws Exception{
        var p1 = new Paciente();
        p1.setCodigo(1);
        p1.setEmail("jose@norton.net.br");
        p1.setNome("Jose da silva");
    
        var m1 = new Medico();
        m1.setCrm("234234234");
        m1.setEspecialidade("Geriatra");
        m1.setNome("Maria Antonieta");
        m1.setTelefone("2344-2344");

        var a1 = new Agenda();
        a1.setData("01/04/2026");
        a1.setHora("10:20");
        a1.setMedico(m1);
        a1.setPaciente(p1);
        return a1;
    }
    
}
