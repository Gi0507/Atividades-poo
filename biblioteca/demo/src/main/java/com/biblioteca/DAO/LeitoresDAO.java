package com.biblioteca.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.biblioteca.Bean.Leitores;
import com.biblioteca.Conexão.ConexaoSQL;

public class LeitoresDAO {
    private java.sql.Connection connection;

    public LeitoresDAO() throws SQLException {
        connection = ConexaoSQL.conectar();
        String sql = """
            CREATE TABLE IF NOT EXISTS leitores (
                id serial          PRIMARY KEY,
                cpf varchar(14)    UNIQUE NOT NULL,
                nome varchar(255)  NOT NULL
                )""";
    
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }
    public void adicionar(Leitores leitor) {
        try {
            String sql = "INSERT INTO leitores (cpf, nome) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, leitor.getCPF());
            statement.setString(2, leitor.getNome());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Leitores buscarPorId(String CPF) {
        try {
            String sql = "SELECT * FROM leitores WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, CPF);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                return new Leitores(id, cpf, nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Leitores leitor) {
        try {
            String sql = "UPDATE leitores SET nome = ? WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, leitor.getNome());
            statement.setString(2, leitor.getCPF());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}