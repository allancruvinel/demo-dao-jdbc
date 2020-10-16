package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import negocio.Libra;
import negocio.Metro;
import negocio.Pe;
import negocio.Quilograma;


public class Formulario {
	private JFrame form;
    private JLabel lblValor1, lblValor2, lblResultado;
    private JTextField txtValor1, txtValor2;
    private JComboBox convertValor;
    private JButton btnConverter;
    
    Double resultado = (double) 0;
    
    public Formulario() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        form = new JFrame("converter Peso/ converter comprimento");
        form.setBounds(500, 200, 450, 350);
        form.setLayout(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        lblValor1 = new JLabel("Massa: ");
        lblValor1.setBounds(150, 80, 100, 20);
        form.add(lblValor1);
        
        txtValor1 = new JTextField();
        txtValor1.setBounds(240, 80, 80, 20);
        txtValor1.setEnabled(false);
        form.add(txtValor1);
        
        lblValor2 = new JLabel("Comprimento: ");
        lblValor2.setBounds(150, 120, 100, 20);
        form.add(lblValor2);

        txtValor2 = new JTextField();
        txtValor2.setBounds(240, 120, 80, 20);
        txtValor2.setEnabled(false);
        form.add(txtValor2);
        
        

        
        
        convertValor = new JComboBox();
        convertValor.setBounds(150, 10, 200, 25);
        convertValor.addItem("<< SELECIONE >>");
        convertValor.addItem("Quilograma (kg) para Libra (lb)");
        convertValor.addItem("Libra (lb) para Quilograma");
        convertValor.addItem("Metro (m) para Pé (ft)");
        convertValor.addItem("Pé (ft) para Metro (m)");
        convertValor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    switch(convertValor.getSelectedIndex()){
                        case 1: 
                            
                            txtValor1.setEnabled(true);
                            txtValor2.setEnabled(false);
                            
                            break;
                        case 2: 
     
                        	txtValor1.setEnabled(true);
                            txtValor2.setEnabled(false);
                            
                            break;
                        case 3: 

                            txtValor1.setEnabled(false);
                            txtValor2.setEnabled(true);
                            
                            break;
                        case 4: 
                          
                            txtValor1.setEnabled(false);
                            txtValor2.setEnabled(true);
                            
                            break;
                        default:

                            txtValor1.setEnabled(false);
                            txtValor2.setEnabled(false);
                            
                    }
                    lblResultado.setText("Resultado: ");
                    txtValor1.setText("");
                    txtValor2.setText("");
                    
                }
            }
        });
        form.add(convertValor);
        
        btnConverter = new JButton("Converter");
        btnConverter.setBounds(150, 180, 220, 25);
        btnConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (convertValor.getSelectedIndex()){
                    case 1: 
                        Quilograma quilo = new Quilograma(Double.parseDouble(txtValor1.getText()));
                        resultado = quilo.getKilo();
                        break;
                    case 2: 
                        Libra libra = new Libra(Double.parseDouble(txtValor1.getText()));
                        resultado = libra.getLibra();
                        break;
                    case 3: 
                    	Pe pe = new Pe(Double.parseDouble(txtValor2.getText()));
                        resultado = pe.getPe();
                        break;
                    case 4: 
                        Metro metro = new Metro(Double.parseDouble(txtValor2.getText()));
                        resultado = metro.getMetro();
                        break;
                }
                lblResultado.setText("resultado "+resultado);
            }
        });
        form.add(btnConverter);
        
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(150, 230, 200, 30);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setForeground(Color.BLACK);
        form.add(lblResultado);
        
        form.setVisible(true);
    }
   
}