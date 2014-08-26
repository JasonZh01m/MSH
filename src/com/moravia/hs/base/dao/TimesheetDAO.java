package com.moravia.hs.base.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Timesheet;
import com.moravia.hs.base.entity.other.SumTsInfo;
import com.moravia.hs.base.entity.other.TsInfoGroupByOrderId;
import com.moravia.hs.base.entity.other.TsMonthlyAbsenceInfo;
import com.moravia.hs.base.entity.other.TsSumDiffTime;

/**
 * A data access object (DAO) providing persistence and search support for
 * Timesheet entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Timesheet
 * @author MyEclipse Persistence Tools
 */

public class TimesheetDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TimesheetDAO.class);
	// property constants

	public void save(Timesheet transientInstance) {
		log.debug("saving Timesheet instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void batchSave(List<Timesheet> tss) {
		log.debug("saving tss instance");
		try {
			int i = 1;
			for (Timesheet ts : tss) {
				getHibernateTemplate().save(ts);
				if(i % 50 == 0) {
					getHibernateTemplate().flush();
					getHibernateTemplate().clear();
//					System.out.println("getHibernateTemplate flush and clear: " + i);
				}
				i++;
			}
			getHibernateTemplate().flush();
			System.out.println("getHibernateTemplate flush finally, totally updated " + i + " records.");
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	

	public void deleteByDate(String startDate) throws ParseException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = 
			"delete from Timesheet ts " +
			"where ts.date >= ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setString(0, startDate);
//			queryObject.setString(1, endDate);
			queryObject.executeUpdate();
			session.flush();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	
	

//	public Timesheet findById(java.lang.Integer id) {
//		log.debug("getting Timesheet instance with id: " + id);
//		try {
//			Timesheet instance = (Timesheet) getHibernateTemplate().get(
//					"com.moravia.hs.base.entity.Timesheet", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}

	//根据loginName, startDate 和 endDate 筛选员工timesheet信息
	public List<Timesheet> findAllByEmpAndDate(String loginName, String startDate, String endDate) throws ParseException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = 
			"from Timesheet ts " +
			"where ts.loginName = ? and ts.date >= ? and ts.date <= ?" +
			"order by " +
			"ts.date";
			Query queryObject = session.createQuery(queryString);
			queryObject.setString(0, loginName);
			queryObject.setString(1, startDate);
			queryObject.setString(2, endDate);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	//根据loginName, startDate, endDate得出timesheet信息(Group by OrderID)
	public List<TsInfoGroupByOrderId> findTsInfoGroupByOrderId(String loginName, String startDate, String endDate) throws ParseException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = 
			"select new com.moravia.hs.base.entity.other.TsInfoGroupByOrderId(ts.loginName as loginName, ts.orderId as orderId, SUM(ts.diffTime) as sumDiff, ts.projectName as projectName, ts.pmName as pmName) " +
			"from Timesheet ts " +
			"where ts.loginName = ? and ts.date >= ? and ts.date <= ?" +
			"group by " +
			"ts.orderId";
			Query queryObject = session.createQuery(queryString);
			queryObject.setString(0, loginName);
			queryObject.setString(1, startDate);
			queryObject.setString(2, endDate);
			
			return queryObject.list();
		} catch (RuntimeException re) {
//			log.error("find all failed", re);
			throw re;
		} finally {
//			log.debug("closing session");
			session.close();
		}
	}
	
//	TsSumDiffTime
	//得到所有人总的工作时间
//	public List<TsSumDiffTime> findAllByLoginNameAndSumTime(String startDate, String endDate) throws ParseException {
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
//		try {
//			String queryString = 
//			"select new com.moravia.hs.base.entity.other.TsSumDiffTime(ts.loginName as loginName, SUM(ts.diffTime) as sumTime) " +
//			"from Timesheet ts " +
//			"where ts.date >= ? and ts.date <= ?" +
//			"group by " +
//			"ts.loginName";
//			Query queryObject = session.createQuery(queryString);
//			queryObject.setString(0, startDate);
//			queryObject.setString(1, endDate);
//			
//			return queryObject.list();
//		} catch (RuntimeException re) {
////			log.error("find all failed", re);
//			throw re;
//		} finally {
////			log.debug("closing session");
//			session.close();
//		}
//	}
	
	//Summary timesheet info, include 'loginName', Timesheet Hours, Absence Hours, Paid Hours, Not Paid Hours and Overtime.
	//Use original sql sequence
	public List<SumTsInfo> SummaryTsInfo(String startDate, String endDate) throws ParseException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString =
					"SELECT\n" +
							"	tabC.loginName,\n" +
							"	tabC.tshrs,\n" +
							"	tabC.absenhrs,\n" +
							"	tabD.paidhrs,\n" +
							"	(tabC.tshrs - tabD.paidhrs) AS notPaidhrs\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			tabA.loginName,\n" +
							"			tabA.tshrs,\n" +
							"			tabB.absenhrs\n" +
							"		FROM\n" +
							"			(\n" +
							"				SELECT\n" +
							"					loginName,\n" +
							"					SUM(diffTime) AS tshrs\n" +
							"				FROM\n" +
							"					timesheet\n" +
							"				WHERE\n" +
							"					Date >= '" + startDate + "'\n" +
							"				AND Date <= '" + endDate + "'\n" +
							"				GROUP BY\n" +
							"					LoginName\n" +
							"			) AS tabA\n" +
							"		LEFT JOIN (\n" +
							"			SELECT\n" +
							"				ts.LoginName,\n" +
							"				SUM(ts.diffTime) AS absenhrs\n" +
							"			FROM\n" +
							"				timesheet ts\n" +
							"			WHERE\n" +
							"				ts.date >= '" + startDate + "'\n" +
							"			AND ts.date <= '" + endDate + "'\n" +
							"			AND ts.orderId IN (\n" +
							"				SELECT\n" +
							"					va.timeSheetOrderId\n" +
							"				FROM\n" +
							"					Vacationtype va\n" +
							"			)\n" +
							"			GROUP BY\n" +
							"				ts.LoginName\n" +
							"		) AS tabB \n" +
							"ON tabA.loginName = tabB.LoginName\n" +
							"	) AS tabC\n" +
							"LEFT JOIN (\n" +
							"	SELECT\n" +
							"		LoginName,\n" +
							"		SUM(DiffTime) AS paidhrs\n" +
							"	FROM\n" +
							"		timesheet\n" +
							"	WHERE\n" +
							"		Date >= '" + startDate + "'\n" +
							"	AND Date <= '" + endDate + "'\n" +
							"	AND OrderID NOT IN (\n" +
							"		SELECT\n" +
							"			TimeSheetOrderID\n" +
							"		FROM\n" +
							"			vacationtype\n" +
							"		WHERE\n" +
							"			Vacation_Paid_Rate = '0'\n" +
							"	)\n" +
							"	GROUP BY\n" +
							"		LoginName\n" +
							") AS tabD ON tabC.loginName = tabD.LoginName\n";
							/*+
							"WHERE\n" +
							"tabD.paidhrs IS NOT NULL"*/
			;
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("loginName", Hibernate.STRING)
					.addScalar("tshrs", Hibernate.DOUBLE).addScalar("absenhrs", Hibernate.DOUBLE)
					.addScalar("paidhrs", Hibernate.DOUBLE).addScalar("notPaidhrs", Hibernate.DOUBLE);
//			 return sqlquery.list().size();
			 System.out.println("sqlquery.list().size()： " + sqlquery.list().size());
			 Iterator it = sqlquery.list().iterator();
			 SumTsInfo sti = null;
			 List<SumTsInfo> sti_List = new ArrayList<SumTsInfo>();
			 while (it.hasNext()) {
				sti = new SumTsInfo();
				Object[] rows = (Object[]) it.next();
				String empLoginId = (String) rows[0];
//				Date da = (Date) rows[1];
//				Double hrs = (Double) rows[2];
				Double timesheetHrs = (Double) rows[1];
				Double absenceHrs = (Double) rows[2];
				Double paidHrs = (Double) rows[3];
				Double notPaidHrs = (Double) rows[4];
				sti.setLoginId(empLoginId);
				sti.setTsHrs(timesheetHrs);
				sti.setAbsenceHrs(absenceHrs);
				sti.setPaidHrs(paidHrs);
				sti.setNotPaidHrs(notPaidHrs);
				sti_List.add(sti);
			}
			return sti_List;
		} catch (RuntimeException re) {
//			log.error("find all failed", re);
			throw re;
		} finally {
//			log.debug("closing session");
			session.close();
		}
	}
	
	
	//得到员工每月timesheet填写天数
	//得到员工每月的请假信息，对应日期以及每天总的请假小时数
	public Integer findTsMonthlyDays(String loginName, String startDate, String endDate) throws ParseException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = 
			"from Timesheet ts " +
			"where ts.loginName = ? and ts.date >= ? and ts.date <= ?" +
			"group by " +
			"ts.date";
			Query queryObject = session.createQuery(queryString);
			queryObject.setString(0, loginName);
			queryObject.setString(1, startDate);
			queryObject.setString(2, endDate);
			
			return queryObject.list().size();
		} catch (RuntimeException re) {
//				log.error("find all failed", re);
			throw re;
		} finally {
//				log.debug("closing session");
			session.close();
		}
	}
	
	
	//得到员工每月的请假信息，对应日期以及每天总的请假小时数
	public List<TsMonthlyAbsenceInfo> findTsMonthlyAbsenceInfo(String loginName, String startDate, String endDate) throws ParseException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = 
			"select new com.moravia.hs.base.entity.other.TsMonthlyAbsenceInfo(ts.orderId, SUM(ts.diffTime), ts.date) " +
			"from Timesheet ts " +
			"where ts.loginName = ? and ts.date >= ? and ts.date <= ?" +
			"and ts.orderId in" +
			"(select va.timeSheetOrderId from Vacationtype va)" +
			"group by " +
			"ts.date";
			Query queryObject = session.createQuery(queryString);
			queryObject.setString(0, loginName);
			queryObject.setString(1, startDate);
			queryObject.setString(2, endDate);
			
			return queryObject.list();
		} catch (RuntimeException re) {
//			log.error("find all failed", re);
			throw re;
		} finally {
//			log.debug("closing session");
			session.close();
		}
	}
	
	//一天timesheet超过11小时的天数
	public Integer findTsMonthlyOvertimeMoreThan11Hrs(String loginName, String startDate, String endDate) throws ParseException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString =
					"SELECT\n" +
							"	loginName,\n" +
							"	Date,\n" +
							"	hrs\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			LoginName,\n" +
							"			Date,\n" +
							"			sum(DiffTime) AS hrs\n" +
							"		FROM\n" +
							"			timesheet\n" +
							"		WHERE\n" +
							"			LoginName = '" + loginName + "' " + 
							"		AND date >= '" + startDate + "' " +
							"		AND date <= '" + endDate + "' " +
							"		GROUP BY\n" +
							"			date\n" +
							"	) ts0\n" +
							"WHERE\n" +
							"	ts0.hrs >= '11'"
			;
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("loginName", Hibernate.STRING).addScalar("Date", Hibernate.DATE).addScalar("hrs", Hibernate.DOUBLE);
			return sqlquery.list().size();
		} catch (RuntimeException re) {
//			log.error("find all failed", re);
			throw re;
		} finally {
//			log.debug("closing session");
			session.close();
		}
	}
	
