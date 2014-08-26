package com.moravia.hs.base.dao;

import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.Rolemenu;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Rolemenu entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.moravia.hs.base.dao.Rolemenu
 * @author MyEclipse Persistence Tools
 */
public class RolemenuDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RolemenuDAO.class);

	// property constants

	public void save(Rolemenu transientInstance) {
		log.debug("saving Rolemenu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Rolemenu persistentInstance) {
		log.debug("deleting Rolemenu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rolemenu findById(java.lang.Integer id) {
		log.debug("getting Rolemenu instance with id: " + id);
		try {
			Rolemenu instance = (Rolemenu) getHibernateTemplate().get(
					"com.moravia.hs.base.dao.Rolemenu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*public List<Rolemenu> findByExample(Rolemenu instance) {
		log.debug("finding Rolemenu instance by example");
		try {
			List<Rolemenu> results = (List<Rolemenu>) getHibernateTemplate()
					.createCriteria("com.moravia.hs.base.dao.Rolemenu")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Rolemenu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Rolemenu as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}*/

	public List findAll() {
		log.debug("finding all Rolemenu instances");
		try {
			String queryString = "from Rolemenu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Rolemenu merge(Rolemenu detachedInstance) {
		log.debug("merging Rolemenu instance");
		try {
			Rolemenu result = (Rolemenu) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Rolemenu instance) {
		log.debug("attaching dirty Rolemenu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Rolemenu instance) {
		log.debug("attaching clean Rolemenu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}