/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicejpa.respositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fernando
 */
public class RepositorioJPA <T> {
    protected EntityManagerFactory emf;
    protected EntityManager em;

    public RepositorioJPA() {
        emf = Persistence.createEntityManagerFactory("PracticeJPAPU");
        em = emf.createEntityManager();
    }
    
    //conectar a bd
    protected void conect() {
        if (!em.isOpen())em = emf.createEntityManager();
    }
    
    //desconectar de bd
    protected void disconect() {
        if (em.isOpen()) em.close();
    }
    
    protected void create(T object) {
        conect();
        em.getTransaction().begin();
        //crea
        em.persist(object);
        em.getTransaction().commit();
        disconect();
    }
    
    protected void update(T object) {
        conect();
        em.getTransaction().begin();
        //actualiza
        em.merge(object);
        em.getTransaction().commit();
        disconect();
    }
    
    protected void delete(T object) {
        conect();
        em.getTransaction().begin();
        //elimina
        em.remove(object);
        em.getTransaction().commit();
        disconect();
    }
}
