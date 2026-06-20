package view;

import dao.ItemMenuDAO;
import javax.swing.*;
import modelo.*;
import view.TelaCardapio;

public class TelaCadastro extends JFrame {

    public TelaCadastro() {

        setTitle("Pizzaria");
        setSize(350, 320);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel label = new JLabel("Nome:");
        label.setBounds(20, 20, 40, 30);
        add(label);

        JTextField nome = new JTextField();
        nome.setBounds(100, 20, 210, 30);
        add(nome);

        label = new JLabel("Preço");
        label.setBounds(20, 60, 60, 30);
        add(label);

        JTextField preco = new JTextField();
        preco.setBounds(100, 60, 210, 30);
        add(preco);

        JComboBox<String> tipo
                = new JComboBox<>(new String[]{"Pizza", "Bebida"});

        tipo.setBounds(20, 100, 290, 30);
        add(tipo);

        label = new JLabel("Extra:");
        label.setBounds(20, 140, 60, 30);
        add(label);
        JTextField extra = new JTextField();
        extra.setBounds(100, 140, 210, 30);
        add(extra);

        JButton salvar = new JButton("Cadastrar Item");
        salvar.setBounds(20, 200, 290, 35);
        add(salvar);

        salvar.addActionListener(e -> {
            try {

                ItemMenu item;

                if (tipo.getSelectedItem().equals("Pizza")) {
                    item = new Pizza(
                            nome.getText(),
                            Double.parseDouble(preco.getText()),
                            extra.getText()
                    );
                } else {
                    item = new Bebida(
                            nome.getText(),
                            Double.parseDouble(preco.getText()),
                            Integer.parseInt(extra.getText())
                    );
                }

                new ItemMenuDAO().salvar(item);

                JOptionPane.showMessageDialog(this, "Cadastro realizado");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        setVisible(true);
    }
    JButton btnCardapio= new JButton("Abrir Cardápio");

    btnCardapio.setBounds(220,230,160,40);

    add(btnCardapio);

    btnCardapio.addActionListener (e
         ->{
            new TelaCardapio();
    });
}
