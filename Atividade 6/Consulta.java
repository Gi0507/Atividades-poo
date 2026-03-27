package com.fatec.ads;

import java.util.ArrayList;
import java.util.List;

public class Consulta {
    String hora;
    String data;
    Medico medico;
    Paciente paciente;
    String motivo;
    String historico;
    List<Exame> exames = new ArrayList<>();
    List<Receita> receitas = new ArrayList<>();

    public List<Exame> getExames() {
        return exames;
    }
    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
    public List<Receita> getReceitas() {
        return receitas;
    }
    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }
    
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
    public void setMotivo(String motivo) throws Exception  {
        if(motivo==null || motivo.length() <= 0 ) 
            throw  new Exception("Motivo da consulta e obrigatorio !!");
        this.motivo = motivo;
    }
    public String getHistorico() {
        return historico;
    }
    public void setHistorico(String historico) {
        this.historico = historico;
    }
    
    public marcar(String hora, String data, Medico medico, Paciente paciente, String motivo, String historico, List<Receita> r, List<Exame> e){
        this.hora = hora;
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
        this.motivo = motivo;
        this.historico = historico;
        this.receitas = r;
        this.exames = e;
    }
    public void consultar(){

    }
    public void marcar(){}
    public void cancelar(consulta c) {
        c=null;
    }

    public void realizarConsulta(Agenda agenda) throws Exception{
        var c1 = new Consulta();
        c1.setData(agenda.getData());
        c1.setHora(agenda.getHora());
        c1.setMedico(agenda.getMedico());
        c1.setPaciente(agenda.getPaciente());
        c1.setMotivo("Dor abdominal");
        c1.setHistorico("apresenta dores na região do estomago, possivel gastrite");
        var e1 = new Exame("01/04/2026", "Exame de sangue");
        c1.getExames().add(e1);
        c1.getExames().add(new Exame("01/04/2026", "Endoscopia"));
        c1.getReceitas().add(new Receita("01/04/2026", "Buscopan"));
        c1.mostrar();
    }

    public void mostrar() {
        System.out.println("Consulta [getHora()=" + getHora() + ", getData()=" + getData() +" ,getMotivo()=" + getMotivo() + ", getHistorico()="+ getHistorico());
        getMedico().mostrar();
        getPaciente().mostrar(); 
        for(var obj : exames){
            obj.mostrar();
        }
        for(var obj: receitas){
            obj.mostrar();
        }
    };

    

}
