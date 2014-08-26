package com.moravia.hs.base.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Vacationchangerecord;
import com.moravia.hs.base.entity.other.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * Vacationchangerecord entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Vacationchangerecord
 * @author MyEclipse Persistence Tools
 */

public class VacationchangerecordDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(VacationchangerecordDAO.class);
	// property constants
	public static final String EMP_ID = "empId";
	public static final String VACATION_ADD_OR_MINUS = "vacationAddOrMinus";
	public static final String CHANGE_HOURS = "changeHours";
	public static final String VACATION_CHANGED_TYPE = "vacationChangedType";
	public static final String ANNUAL_LEAVE_LEFT = "annualLeaveLeft";
	public static final String COMPENSATORY_LEAVE_LEFT = "compensatoryLeaveLeft";
	public static final String CHANGE_REASON = "changeReason";

	@Autowired
	private Pagination pagination;
	
	public void save(Vacationchangerecord transientInstance) {
		log.debug("saving Vacationchangerecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vacationchangerecord persistentInstance) {
		log.debug("deleting Vacationchangerecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vacationchangerecord findById(java.lang.Integer id) {
		log.debug("getting Vacationchangerecord instance with id: " + id);
		try {
			Vacationchangerecord instance = (Vacationchangerecord) getHibernateTemplate()
					.get("com.moravia.hs.base.entity.Vacationchangerecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List<Vacationchangerecord> findByExample(
//			Vacationchangerecord instance) {
//		log.debug("finding Vacationchangerecord instance by example");
//		try {
//			List<Vacationchangerecord> results = (List<Vacationchangerecord>) getHibernateTemplate()
//					.createCriteria(
//							"com.moravia.hs.base.entity.Vacationchangerecord")
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
//		log.debug("finding Vacationchangerecord instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Vacationchangerecord as model where model."
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
//	public List<Vacationchangerecord> findByEmpId(Object empId) {
//		return findByProperty(EMP_ID, empId);
//	}
//
//	public List<Vacationchangerecord> findByVacationAddOrMinus(
//			Object vacationAddOrMinus) {
//		return findByProperty(VACATION_ADD_OR_MINUS, vacationAddOrMinus);
//	}
//
//	public List<Vacationchangerecord> findByChangeHours(Object changeHours) {
//		return findByProperty(CHANGE_HOURS, changeHours);
//	}
//
//	public List<Vacationchangerecord> findByVacationChangedType(
//			Object vacationChangedType) {
//		return findByProperty(VACATION_CHANGED_TYPE, vacationChangedType);
//	}
//
//	public List<Vacationchangerecord> findByAnnualLeaveLeft(
//			Object annualLeaveLeft) {
//		return findByProperty(ANNUAL_LEAVE_LEFT, annualLeaveLeft);
//	}
//
//	public List<Vacationchangerecord> findByCompensatoryLeaveLeft(
//			Object compensatoryLeaveLeft) {
//		return findByProperty(COMPENSATORY_LEAVE_LEFT, compensatoryLeaveLeft);
//	}
//
//	public List<Vacationchangerecord> findByChangeReason(Object changeReason) {
//		return findByProperty(CHANGE_REASON, changeReason);
//	}
//
//	public List findAll() {
//		log.debug("finding all Vacationchangerecord instances");
//		try {
//			String queryString = "from Vacationchangerecord";
//			Query queryObject = getHibernateTemplate().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}

	public PageBean findPageBeanByEmp(String emploginId, int pageSize, int page) {
		try {
			String queryString = "from Vacationchangerecord as model where model.emp.empLoginId = '" + emploginId + "' order by createDate desc";
			return pagination.findAll(queryString, pageSize, page);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	public Vacationchangerecord merge(Vacationchangerecord detachedInstance) {
		log.debug("merging Vacationchangerecord instance");
		try {
			Vacationchangerecord result = (Vacationchangerecord) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Vacationchangerecord instance) {
		log.debug("attaching dirty Vacationchangerecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vacationchangerecord instance) {
		log.debug("attaching clean Vacationchangerecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}