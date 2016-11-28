package ua.artcode.run_service;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ua.artcode"})
public class Run {
    public static void main(String[] args) {
        System.getProperties().put( "server.port", 9999);
        SpringApplication.run(Run.class, args);
    }
}
