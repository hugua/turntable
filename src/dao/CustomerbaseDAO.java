package dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Customerbase;

/**
 * A data access object (DAO) providing persistence and search support for
 * Customerbase entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see entity.Customerbase
 * @author MyEclipse Persistence Tools
 */
public class CustomerbaseDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CustomerbaseDAO.class);
	// property constants
	public static final String BASE_ID = "baseId";
	public static final String CUSTOMER_BASE = "customerBase";
	public static final String PRODUCT_ID = "productId";
	public static final String PRODUCT_PROBLITY = "productProblity";
	public static final String COUPON_ID = "couponId";

	protected void initDao() {
		// do nothing
	}

	public void save(Customerbase transientInstance) {
		log.debug("saving Customerbase instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Customerbase persistentInstance) {
		log.debug("deleting Customerbase instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Customerbase findById(java.lang.Integer id) {
		log.debug("getting Customerbase instance with id: " + id);
		try {
			Customerbase instance = (Customerbase) getHibernateTemplate().get(
					"entity.Customerbase", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Customerbase instance) {
		log.debug("finding Customerbase instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Customerbase instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Customerbase as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBaseId(Object baseId) {
		return findByProperty(BASE_ID, baseId);
	}

	public List findByCustomerBase(Object customerBase) {
		return findByProperty(CUSTOMER_BASE, customerBase);
	}

	public List findByProductId(Object productId) {
		return findByProperty(PRODUCT_ID, productId);
	}

	public List findByProductProblity(Object productProblity) {
		return findByProperty(PRODUCT_PROBLITY, productProblity);
	}

	public List findByCouponId(Object couponId) {
		return findByProperty(COUPON_ID, couponId);
	}

	public List findAll() {
		log.debug("finding all Customerbase instances");
		try {
			String queryString = "from Customerbase";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Customerbase merge(Customerbase detachedInstance) {
		log.debug("merging Customerbase instance");
		try {
			Customerbase result = (Customerbase) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Customerbase instance) {
		log.debug("attaching dirty Customerbase instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customerbase instance) {
		log.debug("attaching clean Customerbase instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CustomerbaseDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CustomerbaseDAO) ctx.getBean("CustomerbaseDAO");
	}
}