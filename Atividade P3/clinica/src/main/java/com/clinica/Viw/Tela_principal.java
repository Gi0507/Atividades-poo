package com.clinica.Viw;

import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela_principal extends JFrame {
    private JButton btnMedico;
    private JButton btnPaciente;
    private JButton btnConsulta;
    

    public Tela_principal() {
        JPanel painel = new JPanel((new GridLayout(5,1,1,3)));
        add(painel);

        setTitle("Clínica Médica");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnMedico = new JButton("Medico");
        painel.add(btnMedico);

        btnPaciente = new JButton("Paciente");
        painel.add(btnPaciente);

        btnConsulta = new JButton("Consulta");
        painel.add(btnConsulta);

        btnMedico.addActionListener(e -> {
            Tela_medico telaMedico = new Tela_medico();
            telaMedico.setVisible(true);
        });

         btnPaciente.addActionListener(e -> {
            Tela_paciente telaPaciente;
            try {
                telaPaciente = new Tela_paciente();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
        });

       btnConsulta.addActionListener(e -> {
            Tela_consulta telaConsulta = new Tela_consulta();
            telaConsulta.setVisible(true);
        });

        setVisible(true);
    }
}
