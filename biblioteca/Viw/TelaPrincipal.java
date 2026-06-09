package com.biblioteca.Viw;

import javax.swing.JButton;
import javax.swing.JFrame;


public class TelaPrincipal extends JFrame {
    private JButton buttonLeitores;
    private JButton buttonFuncionarios;
    private JButton ButtonObra;
    private JButton ButtonCopias;

    public TelaPrincipal() {
        setTitle("Biblioteca");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); 

        buttonLeitores = new JButton("Leitores");
        buttonLeitores.setBounds(50, 20, 120, 30);
        add(buttonLeitores);

        buttonFuncionarios = new JButton("Funcionários");
        buttonFuncionarios.setBounds(200, 20, 120, 30);
        add(buttonFuncionarios);
        ButtonObra = new JButton("Obras");
        ButtonObra.setBounds(50, 100, 120, 30);
        add(ButtonObra);
        ButtonCopias = new JButton("Copias");
        ButtonCopias.setBounds(200, 100, 120, 30);
        add(ButtonCopias);

        buttonLeitores.addActionListener(e -> {
            TelaLeitores telaLeitores = new TelaLeitores();
            telaLeitores.setVisible(true);
            dispose();
        });

        buttonFuncionarios.addActionListener(e -> {
            TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
            telaFuncionarios.setVisible(true);
            dispose();
        });
        ButtonObra.addActionListener(e -> {
            TelaObra telaObras = new TelaObra();
            telaObras.setVisible(true);
            dispose();
        });
        ButtonCopias.addActionListener(e -> {
            TelaCopia telaCopias = new TelaCopia();
            telaCopias.setVisible(true);
            dispose();
        });

        getContentPane().setBackground(
         java.awt.Color.GRAY
        );
        setVisible(true);
    }
}