package com.uploadimage.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uploadimage.entity.TimeLine;
import com.uploadimage.repository.TimelineRep;

@Service
public class TimelineService {
	@Autowired
	private TimelineRep timelineRep;

	public void timelineschedule(TimeLine timeLine) {
		timelineRep.save(timeLine);
	}
}
//	@SuppressWarnings("unused")
//	public List<TimeLine> getAll() {
//
//		try {
//			List<String> timelineIds = Arrays.asList("timeline_1", "timeline_2", "timeline_3", "timeline_4");
//			for (String timelineId : timelineIds) {
//
//				TimeLine timeObj = timelineRep.findById(timelineId).orElse(null);
//				if (timeObj.getTimeLine() != null) {
//					String sdate = timeObj.getStartDate();
//					String edate = timeObj.getEndDate();
//
//					if (sdate != null && edate != null) {
//
//						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//						LocalDate start = LocalDate.parse(sdate, dtf);
//						LocalDate end = LocalDate.parse(edate, dtf);
//						long difDate = ChronoUnit.DAYS.between(start, end);
//						System.out.println("*************************");
//
//						System.out.println("Days Between " + " " + timeObj.getTimeLine() + " " + " is :" + difDate);
//						System.out.println("**************************");

//						String endate = "12-10-2023";
//						if (endate != null) {
//							LocalDate endDate = LocalDate.parse(endate, dtf);
//
//							long daysminus = difDate;
//							LocalDate startDate = endDate.minusDays(daysminus);
//							System.out.println("Start date " + " " + timeObj.getTimeLine() + " " + " is :" + startDate);
//							System.out.println("*************************");
//
//							System.out.println("End Date " + " " + timeObj.getTimeLine() + " " + " is :" + endDate);
//							System.out.println("*************************");
//
//						} else {
//							System.out.println("start and end null");
//						}
//					} else {
//						System.out.println("Dates are null");
//					}
//				} else {
//					System.out.println("TimeLine Not Found" + timelineId);
//				}
//			}
//
//		} catch (DateTimeParseException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return timelineRep.findAll();
//	}
//
//}
