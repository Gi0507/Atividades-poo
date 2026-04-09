

public class Agenda {
    private String data;
    private String hora;
    private Medico medico;
    private Paciente paciente;

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

    public Agenda(String data, String hora, Medico medico, Paciente paciente) {
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Agenda() {
    }

    public void mostrar() {
       System.out.println("Agenda [getData()=" + getData() + ", getHora()=" + getHora() ); getMedico.mostrar();
       getPaciente().mostrar();
    }

    
}
