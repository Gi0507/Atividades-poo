package com.biblioteca.Bean;

public class Copia extends Obra {

    private int codigo;
    private boolean disponivel;

    public Copia(boolean disponivel, String titulo, String autor, int ano) {
        super(titulo, autor, ano);
        this.disponivel = disponivel;
    }


    public int getcodigo() {
        return codigo;
    }
    public void setcodigo(int id) {
        this.codigo = id;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}