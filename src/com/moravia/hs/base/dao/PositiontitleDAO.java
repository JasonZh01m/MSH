package com.moravia.hs.base.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Positiontitle;

/**
 * A data access object (DAO) providing persistence and search support for
 * Positiontitle entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Positiontitle
 * @author MyEclipse Persistence Tools
 */

public class PositiontitleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PositiontitleDAO.class);
	// property constants
	public static final String POSITION_TITLE_NAME = "positionTitleName";
	public static final String POSITION_TITLE_DESC = "positionTitleDesc";

	public void save(Positiontitle transientInstance) {
		log.debug("saving Positiontitle instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	
	public void saveOrUpdate(Positiontitle instance) {
		log.debug("save or update Positiontitle instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("save or update successful");
		} catch (RuntimeException re) {
			log.error("save or update failed", re);
			throw re;
		}
	}

	public void delete(Positiontitle persistentInstance) {
		log.debug("deleting Positiontitle instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			getHibernateTemplate().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Positiontitle findById(java.lang.Integer id) {
		log.debug("getting Positiontitle instance with id: " + id);
		try {
			Positiontitle instance = (Positiontitle) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Positiontitle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List<Positiontitle> findByExample(Positiontitle instance) {
//		log.debug("finding Positiontitle instance by example");
//		try {
//			List<Positiontitle> results = (List<Positiontitle>) getHibernateTemplate()
//					.createCriteria("com.moravia.hs.base.entity.Positiontitle")
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
//		log.debug("finding Positiontitle instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Positiontitle as model where model."
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
//	public List<Positiontitle> findByPositionTitleName(Object positionTitleName) {
//		return findByProperty(POSITION_TITLE_NAME, positionTitleName);
//	}
//
//	public List<Positiontitle> findByPositionTitleDesc(Object positionTitleDesc) {
//		return findByProperty(POSITION_TITLE_DESC, positionTitleDesc);
//	}

	public List findAll() {
		log.debug("finding all Positiontitle instances");
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Positiontitle";
//			Query queryObject = session.createQuery(queryString);
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public Positiontitle merge(Positiontitle detachedInstance) {
		log.debug("merging Positiontitle instance");
		try {
			Positiontitle result = (Positiontitle) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Positiontitle instance) {
		log.debug("attaching dirty Positiontitle instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Positiontitle instance) {
		log.debug("attaching clean Positiontitle instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}