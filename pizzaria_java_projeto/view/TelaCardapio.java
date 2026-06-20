package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaCardapio extends JFrame{

    public TelaCardapio(){

        setTitle("Cardápio");

        setSize(400,300);

        setLayout(null);

        setLocationRelativeTo(null);

        JTextArea area=
        new JTextArea();

        area.setEditable(false);

        area.setText(

        "🍕 Calabresa - R$45\n"+

        "🍕 Portuguesa - R$50\n"+

        "🍕 Frango com Catupiry - R$55\n"+

        "🥤 Refrigerante 350ml - R$8\n"+

        "🥤 Suco 500ml - R$10"

        );

        JScrollPane scroll=
        new JScrollPane(
        area
        );

        scroll.setBounds(
        20,
        20,
        340,
        200
        );

        add(
        scroll
        );

        setVisible(
        true
        );

    }

}