/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelAgenda;
import views.ViewAgenda;

/**
 *
 * @author Jose Felix
 */
public class ControllerAgenda {

    public ModelAgenda modelAgenda;
    public ViewAgenda viewAgenda;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_nuevo) {
                jbtn_nuevo_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_eliminar) {
                jbtn_eliminar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_insertar) {
                jbtn_insertar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_cancelar) {
                jbtn_cancelar_actionPerformed();
                
            }

        }

    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelAgenda
     * @param viewAgenda objeto de tipo ViewAgenda
     */
    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    private void initDB() {
        modelAgenda.conectarDB();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_telefono.setText(modelAgenda.getTelefono());
        viewAgenda.jtf_id_contacto.setText(modelAgenda.getId());
        viewAgenda.jbtn_insertar.setVisible(false);
        viewAgenda.jbtn_cancelar.setVisible(false);
        viewAgenda.jbtn_guardar.setVisible(false);
        viewAgenda.jtf_id_contacto.setVisible(false);
    }
    

//    /**
//     * Metodo para inicializar la ViewAgenda
//     */
//    public void initComponents() {
//        viewAgenda.setLocationRelativeTo(null);
//        viewAgenda.setTitle("Agenda MVC");
//        viewAgenda.setVisible(true);
//    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    private void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
        viewAgenda.jbtn_nuevo.addActionListener(actionListener);
        viewAgenda.jbtn_eliminar.addActionListener(actionListener);
        viewAgenda.jbtn_modificar.addActionListener(actionListener);
        viewAgenda.jbtn_insertar.addActionListener(actionListener);
        viewAgenda.jbtn_guardar.addActionListener(actionListener);
        viewAgenda.jbtn_cancelar.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() {
        modelAgenda.moverPrimerRegistro();
        setValues();
    }

    /**
     * Método para ver el registro anterior de la tabla contactos.
     */
    private void jbtn_anterior_actionPerformed() {
        modelAgenda.moverAnteriorRegistro();
        setValues();
    }

    /**
     * Método para ver el último registro de la tabla contactos.
     */
    private void jbtn_ultimo_actionPerformed() {
        modelAgenda.moverUltimoRegistro();
        setValues();
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos.
     */
    private void jbtn_siguiente_actionPerformed() {
        modelAgenda.moverSiguienteRegistro();
        setValues();
    }
    private void jbtn_nuevo_actionPerformed() {
        viewAgenda.jtf_nombre.setText("");
        viewAgenda.jtf_nombre.setEditable(true);
        viewAgenda.jtf_email.setText("");
        viewAgenda.jtf_email.setEditable(true);
        viewAgenda.jtf_telefono.setText("");
        viewAgenda.jtf_id_contacto.setText("");
        viewAgenda.jtf_telefono.setEditable(true);
        viewAgenda.jbtn_nuevo.setVisible(false);
        viewAgenda.jbtn_eliminar.setVisible(false);
        viewAgenda.jbtn_modificar.setVisible(false);
        viewAgenda.jbtn_primero.setVisible(false);
        viewAgenda.jbtn_siguiente.setVisible(false);
        viewAgenda.jbtn_anterior.setVisible(false);
        viewAgenda.jbtn_ultimo.setVisible(false);
        viewAgenda.jbtn_insertar.setVisible(true);
        viewAgenda.jbtn_cancelar.setVisible(true);
    }
    private void jbtn_eliminar_actionPerformed() {
        modelAgenda.eliminarRegistro();
        initDB();
    }
    private void jbtn_modificar_actionPerformed() {
        viewAgenda.jtf_nombre.setEditable(true);
        viewAgenda.jtf_email.setEditable(true);
        viewAgenda.jtf_telefono.setEditable(true);
        viewAgenda.jbtn_cancelar.setVisible(true);
        viewAgenda.jbtn_guardar.setVisible(true);
        viewAgenda.jbtn_nuevo.setVisible(false);
        viewAgenda.jbtn_eliminar.setVisible(false);
        viewAgenda.jbtn_modificar.setVisible(false);
    }
    private void jbtn_insertar_actionPerformed() {
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); 
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); 
        modelAgenda.insertarRegistro();
        viewAgenda.jtf_nombre.setText("");
        viewAgenda.jtf_email.setText("");
        viewAgenda.jtf_telefono.setText("");
    }
    private void jbtn_guardar_actionPerformed() {
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); 
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); 
        modelAgenda.setId(viewAgenda.jtf_id_contacto.getText());
        modelAgenda.setTelefono(viewAgenda.jtf_telefono.getText());
        modelAgenda.guardarRegistro();
    }
    private void jbtn_cancelar_actionPerformed() {
        viewAgenda.jtf_nombre.setEditable(false);
        viewAgenda.jtf_email.setEditable(false);
        viewAgenda.jtf_telefono.setEditable(false);
        viewAgenda.jbtn_nuevo.setVisible(true);
        viewAgenda.jbtn_eliminar.setVisible(true);
        viewAgenda.jbtn_modificar.setVisible(true);
        viewAgenda.jbtn_primero.setVisible(true);
        viewAgenda.jbtn_siguiente.setVisible(true);
        viewAgenda.jbtn_anterior.setVisible(true);
        viewAgenda.jbtn_ultimo.setVisible(true);
        viewAgenda.jbtn_insertar.setVisible(false);
        viewAgenda.jbtn_cancelar.setVisible(false);
        viewAgenda.jbtn_guardar.setVisible(false);
        initDB();
    }

    /**
     * Muestra el nombre y email almacenados en el modelAgenda en el viewAgenda.
     */
    private void setValues() {
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_telefono.setText(modelAgenda.getTelefono());
        viewAgenda.jtf_id_contacto.setText(modelAgenda.getId());
    }
}
