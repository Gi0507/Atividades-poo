public class Agenda{
        public String data;
        public String hora;
        public Medico medico;
        public Paciente paciente;
        void mostrar(){ 
            System.out.println("---Agenda---");
            System.out.println("Paciente:"+paciente.nome+"\nMedico:"+medico.nome+"\nData:"+data+"\nHora:"+hora+"\n\n");
        }
    }