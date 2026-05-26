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
        String sql = """
            CREATE TABLE IF NOT EXISTS obra (
                id serial          PRIMARY KEY,
                titulo varchar(255) NOT NULL,
                autor varchar(255)  NOT NULL
                )""";
    
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

    public void adicionar(Obra obra) {
        try {
            String sql = "INSERT INTO obras (titulo, autor) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, obra.getTitulo());
            statement.setString(2, obra.getAutor());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Obra buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM obras WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                return new Obra(id, titulo, autor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Obra obra) {
        try {
            String sql = "UPDATE obras SET titulo = ?, autor = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, obra.getTitulo());
            statement.setString(2, obra.getAutor());
            statement.setInt(3, obra.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        try {
            String sql = "DELETE FROM obras WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }public void obraDAO() {
        try {
            ObraDAO obraDAO = new ObraDAO();
            Obra novaObra = new Obra(0, "O Senhor dos Anéis", "J.R.R. Tolkien");
            obraDAO.adicionar(novaObra);
            System.out.println("Obra adicionada com sucesso!");

            Obra obraEncontrada = obraDAO.buscarPorId(1);
            if (obraEncontrada != null) {
                System.out.println("Obra encontrada: " + obraEncontrada.getTitulo() + " por " + obraEncontrada.getAutor());
            } else {
                System.out.println("Obra não encontrada.");
            }

            novaObra.setTitulo("O Hobbit");
            novaObra.setAutor("J.R.R. Tolkien");
            obraDAO.update(novaObra);
            System.out.println("Obra atualizada com sucesso!");

            obraDAO.delete(1);
            System.out.println("Obra deletada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
