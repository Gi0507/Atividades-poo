package com.fatec.ads;

public class Consulta {
    String hora;
    String data;
    Medico medico;
    Paciente paciente;
    String motivo;
    String historico;

    public void marcar(){};
    public void cancelar(){};
    public void consultar(){};
    public void realizar(){};
    public void atualizar(){}
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) throws Exception {
        if(motivo.length()<10||motivo=="")
            throw new Exception ("Campo obrigatorio!");
        else this.motivo = motivo;
    }
    public String getHistorico() {
        return historico;
    }
    public void setHistorico(String historico) {
        this.historico = historico;
    }
    
    public Consulta(String hora, String data, Medico medico, Paciente paciente, String motivo, String historico) {
        this.hora = hora;
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
        this.motivo = motivo;
        this.historico = historico;
    }
    public Consulta() {
    }


    public void mostrar() {
        var s = "Consulta [getHora()=" + getHora() + ", getData()=" + getData() + ", getMedico()=" + getMedico()
                + ", getPaciente()=" + getPaciente() + ", getMotivo()=" + getMotivo() + ", getHistorico()="
                + getHistorico() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
        System.out.println(s);
    };

    

}
