package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Item;

@Repository("itemDao")
public class ItemDaoImpl extends AbstractDao<Integer, Item> implements ItemDao{

	public Item findById(Integer id) {
		Item item = getByKey(id);
		if(item!=null){
			Hibernate.initialize(item.getItemTypes());
		}
		return item;
	}

	public void save(Item item) {
		persist(item);
	}

	public void deleteById(Integer id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Item item = (Item)crit.uniqueResult();
		delete(item);
	}

	@SuppressWarnings("unchecked")
	public List<Item> findAllItems() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("brand")).addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Item> items = (List<Item>)criteria.list();
		return items;
	}
	
}