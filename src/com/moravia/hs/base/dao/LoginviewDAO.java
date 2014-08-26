package com.moravia.hs.base.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moravia.hs.base.entity.Mbo;
import com.moravia.hs.base.entity.Positiontitle;
import com.moravia.hs.base.entity.view.Loginview;

/**
 * A data access object (DAO) providing persistence and search support for
 * Positiontitle entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Positiontitle
 * @author MyEclipse Persistence Tools
 */
@Repository
//@Transactional
public class LoginviewDAO extends HibernateDaoSupport{
   //find by empLoginId
 	public Loginview findByLoginId(String empLoginId) {
 		try {
 			String queryString = "from Loginview where empLoginId = ?";
 			List list = getHibernateTemplate().find(queryString, empLoginId);
 			if(list != null && list.size() == 1) {
 				return (Loginview) list.get(0);
 			}
 			return null;
 		} catch (RuntimeException re) {
 			throw re;
 		} 
 	}
 	
 	
 	public List<Loginview> findAll() {
 		try {
 			String queryString = "from Loginview";
 			return getHibernateTemplate().find(queryString);
 		} catch (RuntimeException re) {
 			throw re;
 		} 
 	}
 	
 	public List<String> findAllLoginId() {
 		try {
 			String queryString = "select empLoginId from Loginview";
 			return getHibernateTemplate().find(queryString);
 		} catch (RuntimeException re) {
 			throw re;
 		}
 	}
 	
 	
 	public Loginview findById(java.lang.Integer id) {
		try {
			Loginview instance = (Loginview) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.view.Loginview", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
 	
	
}