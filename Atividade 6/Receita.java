package com.fatec.ads;

public class Receita extends Procedimento {
    String data;
    String descritivo;

    public Receita(String data, String descritivo) {
        this.data = data;
        this.descritivo = descritivo;
    }

    public void preescrever(){};
   
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getDescritivo() {
        return descritivo;
    }
    public void setDescritivo(String descritivo) throws Exception 
    {
         if(descritivo==null || descritivo.length()<=0)
            throw new Exception("Informe o descritvo do exame");
     
        this.descritivo = descritivo;
    }

    public void prescrever(String descritivo,String data) {
        setDescritivo(descritivo);
    }

   
    public void mostrar() {
        var s = "Receita [ getData()=" + getData() + ", getDescritivo()="
                + getDescritivo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
        System.out.println(s);
    };


    
}
