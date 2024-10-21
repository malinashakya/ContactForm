/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactform.repository;

import com.mycompany.contactform.model.Contact;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Repository for managing Contact entities.
 */
@ApplicationScoped
public class ContactRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Default constructor
    public ContactRepository() {
    }

    // Getters and setters for entityManager if needed
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Contact contact) {
        getEntityManager().persist(contact);
    }

    @Transactional
    public Contact getById(Long id) {
        return getEntityManager().find(Contact.class, id);
    }

    @Transactional
    public void update(Contact contact) {
        getEntityManager().merge(contact);
    }

    @Transactional
    public void delete(Long id) {
        Contact contact = getById(id);
        if (contact != null) {
            getEntityManager().remove(contact);
        }
    }

    public List<Contact> getAll() {
        return getEntityManager()
                .createQuery("SELECT c FROM Contact c", Contact.class)
                .getResultList();
    }
    
    //Inorder to do VirtualLazyLoading in Nuxt
    public List<Contact> getPaginatedContacts(int start, int limit)
    {
        return entityManager.createQuery("SELECT c FROM Contact c",Contact.class)
        .setFirstResult(start)
        .setMaxResults(limit)
        .getResultList();
    }
}
