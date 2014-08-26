package com.moravia.hs.base.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.other.PageBean;

public class Pagination extends HibernateDaoSupport{
	
	public List queryForPage(final String hql, final int offset, final int length) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}
	
	public int getAllRowCount(String hql) {
		return getHibernateTemplate().find(hql).size();
	}
	
	
	public PageBean findAll(final String hql, int pageSize, int page) {
		int allRow = getAllRowCount(hql);	// 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow);	// 总页数
		final int offset = PageBean.countOffset(pageSize, page);	// 当前页开始记录
		final int length = pageSize;	// 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List list = queryForPage(hql, offset, length);	// "一页"的记录
//		System.out.println("Inner Pagination list.size(): " + list.size());
		// 把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

}
