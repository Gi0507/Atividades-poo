package com.clinica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.clinica.Bean.Consulta;
import com.clinica.Conexão.ConexaoSQL;


public class ConsultaDAO {
     private Connection connection;

    
    public ConsultaDAO() throws Exception{
       connection = ConexaoSQL.conectar();

       String sql = """
            CREATE TABLE IF NOT EXISTS consulta (
                codigo INTEGER PRIMARY KEY AUTOINCREMENT,
                medico TEXT FOREIGN KEY REFERENCES medico(nome),
                paciente TEXT FOREIGN KEY REFERENCES paciente(nome),
                historico TEXT NOT NULL,
                data TEXT NOT NULL,
                hora TEXT NOT NULL
            )""";
      

        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

    public void create(Consulta obj) throws Exception{
        String sql = "insert into consulta(medico, paciente, data, hora, historico) values(?,?,?,?,?)";
        PreparedStatement comandoSql = connection.prepareStatement(sql);
        comandoSql.setString(1, obj.getMedico());
        comandoSql.setString(2, obj.getPaciente());
        comandoSql.setString(3, obj.getData());
        comandoSql.setString(4, obj.getHora());
        comandoSql.setString(5, obj.getHistorico());
        comandoSql.executeUpdate();
    }

    
    public Consulta read(int codigo) throws  Exception{
        Consulta obj = new Consulta();
        String sql = "select * from consulta where codigo=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, codigo);

        ResultSet resultado = stmt.executeQuery();
        if(!resultado.isClosed()){
            obj.setMedico(resultado.getString("medico"));
            obj.setPaciente(resultado.getString("paciente"));
            obj.setData(resultado.getString("data"));
            obj.setHora(resultado.getString("hora"));
            obj.setCodigo(codigo);
        }
        return obj;
    }
    
}
