package com.clinica.Viw;

import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.clinica.Bean.Paciente;
import com.clinica.DAO.PacienteDAO;

public class Tela_paciente extends JFrame {
    private JTextField txtCpf;
    private JTextField txtNome;
    private JTextField txtTelefone;

    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnVoltar;

    public Tela_paciente() throws ParseException {

        setTitle("Cadastro de Pacientes");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(10,15,5,5));

        painel.add(new JLabel(" CPF:"));
        txtCpf = new JTextField();
        painel.add(txtCpf);

        painel.add(new JLabel(" Nome:"));
        txtNome = new JTextField();
        painel.add(txtNome);

        painel.add(new JLabel(" Telefone:"));
        txtTelefone = new JTextField();
        painel.add(txtTelefone);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setPreferredSize(new java.awt.Dimension(120, 40));
        painel.add(btnSalvar);

        btnLimpar = new JButton("Limpar");        
        btnLimpar.setPreferredSize(new java.awt.Dimension(120, 40));
        painel.add(btnLimpar);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setPreferredSize(new java.awt.Dimension(120, 40));
        painel.add(btnVoltar);



        add(painel);

        btnSalvar.addActionListener(e -> salvar());
        btnLimpar.addActionListener(e -> limparCampos());
        btnVoltar.addActionListener(e -> {
            dispose();
        });

        setVisible(true);
    }

    private void salvar() {
        try {
            Paciente paciente = new Paciente();

            paciente.setCpf(txtCpf.getText());
            paciente.setNome(txtNome.getText());
            paciente.setTelefone(txtTelefone.getText());

            PacienteDAO dao = new PacienteDAO();
            dao.create(paciente);

            JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");

            limparCampos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage() + " - Falha ao cadastrar paciente!");
        }
        }

    private void limparCampos() {
        txtCpf.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
    }

}