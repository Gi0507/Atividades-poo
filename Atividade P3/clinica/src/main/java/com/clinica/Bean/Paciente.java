package com.clinica.Bean;


public class Paciente {
    private String cpf;
    private String telefone;
    private int idade;   
    private String nome;
    private String genero;

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
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }


    public Paciente(String cpf, String telefone, int idade, String nome, String genero) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.idade = idade;
        this.nome = nome;
        this.genero = genero;
        }


        public Paciente(){
        this.setCpf("0");
        this.setTelefone("0");
        this.setIdade(0);
        this.setNome("0");
        this.setGenero("0");
        }
        
        void mostrar(){ 
            System.out.println("---Paciente---");
            System.out.println("Nome:"+nome+"\nCPF:"+cpf+"\nIdade:"+idade+"\nTelefone:"+telefone+"\nGenero:"+genero+"\n\n");
        }
   
}
