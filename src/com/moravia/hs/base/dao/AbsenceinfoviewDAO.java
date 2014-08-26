package com.moravia.hs.base.dao;

import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.view.Absenceinfoview;

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
 * Absenceinfoview entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.view.Absenceinfoview
 * @author MyEclipse Persistence Tools
 */
public class AbsenceinfoviewDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AbsenceinfoviewDAO.class);
	// property constants
	public static final String STATE_NAME = "stateName";
	public static final String EMP_LOGIN_ID = "empLoginId";
	public static final String ABSENCE_APPROVER_PM = "absenceApproverPm";
	public static final String ABSENCE_APPROVER_LINE_MANAGER = "absenceApproverLineManager";
	public static final String ABSENCE_HOURS = "absenceHours";
	public static final String TYPE_ID = "typeId";
	public static final String TIME_SHEET_ORDER_ID = "timeSheetOrderId";
	public static final String VACATION_PAID_RATE = "vacationPaidRate";
	public static final String VACATION_TYPE_NAME = "vacationTypeName";

	/*public void save(Absenceinfoview transientInstance) {
		log.debug("saving Absenceinfoview instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Absenceinfoview persistentInstance) {
		log.debug("deleting Absenceinfoview instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Absenceinfoview findById(java.lang.Integer id) {
		log.debug("getting Absenceinfoview instance with id: " + id);
		try {
			Absenceinfoview instance = (Absenceinfoview) getSession().get(
					"com.moravia.hs.base.entity.view.Absenceinfoview", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Absenceinfoview> findByExample(Absenceinfoview instance) {
		log.debug("finding Absenceinfoview instance by example");
		try {
			List<Absenceinfoview> results = (List<Absenceinfoview>) getSession()
					.createCriteria(
							"com.moravia.hs.base.entity.view.Absenceinfoview")
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
		log.debug("finding Absenceinfoview instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Absenceinfoview as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Absenceinfoview> findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<Absenceinfoview> findByEmpLoginId(Object empLoginId) {
		return findByProperty(EMP_LOGIN_ID, empLoginId);
	}

	public List<Absenceinfoview> findByAbsenceApproverPm(
			Object absenceApproverPm) {
		return findByProperty(ABSENCE_APPROVER_PM, absenceApproverPm);
	}

	public List<Absenceinfoview> findByAbsenceApproverLineManager(
			Object absenceApproverLineManager) {
		return findByProperty(ABSENCE_APPROVER_LINE_MANAGER,
				absenceApproverLineManager);
	}

	public List<Absenceinfoview> findByAbsenceHours(Object absenceHours) {
		return findByProperty(ABSENCE_HOURS, absenceHours);
	}

	public List<Absenceinfoview> findByTypeId(Object typeId) {
		return findByProperty(TYPE_ID, typeId);
	}

	public List<Absenceinfoview> findByTimeSheetOrderId(Object timeSheetOrderId) {
		return findByProperty(TIME_SHEET_ORDER_ID, timeSheetOrderId);
	}

	public List<Absenceinfoview> findByVacationPaidRate(Object vacationPaidRate) {
		return findByProperty(VACATION_PAID_RATE, vacationPaidRate);
	}

	public List<Absenceinfoview> findByVacationTypeName(Object vacationTypeName) {
		return findByProperty(VACATION_TYPE_NAME, vacationTypeName);
	}*/

	public List findAll() {
		log.debug("finding all Absenceinfoview instances");
		try {
			String queryString = "from Absenceinfoview";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByEmp(String loginId, Timestamp startTime, Timestamp endTime, String stateName) {
		log.debug("finding all Absenceinfoview by emp, startTime and endTime");
		try {
			String queryString = "from Absenceinfoview as model where model.empLoginId=? and "
					+ "model.absenceStartTime>=? and model.absenceEndTime<=? and model.stateName=?";
			return getHibernateTemplate().find(queryString, loginId, startTime, endTime, stateName);
		} catch (RuntimeException re) {
			log.error("finding by emp failed", re);
			throw re;
		}
		
	}
	
	
	public List findByEmpAllState(String loginId, Timestamp startTime, Timestamp endTime) {
		log.debug("finding all Absenceinfoview by emp, startTime and endTime");
		try {
			String queryString = "from Absenceinfoview as model where model.empLoginId=? and "
					+ "model.absenceStartTime>=? and model.absenceEndTime<=?";
			return getHibernateTemplate().find(queryString, loginId, startTime, endTime);
		} catch (RuntimeException re) {
			log.error("finding by emp failed", re);
			throw re;
		}
		
	}
	
	

	/*public Absenceinfoview merge(Absenceinfoview detachedInstance) {
		log.debug("merging Absenceinfoview instance");
		try {
			Absenceinfoview result = (Absenceinfoview) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Absenceinfoview instance) {
		log.debug("attaching dirty Absenceinfoview instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Absenceinfoview instance) {
		log.debug("attaching clean Absenceinfoview instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}*/
}