package com.clinica.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.clinica.Bean.Receita;


public class ReceitaDAO{
     private String url = "jdbc:sqlite:database.db";
    private Connection conexao;
    
    public ReceitaDAO() throws Exception{
       conexao = DriverManager.getConnection(url);

       String sql = """
            CREATE TABLE IF NOT EXISTS receita (
                codigo INTEGER PRIMARY KEY AUTOINCREMENT,
                consulta INTEGER FOREIGN KEY REFERENCES consulta(codigo),
                data TEXT NOT NULL FOREIGN KEY REFERENCES consulta(data),
                descritivo TEXT NOT NULL FOREIGN KEY REFERENCES consulta(hora)
            )""";   
           
            

        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
    }

    public void create(Receita obj) throws Exception{
        String sql = "insert into receita(consulta, data, descritivo) values(?,?,?)";
        PreparedStatement comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, obj.getConsulta());
        comandoSql.setString(2, obj.getData());
        comandoSql.setString(3, obj.getDescritivo());
        comandoSql.executeUpdate();
    }

    
    public Receita read(int codigo) throws  Exception{
        Receita obj = new Receita();
        String sql = "select * from receita where codigo=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, codigo);
        ResultSet resultado = stmt.executeQuery();
        if(!resultado.isClosed()){
            obj.setDescritivo(resultado.getString("descritivo"));
            obj.setConsulta(resultado.getInt("consulta"));
            obj.setData(resultado.getString("data"));
            obj.setCodigo(codigo);
        }
        return obj;
    }    
}
