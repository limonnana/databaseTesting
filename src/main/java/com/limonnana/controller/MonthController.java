package com.limonnana.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.limonnana.domain.MonthDTO;
import com.limonnana.domain.MonthList;
import com.limonnana.domain.MonthListDTO;
import com.limonnana.monthFactory.MonthCreator;
import com.limonnana.monthFactory.MonthUtils;
import com.limonnana.repository.ListWrapperRepository;
import org.springframework.beans.factory.annotation.Autowired;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;

@RestController
@RequestMapping(path = "/api")
public class MonthController {


    @Autowired
    private ListWrapperRepository listWrapperRepository;

    @Autowired
   private MonthCreator monthCreator;

    @Autowired
    private MonthUtils monthUtils;



    protected Gson gson;

    @RequestMapping(value = "/test", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public HashMap HelloWorld() {

        HashMap<String, String> res = new HashMap<String, String>();
        res.put("data", "hello world");
        res.put("errorCode", "0");
        return res;

    }

    @RequestMapping(value = "/testing", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> Hola() {
        Gson g = new Gson();
        HashMap<String, String> res = new HashMap<String, String>();
        System.out.println("HelloWorld Test!");
        res.put("data", "hello world!");
        res.put("errCode", "0");
        return ResponseEntity.status(HttpStatus.OK).body(g.toJson(res));
    }

    /*
        (0, currentYear, currentMonth, day, this.login, from, untill)
  */

    @RequestMapping(value="/addEntity/{month}/{year}/{day}/{from}/{untill}" , method = RequestMethod.GET)
    ResponseEntity<String> saveEntity(@PathVariable("month") String month, @PathVariable("year") int year, @PathVariable("day") int day, @PathVariable("from") int from, @PathVariable("untill") int untill){
        System.out.println("addEntity");
        MonthDTO monthDTO = new MonthDTO();
        monthDTO.setUserLogin("user6");
        monthDTO.setName(month);
        monthDTO.setYear(year);
        monthDTO.setDay(day);
        monthDTO.setFrom(from);
        monthDTO.setUntill(untill);
        monthUtils.saveEntity(monthDTO);

        Month m = Month.valueOf(monthDTO.getName().toUpperCase());
        LocalDateTime ld = monthUtils.getLocalDateTime(m, monthDTO.getYear(), 1);
        LocalDateTime nextMonth = ld.plusMonths(1);

        MonthListDTO mDTO = monthCreator.getMockTestListReservationsNext(nextMonth);

        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

        String result = gson.toJson(mDTO);

        return ResponseEntity.ok().body(result);
    }



    @GetMapping("/month")
    public ResponseEntity<String>  getMonths(){

        MonthListDTO mDTO = monthCreator.getMockTestListReservations();

        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

        String result = gson.toJson(mDTO);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/nextMonth/{month}/{year}/{direction}")
    ResponseEntity<String>  getNextMonths(@PathVariable String month, @PathVariable int year, @PathVariable int direction){

        Month m = Month.valueOf(month);
        LocalDateTime ld = monthUtils.getLocalDateTime(m, year, 1);
        LocalDateTime nextMonth = ld.plusMonths(1);
         if(direction == -1){
             nextMonth = ld.minusMonths(1);
        }

        MonthListDTO mDTO = monthCreator.getMockTestListReservationsNext(nextMonth);

        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        String result = gson.toJson(mDTO);

        return ResponseEntity.ok().body(result);
    }


}
