package cn.ymb.crm.page;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {
	
	private String hql;		//hql语句
	private Object[] params;//hql语句的实际查询条件
	private int startIndex;	//分页：开始索引
	private int pageSize;	//分页：每页显示个数

	public PageHibernateCallback(String hql, Object[] params, int startIndex,
			int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {

		Query queryObject = session.createQuery(hql);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				queryObject.setParameter(i, params[i]);  
			}
		}

		if (startIndex >= 0) {
			queryObject.setFirstResult(startIndex);
		}

		if (pageSize > 0) {
			queryObject.setMaxResults(pageSize);
		}
		
		return queryObject.list();
	}

}
