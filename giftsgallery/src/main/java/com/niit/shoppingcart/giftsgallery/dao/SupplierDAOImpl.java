package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.Supplier;

@Repository(value= "supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		sessionfactory.getCurrentSession().saveOrUpdate(supplier);
	}


	public SupplierDAOImpl() {
		
		// TODO Auto-generated constructor stub
	}

	public SupplierDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	public boolean delete(int id) {
		Supplier supplier = new Supplier();
		supplier.setSup_id(id);
		try {
			sessionfactory.getCurrentSession().delete(supplier);
		} catch (HibernateException e) {
			e.printStackTrace();
			return true;
			
		}
		return false;

	}

	public Supplier get(int id) {
		
		String hql = "from Supplier where sup_id=" + "'"+ id+"'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;

	}

	@Transactional
	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) sessionfactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	
	@Transactional
	public Supplier getByName(String name) {
		String hql = "from Supplier where sup_name=" + "'"+ name+"'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}


	public void update(Supplier s2) {
		Supplier s1=new Supplier();
		s1=getByName(s2.getSup_name());
		System.out.println(s1.getSup_id());
		if(s1!=null)
		{
			s1.setSup_id(s2.getSup_id());
			s1.setSup_name(s2.getSup_name());
			s1.setSup_description(s2.getSup_name());
		}
		
		
	}


}
