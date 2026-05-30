package com.clinica.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.clinica.Bean.Consulta;
import com.clinica.Bean.Exame;


public class ExameDAO {
     private String url = "jdbc:sqlite:database.db";
    private Connection conexao;
    
    public ExameDAO() throws Exception{
       conexao = DriverManager.getConnection(url);

       String sql = """
            CREATE TABLE IF NOT EXISTS agenda (
                consulta INTEGER          PRIMARY KEY FOREIGN KEY REFERENCES Consulta(codigo),
                data TEXT NOT NULL      FOREIGN KEY REFERENCES consulta(data),
                descretivo TEXT NOT NULL      FOREIGN KEY REFERENCES consulta(hora)
            )""";


        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
    }

    public void create(Exame obj) throws Exception{
        String sql = "insert into agenda(consulta, data, descritivo) values(?,?,?)";
        PreparedStatement comandoSql = conexao.prepareStatement(sql);
        comandoSql.setObject(1, obj.getConsulta());
        comandoSql.setString(2, obj.getData());
        comandoSql.setString(3, obj.getDescritivo());
        comandoSql.executeUpdate();
    }

    
    public Exame read(int codigo) throws  Exception{
        Exame obj = new Exame();
        String sql = "select * from agenda where codigo=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, codigo);

        ResultSet resultado = stmt.executeQuery();
        if(!resultado.isClosed()){
            obj.setConsulta(resultado.getObject("consulta", Consulta.class));
            obj.setData(resultado.getString("data"));
            obj.setDescritivo(resultado.getString("descritivo"));
            }
        return obj;
    }
    
}