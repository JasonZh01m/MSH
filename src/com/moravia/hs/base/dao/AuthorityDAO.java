package com.moravia.hs.base.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Authority;

/**
 * A data access object (DAO) providing persistence and search support for
 * Authority entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Authority
 * @author MyEclipse Persistence Tools
 */

public class AuthorityDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AuthorityDAO.class);
	// property constants
//	public static final String AUTHORITY_NAME = "authorityName";
//	public static final String AUTHORITY_DESC = "authorityDesc";

	public void save(Authority transientInstance) {
		log.debug("saving Authority instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Authority persistentInstance) {
		log.debug("deleting Authority instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Authority findById(java.lang.Integer id) {
		log.debug("getting Authority instance with id: " + id);
		try {
			Authority instance = (Authority) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Authority", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List<Authority> findByExample(Authority instance) {
//		log.debug("finding Authority instance by example");
//		try {
//			List<Authority> results = (List<Authority>) getHibernateTemplate()
//					.createCriteria("com.moravia.hs.base.entity.Authority")
//					.add(create(instance)).list();
//			log.debug("find by example successful, result size: "
//					+ results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}

//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Authority instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from Authority as model where model."
//					+ propertyName + "= ?";
//			Query queryObject = getHibernateTemplate().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}

//	public List<Authority> findByAuthorityName(Object authorityName) {
//		return findByProperty(AUTHORITY_NAME, authorityName);
//	}
//
//	public List<Authority> findByAuthorityDesc(Object authorityDesc) {
//		return findByProperty(AUTHORITY_DESC, authorityDesc);
//	}

//	public List findAll() {
//		log.debug("finding all Authority instances");
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
//		try {
//			String queryString = "from Authority";
//			Query queryObject = session.createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		} finally {
//			log.debug("closing session");
//			session.close();
//		}
//	}

	public Authority merge(Authority detachedInstance) {
		log.debug("merging Authority instance");
		try {
			Authority result = (Authority) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Authority instance) {
		log.debug("attaching dirty Authority instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Authority instance) {
		log.debug("attaching clean Authority instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}