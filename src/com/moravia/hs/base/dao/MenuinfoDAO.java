package com.moravia.hs.base.dao;

import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.Menuinfo;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Menuinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.moravia.hs.base.dao.Menuinfo
 * @author MyEclipse Persistence Tools
 */
public class MenuinfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(MenuinfoDAO.class);
	// property constants
	public static final String MENU_NAME = "menuName";
	public static final String LINK = "link";
	public static final String DESC = "desc";

	public void save(Menuinfo transientInstance) {
		log.debug("saving Menuinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Menuinfo persistentInstance) {
		log.debug("deleting Menuinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Menuinfo findById(java.lang.Integer id) {
		log.debug("getting Menuinfo instance with id: " + id);
		try {
			Menuinfo instance = (Menuinfo) getHibernateTemplate().get(
					"com.moravia.hs.base.dao.Menuinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*public List<Menuinfo> findByExample(Menuinfo instance) {
		log.debug("finding Menuinfo instance by example");
		try {
			List<Menuinfo> results = (List<Menuinfo>) getHibernateTemplate()
					.createCriteria("com.moravia.hs.base.dao.Menuinfo")
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
		log.debug("finding Menuinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Menuinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Menuinfo> findByMenuName(Object menuName) {
		return findByProperty(MENU_NAME, menuName);
	}

	public List<Menuinfo> findByLink(Object link) {
		return findByProperty(LINK, link);
	}

	public List<Menuinfo> findByDesc(Object desc) {
		return findByProperty(DESC, desc);
	}*/

	public List findAll() {
		log.debug("finding all Menuinfo instances");
		try {
			String queryString = "from Menuinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Menuinfo merge(Menuinfo detachedInstance) {
		log.debug("merging Menuinfo instance");
		try {
			Menuinfo result = (Menuinfo) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Menuinfo instance) {
		log.debug("attaching dirty Menuinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Menuinfo instance) {
		log.debug("attaching clean Menuinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}