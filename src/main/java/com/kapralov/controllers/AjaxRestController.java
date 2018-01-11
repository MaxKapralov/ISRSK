package com.kapralov.controllers;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.collect.Lists;
import com.kapralov.model.data.RoomBook;
import com.kapralov.model.repository.RoomBookRepository;

@RestController
public class AjaxRestController {

	@Autowired
	RoomBookRepository roomBookRep;
	

	@RequestMapping(value="/admin/checkDate", method = RequestMethod.GET)
	public String checkDate(@RequestParam("date") String str) throws ParseException
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(str);
		List<Integer> hours = getHours();	
		ArrayList<RoomBook> rooms = new ArrayList<RoomBook>(roomBookRep.findWithDate(date));
		hours = getFreeHours(hours, rooms);
		return hours.toString();
	}
	
	public static List<Integer> getFreeHours(List<Integer> hours, ArrayList<RoomBook> rooms)
	{
		Calendar calendar = GregorianCalendar.getInstance();
		for(int i = 0; i < rooms.size(); i++)
		{
			calendar.setTime(rooms.get(i).getBusyFrom());
			if(hours.contains(new Integer(calendar.get(Calendar.HOUR_OF_DAY))))
				hours.remove(new Integer(calendar.get(Calendar.HOUR_OF_DAY)));
		}
		return hours;
	}
	public static List<Integer> getHours()
	{
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0,  j = 8; i < 6; i++, j+=2)
			list.add(j);
		return list;
	}
	
}

