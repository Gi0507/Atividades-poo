package com.clinica.Viw;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.clinica.Bean.Medico;
import com.clinica.DAO.MedicoDAO;

public class Tela_medico extends JFrame {

    private JTextField txtCrm;
    private JTextField txtNome;
    private JTextField txtEspecialidade;
    private JTextField txtTelefone;
    private JTextField txtCpf;

    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnVoltar;

    public Tela_medico() {

        setTitle("Cadastro de Médicos");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(10,15,5,5));

        painel.add(new JLabel(" CRM:"));
        txtCrm = new JTextField();
        painel.add(txtCrm);

        painel.add(new JLabel(" CPF:"));
        txtCpf = new JTextField();
        painel.add(txtCpf);

        painel.add(new JLabel(" Nome:"));
        txtNome = new JTextField();
        painel.add(txtNome);

        painel.add(new JLabel(" Especialidade:"));
        txtEspecialidade = new JTextField();
        painel.add(txtEspecialidade);

        painel.add(new JLabel(" Telefone:"));
        txtTelefone = new JTextField();
        painel.add(txtTelefone);

        btnSalvar = new JButton("Salvar");
        painel.add(btnSalvar);

        btnLimpar = new JButton("Limpar");
        painel.add(btnLimpar);

        btnVoltar = new JButton("Voltar");
        painel.add(btnVoltar);

        add(painel);

        btnSalvar.addActionListener(e -> salvarMedico());
        btnLimpar.addActionListener(e -> limparCampos());
        btnVoltar.addActionListener(e -> {
            dispose();
        });

        setVisible(true);
    }

    private void salvarMedico() {

        try {

            Medico medico = new Medico();

            medico.setCrm(txtCrm.getText());
            medico.setNome(txtNome.getText());
            medico.setEspecialidade(txtEspecialidade.getText());
            medico.setTelefone(txtTelefone.getText());
            medico.setCpf(txtCpf.getText());

            MedicoDAO dao = new MedicoDAO();
            dao.create(medico);

            JOptionPane.showMessageDialog(
                    this,
                    "Médico cadastrado com sucesso!");

            limparCampos();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro: " + ex.getMessage() + " - Falha ao cadastrar médico!");
        }
    }

    private void limparCampos() {

        txtCrm.setText("");
        txtNome.setText("");
        txtEspecialidade.setText("");
        txtTelefone.setText("");
        txtCpf.setText("");
    }
}