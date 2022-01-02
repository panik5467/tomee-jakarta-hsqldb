package com.mastertheboss.ejb;

import com.mastertheboss.model.SimpleProperty;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Stateless
public class  ServiceBean  {

	@PersistenceContext
	private EntityManager em;

	List<SimpleProperty> list = new ArrayList<>();

	private void init() {
		if (list.isEmpty()) {
		list.add(SimpleProperty.newSimpleProperty("1","A"));
		list.add(SimpleProperty.newSimpleProperty("2","B"));
		list.add(SimpleProperty.newSimpleProperty("3","C"));
		}

	}

	public void put(String key, String value){
		SimpleProperty p = new SimpleProperty();
		p.setKey(key);
		p.setValue(value);
		em.persist(p);
	}

	public void _put(String key, String value){

		list.add(SimpleProperty.newSimpleProperty(key,value));

	}

	public void deleteAll(){

		Query query = em.createQuery("delete FROM SimpleProperty p");

		query.executeUpdate();

	}

	public void deleteById(String key){

		Query query = em.createQuery("delete FROM SimpleProperty p where p.key='"+key+"'");

		query.executeUpdate();

	}

	public List<SimpleProperty> findAll(){

		Query query = em.createQuery("select p FROM SimpleProperty p");

		List <SimpleProperty> lst = query.getResultList();
		return lst;

	}

	public List<SimpleProperty> _findAll(){

		init();

		return list;

	}

	public SimpleProperty findById(String id){

		SimpleProperty p = em.find(SimpleProperty.class, id);
		return p;

	}

}