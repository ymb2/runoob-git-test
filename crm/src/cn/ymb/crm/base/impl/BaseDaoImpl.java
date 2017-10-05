package cn.ymb.crm.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ymb.crm.page.PageHibernateCallback;
import cn.ymb.crm.base.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	private Class<T> beanClass;
	
	public BaseDaoImpl() {

		ParameterizedType parameterizedType =  (ParameterizedType) this.getClass().getGenericSuperclass();

		beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	};
	
	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(beanClass, id);
	}

	@Override
	public List<T> findAll() {
		// class.getName() 获得类的全限定类名，例如：java.lang.String 
		// hibernate hql 完成写法 “from cn.ymb.crm...CrmUser”
		return this.getHibernateTemplate().find("from " + beanClass.getName());
	}
	
	@Override
	public List<T> findAll(String condition, Object... params) {
		String hql = "from " + beanClass.getName() + " where 1=1 " + condition;
		return this.getHibernateTemplate().find(hql , params);
	}


	
	@Override
	public List<T> findAllWithPage(int startIndex, int pageSize) {
		String hql = "from " + beanClass.getName();
		Object[] params = {};
		return this.getHibernateTemplate().execute(new PageHibernateCallback<T>(hql,params,startIndex,pageSize));
	}

	@Override
	public int getTotalRecord() {
		List<Long> allData = this.getHibernateTemplate().find("select count(u) from "+beanClass.getName()+" u");
		return allData.get(0).intValue();
	}

}
