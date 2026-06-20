package conexao;

import java.sql.*;

public class FabricaConexao {
    private static final String URL="jdbc:sqlite:pizzaria.db";

    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(URL);
    }
}
