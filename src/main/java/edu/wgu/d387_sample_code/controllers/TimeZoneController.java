package edu.wgu.d387_sample_code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TimeZoneController {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void timeMachine(){
        ZoneId zEastern=ZoneId.of("America/New_York");
        ZoneId zPacific=ZoneId.of("America/Los_Angeles");
        ZoneId zUTC=ZoneId.of("UTC");
        ZoneId zoneId=ZoneId.systemDefault();

        LocalDateTime localDateTime=LocalDateTime.now();
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTimeUTC=zonedDateTime.withZoneSameInstant(zUTC);
        LocalDateTime localDateTimeUTC=zonedDateTimeUTC.toLocalDateTime();

        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();

        ZonedDateTime zonedDateTimePacific=zonedDateTime.withZoneSameInstant(zPacific);
        LocalDateTime localDateTimePacific=zonedDateTimePacific.toLocalDateTime();
    }


    @RequestMapping(path = "/UTCTIME", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTimeUTC(){
        ZoneId zoneId=ZoneId.systemDefault();
        LocalDateTime localDateTime=LocalDateTime.now();
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);

        ZoneId zUTC=ZoneId.of("UTC");
        ZonedDateTime zonedDateTimeUTC=zonedDateTime.withZoneSameInstant(zUTC);

        String UTCTime = zonedDateTimeUTC.format(formatter);

        return new ResponseEntity<String>(UTCTime,HttpStatus.OK);
    }

    @RequestMapping(path = "/EASTERNTIME", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTimeEastern(){
        ZoneId zoneId=ZoneId.systemDefault();
        LocalDateTime localDateTime=LocalDateTime.now();
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);

        ZoneId zEastern=ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zEastern);

        String EasternTime = zonedDateTimeEastern.format(formatter);

        return new ResponseEntity<String>(EasternTime,HttpStatus.OK);
    }

    @RequestMapping(path = "/WESTERNTIME", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTimeWestern(){
        ZoneId zoneId=ZoneId.systemDefault();
        LocalDateTime localDateTime=LocalDateTime.now();
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);

        ZoneId zPacific=ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zPacific);

        String WesternTime = zonedDateTimeEastern.format(formatter);

        return new ResponseEntity<String>(WesternTime, HttpStatus.OK);


    }
}
