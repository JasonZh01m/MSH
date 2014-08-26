package com.moravia.hs.base.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Absencerequestitem;
import com.moravia.hs.base.entity.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Absencerequestitem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Absencerequestitem
 * @author MyEclipse Persistence Tools
 */
public class AbsencerequestitemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AbsencerequestitemDAO.class);
	// property constants
	public static final String ABSENCE_TYPE = "absenceType";
	public static final String ABSENCE_HOURS = "absenceHours";

	public void save(Absencerequestitem transientInstance) {
		log.debug("saving Absencerequestitem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			System.out.println("保存 AbsenceRecord Item: " + transientInstance.getItemId());
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Absencerequestitem persistentInstance) {
		log.debug("deleting Absencerequestitem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			getHibernateTemplate().flush();
			System.out.println("删除 AbsenceRecord 的Item： " + persistentInstance.getItemId());
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Absencerequestitem findById(java.lang.Integer id) {
		log.debug("getting Absencerequestitem instance with id: " + id);
		try {
			Absencerequestitem instance = (Absencerequestitem) getHibernateTemplate()
					.get("com.moravia.hs.base.entity.Absencerequestitem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*public List<Absencerequestitem> findByExample(Absencerequestitem instance) {
		log.debug("finding Absencerequestitem instance by example");
		try {
			List<Absencerequestitem> results = (List<Absencerequestitem>) getHibernateTemplate()
					.createCriteria(
							"com.moravia.hs.base.entity.Absencerequestitem")
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
		log.debug("finding Absencerequestitem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Absencerequestitem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Absencerequestitem> findByAbsenceType(Object absenceType) {
		return findByProperty(ABSENCE_TYPE, absenceType);
	}

	public List<Absencerequestitem> findByAbsenceHours(Object absenceHours) {
		return findByProperty(ABSENCE_HOURS, absenceHours);
	}*/

	public List findAll() {
		log.debug("finding all Absencerequestitem instances");
		try {
			String queryString = "from Absencerequestitem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public Absencerequestitem merge(Absencerequestitem detachedInstance) {
		log.debug("merging Absencerequestitem instance");
		try {
			Absencerequestitem result = (Absencerequestitem) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Absencerequestitem instance) {
		log.debug("attaching dirty Absencerequestitem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Absencerequestitem instance) {
		log.debug("attaching clean Absencerequestitem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}