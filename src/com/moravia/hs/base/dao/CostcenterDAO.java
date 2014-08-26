package com.moravia.hs.base.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Costcenter;

/**
 * A data access object (DAO) providing persistence and search support for
 * Costcenter entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Costcenter
 * @author MyEclipse Persistence Tools
 */

public class CostcenterDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CostcenterDAO.class);
	// property constants
	public static final String COST_CENTER_NAME = "costCenterName";
	public static final String COST_CENTER_PARENT = "costCenterParent";
	public static final String COST_CENTER_OWNER = "costCenterOwner";
	public static final String COST_CENTER_DESC = "costCenterDesc";

	public void save(Costcenter transientInstance) {
		log.debug("saving Costcenter instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveOrUpdate(Costcenter instance) {
		log.debug("save or update Costcenter instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("save or update successful");
		} catch (RuntimeException re) {
			log.error("save or update failed", re);
			throw re;
		}
	}

	public void delete(Costcenter persistentInstance) {
		log.debug("deleting Costcenter instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			getHibernateTemplate().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Costcenter findById(java.lang.Integer id) {
		log.debug("getting Costcenter instance with id: " + id);
		try {
			Costcenter instance = (Costcenter) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Costcenter", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List<Costcenter> findByExample(Costcenter instance) {
//		log.debug("finding Costcenter instance by example");
//		try {
//			List<Costcenter> results = (List<Costcenter>) getHibernateTemplate()
//					.createCriteria("com.moravia.hs.base.entity.Costcenter")
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
//		log.debug("finding Costcenter instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from Costcenter as model where model."
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
//	public List<Costcenter> findByCostCenterName(Object costCenterName) {
//		return findByProperty(COST_CENTER_NAME, costCenterName);
//	}
//
//	public List<Costcenter> findByCostCenterParent(Object costCenterParent) {
//		return findByProperty(COST_CENTER_PARENT, costCenterParent);
//	}
//
//	public List<Costcenter> findByCostCenterOwner(Object costCenterOwner) {
//		return findByProperty(COST_CENTER_OWNER, costCenterOwner);
//	}
//
//	public List<Costcenter> findByCostCenterDesc(Object costCenterDesc) {
//		return findByProperty(COST_CENTER_DESC, costCenterDesc);
//	}
//
	public List findAll() {
		log.debug("finding all Costcenter instances");
		try {
			String queryString = "from Costcenter";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public Costcenter merge(Costcenter detachedInstance) {
		log.debug("merging Costcenter instance");
		try {
			Costcenter result = (Costcenter) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Costcenter instance) {
		log.debug("attaching dirty Costcenter instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Costcenter instance) {
		log.debug("attaching clean Costcenter instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}