package com.moravia.hs.base.dao;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.Requeststate;
import com.moravia.hs.base.entity.other.PageBean;
import com.moravia.hs.base.entity.other.VacationUsedInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Absencerecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Absencerecord
 * @author MyEclipse Persistence Tools
 */
public class AbsencerecordDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AbsencerecordDAO.class);
	// property constants
	public static final String EMP_LOGIN_ID = "empLoginId";
	public static final String APPLICANT = "applicant";
	public static final String ABSENCE_REASON = "absenceReason";
	public static final String ABSENCE_APPROVER_PM = "absenceApproverPm";
	public static final String ABSENCE_APPROVER_LINE_MANAGER = "absenceApproverLineManager";
	public static final String ABSENCE_NOTE_LINE_MANAGER = "absenceNoteLineManager";
	
	@Autowired
	private Pagination pagination;
	
	public void save(Absencerecord transientInstance) {
		log.debug("saving Absencerecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Absencerecord persistentInstance) {
		log.debug("deleting Absencerecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			getHibernateTemplate().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Absencerecord findById(java.lang.Integer id) {
		log.debug("getting Absencerecord instance with id: " + id);
		try {
			Absencerecord instance = (Absencerecord) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Absencerecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Absencerecord instance with property: "
				+ propertyName + ", value: " + value);
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Absencerecord as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		} 
//		finally  {
//			log.debug("clossing session");
//			session.close();
//		}
	}
	
	/*public List findByProperties(String propertyName1, Object value1, String propertyName2, Object value2) {
		log.debug("finding Absencerecord instance with property: "
				+ propertyName1 + ", value: " + value1 + " and property: " + propertyName2 + ", value: " + value2);
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Absencerecord as model where model."
					+ propertyName1 + "= ? and model." + propertyName2 + "= ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value1);
			queryObject.setParameter(1, value2);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		} finally  {
			log.debug("clossing session");
			session.close();
		}
	}*/

	public PageBean findByEmpLoginId(String empLoginId, int pageSize, int page) {
		try {
			String queryString = "from Absencerecord as model where model.empLoginId = '" + empLoginId + "'";
			return pagination.findAll(queryString, pageSize, page);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	/*public List findByEmpLoginId(String empLoginId) {
		try {
			String queryString = "from Absencerecord as model where model.empLoginId = '" + empLoginId + "'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	*/
	
	public VacationUsedInfo findVacationUsedInfo(String empLoginId, String yearStartTime, String yearEndTime) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
//		String queryString = "select sum(Absencerequestitem.absenceHours) from Absencerecord left join Absencerequestitem on Absencerecord.absenceRecordId = Absencerequestitem.absencerecord.absenceRecordId";
//				+ " left join Vacationtype on Absencerequestitem.vacationtype.vacationTypeId = Vacationtype.vacationTypeId";
//		return getHibernateTemplate().find;
			String queryString =
			"SELECT\n" +
			"	SUM(absence_Hours) as hrs,\n" +
			"	Vacation_Type_Name,\n" +
			"	TimeSheetOrderID\n" +
			"FROM\n" +
			"	(SELECT * FROM absencerecord) AS tabA\n" +
			"LEFT JOIN (\n" +
			"	SELECT\n" +
			"		*\n" +
			"	FROM\n" +
			"		absencerequestitem\n" +
			") AS tabB ON tabA.Absence_Record_ID = tabB.Related_RequestID\n" +
			"LEFT JOIN vacationtype ON type_id = Vacation_Type_ID\n" +
			"WHERE\n" +
			"	emp_loginID = '" + empLoginId +"'\n" +
			"AND absence_StartTime >= '" + yearStartTime + "'\n" +
			"AND absence_EndTime <= '" + yearEndTime + "'\n" +
			"GROUP BY\n" +
			"	type_id";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("hrs", Hibernate.DOUBLE)
					.addScalar("Vacation_Type_Name", Hibernate.STRING).addScalar("TimeSheetOrderID", Hibernate.INTEGER);
			Iterator it = sqlquery.list().iterator();
			VacationUsedInfo vci = new VacationUsedInfo();
			while (it.hasNext()) {
				Object[] rows = (Object[]) it.next();
				Double vacationUsed = (Double) rows[0];
				String typeName = (String) rows[1];
				Integer tsOrderID = (Integer) rows[2];
				switch (tsOrderID) {
				case 70:
					vci.setPersonalLeave(vacationUsed);
					break;
				case 58:
					vci.setSickMateryBreaveLeave(vacationUsed);
					break;
				case 57:
					vci.setLongSickMarriageLeave(vacationUsed);
					break;
				case 61:
					if(typeName.equals("Compensatory_Leave")) {
						vci.setCompensatory(vacationUsed);
					} else {
						vci.setAnnualLeave(vacationUsed);
					}
					break;

				default:
					break;
				}
			}
		
			return vci;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
		
		
	}
	
	
	/*public List<Absencerecord> findByEmpLoginIdAndRequestState(Object empLoginId, Requeststate requestState) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Absencerecord as model where model.empLoginId = ? and model.requeststate=:requeststate";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, empLoginId);
			queryObject.setEntity("requeststate", requestState);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		} finally  {
			log.debug("clossing session");
			session.close();
		}
	}*/

	public List<Absencerecord> findByApplicant(Object applicant) {
		return findByProperty(APPLICANT, applicant);
	}

	public List<Absencerecord> findByAbsenceReason(Object absenceReason) {
		return findByProperty(ABSENCE_REASON, absenceReason);
	}

	public List<Absencerecord> findByAbsenceApproverPm(Object absenceApproverPm) {
		return findByProperty(ABSENCE_APPROVER_PM, absenceApproverPm);
	}

	public List<Absencerecord> findByAbsenceApproverLineManager(
			Object absenceApproverLineManager) {
		return findByProperty(ABSENCE_APPROVER_LINE_MANAGER,
				absenceApproverLineManager);
	}

	public List<Absencerecord> findByAbsenceNoteLineManager(
			Object absenceNoteLineManager) {
		return findByProperty(ABSENCE_NOTE_LINE_MANAGER, absenceNoteLineManager);
	}

	public List findAll() {
		log.debug("finding all Absencerecord instances");
		try {
			String queryString = "from Absencerecord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Absencerecord merge(Absencerecord detachedInstance) {
		log.debug("merging Absencerecord instance");
		try {
			Absencerecord result = (Absencerecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Absencerecord instance) {
		log.debug("attaching dirty Absencerecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Absencerecord instance) {
		log.debug("attaching clean Absencerecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}