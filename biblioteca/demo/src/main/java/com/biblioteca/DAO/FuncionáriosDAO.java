package com.biblioteca.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.biblioteca.Bean.Funcionários;
import com.biblioteca.Conexão.ConexaoSQL;


public class FuncionáriosDAO {
    private java.sql.Connection connection;

    public FuncionáriosDAO() throws SQLException {
        connection = ConexaoSQL.conectar();
        String sql = """
            CREATE TABLE IF NOT EXISTS funcionarios (
                id serial,
                cpf varchar(14)    PRIMARY KEY,
                nome varchar(255)  NOT NULL,
                cargo varchar(255) NOT NULL
                )""";
    
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

    public void adicionar(Funcionários funcionario) {
        try {
            String sql = "INSERT INTO funcionarios (cpf, nome, cargo) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, funcionario.getCPF());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, funcionario.getCargo());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(Funcionários funcionario) {
        try {
            String sql = "UPDATE funcionarios SET nome = ?, cargo = ? WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCargo());
            statement.setString(3, funcionario.getCPF());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Funcionários buscarPorId(String CPF) {
        try {
            String sql = "SELECT * FROM funcionarios WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, CPF);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                return new Funcionários(id, cpf, nome, cargo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}