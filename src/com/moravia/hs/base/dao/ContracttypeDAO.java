package com.moravia.hs.base.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Contracttype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Contracttype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Contracttype
 * @author MyEclipse Persistence Tools
 */

public class ContracttypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ContracttypeDAO.class);
	// property constants
	public static final String CONTRACT_TYPE_NAME = "contractTypeName";
	public static final String CONTRACT_TYPE_DESC = "contractTypeDesc";

	public void save(Contracttype transientInstance) {
		log.debug("saving Contracttype instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Contracttype instance) {
		log.debug("save or update Contracttype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("save or update successful");
		} catch (RuntimeException re) {
			log.error("save or update failed", re);
			throw re;
		}
	}
	
	public void delete(Contracttype persistentInstance) {
		log.debug("deleting Contracttype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			getHibernateTemplate().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Contracttype findById(java.lang.Integer id) {
		log.debug("getting Contracttype instance with id: " + id);
		try {
			Contracttype instance = (Contracttype) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Contracttype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List<Contracttype> findByExample(Contracttype instance) {
//		log.debug("finding Contracttype instance by example");
//		try {
//			List<Contracttype> results = (List<Contracttype>) getHibernateTemplate()
//					.createCriteria("com.moravia.hs.base.entity.Contracttype")
//					.add(create(instance)).list();
//			log.debug("find by example successful, result size: "
//					+ results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Contracttype instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Contracttype as model where model."
//					+ propertyName + "= ?";
//			Query queryObject = getHibernateTemplate().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List<Contracttype> findByContractTypeName(Object contractTypeName) {
//		return findByProperty(CONTRACT_TYPE_NAME, contractTypeName);
//	}
//
//	public List<Contracttype> findByContractTypeDesc(Object contractTypeDesc) {
//		return findByProperty(CONTRACT_TYPE_DESC, contractTypeDesc);
//	}
//
	public List findAll() {
		log.debug("finding all Contracttype instances");
		try {
			String queryString = "from Contracttype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public Contracttype merge(Contracttype detachedInstance) {
		log.debug("merging Contracttype instance");
		try {
			Contracttype result = (Contracttype) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Contracttype instance) {
		log.debug("attaching dirty Contracttype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Contracttype instance) {
		log.debug("attaching clean Contracttype instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}