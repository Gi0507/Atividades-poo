package view;

import javax.swing.*;
import dao.ItemMenuDAO;
import modelo.*;

public class TelaCadastro extends JFrame{

    public TelaCadastro(){

        setTitle("Pizzaria");
        setSize(450,320);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField nome=new JTextField();
        nome.setBounds(20,20,250,30);
        add(nome);

        JTextField preco=new JTextField();
        preco.setBounds(20,60,250,30);
        add(preco);

        JComboBox<String> tipo=
        new JComboBox<>(new String[]{"Pizza","Bebida"});

        tipo.setBounds(20,100,250,30);
        add(tipo);

        JTextField extra=new JTextField();
        extra.setBounds(20,140,250,30);
        add(extra);

        JButton salvar=new JButton("Cadastrar Item");
        salvar.setBounds(20,200,180,35);
        add(salvar);

        salvar.addActionListener(e->{
            try{

                ItemMenu item;

                if(tipo.getSelectedItem().equals("Pizza")){
                    item=new Pizza(
                        nome.getText(),
                        Double.parseDouble(preco.getText()),
                        extra.getText()
                    );
                }else{
                    item=new Bebida(
                        nome.getText(),
                        Double.parseDouble(preco.getText()),
                        Integer.parseInt(extra.getText())
                    );
                }

                new ItemMenuDAO().salvar(item);

                JOptionPane.showMessageDialog(this,"Cadastro realizado");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        });

        setVisible(true);
    }
}
