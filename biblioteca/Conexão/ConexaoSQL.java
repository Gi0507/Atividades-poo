package com.biblioteca.Conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConexaoSQL {
 
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String SENHA = "1234";
 
    public static Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, SENHA);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver do PostgreSQL não encontrado! Adicione o JAR às propriedades do projeto.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("Erro ao se conectar no banco de dados! Verifique se o Postgres está rodando.");
            throw new RuntimeException(e);
        }
    }
}