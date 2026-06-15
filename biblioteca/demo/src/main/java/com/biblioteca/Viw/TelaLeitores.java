package com.biblioteca.Viw;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.biblioteca.Bean.Leitores;
import com.biblioteca.DAO.LeitoresDAO;

public class TelaLeitores extends JFrame {
    private JFormattedTextField txtCPF;
    private JLabel labelCPF;
    private JFormattedTextField txtTelefone;


    public TelaLeitores() {
        setTitle("Leitores");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); 

        JLabel label = new JLabel("Nome:");
        label.setBounds(30, 20, 100, 30);
        add(label);
        JTextField Nome = new JTextField();
        Nome.setBounds(100, 20, 250, 30);
        add(Nome);

        labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(30, 50, 100, 30);
        add(labelCPF);
        try {
            txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        txtCPF.setBounds(100, 50, 250, 30);
        add(txtCPF);
        JLabel labelTelefone = new JLabel("Telefone:");
        labelTelefone.setBounds(30, 80, 100, 30);
        add(labelTelefone);
        try {
            txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        txtTelefone.setBounds(100, 80, 250, 30);
        add(txtTelefone);

        JButton voltar = new JButton("Voltar");
        voltar.setBounds(200, 200, 150, 30);
        add(voltar);

        voltar.addActionListener(e -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            dispose();
        });
        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(30, 120, 150, 30);
        add(cadastrar);
        cadastrar.addActionListener(e -> {
            String nome = Nome.getText();
            String cpf = txtCPF.getText();
            String telefone = txtTelefone.getText();

            try{
            LeitoresDAO leitoresDAO = new LeitoresDAO();
            leitoresDAO.adicionar(new Leitores (nome, cpf, telefone));  
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
            javax.swing.JOptionPane.showMessageDialog(this, "Leitor cadastrado com sucesso!");
        });
        JButton buscar = new JButton("Buscar");
        buscar.setBounds(200, 120, 150, 30);
        add(buscar);
        buscar.addActionListener(e -> {
            String cpf = txtCPF.getText();
            try {
                LeitoresDAO leitoresDAO = new LeitoresDAO();
                Leitores leitor = leitoresDAO.buscarPorId(cpf);
                if (leitor != null) {
                    Nome.setText(leitor.getNome());
                    txtTelefone.setText(leitor.getTelefone());
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Leitor não encontrado!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "leitor não encontrada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JButton atualizar = new JButton("Atualizar");
        atualizar.setBounds(30, 160, 150, 30); 
        add(atualizar);
        atualizar.addActionListener(e -> {
            String nome = Nome.getText();
            String cpf = txtCPF.getText();
            String telefone = txtTelefone.getText();

            try {
                LeitoresDAO leitoresDAO = new LeitoresDAO();
                leitoresDAO.update(new Leitores(nome, cpf, telefone));
                javax.swing.JOptionPane.showMessageDialog(this, "Leitor atualizado com sucesso!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        
        JButton excluir = new JButton("Excluir");
        excluir.setBounds(200, 160, 150, 30);
        add(excluir);
        excluir.addActionListener(e -> {
            String cpf = txtCPF.getText();
            try {
                LeitoresDAO leitoresDAO = new LeitoresDAO();
                leitoresDAO.excluir(cpf);
                javax.swing.JOptionPane.showMessageDialog(this, "Leitor excluído com sucesso!");
                Nome.setText("");
                txtCPF.setText("");
                txtTelefone.setText("");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        JButton btnlimpar = new JButton("Limpar");
        btnlimpar.setBounds(30, 200, 150, 30);
        btnlimpar.addActionListener(e -> {
            Nome.setText("");
            txtCPF.setText("");
            txtTelefone.setText("");
        });
        add(btnlimpar);
        getContentPane().setBackground(java.awt.Color.GRAY); 
        setVisible(true);
    }
    
    
}
