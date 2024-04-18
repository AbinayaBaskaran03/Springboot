package com.uploadimage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uploadimage.entity.TimeLine;
import com.uploadimage.service.TimeService;
import com.uploadimage.service.TimelineService;

@RestController
@RequestMapping("/timeline")
public class TimelineController {

	@Autowired
	private TimelineService timelineService;

	@Autowired
	private TimeService timeService;

	@PostMapping("/create-date")
	public ResponseEntity<String> createTimeline(@RequestBody TimeLine timeLine) {
		timelineService.timelineschedule(timeLine);
		return ResponseEntity.ok("Timeline Created");
	}

	@PostMapping(value = "/getbydate")
	public ResponseEntity<String> getBytime(@RequestBody TimeLine timeLine) {
		try {
			timeService.findbytime(timeLine);
			return ResponseEntity.ok("Timeline created");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping(value = "/get")
	public  String getTimelines(TimeLine timeLineobj)  {
		System.out.println("_______________________");
		try {
			List<TimeLine> timelines = timeService.getAlldates();
			System.out.println("_______________________");

			return "Timeline";
		} catch (Exception e) {
			System.out.println("_______________________");

			return e.getMessage();
		}
	}
}
