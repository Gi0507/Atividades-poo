

public class Exame extends Procedimento{
    String data;
    String descritivo;


    public void solicitar(){}
    public void consultar(){}

   
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getDescritivo() {
        return descritivo;
    }
    public void setDescritivo(String descritivo) throws Exception {
        if(descritivo==null || descritivo.length()<=0)
            throw new Exception("Informe o descritvo do exame");
        this.descritivo = descritivo;
    }
    public Exame( String data, String descritivo) {
     
        this.data = data;
        this.descritivo = descritivo;
    }
    public Exame() {
    }
   
    public void mostrar() {
        var s = "Exame  \ngetData()=" + getData() + "\ngetDescritivo()="
                + getDescritivo() ;
        System.out.println(s);
    }

    
    
}
