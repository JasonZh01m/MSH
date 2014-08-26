package com.moravia.hs.base.dao;

import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.view.Overtimeinfoview;

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
 * Overtimeinfoview entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.view.Overtimeinfoview
 * @author MyEclipse Persistence Tools
 */
public class OvertimeinfoviewDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OvertimeinfoviewDAO.class);
	// property constants
	public static final String STATE_NAME = "stateName";
	public static final String EMPLOGINID = "emploginid";
	public static final String HOURS = "hours";
	public static final String COSTCENTER = "costcenter";
	public static final String OTHERPAIDRATE = "otherpaidrate";
	public static final String PAID_RATE = "paidRate";
	public static final String WITH_COMPENSATORY = "withCompensatory";
	public static final String COMPENSATORY_HOURS = "compensatoryHours";

	/*public void save(Overtimeinfoview transientInstance) {
		log.debug("saving Overtimeinfoview instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Overtimeinfoview persistentInstance) {
		log.debug("deleting Overtimeinfoview instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Overtimeinfoview findById(java.lang.Integer id) {
		log.debug("getting Overtimeinfoview instance with id: " + id);
		try {
			Overtimeinfoview instance = (Overtimeinfoview) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.view.Overtimeinfoview", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}*/

	/*public List<Overtimeinfoview> findByExample(Overtimeinfoview instance) {
		log.debug("finding Overtimeinfoview instance by example");
		try {
			List<Overtimeinfoview> results = (List<Overtimeinfoview>) getHibernateTemplate()
					.createCriteria(
							"com.moravia.hs.base.entity.view.Overtimeinfoview")
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
		log.debug("finding Overtimeinfoview instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Overtimeinfoview as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Overtimeinfoview> findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<Overtimeinfoview> findByEmploginid(Object emploginid) {
		return findByProperty(EMPLOGINID, emploginid);
	}

	public List<Overtimeinfoview> findByHours(Object hours) {
		return findByProperty(HOURS, hours);
	}

	public List<Overtimeinfoview> findByCostcenter(Object costcenter) {
		return findByProperty(COSTCENTER, costcenter);
	}

	public List<Overtimeinfoview> findByOtherpaidrate(Object otherpaidrate) {
		return findByProperty(OTHERPAIDRATE, otherpaidrate);
	}

	public List<Overtimeinfoview> findByPaidRate(Object paidRate) {
		return findByProperty(PAID_RATE, paidRate);
	}

	public List<Overtimeinfoview> findByWithCompensatory(Object withCompensatory) {
		return findByProperty(WITH_COMPENSATORY, withCompensatory);
	}

	public List<Overtimeinfoview> findByCompensatoryHours(
			Object compensatoryHours) {
		return findByProperty(COMPENSATORY_HOURS, compensatoryHours);
	}*/

	public List findAll() {
		log.debug("finding all Overtimeinfoview instances");
		try {
			String queryString = "from Overtimeinfoview";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByEmp(String loginId, Timestamp startTime, Timestamp endTime, String stateName) {
		log.debug("finding all Overtimeinfoview by emp, startTime and endTime");
		try {
			String queryString = "from Overtimeinfoview as model where model.emploginid=? and "
					+ "model.starttime>=? and model.endtime<=? and model.stateName=?";
			return getHibernateTemplate().find(queryString, loginId, startTime, endTime, stateName);
		} catch (RuntimeException re) {
			log.error("finding by emp failed", re);
			throw re;
		}
	}
	
	public List findByEmpAllState(String loginId, Timestamp startTime, Timestamp endTime) {
		log.debug("finding all Overtimeinfoview by emp, startTime and endTime");
		try {
			String queryString = "from Overtimeinfoview as model where model.emploginid=? and "
					+ "model.starttime>=? and model.endtime<=?";
			return getHibernateTemplate().find(queryString, loginId, startTime, endTime);
		} catch (RuntimeException re) {
			log.error("finding by emp failed", re);
			throw re;
		}
	}

	/*public Overtimeinfoview merge(Overtimeinfoview detachedInstance) {
		log.debug("merging Overtimeinfoview instance");
		try {
			Overtimeinfoview result = (Overtimeinfoview) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Overtimeinfoview instance) {
		log.debug("attaching dirty Overtimeinfoview instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Overtimeinfoview instance) {
		log.debug("attaching clean Overtimeinfoview instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}*/
}