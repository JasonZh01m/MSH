package com.moravia.hs.base.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Baseincomtax;

/**
 * A data access object (DAO) providing persistence and search support for
 * Baseincomtax entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.test.Baseincomtax
 * @author MyEclipse Persistence Tools
 */

public class BaseincomtaxDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BaseincomtaxDAO.class);
	// property constants
	public static final String INCOMTAX_VALUE = "incomtaxValue";
	public static final String INCOMTAX_RATE = "incomtaxRate";
	public static final String INCOMTAX_DESC = "incomtaxDesc";

	public void save(Baseincomtax transientInstance) {
		log.debug("saving Baseincomtax instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveOrUpdate(Baseincomtax instance) {
		log.debug("Save or update Baseincomtax instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("Save or update successful");
		} catch (RuntimeException re) {
			log.error("Save or update failed", re);
			throw re;
		}
	}

	public void delete(Baseincomtax persistentInstance) {
		log.debug("deleting Baseincomtax instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	// delete By Id
	public void deleteById(Integer id) {
		log.debug("deleting Baseincomtax instance with id: " + id);
			Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "delete from Baseincomtax where incomtaxId = ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setInteger(0, id);
			queryObject.executeUpdate();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		} finally {
			log.debug("closing session");
			session.close();
		}
	}

	public Baseincomtax findById(java.lang.Integer id) {
		log.debug("getting Baseincomtax instance with id: " + id);
		try {
			Baseincomtax instance = (Baseincomtax) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Baseincomtax", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List<Baseincomtax> findByExample(Baseincomtax instance) {
//		log.debug("finding Baseincomtax instance by example");
//		try {
//			List<Baseincomtax> results = (List<Baseincomtax>) getHibernateTemplate()
//					.createCriteria("com.test.Baseincomtax")
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
//		log.debug("finding Baseincomtax instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Baseincomtax as model where model."
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
//	public List<Baseincomtax> findByIncomtaxValue(Object incomtaxValue) {
//		return findByProperty(INCOMTAX_VALUE, incomtaxValue);
//	}
//
//	public List<Baseincomtax> findByIncomtaxRate(Object incomtaxRate) {
//		return findByProperty(INCOMTAX_RATE, incomtaxRate);
//	}
//
//	public List<Baseincomtax> findByIncomtaxDesc(Object incomtaxDesc) {
//		return findByProperty(INCOMTAX_DESC, incomtaxDesc);
//	}

	public List findAll() {
		log.debug("finding all Baseincomtax instances");
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Baseincomtax";
//			Query queryObject = session.createQuery(queryString);
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
//		finally {
//			log.debug("closing session");
//			session.close();
//		}
	}

	public Baseincomtax merge(Baseincomtax detachedInstance) {
		log.debug("merging Baseincomtax instance");
		try {
			Baseincomtax result = (Baseincomtax) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Baseincomtax instance) {
		log.debug("attaching dirty Baseincomtax instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Baseincomtax instance) {
		log.debug("attaching clean Baseincomtax instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}