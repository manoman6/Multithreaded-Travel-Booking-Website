package edu.wgu.d387_sample_code.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;
//FIXME: notes:
//cross origin might need to be set to 8080
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class HelloController {
    static ExecutorService messageExecutor = newFixedThreadPool(2);
    private static final String[] frenchWelcome = new String[2];

    @GetMapping("/resource")
    public static String[] getWelcomeMessage() {
        //fixme: commented out for testing
        //changing return type to responseenttity and changing the return to return responseentity frenchwelcome
        //from String[] and french welcome as the return
        //SpringApplication.run(WelcomeMessage.class);
        System.out.println("works");
        messageExecutor.execute(() -> {
            try {
                Properties properties = new Properties();
                InputStream stream = new ClassPathResource("Translation_french.properties").getInputStream();
                properties.load(stream);
                frenchWelcome[0] = properties.getProperty("welcome");
                System.out.println("Welcome message executed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        messageExecutor.execute(() -> {
            try {
                Properties properties = new Properties();
                InputStream stream = new ClassPathResource("Translation_english.properties").getInputStream();
                properties.load(stream);
                frenchWelcome[1] = properties.getProperty("welcome");
                System.out.println(frenchWelcome[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            Thread.sleep(1500);
        }catch(Exception e){}
        return frenchWelcome;
    }

    @RequestMapping(path = "/welcomefrench", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> showFrenchMessage() {

        String[] welcomeArray = new String[2];
        welcomeArray = getWelcomeMessage();
        String finalMessage = welcomeArray[0];


        //String finalMessage = "hello world";
        return new ResponseEntity<String>(finalMessage, HttpStatus.OK);
    }
    @RequestMapping(path = "/welcomeenglish", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> showEnglishMessage(){
        String[] welcomeArray = new String[2];
        welcomeArray = getWelcomeMessage();
        String finalMessage = welcomeArray[1];

        return new ResponseEntity<String>(finalMessage, HttpStatus.OK);
    }


}






    /*
        public static void assignThreads(String[] frenchWelcome){
            Thread frenchThread = new Thread();
            Thread englishThread = new Thread();

            frenchThread.setName(frenchWelcome[0]);
            englishThread.setName(frenchWelcome[1]);

            frenchThread.start();
            englishThread.start();
            System.out.println(englishThread);

        }
        */





