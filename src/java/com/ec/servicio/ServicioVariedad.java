/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Variedad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioVariedad {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(Variedad variedad) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(variedad);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar variedad " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public void eliminar(Variedad variedad) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(variedad));
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error en eliminar  variedad " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public void modificar(Variedad variedad) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(variedad);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar variedad " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public List<Variedad> findBy(String valor) {

        List<Variedad> listaVariedads = new ArrayList<Variedad>();
        try {
            //Connection connection = em.unwrap(Connection.class);
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Variedad a WHERE a.varNombre LIKE :varNombre");
            query.setParameter("varNombre", "%" + valor + "%");
            listaVariedads = (List<Variedad>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en la consulta variedad " + e.getMessage());
        } finally {
            em.close();
        }

        return listaVariedads;
    }

}
