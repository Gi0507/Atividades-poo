package modelo;

public class Pizza extends ItemMenu{
    private String ingredientes;

    public Pizza(String nome,double preco,String ingredientes){
        super(nome,preco);
        this.ingredientes=ingredientes;
    }

    public String getIngredientes(){ return ingredientes; }
    public void setIngredientes(String ingredientes){
        this.ingredientes=ingredientes;
    }

    @Override
    public double calcularPrecoFinal(){
        return getPreco()+5;
    }
}
