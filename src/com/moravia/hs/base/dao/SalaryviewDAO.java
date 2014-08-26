package com.moravia.hs.base.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.view.Salaryview;

/**
 * A data access object (DAO) providing persistence and search support for
 * Salaryview entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.test.Salaryview
 * @author MyEclipse Persistence Tools
 */

public class SalaryviewDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SalaryviewDAO.class);

	// property constants

	public void save(Salaryview transientInstance) {
		log.debug("saving Salaryview instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Salaryview persistentInstance) {
		log.debug("deleting Salaryview instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Salaryview findById(java.lang.Integer id) {
		log.debug("getting Salaryview instance with id: " + id);
		try {
			Salaryview instance = (Salaryview) getHibernateTemplate().get(
					"com.test.Salaryview", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Salaryview findByLoginName(String loginName) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Salaryview where empLoginId = ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setString(0, loginName);
			return (Salaryview) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("find by loginName failed", re);
			throw re;
		} finally {
			session.close();
		}
	}
	

//	public List<Salaryview> findByExample(Salaryview instance) {
//		log.debug("finding Salaryview instance by example");
//		try {
//			List<Salaryview> results = (List<Salaryview>) getHibernateTemplate()
//					.createCriteria("com.test.Salaryview")
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
//		log.debug("finding Salaryview instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from Salaryview as model where model."
//					+ propertyName + "= ?";
//			Query queryObject = getHibernateTemplate().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}

	public List findAll() {
		log.debug("finding all Salaryview instances");
		try {
			String queryString = "from Salaryview";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public Salaryview merge(Salaryview detachedInstance) {
		log.debug("merging Salaryview instance");
		try {
			Salaryview result = (Salaryview) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Salaryview instance) {
		log.debug("attaching dirty Salaryview instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Salaryview instance) {
		log.debug("attaching clean Salaryview instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}