package com.clinica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.clinica.Bean.Medico;
import com.clinica.Conexão.ConexaoSQL;

public class MedicoDAO{
        private Connection connection;

        
        public MedicoDAO() throws Exception{
        connection = ConexaoSQL.conectar();
    
        String sql = """
                CREATE TABLE IF NOT EXISTS medico (
                    crm TEXT PRIMARY KEY,
                    cpf TEXT PRIMARY KEY,
                    nome TEXT NOT NULL,
                    especialidade TEXT NOT NULL,
                    telefone TEXT NOT NULL
                )""";   
            
                
    
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
        }
    
        public void create(Medico obj) throws Exception{
            String sql = "insert into medico(crm, cpf, nome, especialidade, telefone) values(?,?,?,?,?)";
            PreparedStatement comandoSql = connection.prepareStatement(sql);
            comandoSql.setString(1, obj.getCrm());
            comandoSql.setString(2, obj.getCpf());
            comandoSql.setString(3, obj.getNome());
            comandoSql.setString(4, obj.getEspecialidade());
            comandoSql.setString(5, obj.getTelefone());
            comandoSql.executeUpdate();
        }
    
        
        public Medico read(String crm) throws  Exception{
            Medico obj = new Medico();
            String sql = "select * from medico where crm=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, crm);
    
            ResultSet resultado = stmt.executeQuery();
            if(!resultado.isClosed()){
                obj.setCrm(resultado.getString("crm"));
                obj.setCpf(resultado.getString("cpf"));
                obj.setNome(resultado.getString("nome"));
                obj.setEspecialidade(resultado.getString("especialidade"));
                obj.setTelefone(resultado.getString("telefone"));
            }
            return obj;
        }
}