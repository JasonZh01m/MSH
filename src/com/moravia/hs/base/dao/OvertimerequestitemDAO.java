package com.moravia.hs.base.dao;

import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.Overtimerequestitem;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Overtimerequestitem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Overtimerequestitem
 * @author MyEclipse Persistence Tools
 */
public class OvertimerequestitemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OvertimerequestitemDAO.class);
	// property constants
	public static final String EMPLOGINID = "emploginid";
	public static final String HOURS = "hours";
	public static final String COSTCENTER = "costcenter";
	public static final String PAID_RATE = "paidRate";
	public static final String WITH_COMPENSATORY = "withCompensatory";
	public static final String COMPENSATORY_HOURS = "compensatoryHours";

	public void save(Overtimerequestitem transientInstance) {
		log.debug("saving Overtimerequestitem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Overtimerequestitem persistentInstance) {
		log.debug("deleting Overtimerequestitem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			getHibernateTemplate().flush();
			System.out.println("You just deleted item: " + persistentInstance.getId());
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Overtimerequestitem findById(java.lang.Integer id) {
		log.debug("getting Overtimerequestitem instance with id: " + id);
		try {
			Overtimerequestitem instance = (Overtimerequestitem) getHibernateTemplate()
					.get("com.moravia.hs.base.entity.Overtimerequestitem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*public List<Overtimerequestitem> findByExample(Overtimerequestitem instance) {
		log.debug("finding Overtimerequestitem instance by example");
		try {
			List<Overtimerequestitem> results = (List<Overtimerequestitem>) getHibernateTemplate()
					.createCriteria(
							"com.moravia.hs.base.dao.Overtimerequestitem")
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
		log.debug("finding Overtimerequestitem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Overtimerequestitem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Overtimerequestitem> findByEmploginid(Object emploginid) {
		return findByProperty(EMPLOGINID, emploginid);
	}

	public List<Overtimerequestitem> findByHours(Object hours) {
		return findByProperty(HOURS, hours);
	}

	public List<Overtimerequestitem> findByCostcenter(Object costcenter) {
		return findByProperty(COSTCENTER, costcenter);
	}

	public List<Overtimerequestitem> findByPaidRate(Object paidRate) {
		return findByProperty(PAID_RATE, paidRate);
	}

	public List<Overtimerequestitem> findByWithCompensatory(
			Object withCompensatory) {
		return findByProperty(WITH_COMPENSATORY, withCompensatory);
	}

	public List<Overtimerequestitem> findByCompensatoryHours(
			Object compensatoryHours) {
		return findByProperty(COMPENSATORY_HOURS, compensatoryHours);
	}*/

	public List findAll() {
		log.debug("finding all Overtimerequestitem instances");
		try {
			String queryString = "from Overtimerequestitem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Overtimerequestitem merge(Overtimerequestitem detachedInstance) {
		log.debug("merging Overtimerequestitem instance");
		try {
			Overtimerequestitem result = (Overtimerequestitem) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Overtimerequestitem instance) {
		log.debug("attaching dirty Overtimerequestitem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Overtimerequestitem instance) {
		log.debug("attaching clean Overtimerequestitem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}