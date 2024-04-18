package com.uploadimage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uploadimage.Dao.TimelineDao;
import com.uploadimage.entity.TimeLine;
import com.uploadimage.repository.TimelineRep;

@Service
public class TimeService {

	@Autowired
	private TimelineRep timelineRep;
	
	@Autowired
	private TimelineDao timelineDao;
	
//	@PersistenceContext
//    private EntityManager entityManager;

	public String findbytime(TimeLine timeLine) {

//		TimelineDto timelineDto = new TimelineDto();
//		timelineDto.setTimeLine(timeLine.getTimeLine());
//		timelineDto.setEndDate(timeLine.getEndDate());
//
//		try {
//
//			ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
//
//			List<String> timeId = Arrays.asList("timeline_1", "timeline_2", "timeline_3", "timeline_4");
//
//			for (String timelineName : timeId) {
//				TimeLine timeObj = timelineRep.findById(timelineName).orElse(null);
//
//				for (int i = 0; i < timeId.size(); i++) {
//					String tnames = timeId.get(i);
//					if (tnames.equals(timelineDto.getTimeLine())) {
//						TimeLine timesObj = timelineRep.findById(timelineDto.getTimeLine()).orElse(null);
//						String sdate = timesObj.getStartDate();
//						String edate = timesObj.getEndDate();
//
//						if (sdate != null && edate != null) {
//
//							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//							LocalDate start = LocalDate.parse(sdate, dtf);
//							LocalDate end = LocalDate.parse(edate, dtf);
//							long difDate = ChronoUnit.DAYS.between(start.plusDays(1), end);
//							System.out.println("*************************");
//
//							System.out.println(
//									"Days Between " + " " + timelineDto.getTimeLine() + " " + " is :" + difDate);
//							System.out.println("**************************");
//
//							if (timelineDto.getEndDate() != null) {
//
//								LocalDate t3newendDate = LocalDate.parse(timelineDto.getEndDate(), dtf);
//								long newdifDate = ChronoUnit.DAYS.between(LocalDate.parse(sdate, dtf),
//										LocalDate.parse(edate, dtf));
//
//								System.out.println("*************************");
//
//								LocalDate t3newstartDate = t3newendDate.minusDays(newdifDate);
//
//								System.out.println("Start date " + " " + "New" + timelineDto.getTimeLine() + " "
//										+ "is : " + t3newstartDate);
//								System.out.println("*************************");
//
//								System.out.println("End Date " + " " + "New" + timelineDto.getTimeLine() + " "
//										+ " is : " + t3newendDate);
//								System.out.println("*************************");
//								//dates.add(t3newstartDate);
//								//dates.add(t3newendDate);
//			                    break;
//
//							}
//
//						} else {
//							System.out.println("Start and End Null : ");
//						}
//					} else {
//						System.out.println("Not Found : " + tnames);
//					}
//				}
//				if (timeObj != null) {
//					timelineRep.save(timeObj);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return "sdffgb";
	}
  
	public List<TimeLine> getAlldates() {
		System.out.println("+++++++++++++++");
		return timelineDao.getAll();
	}
	

}
