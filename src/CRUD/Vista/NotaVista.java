/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Vista;

import CRUD.Model.Matricula;
import CRUD.Model.Nota;
import java.util.List;

/**
 *
 * @author usuario
 */
public class NotaVista {
 
       public void verNotas(List<Nota> notas) {
        for (Nota x : notas) {
            System.out.println("Datos de la nota: " + x.toString());
        }
    }

    public void verNota(Nota nota) {

        if (nota != null) {
            System.out.println("Datos de la matrícula: " + nota.toString());
        } else {
            System.out.println("La matrícula buscada no existe");
        }}}

