package com.moravia.hs.base.dao;

import java.sql.Timestamp;
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

import com.moravia.hs.base.entity.Empchangerecord;
import com.moravia.hs.base.entity.other.HistoryTrack;
import com.moravia.hs.base.entity.other.HistoryTrackD;

/**
 * A data access object (DAO) providing persistence and search support for
 * Empchangerecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Empchangerecord
 * @author MyEclipse Persistence Tools
 */

public class EmpchangerecordDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EmpchangerecordDAO.class);
	// property constants
	public static final String TITLE_NAME = "titleName";
	public static final String SALARY_BASE_SALARY = "salaryBaseSalary";
	public static final String SALARY_MBO = "salaryMbo";

	public void save(Empchangerecord transientInstance) {
		log.debug("saving Empchangerecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Empchangerecord persistentInstance) {
		log.debug("deleting Empchangerecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Empchangerecord findById(java.lang.Integer id) {
		log.debug("getting Empchangerecord instance with id: " + id);
		try {
			Empchangerecord instance = (Empchangerecord) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Empchangerecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	//get latest position title, earlier than endDate
	public String getLatestPositionTitle(String empLoginID, String endDate) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
			"select Position_Title_Name from\n" +
					"(\n" +
					"select Emp_LoginID, Position_Title_Name, Position_Title_Validate from empchangerecord\n" +
					"where Emp_LoginID = '" + empLoginID + "' and BaseSalary_Validate <= '" + endDate + "'\n" +
					"order by Position_Title_Validate DESC\n" +
					") as tab_A\n" +
					"GROUP BY tab_A.Emp_LoginID";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("Position_Title_Name", Hibernate.STRING);
			String position_title_name = (String) sqlquery.uniqueResult();
			return position_title_name;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	//get latest department, earlier than endDate
	public String getLatestDepartment(String empLoginID, String endDate) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
			"select Department_Name from\n" +
					"(\n" +
					"select Emp_LoginID, Department_Name, Department_Validate from empchangerecord\n" +
					"where Emp_LoginID = '" + empLoginID + "' and BaseSalary_Validate <= '" + endDate + "'\n" +
					"order by Department_Validate DESC\n" +
					") as tab_A\n" +
					"GROUP BY tab_A.Emp_LoginID";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("Department_Name", Hibernate.STRING);
			String position_title_name = (String) sqlquery.uniqueResult();
			return position_title_name;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	//get latest cost center, earlier than endDate
	public String getLatestCostCenter(String empLoginID, String endDate) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
			"select Cost_Center from\n" +
					"(\n" +
					"select Emp_LoginID, Cost_Center, Cost_Center_Validate from empchangerecord\n" +
					"where Emp_LoginID = '" + empLoginID + "' and BaseSalary_Validate <= '" + endDate + "'\n" +
					"order by Cost_Center_Validate DESC\n" +
					") as tab_A\n" +
					"GROUP BY tab_A.Emp_LoginID";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("Cost_Center", Hibernate.STRING);
			String cost_center_name = (String) sqlquery.uniqueResult();
			return cost_center_name;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	//get latest base salary, earlier than endDate
	public Double getLatestBaseSalary(String empLoginID, String endDate) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
			"select BaseSalary from\n" +
					"(\n" +
					"select Emp_LoginID, BaseSalary, BaseSalary_Validate from empchangerecord\n" +
					"where Emp_LoginID = '" + empLoginID + "' and BaseSalary_Validate <= '" + endDate + "'\n" +
					"order by BaseSalary_Validate DESC\n" +
					") as tab_A\n" +
					"GROUP BY tab_A.Emp_LoginID";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("BaseSalary", Hibernate.DOUBLE);
			Double baseSalary = (Double) sqlquery.uniqueResult();
			return baseSalary;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	//get latest social insurance, earlier than endDate
	public Double getLatestSocialIns(String empLoginID, String endDate) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
			"select SocialInsurBase from\n" +
					"(\n" +
					"select Emp_LoginID, SocialInsurBase, SocialInsur_Validate from empchangerecord\n" +
					"where Emp_LoginID = '" + empLoginID + "' and BaseSalary_Validate <= '" + endDate + "'\n" +
					"order by SocialInsur_Validate DESC\n" +
					") as tab_A\n" +
					"GROUP BY tab_A.Emp_LoginID";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("SocialInsurBase", Hibernate.DOUBLE);
			Double socialIns = (Double) sqlquery.uniqueResult();
			return socialIns;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	//get latest mbo rate, earlier than endDate
	public Double getLatestMBORate(String empLoginID, String endDate) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
			"select MBO as mboRate from\n" +
					"(\n" +
					"select Emp_LoginID, MBO, MBO_Validate from empchangerecord\n" +
					"where Emp_LoginID = '" + empLoginID + "' and BaseSalary_Validate <= '" + endDate + "'\n" +
					"order by MBO_Validate DESC\n" +
					") as tab_A\n" +
					"GROUP BY tab_A.Emp_LoginID";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("mboRate", Hibernate.DOUBLE);
			Double mboRate = (Double) sqlquery.uniqueResult();
			return mboRate;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	//get Position_title_name history track
	public List<HistoryTrack> getHistroryTrack_PositionTitleName(String empLoginID) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
				"SELECT\n" +
						"	tab_A.Position_Title_Name,\n" +
						"	tab_A.Position_Title_Validate\n" +
						"FROM\n" +
						"	(\n" +
						"		SELECT\n" +
						"			Emp_LoginID,\n" +
						"			Position_Title_Name,\n" +
						"			Position_Title_Validate\n" +
						"		FROM\n" +
						"			empchangerecord\n" +
						"		WHERE\n" +
						"			Emp_LoginID = '" + empLoginID + "'\n" +
						"		ORDER BY\n" +
						"			Position_Title_Validate DESC\n" +
						"	) AS tab_A\n" +
						"GROUP BY\n" +
						"	tab_A.Position_Title_Name\n" +
						"ORDER BY\n" +
						"	tab_A.Position_Title_Validate";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("Position_Title_Name", Hibernate.STRING).addScalar("Position_Title_Validate", Hibernate.DATE);
			Iterator it = sqlquery.list().iterator();
			HistoryTrack ht = null;
			List<HistoryTrack> htList = new ArrayList<HistoryTrack>();
			while(it.hasNext()) {
				ht = new HistoryTrack();
				Object[] rows = (Object[]) it.next();
				String name = (String) rows[0];
				Date validateDate = (Date) rows[1];
				ht.setSection_Name(name);
				ht.setValidateDate(validateDate);
				htList.add(ht);
			}
			 
			return htList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	
	//get department_name history track
	public List<HistoryTrack> getHistroryTrack_DepartName(String empLoginID) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
					"SELECT\n" +
							"	tab_A.Department_Name,\n" +
							"	tab_A.Department_Validate\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			Emp_LoginID,\n" +
							"			Department_Name,\n" +
							"			Department_Validate\n" +
							"		FROM\n" +
							"			empchangerecord\n" +
							"		WHERE\n" +
							"			Emp_LoginID = '" + empLoginID + "'\n" +
							"		ORDER BY\n" +
							"			Department_Validate DESC\n" +
							"	) AS tab_A\n" +
							"GROUP BY\n" +
							"	tab_A.Department_Name\n" +
							"ORDER BY\n" +
							"	tab_A.Department_Validate";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("Department_Name", Hibernate.STRING).addScalar("Department_Validate", Hibernate.DATE);
			Iterator it = sqlquery.list().iterator();
			HistoryTrack ht = null;
			List<HistoryTrack> htList = new ArrayList<HistoryTrack>();
			while(it.hasNext()) {
				ht = new HistoryTrack();
				Object[] rows = (Object[]) it.next();
				String name = (String) rows[0];
				Date validateDate = (Date) rows[1];
				ht.setSection_Name(name);
				ht.setValidateDate(validateDate);
				htList.add(ht);
			}
			 
			return htList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	
	//get line manager history track
	public List<HistoryTrack> getHistroryTrack_LineManager(String empLoginID) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
					"SELECT\n" +
							"	tab_A.Line_Manager,\n" +
							"	tab_A.Line_Manager_Validate\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			Emp_LoginID,\n" +
							"			Line_Manager,\n" +
							"			Line_Manager_Validate\n" +
							"		FROM\n" +
							"			empchangerecord\n" +
							"		WHERE\n" +
							"			Emp_LoginID = '" + empLoginID + "'\n" +
							"		ORDER BY\n" +
							"			Line_Manager_Validate DESC\n" +
							"	) AS tab_A\n" +
							"GROUP BY\n" +
							"	tab_A.Line_Manager\n" +
							"ORDER BY\n" +
							"	tab_A.Line_Manager_Validate";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("Line_Manager", Hibernate.STRING).addScalar("Line_Manager_Validate", Hibernate.DATE);
			Iterator it = sqlquery.list().iterator();
			HistoryTrack ht = null;
			List<HistoryTrack> htList = new ArrayList<HistoryTrack>();
			while(it.hasNext()) {
				ht = new HistoryTrack();
				Object[] rows = (Object[]) it.next();
				String name = (String) rows[0];
				Date validateDate = (Date) rows[1];
				ht.setSection_Name(name);
				ht.setValidateDate(validateDate);
				htList.add(ht);
			}
			 
			return htList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	//get line cost center track
	public List<HistoryTrack> getHistroryTrack_CostCenter(String empLoginID) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
					"SELECT\n" +
							"	tab_A.Cost_Center,\n" +
							"	tab_A.Cost_Center_Validate\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			Emp_LoginID,\n" +
							"			Cost_Center,\n" +
							"			Cost_Center_Validate\n" +
							"		FROM\n" +
							"			empchangerecord\n" +
							"		WHERE\n" +
							"			Emp_LoginID = '" + empLoginID + "'\n" +
							"		ORDER BY\n" +
							"			Cost_Center_Validate DESC\n" +
							"	) AS tab_A\n" +
							"GROUP BY\n" +
							"	tab_A.Cost_Center\n" +
							"ORDER BY\n" +
							"	tab_A.Cost_Center_Validate";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("Cost_Center", Hibernate.STRING).addScalar("Cost_Center_Validate", Hibernate.DATE);
			Iterator it = sqlquery.list().iterator();
			HistoryTrack ht = null;
			List<HistoryTrack> htList = new ArrayList<HistoryTrack>();
			while(it.hasNext()) {
				ht = new HistoryTrack();
				Object[] rows = (Object[]) it.next();
				String name = (String) rows[0];
				Date validateDate = (Date) rows[1];
				ht.setSection_Name(name);
				ht.setValidateDate(validateDate);
				htList.add(ht);
			}
			 
			return htList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	
	//get Contract_Type name history track
	public List<HistoryTrack> getHistroryTrack_ContractType(String empLoginID) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
					"SELECT\n" +
							"	tab_A.Contract_Type,\n" +
							"	tab_A.Modify_Date\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			Emp_LoginID,\n" +
							"			Contract_Type,\n" +
							"			Modify_Date\n" +
							"		FROM\n" +
							"			empchangerecord\n" +
							"		WHERE\n" +
							"			Emp_LoginID = '" + empLoginID + "'\n" +
							"		ORDER BY\n" +
							"			Modify_Date DESC\n" +
							"	) AS tab_A\n" +
							"GROUP BY\n" +
							"	tab_A.Contract_Type\n" +
							"ORDER BY\n" +
							"	tab_A.Modify_Date";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("Contract_Type", Hibernate.STRING).addScalar("Modify_Date", Hibernate.DATE);
			Iterator it = sqlquery.list().iterator();
			HistoryTrack ht = null;
			List<HistoryTrack> htList = new ArrayList<HistoryTrack>();
			while(it.hasNext()) {
				ht = new HistoryTrack();
				Object[] rows = (Object[]) it.next();
				String name = (String) rows[0];
				Date modifyDate = (Date) rows[1];
				ht.setSection_Name(name);
				ht.setValidateDate(modifyDate);
				htList.add(ht);
			}
			 
			return htList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	//get Emp_Type name history track
	public List<HistoryTrack> getHistroryTrack_EmpType(String empLoginID) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
					"SELECT\n" +
							"	tab_A.Emp_Type,\n" +
							"	tab_A.Modify_Date\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			Emp_LoginID,\n" +
							"			Emp_Type,\n" +
							"			Modify_Date\n" +
							"		FROM\n" +
							"			empchangerecord\n" +
							"		WHERE\n" +
							"			Emp_LoginID = '" + empLoginID + "'\n" +
							"		ORDER BY\n" +
							"			Modify_Date DESC\n" +
							"	) AS tab_A\n" +
							"GROUP BY\n" +
							"	tab_A.Emp_Type\n" +
							"ORDER BY\n" +
							"	tab_A.Modify_Date";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("Emp_Type", Hibernate.STRING).addScalar("Modify_Date", Hibernate.DATE);
			Iterator it = sqlquery.list().iterator();
			HistoryTrack ht = null;
			List<HistoryTrack> htList = new ArrayList<HistoryTrack>();
			while(it.hasNext()) {
				ht = new HistoryTrack();
				Object[] rows = (Object[]) it.next();
				String name = (String) rows[0];
				Date modifyDate = (Date) rows[1];
				ht.setSection_Name(name);
				ht.setValidateDate(modifyDate);
				htList.add(ht);
			}
			 
			return htList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	
	
	//get base salary history track
	//HistoryTrack is an entity for those with double type value.
	public List<HistoryTrackD> getHistroryTrack_BaseSalary(String empLoginID) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
					"SELECT\n" +
							"	tab_A.BaseSalary,\n" +
							"	tab_A.BaseSalary_Validate\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			Emp_LoginID,\n" +
							"			BaseSalary,\n" +
							"			BaseSalary_Validate\n" +
							"		FROM\n" +
							"			empchangerecord\n" +
							"		WHERE\n" +
							"			Emp_LoginID = '" + empLoginID + "'\n" +
							"		ORDER BY\n" +
							"			BaseSalary_Validate DESC\n" +
							"	) AS tab_A\n" +
							"GROUP BY\n" +
							"	tab_A.BaseSalary\n" +
							"ORDER BY\n" +
							"	tab_A.BaseSalary_Validate";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("BaseSalary", Hibernate.DOUBLE).addScalar("BaseSalary_Validate", Hibernate.DATE);
			Iterator it = sqlquery.list().iterator();
			HistoryTrackD htd = null;
			List<HistoryTrackD> htdList = new ArrayList<HistoryTrackD>();
			while(it.hasNext()) {
				htd = new HistoryTrackD();
				Object[] rows = (Object[]) it.next();
				Double value = (Double) rows[0];
				Date validateDate = (Date) rows[1];
				htd.setValue(value);
				htd.setValidateDate(validateDate);
				htdList.add(htd);
			}
			 
			return htdList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	
	//get social insurance history track
	//HistoryTrack is an entity for those with double type value.
	public List<HistoryTrackD> getHistroryTrack_SocialIns(String empLoginID) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
					"SELECT\n" +
							"	tab_A.SocialInsurBase,\n" +
							"	tab_A.SocialInsur_Validate\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			Emp_LoginID,\n" +
							"			SocialInsurBase,\n" +
							"			SocialInsur_Validate\n" +
							"		FROM\n" +
							"			empchangerecord\n" +
							"		WHERE\n" +
							"			Emp_LoginID = '" + empLoginID + "'\n" +
							"		ORDER BY\n" +
							"			SocialInsur_Validate DESC\n" +
							"	) AS tab_A\n" +
							"GROUP BY\n" +
							"	tab_A.SocialInsurBase\n" +
							"ORDER BY\n" +
							"	tab_A.SocialInsur_Validate";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("SocialInsurBase", Hibernate.DOUBLE).addScalar("SocialInsur_Validate", Hibernate.DATE);
			Iterator it = sqlquery.list().iterator();
			HistoryTrackD htd = null;
			List<HistoryTrackD> htdList = new ArrayList<HistoryTrackD>();
			while(it.hasNext()) {
				htd = new HistoryTrackD();
				Object[] rows = (Object[]) it.next();
				Double value = (Double) rows[0];
				Date validateDate = (Date) rows[1];
				htd.setValue(value);
				htd.setValidateDate(validateDate);
				htdList.add(htd);
			}
			 
			return htdList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	
	//get mbo rate history track
	//HistoryTrack is an entity for those with double type value.
	public List<HistoryTrackD> getHistroryTrack_MBO(String empLoginID) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
		
			String queryString = 
					"SELECT\n" +
							"	tab_A.MBO,\n" +
							"	tab_A.MBO_Validate\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			Emp_LoginID,\n" +
							"			MBO,\n" +
							"			MBO_Validate\n" +
							"		FROM\n" +
							"			empchangerecord\n" +
							"		WHERE\n" +
							"			Emp_LoginID = '" + empLoginID + "'\n" +
							"		ORDER BY\n" +
							"			MBO_Validate DESC\n" +
							"	) AS tab_A\n" +
							"GROUP BY\n" +
							"	tab_A.MBO\n" +
							"ORDER BY\n" +
							"	tab_A.MBO_Validate";
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("MBO", Hibernate.DOUBLE).addScalar("MBO_Validate", Hibernate.DATE);
			Iterator it = sqlquery.list().iterator();
			HistoryTrackD htd = null;
			List<HistoryTrackD> htdList = new ArrayList<HistoryTrackD>();
			while(it.hasNext()) {
				htd = new HistoryTrackD();
				Object[] rows = (Object[]) it.next();
				Double value = (Double) rows[0];
				Date validateDate = (Date) rows[1];
				htd.setValue(value);
				htd.setValidateDate(validateDate);
				htdList.add(htd);
			}
			 
			return htdList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.close();
		}
	}
	
	
//	public List<Empchangerecord> findByExample(Empchangerecord instance) {
//		log.debug("finding Empchangerecord instance by example");
//		try {
//			List<Empchangerecord> results = (List<Empchangerecord>) getHibernateTemplate()
//					.createCriteria(
//							"com.moravia.hs.base.entity.Empchangerecord")
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
//		log.debug("finding Empchangerecord instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Empchangerecord as model where model."
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
//	public List<Empchangerecord> findByTitleName(Object titleName) {
//		return findByProperty(TITLE_NAME, titleName);
//	}
//
//	public List<Empchangerecord> findBySalaryBaseSalary(Object salaryBaseSalary) {
//		return findByProperty(SALARY_BASE_SALARY, salaryBaseSalary);
//	}
//
//	public List<Empchangerecord> findBySalaryMbo(Object salaryMbo) {
//		return findByProperty(SALARY_MBO, salaryMbo);
//	}
//
	public List findAll() {
		log.debug("finding all Empchangerecord instances");
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Empchangerecord";
			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} finally {
			log.debug("closing session");
			session.close();
		}
	}

	public Empchangerecord merge(Empchangerecord detachedInstance) {
		log.debug("merging Empchangerecord instance");
		try {
			Empchangerecord result = (Empchangerecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Empchangerecord instance) {
		log.debug("attaching dirty Empchangerecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Empchangerecord instance) {
		log.debug("attaching clean Empchangerecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}