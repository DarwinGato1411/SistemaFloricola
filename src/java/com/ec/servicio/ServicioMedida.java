/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Medida;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioMedida {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(Medida medida) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(medida);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar medida " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public void eliminar(Medida medida) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(medida));
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error en eliminar  medida " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public void modificar(Medida medida) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(medida);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar medida " + e.getMessage());
        } finally {
            em.close();
        }

    }
    public List<Medida> findByM(String valor) {

        List<Medida> listaMedidas = new ArrayList<Medida>();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Medida a WHERE a.medCentimetros LIKE :medCentimetros");
            query.setParameter("medCentimetros", "%" + valor + "%");
            listaMedidas = (List<Medida>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en la consulta medida " + e.getMessage());
        } finally {
            em.close();
        }

        return listaMedidas;
    }

}
