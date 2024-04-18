package com.uploadimage.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uploadimage.entity.TimeLine;

@Repository
public class TimelineDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<TimeLine> getAll() {
	//	try {
			
		System.out.println("-----------------");

		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(TimeLine.class);
		List<TimeLine> list = crit.list();
		System.out.println("-----------------");
		return list;
	}
//		
//		String selectquery = "SELECT t.timeline, t.start_date,t.end_date FROM tb_timeline_keas t  ";
//
//		Query queryObj = session.createSQLQuery(selectquery);
//		List<Object[]> rows = queryObj.list();
//		List<TimelineDto> list = new ArrayList<>();
//		
//		for (Object[] row : rows) {
//			TimelineDto obj = new TimelineDto();
//
//			obj.setTimeLine(row[0] != null ? row[0].toString() : null);
//			obj.setStartDate(row[1] != null ? row[1].toString() : null);
//			obj.setEndDate(row[2] != null ? row[2].toString() : null);
//			list.add(obj);
//		}

		//return t;
	
		  
//	}catch(Exception e) {
//		e.printStackTrace();
//		throw e;
//	}
	} 


