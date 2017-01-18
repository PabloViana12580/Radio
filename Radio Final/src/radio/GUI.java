/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 *
 * @author richi
 */

public class GUI{

    public GUI(){
        
        RadioNosotros grupo = new RadioNosotros();
        
        int resp = JOptionPane.showConfirmDialog(null, "Desea Encender la radio del carro?", "Radio", JOptionPane.YES_NO_OPTION);
        if(resp==0){
            grupo.setEstado(true);
        }else{
            grupo.setEstado(false);
        }
        if (grupo.isEstado()) {
            DecimalFormat decimales = new DecimalFormat("0.0");
            grupo.setEmisora(87.9);

            JFrame f = new JFrame("Radio");
            f.setLayout(new FlowLayout());

            //panel del titulo
            JPanel panelTitulo = new JPanel();
            panelTitulo.setLayout(new FlowLayout());
            JLabel titulo = new JLabel("Radio");
            titulo.setFont(new java.awt.Font("Tahoma", 0, 36));
            panelTitulo.add(titulo);

            //panel que muestra emisora y onda
            JPanel panelEmisora = new JPanel();
            panelEmisora.setLayout(new FlowLayout());
            JLabel emisora = new JLabel(decimales.format(grupo.getEmisora()) + " " + verificador(grupo.isOnda()));
            emisora.setFont(new java.awt.Font("Tahoma", 0, 18));
            panelEmisora.add(emisora);

            //actualizar un Label y seleccionar emisora guardada
            ActionListener listener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String[] opciones = {"Guardar", "Reproducir", "Cancelar"};

                    int opcion = JOptionPane.showOptionDialog(
                            null //componente
                            , "Opciones" // Mensaje
                            , "Opciones Personalizadas para Emisoras" // Titulo en la barra del cuadro
                            , JOptionPane.DEFAULT_OPTION // Tipo de opciones
                            , JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje (icono)
                            , null // Icono (ninguno)
                            , opciones // Opciones personalizadas
                            , null // Opcion por defecto
                    );
                    if (opciones[opcion] == "Reproducir") {
                        grupo.seleccionar(Integer.parseInt(((JButton) e.getSource()).getName())); //obtinene nombre del boton, lo convierte y lo utiliza para obtener la emisora guardada                    
                    } else if (opciones[opcion] == "Guardar") {
                        grupo.guardar(Integer.parseInt(((JButton) e.getSource()).getName()));
                    } else {
                        //se sale rel recuadro
                    }
                    emisora.setText(decimales.format(grupo.getEmisora()) + " " + verificador(grupo.isOnda()));
                }
            };

            //actualizar un Label y cambiar emisora
            ActionListener cambio = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (((JButton) e.getSource()).getName() == ">>") {
                        grupo.frecuencias(true); //cambia frecuencia segun boton apachado
                    } else {
                        grupo.frecuencias(false);
                    }
                    emisora.setText(decimales.format(grupo.getEmisora()) + " " + verificador(grupo.isOnda()));
                }
            };

            //enciende y apaga consola
            ActionListener encenderApagar = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    grupo.estado();
                    System.exit(0);
                }
            };

            //panel de los botones de encendido y apagado
            JPanel panelONOF = new JPanel();
            panelONOF.setLayout(new FlowLayout());
            JButton OF = new JButton("OF");
            OF.setName("OF");
            OF.addActionListener(encenderApagar);
            panelONOF.add(OF);        
            
            //panel de los botones de cambio de frecuencia
            JPanel panelCambioFrecuencia = new JPanel();
            panelCambioFrecuencia.setLayout(new FlowLayout());
            JButton atras = new JButton("<<");
            atras.setName("<<");
            atras.addActionListener(cambio);
            panelCambioFrecuencia.add(atras);
            JButton adelante = new JButton(">>");
            adelante.setName(">>");
            adelante.addActionListener(cambio);
            panelCambioFrecuencia.add(adelante);

            //actualizar un Label y cambiar Onda
            ActionListener cambioOnda = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (grupo.isOnda()) {
                        grupo.setEmisora(530);
                        grupo.cambiar(true); //cambia onda FM a AM y viceversa
                    } else {
                        grupo.setEmisora(87.9);
                        grupo.cambiar(false);
                    }
                    emisora.setText(decimales.format(grupo.getEmisora()) + " " + verificador(grupo.isOnda()));
                }
            };

            //panel de botones de cambio de onda
            JPanel panelOnda = new JPanel();
            panelOnda.setLayout(new FlowLayout());
            JButton AMFM = new JButton("FM/AM");
            AMFM.setName("FM/AM");
            AMFM.addActionListener(cambioOnda);
            panelOnda.add(AMFM);

            //panel de los botones de las emisoras guardadas
            JPanel panelBotones = new JPanel();
            panelBotones.setLayout(new FlowLayout());
            for (int i = 1; i <= 12; i++) {
                JButton boton = new JButton(String.valueOf(i));
                boton.setName(i + "");
                boton.addActionListener(listener);
                panelBotones.add(boton);
            }

            GridLayout gl = new GridLayout(5, 5);
            gl.setHgap(5);
            gl.setVgap(5);
            f.setLayout(gl);

            f.add(panelTitulo, BorderLayout.NORTH);
            f.add(panelOnda, BorderLayout.CENTER);
            f.add(panelEmisora, BorderLayout.CENTER);
            f.add(panelCambioFrecuencia, BorderLayout.CENTER);
            f.add(panelBotones, BorderLayout.SOUTH);
            f.add(panelONOF);

            f.setSize(500, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }

    }

    //devuelve la onda utilizada
    static String verificador(boolean onda) {
        if (onda) {
            return "FM";
        } else {
            return "AM";
        }
    }

}
