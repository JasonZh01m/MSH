package com.moravia.hs.base.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moravia.hs.base.entity.Basesocialinsurance;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.other.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for Emp
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Emp
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class EmpDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(EmpDAO.class);
	
	@Autowired
	private Pagination pagination;
/*	// property constants
	public static final String EMP_LOGIN_ID = "empLoginId";
	public static final String NAME_CHINESE = "nameChinese";
	public static final String NAME_ENGLISH = "nameEnglish";
	public static final String PASSWORD = "password";
	public static final String AGE = "age";
	public static final String GENDER = "gender";
	public static final String ADDRESS = "address";
	public static final String MOBILE = "mobile";
	public static final String OFFICE_PHONE = "officePhone";
	public static final String SKYPE = "skype";
	public static final String EMAIL = "email";
	public static final String WORKING_AGE = "workingAge";
	public static final String BASE_SALARY = "baseSalary";
	public static final String CREDIT_CARD_NUMBER = "creditCardNumber";
	public static final String ANNUAL_LEAVE_LEFT = "annualLeaveLeft";
	public static final String COMPENSATORY_LEAVE_LEFT = "compensatoryLeaveLeft";
*/
	public void save(Emp transientInstance) {
		log.debug("saving Emp instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			getHibernateTemplate().flush();
			System.out.println("save emp successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Emp emp) {
		log.debug("Save or Update Emp instance");
		try {
			getHibernateTemplate().saveOrUpdate(emp);
			getHibernateTemplate().flush();
			System.out.println("save or update successful....");
			log.debug("save or update successful");
		} catch (RuntimeException re) {
			log.error("save or update failed", re);
			throw re;
		}
	}
	
	public void delete(Emp persistentInstance) {
		log.debug("deleting Emp instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Emp findById(java.lang.Integer id) {
		log.debug("getting Emp instance with id: " + id);
		try {
			Emp instance = (Emp) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Emp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	 //根据loginName查询
//	@Deprecated
	public Emp findByLoginName(String emploginId) {
		log.debug("finding Emp instances by loginName");
		try {
			String queryString = "from Emp where empLoginId = ?";
			if(getHibernateTemplate().find(queryString, emploginId).size() > 0) {
				return (Emp) getHibernateTemplate().find(queryString, emploginId).get(0);
			} else {
				System.out.println("没有找到该员工");
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		} 
	}
	
//	public List<Emp> findByExample(Emp instance) {
//		log.debug("finding Emp instance by example");
//		try {
//			List<Emp> results = (List<Emp>) getHibernateTemplate()
//					.createCriteria("com.moravia.hs.base.entity.Emp")
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
//		log.debug("finding Emp instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from Emp as model where model."
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
//	public List<Emp> findByEmpLoginId(Object empLoginId) {
//		return findByProperty(EMP_LOGIN_ID, empLoginId);
//	}
//
//	public List<Emp> findByNameChinese(Object nameChinese) {
//		return findByProperty(NAME_CHINESE, nameChinese);
//	}
//
//	public List<Emp> findByNameEnglish(Object nameEnglish) {
//		return findByProperty(NAME_ENGLISH, nameEnglish);
//	}
//
//	public List<Emp> findByPassword(Object password) {
//		return findByProperty(PASSWORD, password);
//	}
//
//	public List<Emp> findByAge(Object age) {
//		return findByProperty(AGE, age);
//	}
//
//	public List<Emp> findByGender(Object gender) {
//		return findByProperty(GENDER, gender);
//	}
//
//	public List<Emp> findByAddress(Object address) {
//		return findByProperty(ADDRESS, address);
//	}
//
//	public List<Emp> findByMobile(Object mobile) {
//		return findByProperty(MOBILE, mobile);
//	}
//
//	public List<Emp> findByOfficePhone(Object officePhone) {
//		return findByProperty(OFFICE_PHONE, officePhone);
//	}
//
//	public List<Emp> findBySkype(Object skype) {
//		return findByProperty(SKYPE, skype);
//	}
//
//	public List<Emp> findByEmail(Object email) {
//		return findByProperty(EMAIL, email);
//	}
//
//	public List<Emp> findByWorkingAge(Object workingAge) {
//		return findByProperty(WORKING_AGE, workingAge);
//	}
//
//	public List<Emp> findByBaseSalary(Object baseSalary) {
//		return findByProperty(BASE_SALARY, baseSalary);
//	}
//
//	public List<Emp> findByCreditCardNumber(Object creditCardNumber) {
//		return findByProperty(CREDIT_CARD_NUMBER, creditCardNumber);
//	}
//
//	public List<Emp> findByAnnualLeaveLeft(Object annualLeaveLeft) {
//		return findByProperty(ANNUAL_LEAVE_LEFT, annualLeaveLeft);
//	}
//
//	public List<Emp> findByCompensatoryLeaveLeft(Object compensatoryLeaveLeft) {
//		return findByProperty(COMPENSATORY_LEAVE_LEFT, compensatoryLeaveLeft);
//	}
//
	public List<Emp> findAll() {
		log.debug("finding all Emp instances");
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Emp";
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
	

	public Emp merge(Emp detachedInstance) {
		log.debug("merging Emp instance");
		try {
			Emp result = (Emp) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Emp instance) {
		log.debug("attaching dirty Emp instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Emp instance) {
		log.debug("attaching clean Emp instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	/*public List queryForPage(final String hql, final int offset, final int length) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}*/
	
	public PageBean queryForPage(int pageSize, int page) {
		String hql = "from Emp"; 
		return pagination.findAll(hql, pageSize, page);
	}
	
	public PageBean testqueryForPage(int pageSize, int page) {
		String hql = "from TokenAbsence as model where model.tokenExecutor='JasonL' and model.tokenState='1'";
		return pagination.findAll(hql, pageSize, page);
	}
	
}