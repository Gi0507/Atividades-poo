package com.clinica.Bean;
public class Agenda{
        private String data;
        private String hora;
        private String medico;
        private String paciente;
        private int codigo;

        

        public int getCodigo() {
            return codigo;
        }
        public void setCodigo(int codigo) {
            this.codigo = codigo;
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

        public Agenda(String data,String hora,String medico,String paciente){
            this.setData(data);
            this.setHora(hora);
            this.setMedico(medico);
            this.setPaciente(paciente);
        }
        
        public Agenda(){
            this.setData(" ");
            this.setHora(" ");
            this.setMedico(" ");
            this.setPaciente(" ");
        }

        void mostrar(){ 
            System.out.println("---Agenda---");
            System.out.println("Paciente:"+getPaciente()+"\nMedico:"+getMedico()+"\nData:"+getData()+"\nHora:"+getHora()+"\n\n");
        }    
}