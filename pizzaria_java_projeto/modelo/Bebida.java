package modelo;

public class Bebida extends ItemMenu{
    private int tamanhoEmMl;

    public Bebida(String nome,double preco,int tamanhoEmMl){
        super(nome,preco);
        this.tamanhoEmMl=tamanhoEmMl;
    }

    public int getTamanhoEmMl(){ return tamanhoEmMl; }
    public void setTamanhoEmMl(int tamanhoEmMl){
        this.tamanhoEmMl=tamanhoEmMl;
    }
}
