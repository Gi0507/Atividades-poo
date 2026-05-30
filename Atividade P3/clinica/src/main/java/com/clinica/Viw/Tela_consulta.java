package com.clinica.Viw;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.clinica.Bean.Consulta;
import com.clinica.DAO.ConsultaDAO;

public class Tela_consulta extends JFrame {
    private JTextField txtMedico;
    private JTextField txtPaciente;
    private JTextField txtData;
    private JTextField txtHora;
    private JTextField txtHistorico;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnVoltar;

    public Tela_consulta() {
        setTitle("Marcar Consultas");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(10,15,5,5));

        painel.add(new JLabel(" Médico:"));
        txtMedico = new JTextField();
        painel.add(txtMedico);

        painel.add(new JLabel(" Paciente:"));
        txtPaciente = new JTextField();
        painel.add(txtPaciente);

        painel.add(new JLabel(" Data:"));
        txtData = new JTextField();
        painel.add(txtData);

        painel.add(new JLabel(" Hora:"));
        txtHora = new JTextField();
        painel.add(txtHora);

        painel.add(new JLabel(" Histórico:"));
        txtHistorico = new JTextField();
        painel.add(txtHistorico);


        btnSalvar = new JButton("Salvar");
        painel.add(btnSalvar);

        btnLimpar = new JButton("Limpar");
        painel.add(btnLimpar);

        btnVoltar = new JButton("Voltar");
        painel.add(btnVoltar);

        add(painel);

        btnSalvar.addActionListener(e -> salvarConsulta());
        btnLimpar.addActionListener(e -> limparCampos());
        btnVoltar.addActionListener(e -> {
            dispose();
        });

        setVisible(true);
    }

    private void salvarConsulta() {
        try {
            Consulta consulta = new Consulta();

            consulta.setMedico(txtMedico.getText());
            consulta.setPaciente(txtPaciente.getText());
            consulta.setData(txtData.getText());
            consulta.setHora(txtHora.getText());
            consulta.setHistorico(txtHistorico.getText());

            ConsultaDAO consultaDAO = new ConsultaDAO();
            consultaDAO.create(consulta);
            

            JOptionPane.showMessageDialog(
                    this,
                    "Consulta cadastrada com sucesso!");

            limparCampos();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro: " + ex.getMessage() + " - Falha ao cadastrar consulta!");
        }
    }

    private void limparCampos() {

        txtMedico.setText("");
        txtPaciente.setText("");
        txtData.setText("");
        txtHora.setText("");
        txtHistorico.setText("");
    }
}