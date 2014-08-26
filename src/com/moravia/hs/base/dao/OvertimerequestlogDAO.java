package com.moravia.hs.base.dao;

import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.Overtimerequestlog;

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
 * Overtimerequestlog entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Overtimerequestlog
 * @author MyEclipse Persistence Tools
 */
public class OvertimerequestlogDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OvertimerequestlogDAO.class);
	// property constants
	public static final String LOG_DESC = "logDesc";
	public static final String CHANGE_PEOPLE = "changePeople";

	public void save(Overtimerequestlog transientInstance) {
		log.debug("saving Overtimerequestlog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Overtimerequestlog persistentInstance) {
		log.debug("deleting Overtimerequestlog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Overtimerequestlog findById(java.lang.Integer id) {
		log.debug("getting Overtimerequestlog instance with id: " + id);
		try {
			Overtimerequestlog instance = (Overtimerequestlog) getHibernateTemplate()
					.get("com.moravia.hs.base.entity.Overtimerequestlog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Overtimerequestlog> findByOvertimeRecordId(Integer id) {
		try {
			String queryString = "from Overtimerequestlog where overtimerecord.id = ? order by changeDate";
			return getHibernateTemplate().find(queryString, id);
		} catch (RuntimeException re) {
			log.error("OvertimerequestlogDao findByOvertimeRecordId failed", re);
			throw re;
		}
		
	}
	
	/*public List<Overtimerequestlog> findByExample(Overtimerequestlog instance) {
		log.debug("finding Overtimerequestlog instance by example");
		try {
			List<Overtimerequestlog> results = (List<Overtimerequestlog>) getHibernateTemplate()
					.createCriteria(
							"com.moravia.hs.base.dao.Overtimerequestlog")
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
		log.debug("finding Overtimerequestlog instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Overtimerequestlog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Overtimerequestlog> findByLogDesc(Object logDesc) {
		return findByProperty(LOG_DESC, logDesc);
	}

	public List<Overtimerequestlog> findByChangePeople(Object changePeople) {
		return findByProperty(CHANGE_PEOPLE, changePeople);
	}*/

	public List findAll() {
		log.debug("finding all Overtimerequestlog instances");
		try {
			String queryString = "from Overtimerequestlog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Overtimerequestlog merge(Overtimerequestlog detachedInstance) {
		log.debug("merging Overtimerequestlog instance");
		try {
			Overtimerequestlog result = (Overtimerequestlog) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void saveOrUpdae(Overtimerequestlog instance) {
		log.debug("attaching dirty Overtimerequestlog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Overtimerequestlog instance) {
		log.debug("attaching clean Overtimerequestlog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}