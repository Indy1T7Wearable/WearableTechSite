package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.model.ItemType;

@Repository("itemTypeDao")
public class ItemTypeDaoImpl extends AbstractDao<Integer, ItemType>implements ItemTypeDao{

	@SuppressWarnings("unchecked")
	public List<ItemType> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<ItemType>)crit.list();
	}

	public ItemType findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (ItemType)crit.uniqueResult();
	}

	public ItemType findById(Integer id) {
		return getByKey(id);
	}
	
	
}