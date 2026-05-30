package com.clinica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.clinica.Bean.Paciente;
import com.clinica.Conexão.ConexaoSQL;


public class PacienteDAO {
     private Connection connection;

    
    public PacienteDAO() throws Exception{
        connection = ConexaoSQL.conectar();

       String sql = """
            CREATE TABLE IF NOT EXISTS paciente (
                cpf TEXT PRIMARY KEY ,
                nome TEXT NOT NULL,
                idade INTEGER NOT NULL,
                sexo TEXT NOT NULL,
                telefone TEXT 
            )""";
      

        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

    public void create(Paciente obj) throws Exception{
        String sql = "insert into paciente(cpf, nome, idade, sexo,telefone) values(?,?,?,?,?)";
        PreparedStatement comandoSql = connection.prepareStatement(sql);
        comandoSql.setString(1, obj.getCpf());
        comandoSql.setString(2, obj.getNome());
        comandoSql.setInt(3, obj.getIdade());
        comandoSql.setString(4, obj.getGenero());
        comandoSql.setString(5,obj.getTelefone());
        comandoSql.executeUpdate();
    }

    
    public Paciente read(String cpf) throws  Exception{
        Paciente obj = new Paciente();
        String sql = "select * from paciente where cpf=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, cpf);

        ResultSet resultado = stmt.executeQuery();
        if(!resultado.isClosed()){
            obj.setNome(resultado.getString("nome"));
            obj.setIdade(resultado.getInt("idade"));
            obj.setGenero(resultado.getString("sexo"));
            obj.setTelefone(resultado.getString("telefone"));
        }
        return obj;
    }
    }
    