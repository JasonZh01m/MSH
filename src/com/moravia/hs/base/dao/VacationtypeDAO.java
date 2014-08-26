package com.moravia.hs.base.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Vacationtype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Vacationtype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Vacationtype
 * @author MyEclipse Persistence Tools
 */

public class VacationtypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(VacationtypeDAO.class);
	// property constants
	public static final String VACATION_TYPE_NAME = "vacationTypeName";
	public static final String VACATION_PAID_RATE = "vacationPaidRate";
	public static final String VACATION_TYPE_DESC = "vacationTypeDesc";

	public void save(Vacationtype transientInstance) {
		log.debug("saving Vacationtype instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveOrUpdate(Vacationtype instance) {
		log.debug("save or update Vacationtype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("save or update successful");
		} catch (RuntimeException re) {
			log.error("save or update failed", re);
			throw re;
		}
	}

	public void delete(Vacationtype persistentInstance) {
		log.debug("deleting Vacationtype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			getHibernateTemplate().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vacationtype findById(java.lang.Integer id) {
		log.debug("getting Vacationtype instance with id: " + id);
		try {
			Vacationtype instance = (Vacationtype) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Vacationtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Vacationtype findByOrderID(int orderID) {
		log.debug("finding by timesheetorderId");
		try {
			String queryString = "from Vacationtype where timeSheetOrderId = ?";
			return (Vacationtype) getHibernateTemplate().find(queryString, orderID).get(0);
		} catch (RuntimeException re) {
			log.error("find by timesheetorderid failed", re);
			throw re;
		} 
	}
	
	
	//for Test
	public List<Integer> findTimeSheetOrderID() {
		log.debug("finding all Vacationtype instances");
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "select timeSheetOrderId from Vacationtype";
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
	
	
//	public List<Vacationtype> findByExample(Vacationtype instance) {
//		log.debug("finding Vacationtype instance by example");
//		try {
//			List<Vacationtype> results = (List<Vacationtype>) getHibernateTemplate()
//					.createCriteria("com.moravia.hs.base.entity.Vacationtype")
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
//		log.debug("finding Vacationtype instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Vacationtype as model where model."
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
//	public List<Vacationtype> findByVacationTypeName(Object vacationTypeName) {
//		return findByProperty(VACATION_TYPE_NAME, vacationTypeName);
//	}
//
//	public List<Vacationtype> findByVacationPaidRate(Object vacationPaidRate) {
//		return findByProperty(VACATION_PAID_RATE, vacationPaidRate);
//	}
//
//	public List<Vacationtype> findByVacationTypeDesc(Object vacationTypeDesc) {
//		return findByProperty(VACATION_TYPE_DESC, vacationTypeDesc);
//	}
//
	public List findAll() {
		log.debug("finding all Vacationtype instances");
		try {
			String queryString = "from Vacationtype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vacationtype merge(Vacationtype detachedInstance) {
		log.debug("merging Vacationtype instance");
		try {
			Vacationtype result = (Vacationtype) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vacationtype instance) {
		log.debug("attaching dirty Vacationtype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vacationtype instance) {
		log.debug("attaching clean Vacationtype instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}