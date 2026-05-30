package com.clinica.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.clinica.Bean.Recepcionista;


public class RecepcionistaDAO{
        private String url = "jdbc:sqlite:database.db";
        private Connection conexao;
        
        public RecepcionistaDAO() throws Exception{
        conexao = DriverManager.getConnection(url);
    
        String sql = """
                CREATE TABLE IF NOT EXISTS recepcionista (
                    cpf INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    telefone TEXT NOT NULL
                )""";   
            
                
    
            Statement stmt = conexao.createStatement();
            stmt.execute(sql);
        }
    
        public void create(Recepcionista obj) throws Exception{
            String sql = "insert into recepcionista(cpf, nome, telefone) values(?,?,?)";
            PreparedStatement comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, obj.getCpf());
            comandoSql.setString(2, obj.getNome());
            comandoSql.setString(3, obj.getTelefone());
            comandoSql.executeUpdate();
        }
    
        
        public Recepcionista read(int codigo) throws  Exception{
            Recepcionista obj = new Recepcionista();
            String sql = "select * from recepcionista where codigo=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet resultado = stmt.executeQuery();
            if(!resultado.isClosed()){
                obj.setCpf(resultado.getString("cpf"));
                obj.setNome(resultado.getString("nome"));
                obj.setTelefone(resultado.getString("telefone"));
            }
            return obj;
        }
}