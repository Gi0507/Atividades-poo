package com.fatec.ads;

public class Paciente {
    private int codigo;
    private String nome;
    private String email;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws Exception {
        if(email==null || email.length()<6 || !email.contains("@")){
            throw new Exception("Email completo Obrigatorio !");
        } else {
            this.email = email;
        }
    }

    public Paciente(){
        this.codigo=0;
        this.nome="";
        this.email="";
    }
    public Paciente(int pCodigo, String pNome, String pEmail) throws Exception{
        setCodigo(pCodigo);
        setEmail(pEmail);
        setNome(pNome);
    }

    public void mostrar() {
        var s = "Paciente [getCodigo()=" + getCodigo() + ", getNome()=" + getNome() + ", getEmail()=" + getEmail()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
        System.out.println(s);        
    }

   
   
}