//	public List<Timesheet> findByExample(Timesheet instance) {
//		log.debug("finding Timesheet instance by example");
//		try {
//			List<Timesheet> results = (List<Timesheet>) getHibernateTemplate()
//					.createCriteria("com.moravia.hs.base.entity.Timesheet")
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
//		log.debug("finding Timesheet instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from Timesheet as model where model."
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
//	public List<Timesheet> findByLoginName(Object loginName) {
//		return findByProperty(LOGIN_NAME, loginName);
//	}
//
//	public List<Timesheet> findByDiffTime(Object diffTime) {
//		return findByProperty(DIFF_TIME, diffTime);
//	}
//
//	public List<Timesheet> findByOrderId(Object orderId) {
//		return findByProperty(ORDER_ID, orderId);
//	}
//
//	public List<Timesheet> findByProjectName(Object projectName) {
//		return findByProperty(PROJECT_NAME, projectName);
//	}
//
//	public List<Timesheet> findByPmName(Object pmName) {
//		return findByProperty(PM_NAME, pmName);
//	}
//
//	public List<Timesheet> findByLanguage(Object language) {
//		return findByProperty(LANGUAGE, language);
//	}
//
//	public List<Timesheet> findByType(Object type) {
//		return findByProperty(TYPE, type);
//	}
//
//	public List<Timesheet> findByActivityGroup(Object activityGroup) {
//		return findByProperty(ACTIVITY_GROUP, activityGroup);
//	}
//
//	public List<Timesheet> findByInvoicingIndicator(Object invoicingIndicator) {
//		return findByProperty(INVOICING_INDICATOR, invoicingIndicator);
//	}
//
//	public List<Timesheet> findByRole(Object role) {
//		return findByProperty(ROLE, role);
//	}
//
//	public List<Timesheet> findByPosition(Object position) {
//		return findByProperty(POSITION, position);
//	}
//
//	public List<Timesheet> findByTool(Object tool) {
//		return findByProperty(TOOL, tool);
//	}
//
//	public List<Timesheet> findByTask(Object task) {
//		return findByProperty(TASK, task);
//	}
//
//	public List<Timesheet> findByCustom(Object custom) {
//		return findByProperty(CUSTOM, custom);
//	}
//
//	public List<Timesheet> findByNote(Object note) {
//		return findByProperty(NOTE, note);
//	}
//
//	public List<Timesheet> findByLock(Object lock) {
//		return findByProperty(LOCK, lock);
//	}

	public List findAll() {
		log.debug("finding all Timesheet instances");
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Timesheet";
			List list = getHibernateTemplate().find(queryString);
//			Query queryObject = session.createQuery(queryString);
//			return queryObject.list();
			return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} finally {
			log.debug("closing session");
//			session.close();
		}
	}
	
//	public List findAll2() throws ParseException {
//		log.debug("finding all Timesheet instances");
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
//		try {
//			String queryString = "from Timesheet";
//			Query queryObject = session.createQuery(queryString);
//			/*queryObject.setString(0, "jasonzh");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date d1 = sdf.parse("2013-12-01");
//			Date d2 = sdf.parse("2013-12-31");
//			
//			queryObject.setDate(1, d1);
//			queryObject.setDate(2, d2);*/
//			
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		} finally {
//			log.debug("closing session");
//			session.close();
//		}
//	}

	public Timesheet merge(Timesheet detachedInstance) {
		log.debug("merging Timesheet instance");
		try {
			Timesheet result = (Timesheet) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Timesheet instance) {
		log.debug("attaching dirty Timesheet instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Timesheet instance) {
		log.debug("attaching clean Timesheet instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}