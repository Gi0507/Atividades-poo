package com.fatec.ads;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            int x =1;
            var p1 = new Paciente();
            p1.setCodigo(x++);
            p1.setNome("jose da silva");
            p1.setEmail("jose@norton.net.br");
            
            var p2 = new Paciente(x++, "maria souza","maria@norton.net.br");
            p2.mostrar();
        }
        catch(Exception e){
            System.out.println("Ocorreu um erro "+ e.getMessage());    
        }
        
      

        var r1 = new Recepcionista("mariazinha", "345345345", "3244-2344", "234234");

        r1.mostrar();
    }
}
