package com.moravia.hs.base.dao;

import com.moravia.hs.base.entity.BaseHibernateDAO;
import com.moravia.hs.base.entity.Overtimerecord;
import com.moravia.hs.base.entity.other.PageBean;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Overtimerecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Overtimerecord
 * @author MyEclipse Persistence Tools
 */
public class OvertimerecordDAO extends HibernateDaoSupport {
	
	@Autowired
	private Pagination pagination;
	
	private static final Logger log = LoggerFactory
			.getLogger(OvertimerecordDAO.class);
	// property constants
	public static final String APPLICANT = "applicant";
	public static final String PROJECTCODE = "projectcode";
	public static final String PROJECTNAME = "projectname";
	public static final String COMMENTS = "comments";
	public static final String TOTALHOURS = "totalhours";
	public static final String GM = "gm";
	public static final String GMNOTE = "gmnote";
	public static final String PM = "pm";
	public static final String PMNOTE = "pmnote";

	public void save(Overtimerecord transientInstance) {
		log.debug("saving Overtimerecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Overtimerecord persistentInstance) {
		log.debug("deleting Overtimerecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Overtimerecord findById(java.lang.Integer id) {
		log.debug("getting Overtimerecord instance with id: " + id);
		try {
			Overtimerecord instance = (Overtimerecord) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Overtimerecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*public List<Overtimerecord> findByExample(Overtimerecord instance) {
		log.debug("finding Overtimerecord instance by example");
		try {
			List<Overtimerecord> results = (List<Overtimerecord>) getHibernateTemplate()
					.createCriteria("com.moravia.hs.base.dao.Overtimerecord")
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
		log.debug("finding Overtimerecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Overtimerecord as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Overtimerecord> findByApplicant(Object applicant) {
		return findByProperty(APPLICANT, applicant);
	}

	public List<Overtimerecord> findByProjectcode(Object projectcode) {
		return findByProperty(PROJECTCODE, projectcode);
	}

	public List<Overtimerecord> findByProjectname(Object projectname) {
		return findByProperty(PROJECTNAME, projectname);
	}

	public List<Overtimerecord> findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List<Overtimerecord> findByTotalhours(Object totalhours) {
		return findByProperty(TOTALHOURS, totalhours);
	}

	public List<Overtimerecord> findByGm(Object gm) {
		return findByProperty(GM, gm);
	}

	public List<Overtimerecord> findByGmnote(Object gmnote) {
		return findByProperty(GMNOTE, gmnote);
	}

	public List<Overtimerecord> findByPm(Object pm) {
		return findByProperty(PM, pm);
	}

	public List<Overtimerecord> findByPmnote(Object pmnote) {
		return findByProperty(PMNOTE, pmnote);
	}*/

	public List findAll() {
		log.debug("finding all Overtimerecord instances");
		try {
			String queryString = "from Overtimerecord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public PageBean findByApplicant(String applicant, int pageSize, int page) {
		try {
			String queryString = "from Overtimerecord as model where model.applicant = '" + applicant + "'";;
			return pagination.findAll(queryString, pageSize, page);
		} catch (RuntimeException re) {
			throw re;
		}
		
	}

	public Overtimerecord merge(Overtimerecord detachedInstance) {
		log.debug("merging Overtimerecord instance");
		try {
			Overtimerecord result = (Overtimerecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Overtimerecord instance) {
		log.debug("attaching dirty Overtimerecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Overtimerecord instance) {
		log.debug("attaching clean Overtimerecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}