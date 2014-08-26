package com.moravia.hs.base.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.TokenAbsence;
import com.moravia.hs.base.entity.other.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * TokenAbsence entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.TokenAbsence
 * @author MyEclipse Persistence Tools
 */
public class TokenAbsenceDAO extends HibernateDaoSupport {
	@Autowired
	private Pagination pagination;
	
	private static final Logger log = LoggerFactory
			.getLogger(TokenAbsenceDAO.class);
	// property constants
	public static final String TOKEN_EXECUTOR = "tokenExecutor";
	public static final String TOKEN_STATE = "tokenState";

	public void save(TokenAbsence transientInstance) {
		log.debug("saving TokenAbsence instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TokenAbsence persistentInstance) {
		log.debug("deleting TokenAbsence instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TokenAbsence findById(java.lang.Integer id) {
		log.debug("getting TokenAbsence instance with id: " + id);
		try {
			TokenAbsence instance = (TokenAbsence) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.TokenAbsence", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
//	public List<TokenAbsence> findByExecutor(String executor) {
//		log.debug("finding all TokenAbsence instances");
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
//		try {
//			String queryString = "from TokenAbsence where tokenExecutor";
//			Query queryObject = session.createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		} finally {
//			log.debug("closing session");
//			session.close();
//		}
//	}

	/*public List<TokenAbsence> findByExample(TokenAbsence instance) {
		log.debug("finding TokenAbsence instance by example");
		try {
			List<TokenAbsence> results = (List<TokenAbsence>) getHibernateTemplate()
					.createCriteria("com.moravia.hs.base.entity.TokenAbsence")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}*/

	/**
	 * Find by Executor and tokenState
	 * @param propertyName1
	 * @param value1
	 * @param propertyName2
	 * @param value2
	 * @return
	 */
	public List findByProperty(String propertyName1, Object value1, String propertyName2, Object value2) {
		log.debug("finding TokenAbsence instance with property: "
				+ propertyName1 + ", value: " + value1 + "and property: " + propertyName2 + ", value: " + value2);
//		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from TokenAbsence as model where model."
					+ propertyName1 + "= ? and model." + propertyName2 + "=?";
//			Query queryObject = session.createQuery(queryString);
//			queryObject.setParameter(0, value1);
//			queryObject.setParameter(1, value2);
			
			// 分页查询
//			queryObject.setFirstResult(11);
//			queryObject.setMaxResults(10);
			
			return getHibernateTemplate().find(queryString, value1, value2);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		} 
//		finally {
//			log.debug("closing session");
//			session.close();
//		}
	}
	
	/**
	 * 
	 * @param propertyName1
	 * @param value1
	 * @param propertyName2
	 * @param value2
	 * @return
	 */
	public PageBean testfindByProperty2(String propertyName1, Object value1, String propertyName2, Object value2, int pageSize, int page) {
		log.debug("finding TokenAbsence instance with property: "
				+ propertyName1 + ", value: " + value1 + "and property: " + propertyName2 + ", value: " + value2);
		try {
			String queryString = "from TokenAbsence as model where model."
					+ propertyName1 + "= '"+ value1 +"' and model." + propertyName2 + "= '"+ value2 +"'";
			return pagination.findAll(queryString, pageSize, page);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		} 
//		finally {
//			log.debug("closing session");
//			session.close();
//		}
	}
	
	

	public List<TokenAbsence> findByTokenExecutor(Object tokenExecutor, Object tokenState) {
		return findByProperty(TOKEN_EXECUTOR, tokenExecutor, TOKEN_STATE, tokenState);
	}
	
	public PageBean findByTokenExecutorWithPageSize(Object tokenExecutor, Object tokenState, int pageSize, int page) {
		return testfindByProperty2(TOKEN_EXECUTOR, tokenExecutor, TOKEN_STATE, tokenState, pageSize, page);
	}

	/*public List<TokenAbsence> findByTokenState(Object tokenState) {
		return findByProperty(TOKEN_STATE, tokenState);
	}*/
	
	public List findAll() {
		log.debug("finding all TokenAbsence instances");
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from TokenAbsence";
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

	public TokenAbsence merge(TokenAbsence detachedInstance) {
		log.debug("merging TokenAbsence instance");
		try {
			TokenAbsence result = (TokenAbsence) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TokenAbsence instance) {
		log.debug("attaching dirty TokenAbsence instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TokenAbsence instance) {
		log.debug("attaching clean TokenAbsence instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	/*public PageBean testqueryForPage(int pageSize, int page) {
		String hql = "from TokenAbsence as model where model.tokenExecutor='JasonL' and model.tokenState='1'";
		return pagination.findAll(hql, pageSize, page);
	}*/
	
}