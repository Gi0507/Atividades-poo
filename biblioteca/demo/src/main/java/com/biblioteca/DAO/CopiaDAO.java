package com.biblioteca.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.biblioteca.Bean.Copia;
import com.biblioteca.Bean.Obra;
import com.biblioteca.Conexão.ConexaoSQL;

public class CopiaDAO{
    private Connection connection;

    public CopiaDAO() throws SQLException {
        connection = ConexaoSQL.conectar();
        String sql = """
            CREATE TABLE IF NOT EXISTS copia (
                codigo serial          PRIMARY KEY,
                id_obra integer        NOT NULL  FOREIGN KEY REFERENCES obra(id),
                disponivel boolean     NOT NULL
                )""";
    
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

    public void update(Copia copia) {
        try {
            String sql = "UPDATE copias SET disponivel = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, copia.isDisponivel());
            statement.setInt(2, copia.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void adicionar(Copia copia) {
        try {
            String sql = "INSERT INTO copias (id_obra, disponivel) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, copia.getObra());
            statement.setBoolean(2, copia.isDisponivel());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Copia buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM copias WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Obra obra = new ObraDAO().buscarPorId(resultSet.getInt("id_obra"));
                boolean disponivel = resultSet.getBoolean("disponivel");
                return new Copia(id, obra, disponivel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}