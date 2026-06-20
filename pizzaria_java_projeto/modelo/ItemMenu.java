package modelo;

public abstract class ItemMenu {
    private int id;
    private String nome;
    private double preco;

    public ItemMenu(){}

    public ItemMenu(String nome,double preco){
        this.nome=nome;
        setPreco(preco);
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }

    public String getNome(){ return nome; }
    public void setNome(String nome){ this.nome=nome; }

    public double getPreco(){ return preco; }

    public void setPreco(double preco){
        if(preco<=0){
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        this.preco=preco;
    }

    public double calcularPrecoFinal(){
        return preco;
    }
}
