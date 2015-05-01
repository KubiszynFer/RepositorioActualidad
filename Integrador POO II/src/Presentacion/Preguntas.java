/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Modelos.Pregunta;
import Modelos.Servidor;
import Modelos.Usuario;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fer
 */
public class Preguntas extends javax.swing.JPanel {
    /**
     * Creates new form Preguntas
     */
    Principal principal;
    Servidor unServidor;
    Usuario unUsuario=null;
        
    private DefaultTableModel modelPreguntas= new DefaultTableModel();
    private Object [] fila = new Object [3];
    
    public Preguntas(Principal unp, Usuario user, Servidor server) {
        this.principal=(Principal)unp;
        this.unServidor=(Servidor)server;
        this.unUsuario=(Usuario)user;
        initComponents();
        this.cargarTablaPreguntas();
        
    }

    public void cargarTablaPreguntas(){
        Pregunta preg=null;
        List lista=this.unServidor.getPreguntas();
        modelPreguntas.setColumnCount(0);
        
        modelPreguntas.addColumn("Título");
        modelPreguntas.addColumn("Respuestas");
        modelPreguntas.addColumn("Autor");
        modelPreguntas.addColumn("Fecha publicación");
        
        modelPreguntas.setNumRows(lista.size());
        for(int i=0; i<lista.size(); i++){ // Recorriendo Los Datos que se Encuentran en el Arraylist 
            preg=(Pregunta)lista.get(i);
         
            modelPreguntas.setValueAt(preg, i, 0); 
            modelPreguntas.setValueAt(preg.getRespuestas().size(), i, 1);
            modelPreguntas.setValueAt(preg.getAutor().getNombre(), i, 2);
            modelPreguntas.setValueAt(preg.getFecha(), i, 3);
        }
        this.tblPreguntas.setModel(modelPreguntas);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTopPreguntas = new javax.swing.JLabel();
        scrollPpreguntas = new javax.swing.JScrollPane();
        tblPreguntas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setForeground(new java.awt.Color(102, 102, 255));

        lblTopPreguntas.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblTopPreguntas.setText("Top preguntas");

        tblPreguntas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tblPreguntas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPreguntasMouseClicked(evt);
            }
        });
        scrollPpreguntas.setViewportView(tblPreguntas);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTopPreguntas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPpreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTopPreguntas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(scrollPpreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblPreguntasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPreguntasMouseClicked
        // TODO add your handling code here:
       int i=this.tblPreguntas.getSelectedRow();
       Pregunta preg;
       if(i> -1){
            preg =(Pregunta)this.tblPreguntas.getValueAt(i, 0);
            Responder pnlRespuesta= new Responder(this.unServidor, this.unUsuario, preg, this.principal);
            this.principal.devolverScroll().setViewportView(pnlRespuesta);
       }
       
    }//GEN-LAST:event_tblPreguntasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTopPreguntas;
    private javax.swing.JScrollPane scrollPpreguntas;
    private javax.swing.JTable tblPreguntas;
    // End of variables declaration//GEN-END:variables
}
