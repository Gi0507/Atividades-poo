package com.clinica.Bean;

public class Exame {
    private Consulta consulta;
    private String data;
    private String descritivo;

    
    public Consulta getConsulta() {
        return consulta;
    }
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
       public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getDescritivo() {
        return descritivo;
    }
    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    public Exame(){
        this.setConsulta(consulta);
        this.setData("");
        this.setDescritivo("");
    }
    public Exame(Consulta consulta,String data, String Descritivo){
        this.setConsulta(consulta);
        this.setData(data);
        this.setDescritivo(Descritivo);
    }

    void mostrar(){ 
        System.out.println("---Exame---");
        System.out.println("Data:"+data+"\nDescrição:"+descritivo+"\n\n");
    }
}
