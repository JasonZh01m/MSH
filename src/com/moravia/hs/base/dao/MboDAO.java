package com.moravia.hs.base.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.moravia.hs.base.entity.Mbo;

public class MboDAO extends HibernateDaoSupport {
	
	private static final Logger log = LoggerFactory.getLogger(MboDAO.class);
	public static final String MBO_RATE = "mboRate";
	public static final String MBO_PAID_PERIOD = "mboPaidPeriod";
	public static final String MBO_DESC = "mboDesc";

//	@Transactional (propagation=Propagation.REQUIRED)
	public void save(Object object) {
		Mbo transientInstance = (Mbo) object;
		log.debug("saving Mbo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveOrUpdate(Mbo instance) {
		log.debug("save or update Mbo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("save or update mbo successful");
		} catch (RuntimeException re) {
			log.error("save or update mbo failed", re);
			throw re;
		}
	}

	public void delete(Mbo persistentInstance) {
		log.debug("deleting Mbo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			getHibernateTemplate().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mbo findById(java.lang.Integer id) {
		log.debug("getting Mbo instance with id: " + id);
		try {
			Mbo instance = (Mbo) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Mbo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Mbo findByMBORate(java.lang.Double mboRate) {
		log.debug("getting Mbo instance with mboRate: " + mboRate);
		try {
			String queryString = "from Mbo where mboRate = ?";
			List list = getHibernateTemplate().find(queryString, mboRate);
			if(list.size() > 0) {
				return (Mbo) list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			throw re;
		} 
	}

//	public List findByExample(Mbo instance) {
//		log.debug("finding Mbo instance by example");
//		try {
//			List results = sessionFactory.openSession()
//					.createCriteria("com.moravia.hs.base.entity.Mbo")
//					.add(Example.create(instance)).list();
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
//		log.debug("finding Mbo instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from Mbo as model where model."
//					+ propertyName + "= ?";
//			Query queryObject = sessionFactory.openSession().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findByMboRate(Object mboRate) {
//		return findByProperty(MBO_RATE, mboRate);
//	}
//
//	public List findByMboPaidPeriod(Object mboPaidPeriod) {
//		return findByProperty(MBO_PAID_PERIOD, mboPaidPeriod);
//	}
//
//	public List findByMboDesc(Object mboDesc) {
//		return findByProperty(MBO_DESC, mboDesc);
//	}
//
	public List findAll() {
		log.debug("finding all Mbo instances");
		try {
			String queryString = "from Mbo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}
//
//	public Mbo merge(Mbo detachedInstance) {
//		log.debug("merging Mbo instance");
//		try {
//			Mbo result = (Mbo) sessionFactory.openSession().merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Mbo instance) {
//		log.debug("attaching dirty Mbo instance");
//		try {
//			sessionFactory.openSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Mbo instance) {
//		log.debug("attaching clean Mbo instance");
//		try {
//			sessionFactory.openSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}