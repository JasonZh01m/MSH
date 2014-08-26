package com.moravia.hs.base.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Basesalaryproperties;

/**
 * A data access object (DAO) providing persistence and search support for
 * Basesalaryproperties entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.test.Basesalaryproperties
 * @author MyEclipse Persistence Tools
 */

public class BasesalarypropertiesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BasesalarypropertiesDAO.class);
	// property constants
	public static final String TOTAL_WORK_HOURS = "totalWorkHours";
	public static final String TOTAL_WORK_DAYS = "totalWorkDays";
	public static final String BASE_SALARY_HRS = "baseSalaryHrs";
	public static final String DAILY_MEAL_SUBSIDY = "dailyMealSubsidy";
	public static final String MONTHLY_TRANS_ALLOWANCE = "monthlyTransAllowance";
	public static final String PROBATION_BASE_RATE = "probationBaseRate";
	public static final String MINIMUM_WAGE = "minimumWage";
	public static final String INCOMTAX_THRESHOLD = "incomtaxThreshold";

	public void save(Basesalaryproperties transientInstance) {
		log.debug("saving Basesalaryproperties instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Basesalaryproperties persistentInstance) {
		log.debug("deleting Basesalaryproperties instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Basesalaryproperties findById(java.lang.Integer id) {
		log.debug("getting Basesalaryproperties instance with id: " + id);
		try {
			Basesalaryproperties instance = (Basesalaryproperties) getHibernateTemplate()
					.get("com.moravia.hs.base.entity.Basesalaryproperties", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Basesalaryproperties findLastCreated() {
		log.debug("finding all Basesalaryproperties instances");
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Basesalaryproperties order by createDate desc";
//			Query queryObject = session.createQuery(queryString);
			List list = getHibernateTemplate().find(queryString);
			if(list.size() != 0) { 
				return (Basesalaryproperties) list.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find LastCreated failed", re);
			throw re;
		} 
//		finally {
//			log.debug("closing session");
//			session.close();
//		}
	}
	
//	public List<Basesalaryproperties> findByExample(
//			Basesalaryproperties instance) {
//		log.debug("finding Basesalaryproperties instance by example");
//		try {
//			List<Basesalaryproperties> results = (List<Basesalaryproperties>) getHibernateTemplate()
//					.createCriteria("com.test.Basesalaryproperties")
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
//		log.debug("finding Basesalaryproperties instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Basesalaryproperties as model where model."
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
//	public List<Basesalaryproperties> findByTotalWorkHours(Object totalWorkHours) {
//		return findByProperty(TOTAL_WORK_HOURS, totalWorkHours);
//	}
//
//	public List<Basesalaryproperties> findByTotalWorkDays(Object totalWorkDays) {
//		return findByProperty(TOTAL_WORK_DAYS, totalWorkDays);
//	}
//
//	public List<Basesalaryproperties> findByBaseSalaryHrs(Object baseSalaryHrs) {
//		return findByProperty(BASE_SALARY_HRS, baseSalaryHrs);
//	}
//
//	public List<Basesalaryproperties> findByDailyMealSubsidy(
//			Object dailyMealSubsidy) {
//		return findByProperty(DAILY_MEAL_SUBSIDY, dailyMealSubsidy);
//	}
//
//	public List<Basesalaryproperties> findByMonthlyTransAllowance(
//			Object monthlyTransAllowance) {
//		return findByProperty(MONTHLY_TRANS_ALLOWANCE, monthlyTransAllowance);
//	}
//
//	public List<Basesalaryproperties> findByProbationBaseRate(
//			Object probationBaseRate) {
//		return findByProperty(PROBATION_BASE_RATE, probationBaseRate);
//	}
//
//	public List<Basesalaryproperties> findByMinimumWage(Object minimumWage) {
//		return findByProperty(MINIMUM_WAGE, minimumWage);
//	}
//
//	public List<Basesalaryproperties> findByIncomtaxThreshold(
//			Object incomtaxThreshold) {
//		return findByProperty(INCOMTAX_THRESHOLD, incomtaxThreshold);
//	}

	public List findAll() {
		log.debug("finding all Basesalaryproperties instances");
		try {
			String queryString = "from Basesalaryproperties";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public Basesalaryproperties merge(Basesalaryproperties detachedInstance) {
		log.debug("merging Basesalaryproperties instance");
		try {
			Basesalaryproperties result = (Basesalaryproperties) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Basesalaryproperties instance) {
		log.debug("attaching dirty Basesalaryproperties instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Basesalaryproperties instance) {
		log.debug("attaching clean Basesalaryproperties instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}