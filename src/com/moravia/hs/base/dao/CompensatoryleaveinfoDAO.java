package com.moravia.hs.base.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Compensatoryleaveinfo;
import com.moravia.hs.base.entity.Emp;

/**
 * A data access object (DAO) providing persistence and search support for
 * Compensatoryleaveinfo entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.test.Compensatoryleaveinfo
 * @author MyEclipse Persistence Tools
 */

public class CompensatoryleaveinfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CompensatoryleaveinfoDAO.class);
	// property constants
	public static final String COMPENSATORY_LEAVE_LEFT = "compensatoryLeaveLeft";
	public static final String COMPENSATORY_LEAVE_DESC = "compensatoryLeaveDesc";

	public void save(Compensatoryleaveinfo transientInstance) {
		log.debug("saving Compensatoryleaveinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Compensatoryleaveinfo persistentInstance) {
		log.debug("deleting Compensatoryleaveinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Compensatoryleaveinfo findById(java.lang.Integer id) {
		log.debug("getting Compensatoryleaveinfo instance with id: " + id);
		try {
			Compensatoryleaveinfo instance = (Compensatoryleaveinfo) getHibernateTemplate()
					.get("com.test.Compensatoryleaveinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List<Compensatoryleaveinfo> findByExample(
//			Compensatoryleaveinfo instance) {
//		log.debug("finding Compensatoryleaveinfo instance by example");
//		try {
//			List<Compensatoryleaveinfo> results = (List<Compensatoryleaveinfo>) getHibernateTemplate()
//					.createCriteria("com.test.Compensatoryleaveinfo")
//					.add(create(instance)).list();
//			log.debug("find by example successful, result size: "
//					+ results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}

	/*public List findByProperty(String propertyName, Object value) {
		log.debug("finding Compensatoryleaveinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Compensatoryleaveinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Compensatoryleaveinfo> findByCompensatoryLeaveLeft(
			Object compensatoryLeaveLeft) {
		return findByProperty(COMPENSATORY_LEAVE_LEFT, compensatoryLeaveLeft);
	}

	public List<Compensatoryleaveinfo> findByCompensatoryLeaveDesc(
			Object compensatoryLeaveDesc) {
		return findByProperty(COMPENSATORY_LEAVE_DESC, compensatoryLeaveDesc);
	}*/
	
	public List findByEmp(Emp emp) {
		log.debug("finding all Compensatoryleaveinfo instances by emp: " + emp.getEmpLoginId());
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Compensatoryleaveinfo where emp = :emp order by expirationDate";
			Query queryObject = session.createQuery(queryString);
			
			queryObject.setEntity("emp", emp);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
		finally {
			log.debug("closing session");
			session.close();
		}
	}
	
	/*
	 * 员工实际剩余调休假
	 * (有效期必须在申请日期之后，即有效期大于
	 */
	public Double findTotalCompensatoryLeaveLeft(Emp emp, String date) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "select sum(compensatoryLeaveLeft) from Compensatoryleaveinfo where expirationDate>=? and emp = :emp";
			Query queryObject = session.createQuery(queryString);
			queryObject.setString(0, date);
			queryObject.setEntity("emp", emp);
			if(queryObject.uniqueResult() != null) {
				return (Double) queryObject.uniqueResult();
			} else {
				System.out.println("findTotalCompensatoryLeaveLeft is null, return 0.0");
				return 0.0;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
		finally {
			log.debug("closing session");
			session.close();
		}
		
	}
	
	public List findAll() {
		log.debug("finding all Compensatoryleaveinfo instances");
		try {
			String queryString = "from Compensatoryleaveinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public Compensatoryleaveinfo merge(Compensatoryleaveinfo detachedInstance) {
		log.debug("merging Compensatoryleaveinfo instance");
		try {
			Compensatoryleaveinfo result = (Compensatoryleaveinfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Compensatoryleaveinfo instance) {
		log.debug("attaching dirty Compensatoryleaveinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Compensatoryleaveinfo instance) {
		log.debug("attaching clean Compensatoryleaveinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}