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

import com.moravia.hs.base.entity.Emptype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Emptype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Emptype
 * @author MyEclipse Persistence Tools
 */

public class EmptypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(EmptypeDAO.class);
	// property constants
	public static final String EMP_TYPE_NAME = "empTypeName";
	public static final String EMP_TYPE_DESC = "empTypeDesc";

	public void save(Emptype transientInstance) {
		log.debug("saving Emptype instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveOrUpdate(Emptype instance) {
		log.debug("save or update Emptype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("save or update successful");
		} catch (RuntimeException re) {
			log.error("save or update failed", re);
			throw re;
		}
	}

	public void delete(Emptype persistentInstance) {
		log.debug("deleting Emptype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			getHibernateTemplate().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Emptype findById(java.lang.Integer id) {
		log.debug("getting Emptype instance with id: " + id);
		try {
			Emptype instance = (Emptype) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Emptype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List<Emptype> findByExample(Emptype instance) {
//		log.debug("finding Emptype instance by example");
//		try {
//			List<Emptype> results = (List<Emptype>) getHibernateTemplate()
//					.createCriteria("com.moravia.hs.base.entity.Emptype")
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
//		log.debug("finding Emptype instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from Emptype as model where model."
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
//	public List<Emptype> findByEmpTypeName(Object empTypeName) {
//		return findByProperty(EMP_TYPE_NAME, empTypeName);
//	}
//
//	public List<Emptype> findByEmpTypeDesc(Object empTypeDesc) {
//		return findByProperty(EMP_TYPE_DESC, empTypeDesc);
//	}
//
	public List findAll() {
		log.debug("finding all Emptype instances");
		try {
			String queryString = "from Emptype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public Emptype merge(Emptype detachedInstance) {
		log.debug("merging Emptype instance");
		try {
			Emptype result = (Emptype) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Emptype instance) {
		log.debug("attaching dirty Emptype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Emptype instance) {
		log.debug("attaching clean Emptype instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}