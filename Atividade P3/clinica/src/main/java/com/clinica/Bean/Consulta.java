package com.clinica.Bean;
    
public class Consulta{
        private String paciente;
        private String medico;
        private String motivo;
        private String historico;
        private String data;
        private String hora;
        private int codigo;

  
        public int getCodigo() {
            return codigo;
        }
        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }
        public String getPaciente() {
            return paciente;
        }
        public void setPaciente(String paciente) {
            this.paciente = paciente;
        }
        public String getMedico() {
            return medico;
        }
        public void setMedico(String medico) {
            this.medico = medico;
        }
        public String getMotivo() {
            return motivo;
        }
        public void setMotivo(String motivo) {
            this.motivo = motivo;
        }
        public String getHistorico() {
            return historico;
        }
        public void setHistorico(String historico) {
            this.historico = historico;
        }
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        public String getHora() {
            return hora;
        }
        public void setHora(String hora) {
            this.hora = hora;
        }

        public Consulta(String paciente, String medico, String motivo, String historico, String data, String hora){
            this.setData(data);
            this.setMedico(medico);
            this.setMotivo(motivo);
            this.setHistorico(historico);
            this.setData(data);
            this.setHora(hora);
        }
        public Consulta(){
            this.setData(" ");
            this.setMedico(" ");
            this.setMotivo(" ");
            this.setHistorico(" ");
            this.setData(" ");
            this.setHora(" ");
        }
    
        
    }