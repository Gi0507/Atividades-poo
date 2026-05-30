package com.clinica.Bean;

import java.sql.ResultSet;

public class Receita {
    public int consulta;
    private String data;
    private String descritivo;
    private int codigo;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getConsulta() {
        return consulta;
    }
    public void setConsulta(int consulta) {
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

    public Receita(int consulta,String data,String descritivo){
        this.setConsulta(consulta);
        this.setData(data);
        this.setDescritivo(descritivo);
    }
    public Receita(){
        setConsulta(consulta);
        setData("");
        setDescritivo("");
    }


    void mostrar(){ 
            System.out.println("---Receita---");
            System.out.println("Data:"+data+"\nDescrição:"+descritivo+"\n\nprivate");
        }
    public void setConsulta(ResultSet resultado, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setConsulta'");
    }
}
