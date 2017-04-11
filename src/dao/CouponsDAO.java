package dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Coupons;

/**
 * A data access object (DAO) providing persistence and search support for
 * Coupons entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Coupons
 * @author MyEclipse Persistence Tools
 */
public class CouponsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CouponsDAO.class);
	// property constants
	public static final String COUPON_ID = "couponId";
	public static final String DISCOUNT = "discount";
	public static final String PRODUCT_ID = "productId";
	public static final String COUPON_DESCRIPTION = "couponDescription";
	public static final String CUSTOMER_IMG = "customerImg";

	protected void initDao() {
		// do nothing
	}

	public void save(Coupons transientInstance) {
		log.debug("saving Coupons instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Coupons persistentInstance) {
		log.debug("deleting Coupons instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Coupons findById(java.lang.Integer id) {
		log.debug("getting Coupons instance with id: " + id);
		try {
			Coupons instance = (Coupons) getHibernateTemplate().get(
					"entity.Coupons", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Coupons instance) {
		log.debug("finding Coupons instance by example");
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
		log.debug("finding Coupons instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Coupons as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCouponId(Object couponId) {
		return findByProperty(COUPON_ID, couponId);
	}

	public List findByDiscount(Object discount) {
		return findByProperty(DISCOUNT, discount);
	}

	public List findByProductId(Object productId) {
		return findByProperty(PRODUCT_ID, productId);
	}

	public List findByCouponDescription(Object couponDescription) {
		return findByProperty(COUPON_DESCRIPTION, couponDescription);
	}

	public List findByCustomerImg(Object customerImg) {
		return findByProperty(CUSTOMER_IMG, customerImg);
	}

	public List findAll() {
		log.debug("finding all Coupons instances");
		try {
			String queryString = "from Coupons";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Coupons merge(Coupons detachedInstance) {
		log.debug("merging Coupons instance");
		try {
			Coupons result = (Coupons) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Coupons instance) {
		log.debug("attaching dirty Coupons instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Coupons instance) {
		log.debug("attaching clean Coupons instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CouponsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CouponsDAO) ctx.getBean("CouponsDAO");
	}
}