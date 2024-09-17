/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactform.repository;

import com.mycompany.contactform.model.NumberForm;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author malina
 */

@ApplicationScoped
public class NumberFormRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Default constructor
    public NumberFormRepository() {
    }

    // Getters and setters for entityManager if needed
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(NumberForm numberForm) {
        getEntityManager().persist(numberForm);
    }

    @Transactional
    public NumberForm getById(Long id) {
        return getEntityManager().find(NumberForm.class, id);
    }

    @Transactional
    public void update(NumberForm numberForm) {
        getEntityManager().merge(numberForm);
    }

    @Transactional
    public void delete(Long id) {
        NumberForm numberForm = getById(id);
        if (numberForm != null) {
            getEntityManager().remove(numberForm);
        }
    }

    public List<NumberForm> getAll() {
        return getEntityManager()
                .createQuery("SELECT n FROM NumberForm n", NumberForm.class)
                .getResultList();
    }
}
