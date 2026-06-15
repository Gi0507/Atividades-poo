package com.biblioteca.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.biblioteca.Bean.Copia;
import com.biblioteca.Conexão.ConexaoSQL;

public class CopiaDAO{
    private Connection connection;

    public CopiaDAO() throws SQLException {
        connection = ConexaoSQL.conectar();
        
    }

    public void update(Copia copia) {
        try {
            String sql = "UPDATE copia codigo(autor,disponivel,titulo,ano)VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, copia.getAutor());
            statement.setBoolean(2, copia.isDisponivel());
            statement.setString(3, copia.getTitulo());
            statement.setInt(4, copia.getAno());
            
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void adicionar(Copia copia) {
        try {
            String sql = "INSERT INTO copia (autor,disponivel,titulo,ano) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, copia.getAutor());
            statement.setBoolean(2, copia.isDisponivel());
            statement.setString(3,copia.getTitulo());
            statement.setInt(4,copia.getAno());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Copia buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM copia WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                boolean disponivel = resultSet.getBoolean("disponivel");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                int ano = resultSet.getInt("ano");
                return new Copia(disponivel, titulo, autor, ano);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void excluir(int id){
        try {
                String sql = "DELETE FROM copia WHERE codigo = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
}