package  com.biblioteca.Viw;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaFuncionarios extends JFrame {
    private JLabel label;
    private JButton button;

    public TelaFuncionarios() {
        // Configurações da janela
        setTitle("Tela de Funcionários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Centraliza a janela

        // Criando um rótulo
        label = new JLabel("Bem-vindo à Tela de Funcionários!");
        label.setBounds(50, 50, 300, 30);
        add(label);
        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 300, 30);
        add(textField);
        
        // Criando um botão
        button = new JButton("Clique aqui");
        button.setBounds(150, 150, 100, 30);
        add(button);
        

        // Exibindo a janela
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaFuncionarios();
    }
}