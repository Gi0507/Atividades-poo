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
           var maria = new Recepcionista();
           var joao = new Medico();

           var agenda20260401 = maria.marcarAgenda();
           joao.realizarConsulta(agenda20260401);     
        }
        catch(Exception e){
            System.out.println("Ocorreu um erro "+ e.getMessage());    
        }
        
    }
}
