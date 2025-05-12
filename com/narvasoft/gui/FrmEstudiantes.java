// FrmESTUDIANTES: Clase Principal de la Interfaz
package com.narvasoft.gui; //Paquete principal

import java.util.ArrayList;
import javax.swing.*;
import java.awt.Image;

public class FrmEstudiantes extends javax.swing.JFrame {
    // Atributos interfaz grafica
    private JButton btnSave;
    private static JLabel lblId3; // Etiquetas
    private static JLabel lblJuegof;
    private static JLabel lblLevel;
    private static JLabel lblNombre;
    private static JLabel lblScore;
    private static JTextField txtId;// Texto
    private static JTextField txtJuego;
    private static JTextField txtLevel;
    private static JTextField txtNombre;
    private static JTextField txtScore;
    private static JTextArea txtArea;// Area de texto
    private static JScrollPane jScrollPane1;
    private static JButton btnBuscar;// Botones
    private static JButton btnEliminar;
    private static JButton btnEditar; // Boton Editar

    static ArrayList<Jugadores> jugadores = new ArrayList<>();

    public static void addJugador() { // Metodo agregar jugador
        Jugadores jugador = new Jugadores(txtNombre.getText(), txtJuego.getText(), txtLevel.getText().charAt(0),
                Integer.parseInt(txtScore.getText()));
        jugadores.add(jugador);
        txtId.setText("");
        txtArea.setText("");
        txtJuego.setText("");
        txtNombre.setText("");
        txtLevel.setText("");
        txtScore.setText("");
        listarJugadores();
    }

    static void listarJugadores() {// Metodo listar jugador
        txtArea.setText("");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("************Listado de Jugadores***************\n");
        for (Jugadores jugador : jugadores)
            // txtArea.setText("Id. "+jugador.getId()+"Nombre del Jugador:"
            // +jugador.getNombre() + " Puntaje: "+jugador.getMaxScore());
            // System.out.println("Id. "+jugador.getId()+"Nombre del Jugador:"
            // +jugador.getNombre() + " Puntaje: "+jugador.getMaxScore());
            stringBuilder.append("Id. ").append(jugador.getId()).append(" Nombre del Jugador: ")
                    .append(jugador.getNombre()).append(" Puntaje: ").append(jugador.getMaxScore()).append("\n");
        txtArea.setText(stringBuilder.toString());
    }

    public FrmEstudiantes() {
        initComponents();
    }

