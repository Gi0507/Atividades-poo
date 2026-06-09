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
                id serial,
                cpf varchar(14)    UNIQUE NOT NULL,
                nome varchar(255)  NOT NULL,
                telefone varchar(20)
                )""";
    
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }
    public void adicionar(Leitores leitor) {
        try {
            String sql = "INSERT INTO leitores (cpf, nome,telefone) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, leitor.getCPF());
            statement.setString(2, leitor.getNome());
            statement.setString(3, leitor.getTelefone());
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
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                return new Leitores(cpf, nome, telefone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Leitores leitor) {
        try {
            String sql = "UPDATE leitores SET nome = ?, telefone = ? WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, leitor.getNome());
            statement.setString(2, leitor.getTelefone());
            statement.setString(3, leitor.getCPF());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void excluir(String CPF) {
        try {
            String sql = "DELETE FROM leitores WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, CPF);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}