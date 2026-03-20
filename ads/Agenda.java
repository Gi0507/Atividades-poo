package com.fatec.ads;

public class Agenda {
    String data;
    String hora;
    String medico;
    String paciente;

    public void consultar(){}

    public String getData() {
        return data;
    }

    public void setData(String data) throws  ExceptionClinica{
        if(data==null){
            throw new ExceptionClinica("AS2345234", "A data nao pode ser nula!");
        } else {
            this.data = data;
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Agenda(String data, String hora, String medico, String paciente) {
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Agenda() {
    }

    public void mostrar() {
        var s = "Agenda [getData()=" + getData() + ", getHora()=" + getHora() + ", getMedico()=" + getMedico()
                + ", getPaciente()=" + getPaciente() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
        System.out.println(s);
    }

    
}
