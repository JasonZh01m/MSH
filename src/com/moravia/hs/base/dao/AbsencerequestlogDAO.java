package com.moravia.hs.base.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.Absencerequestlog;
import com.moravia.hs.base.entity.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Absencerequestlog entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Absencerequestlog
 * @author MyEclipse Persistence Tools
 */
public class AbsencerequestlogDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AbsencerequestlogDAO.class);
	// property constants
	public static final String DESC = "desc";
	public static final String CHANGE_PEOPLE = "changePeople";

	public void save(Absencerequestlog transientInstance) {
		log.debug("saving Absencerequestlog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Absencerequestlog persistentInstance) {
		log.debug("deleting Absencerequestlog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Absencerequestlog findById(java.lang.Integer id) {
		log.debug("getting Absencerequestlog instance with id: " + id);
		try {
			Absencerequestlog instance = (Absencerequestlog) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Absencerequestlog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<Absencerequestlog> findByAbsenceRecord(Integer arId) {
		try {
			String queryString = "from Absencerequestlog where absencerecord.absenceRecordId = ? order by changeDate";
			return getHibernateTemplate().find(queryString, arId);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*public List<Absencerequestlog> findByExample(Absencerequestlog instance) {
		log.debug("finding Absencerequestlog instance by example");
		try {
			List<Absencerequestlog> results = (List<Absencerequestlog>) getHibernateTemplate()
					.createCriteria(
							"com.moravia.hs.base.entity.Absencerequestlog")
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
		log.debug("finding Absencerequestlog instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Absencerequestlog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Absencerequestlog> findByDesc(Object desc) {
		return findByProperty(DESC, desc);
	}

	public List<Absencerequestlog> findByChangePeople(Object changePeople) {
		return findByProperty(CHANGE_PEOPLE, changePeople);
	}

	public List findAll() {
		log.debug("finding all Absencerequestlog instances");
		try {
			String queryString = "from Absencerequestlog";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}*/

	public Absencerequestlog merge(Absencerequestlog detachedInstance) {
		log.debug("merging Absencerequestlog instance");
		try {
			Absencerequestlog result = (Absencerequestlog) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Absencerequestlog instance) {
		log.debug("attaching dirty Absencerequestlog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Absencerequestlog instance) {
		log.debug("attaching clean Absencerequestlog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}