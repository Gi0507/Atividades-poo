package com.biblioteca;

import com.biblioteca.DAO.ObraDAO;

public class Main {
    public static void main(String[] args) {
        try {
            ObraDAO obraDAO = new ObraDAO();
            System.out.println("Tabela 'obra' criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}