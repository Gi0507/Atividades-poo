public class Paciente {
    String cpf;
    String telefone;
    int idade;   
    String nome;
    String genero;

    void mostrar(){ 
            System.out.println("---Paciente---");
            System.out.println("Nome:"+nome+"\nCPF:"+cpf+"\nIdade:"+idade+"\nTelefone:"+telefone+"\nGenero:"+genero+"\n\n");
        }
}
