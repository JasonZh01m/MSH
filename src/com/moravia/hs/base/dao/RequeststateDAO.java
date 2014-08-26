package com.moravia.hs.base.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Requeststate;

/**
 * A data access object (DAO) providing persistence and search support for
 * Requeststate entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Requeststate
 * @author MyEclipse Persistence Tools
 */
public class RequeststateDAO extends HibernateDaoSupport{
	private static final Logger log = LoggerFactory
			.getLogger(RequeststateDAO.class);
	// property constants
	public static final String STATE_NAME = "stateName";
	public static final String STATE_DESC = "stateDesc";

	public void save(Requeststate transientInstance) {
		log.debug("saving Requeststate instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			getHibernateTemplate().flush();
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Requeststate persistentInstance) {
		log.debug("deleting Requeststate instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Requeststate findById(java.lang.Integer id) {
		log.debug("getting Requeststate instance with id: " + id);
		try {
			Requeststate instance = (Requeststate) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Requeststate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Requeststate findByStateName(String StateName) {
		String queryString = "from Requeststate where stateName=?";
		return (Requeststate) getHibernateTemplate().find(queryString, StateName).get(0);
	}

	/*public List<Requeststate> findByExample(Requeststate instance) {
		log.debug("finding Requeststate instance by example");
		try {
			List<Requeststate> results = (List<Requeststate>) getHibernateTemplate()
					.createCriteria("com.moravia.hs.base.entity.Requeststate")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}*/

	/*public List findByProperty(String propertyName, Object value) {
		log.debug("finding Requeststate instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Requeststate as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}*/

	/*public List<Requeststate> findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<Requeststate> findByStateDesc(Object stateDesc) {
		return findByProperty(STATE_DESC, stateDesc);
	}*/

	public List findAll() {
		log.debug("finding all Requeststate instances");
		try {
			String queryString = "from Requeststate";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}
	

	public Requeststate merge(Requeststate detachedInstance) {
		log.debug("merging Requeststate instance");
		try {
			Requeststate result = (Requeststate) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Requeststate instance) {
		log.debug("attaching dirty Requeststate instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Requeststate instance) {
		log.debug("attaching clean Requeststate instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}