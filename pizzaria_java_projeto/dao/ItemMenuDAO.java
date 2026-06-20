package dao;

import java.sql.*;
import java.util.ArrayList;

import conexao.FabricaConexao;
import modelo.*;

public class ItemMenuDAO {

    public void salvar(ItemMenu item) throws SQLException{
        Connection c=FabricaConexao.conectar();

        String sql="INSERT INTO item_menu(nome,preco,tipo,extra) VALUES(?,?,?,?)";

        PreparedStatement st=c.prepareStatement(sql);

        st.setString(1,item.getNome());
        st.setDouble(2,item.calcularPrecoFinal());

        if(item instanceof Pizza){
            st.setString(3,"PIZZA");
            st.setString(4,((Pizza)item).getIngredientes());
        }else{
            st.setString(3,"BEBIDA");
            st.setString(4,String.valueOf(((Bebida)item).getTamanhoEmMl()));
        }

        st.executeUpdate();
    }

    public ArrayList<ItemMenu> listarTodos() throws SQLException{

        ArrayList<ItemMenu> lista=new ArrayList<>();

        Connection c=FabricaConexao.conectar();

        PreparedStatement st=
        c.prepareStatement("SELECT * FROM item_menu");

        ResultSet rs=st.executeQuery();

        while(rs.next()){

            if(rs.getString("tipo").equals("PIZZA")){

                lista.add(
                    new Pizza(
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("extra")
                    )
                );

            }else{

                lista.add(
                    new Bebida(
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        Integer.parseInt(rs.getString("extra"))
                    )
                );

            }
        }

        return lista;
    }
}
