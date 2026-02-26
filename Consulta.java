public class Consulta{
        public Paciente paciente;
        public Medico medico;
        public String motivo;
        public String historico;
        public String data;
        public String hora;

        void mostrar(){ 
            System.out.println("---Consulta---");
            System.out.println("Paciente:"+paciente.nome+"\nMedico:"+medico.nome+"\nMotivo:"+motivo+"\nData:"+data+"\nHora:"+hora+"\n\n");
        }
    }