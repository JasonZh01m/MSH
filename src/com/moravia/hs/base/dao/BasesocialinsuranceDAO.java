package com.moravia.hs.base.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Basesocialinsurance;

/**
 * A data access object (DAO) providing persistence and search support for
 * Basesocialinsurance entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.test.Basesocialinsurance
 * @author MyEclipse Persistence Tools
 */

public class BasesocialinsuranceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BasesocialinsuranceDAO.class);
	// property constants
	public static final String BSI_NAME = "bsiName";
	public static final String BSI_RATE = "bsiRate";
	public static final String BSI_ADDITIONAL = "bsiAdditional";
	public static final String BSI_DESC = "bsiDesc";

	public void save(Basesocialinsurance transientInstance) {
		log.debug("saving Basesocialinsurance instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Basesocialinsurance instance) {
		log.debug("Save or Update Basesocialinsurance instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("save or update successful");
		} catch (RuntimeException re) {
			log.error("save or update failed", re);
			throw re;
		}
	}
	
	public void delete(Basesocialinsurance persistentInstance) {
		log.debug("deleting Basesocialinsurance instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Basesocialinsurance findById(java.lang.Integer id) {
		log.debug("getting Basesocialinsurance instance with id: " + id);
		try {
			Basesocialinsurance instance = (Basesocialinsurance) getHibernateTemplate()
					.get("com.moravia.hs.base.entity.Basesocialinsurance", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
//	public List<Basesocialinsurance> findByExample(Basesocialinsurance instance) {
//		log.debug("finding Basesocialinsurance instance by example");
//		try {
//			List<Basesocialinsurance> results = (List<Basesocialinsurance>) getHibernateTemplate()
//					.createCriteria("com.test.Basesocialinsurance")
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
//		log.debug("finding Basesocialinsurance instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Basesocialinsurance as model where model."
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
//	public List<Basesocialinsurance> findByBsiName(Object bsiName) {
//		return findByProperty(BSI_NAME, bsiName);
//	}
//
//	public List<Basesocialinsurance> findByBsiRate(Object bsiRate) {
//		return findByProperty(BSI_RATE, bsiRate);
//	}
//
//	public List<Basesocialinsurance> findByBsiAdditional(Object bsiAdditional) {
//		return findByProperty(BSI_ADDITIONAL, bsiAdditional);
//	}
//
//	public List<Basesocialinsurance> findByBsiDesc(Object bsiDesc) {
//		return findByProperty(BSI_DESC, bsiDesc);
//	}

	public List findAll() {
		log.debug("finding all Basesocialinsurance instances");
		try {
			String queryString = "from Basesocialinsurance";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public Basesocialinsurance merge(Basesocialinsurance detachedInstance) {
		log.debug("merging Basesocialinsurance instance");
		try {
			Basesocialinsurance result = (Basesocialinsurance) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Basesocialinsurance instance) {
		log.debug("attaching dirty Basesocialinsurance instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Basesocialinsurance instance) {
		log.debug("attaching clean Basesocialinsurance instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}