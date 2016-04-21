package com.sarcastico.as.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sarcastico.interceptors.Audit;
import com.sarcastico.interceptors.Logging;


/**
 * Methods of ItemServiceBean marked with annotations, which specify that an annotation type is an interceptor binding type.
 * CDI-interceptors are disabled by default, so must be added to WEB-INF/beans.xml, also the order of execution can be specified
 * in descriptor.
 *
 * @author Ievgen Shulga
 */
@Stateless
public class ItemServiceBean {

    @Inject
    private EntityManager em;

    //@Audit
    @Logging
    public void create(Long id, String name) {
    	Item i = new Item();
    	i.setId(id);
    	i.setName(name);
        em.persist(i);
    }

    //@Audit
    @Logging
    public List<Item> getList() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

}
