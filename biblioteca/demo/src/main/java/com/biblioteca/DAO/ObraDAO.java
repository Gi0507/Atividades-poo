package com.biblioteca.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.biblioteca.Bean.Obra;
import com.biblioteca.Conexão.ConexaoSQL;

public class ObraDAO {
    private Connection connection;

    public ObraDAO() throws SQLException {
        connection = ConexaoSQL.conectar();
        Statement stmt = connection.createStatement();
        
    }

    public void adicionar(Obra obra) {
        try {
            String sql = "INSERT INTO obra (titulo, autor, ano) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, obra.getTitulo());
            statement.setString(2, obra.getAutor());
            statement.setInt(3, obra.getAno());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Obra buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM obra WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                int ano = resultSet.getInt("ano");
                return new Obra( titulo, autor, ano);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int buscar(String nome){
        try {
            String sql = "SELECT * FROM obra WHERE titulo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void update(Obra obra) {
        try {
            String sql = "UPDATE obra SET titulo = ?, autor = ?, ano = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, obra.getTitulo());
            statement.setString(2, obra.getAutor());
            statement.setInt(3, obra.getAno());
            statement.setInt(4, obra.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        try {
            String sql = "DELETE FROM obra WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }public void obraDAO() {

    }   
    void criarTabela() {
        try {
            String sql = """
                CREATE TABLE IF NOT EXISTS obra (
                    id serial          PRIMARY KEY,
                    titulo varchar(255) NOT NULL,
                    autor varchar(255)  NOT NULL
                    )""";
        
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
