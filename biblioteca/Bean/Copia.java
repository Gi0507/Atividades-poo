package com.biblioteca.Bean;

public class Copia extends Obra {

    private int id;
    private Obra obra;
    private boolean disponivel;

    public Copia( Obra obra, boolean disponivel, String titulo, String autor, int ano) {
        super(titulo, autor, ano);
        this.id = id;
        this.obra = obra;
        this.disponivel = disponivel;
    }

    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Obra getObra() {
        return obra;
    }
    public void setObra(Obra obra) {
        this.obra = obra;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    
}
