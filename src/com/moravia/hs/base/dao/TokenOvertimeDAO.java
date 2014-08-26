package com.moravia.hs.base.dao;

import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.TokenOvertime;
import com.moravia.hs.base.entity.other.PageBean;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TokenOvertime entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.TokenOvertime
 * @author MyEclipse Persistence Tools
 */
public class TokenOvertimeDAO extends HibernateDaoSupport {
	
	@Autowired
	private Pagination pagination;
	
	private static final Logger log = LoggerFactory
			.getLogger(TokenOvertimeDAO.class);
	// property constants
	public static final String OVERTIMERECORD = "overtimerecord";
	public static final String TOKEN_EXECUTOR = "tokenExecutor";
	public static final String TOKEN_STATE = "tokenState";

	public void save(TokenOvertime transientInstance) {
		log.debug("saving TokenOvertime instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TokenOvertime persistentInstance) {
		log.debug("deleting TokenOvertime instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TokenOvertime findById(java.lang.Integer id) {
		log.debug("getting TokenOvertime instance with id: " + id);
		try {
			TokenOvertime instance = (TokenOvertime) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.TokenOvertime", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*public List<TokenOvertime> findByExample(TokenOvertime instance) {
		log.debug("finding TokenOvertime instance by example");
		try {
			List<TokenOvertime> results = (List<TokenOvertime>) getHibernateTemplate()
					.createCriteria("com.moravia.hs.base.dao.TokenOvertime")
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
		log.debug("finding TokenOvertime instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TokenOvertime as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TokenOvertime> findByOvertimerecord(Object overtimerecord) {
		return findByProperty(OVERTIMERECORD, overtimerecord);
	}

	public List<TokenOvertime> findByTokenExecutor(Object tokenExecutor) {
		return findByProperty(TOKEN_EXECUTOR, tokenExecutor);
	}

	public List<TokenOvertime> findByTokenState(Object tokenState) {
		return findByProperty(TOKEN_STATE, tokenState);
	}*/

	public List findAll() {
		log.debug("finding all TokenOvertime instances");
		try {
			String queryString = "from TokenOvertime";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PageBean findByExecutorWithPageSize(String executor, int tokenState, int pageSize, int page) {
		try {
			String queryString = "from TokenOvertime as model where model.tokenExecutor= '"+ executor +"' and model.tokenState = '"+ tokenState +"'";
			return pagination.findAll(queryString, pageSize, page);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	
	public TokenOvertime merge(TokenOvertime detachedInstance) {
		log.debug("merging TokenOvertime instance");
		try {
			TokenOvertime result = (TokenOvertime) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(TokenOvertime instance) {
		log.debug("attaching dirty TokenOvertime instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TokenOvertime instance) {
		log.debug("attaching clean TokenOvertime instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}