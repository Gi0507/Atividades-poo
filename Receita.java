public class Receita {
    public Consulta consulta;
    public String data;
    public String descritivo;

    void mostrar(){ 
            System.out.println("---Receita---");
            System.out.println("Data:"+data+"\nDescrição:"+descritivo+"\n\n");
        }
}