    static void buscarJugador() {
    int id = Integer.parseInt(txtId.getText());
    boolean encontrado = false;

    for (Jugadores jugador : jugadores) {
        if (jugador.getId() == id) {
            txtNombre.setText(jugador.getNombre());
            txtJuego.setText(jugador.getJuegoFavortio());
            txtScore.setText(String.valueOf(jugador.getMaxScore()));
            txtLevel.setText(Character.toString(jugador.getLevel()));
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(null, 
            "No se encontró el jugador con ID: " + id, 
            "Jugador no encontrado",
            JOptionPane.INFORMATION_MESSAGE);
        System.out.println("No se ha encontrado un jugador con ID " + id);
    }
}



    	static void eliminarJugador() {
	int id = Integer.parseInt(txtId.getText());
	               for (Jugadores jugador : jugadores) {
	                              if (jugador.getId() == id) {
	                              int confirmacion = JOptionPane.showConfirmDialog(null,
                              "¿Estás seguro de que deseas eliminar al jugador con ID: " + id + "?",
	                              "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
	                              if (confirmacion == JOptionPane.YES_OPTION) {
	                              jugadores.remove(jugador);
	               JOptionPane.showMessageDialog(null, "Se ha eliminado el jugador con ID: "
	               + jugador.getId(), "Eliminar jugador", JOptionPane.INFORMATION_MESSAGE);
	                              System.out.println("Se ha eliminado el jugador " + jugador.getId());
                                      txtId.setText("");
                                      txtArea.setText("");
                                      txtJuego.setText("");
                                      txtNombre.setText("");
                                      txtLevel.setText("");
                                      txtScore.setText("");
	                              } else {
	               JOptionPane.showMessageDialog(null, "Eliminación cancelada.", "Cancelar",
	               JOptionPane.INFORMATION_MESSAGE);
	                              }
	                              break;
	                              }
	               }
	}


    static void editarJugador() {
        int id = Integer.parseInt(txtId.getText());
        boolean encontrado = false;

        for (Jugadores jugador : jugadores) {
            if (jugador.getId() == id) {
                jugador.setNombre(txtNombre.getText());
                jugador.setJuegoFavortio(txtJuego.getText());
                jugador.setLevel(txtLevel.getText().charAt(0));
                jugador.setMaxScore(Integer.parseInt(txtScore.getText()));

                JOptionPane.showMessageDialog(null, "Se han actualizado los datos del jugador con ID: " + id,
                        "Jugador actualizado", JOptionPane.INFORMATION_MESSAGE);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró un jugador con ID: " + id, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }





    public ImageIcon redimensionarIcono(String rutaRelativa, int ancho, int alto) {
        java.net.URL url = getClass().getResource(rutaRelativa);
        if (url != null) {
            ImageIcon icono = new ImageIcon(url);
            Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(imagen);
        } else {
            System.err.println("No se encontró la imagen: " + rutaRelativa);
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblJuegof = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblId3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtLevel = new javax.swing.JTextField();
        txtJuego = new javax.swing.JTextField();
        txtScore = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton(); // AGREGADO
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNombre.setText("Nombre del jugador:");
        lblNombre.setIcon(redimensionarIcono("/imagenes/nombre.png", 24, 24));

        lblLevel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLevel.setText("Nivel:");
        lblLevel.setIcon(redimensionarIcono("/imagenes/nivel.png", 24, 24));
        lblLevel.setToolTipText("'");

        lblJuegof.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblJuegof.setText("Juego Favorito:");
        lblJuegof.setIcon(redimensionarIcono("/imagenes/juego.png", 24, 24));

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblScore.setText("Score:");
        lblScore.setIcon(redimensionarIcono("/imagenes/puntaje.png", 24, 24));

        lblId3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblId3.setText("ID:");
        lblId3.setIcon(redimensionarIcono("/imagenes/id.png", 24, 24)); // NOI18N
        lblId3.setToolTipText("Campo ID del jugador");

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtLevel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLevel.setToolTipText("P' principiante, 'I' Intermedio o 'A' Avanzado");

        txtJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtScore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        // btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salvar.png"))); // NOI18N
        btnSave.setIcon(redimensionarIcono("/imagenes/salvar.png", 24, 24)); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setToolTipText("Guardar el Jugador Actual");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnBuscar.setIcon(redimensionarIcono("/imagenes/buscar.png", 24, 24)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Guardar el Jugador Actual");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(redimensionarIcono("/imagenes/borrar.png", 24, 24)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Guardar el Jugador Actual");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(redimensionarIcono("/imagenes/editar.png", 24, 24)); // icono
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Editar los datos del Jugador actual");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblNombre,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                274,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblLevel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                119,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtLevel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                43,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtNombre,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                240,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtId,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        44,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(30, 30, 30)
                                                                                .addComponent(btnBuscar))))
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                        layout.createSequentialGroup()
                                                                                .addComponent(lblScore,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        141,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(txtScore,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        301,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                        layout.createSequentialGroup()
                                                                                .addComponent(lblJuegof,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        204,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(txtJuego,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        301,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 678,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(306, 306, 306)
                                                .addComponent(btnSave)
                                                .addGap(42, 42, 42)
                                                .addComponent(btnEliminar)
                                                .addGap(42, 42, 42)
                                                .addComponent(btnEditar)))
                                .addContainerGap(46, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(663, Short.MAX_VALUE))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblJuegof, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtJuego, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(82, 82, 82)
                                        .addComponent(btnSave)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnEditar)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(653, Short.MAX_VALUE))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed
        addJugador(); // TODO add your handling code here:
    }// GEN-LAST:event_btnSaveActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarJugador();
    }// GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        eliminarJugador();
        listarJugadores();
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        editarJugador();
        listarJugadores();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEstudiantes().setVisible(true);
            }
        });
    }
    /*
     * // Variables declaration - do not modify//GEN-BEGIN:variables
     * private javax.swing.JButton btnBuscar;
     * private javax.swing.JButton btnEliminar;
     * private javax.swing.JButton btnSave;
     * private javax.swing.JScrollPane jScrollPane1;
     * private javax.swing.JLabel lblId3;
     * private javax.swing.JLabel lblJuegof;
     * private javax.swing.JLabel lblLevel;
     * private javax.swing.JLabel lblNombre;
     * private javax.swing.JLabel lblScore;
     * private javax.swing.JTextArea txtArea;
     * private javax.swing.JTextField txtId;
     * private javax.swing.JTextField txtJuego;
     * private javax.swing.JTextField txtLevel;
     * private javax.swing.JTextField txtNombre;
     * private javax.swing.JTextField txtScore;
     * // End of variables declaration//GEN-END:variables
     */
}
