package org.example;

import org.example.DI.AppConfig;
import org.example.DI.NotificationService;
import org.example.DI.SMSService;
import org.example.IoC.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // IoC Example
        ApplicationContext ap=new ClassPathXmlApplicationContext("config.xml");
        Car obj=ap.getBean("car",Car.class);
        System.out.println(obj);

        // DI -Example
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Constructor Injection
        NotificationService emailNotificationService = context.getBean(NotificationService.class);
        emailNotificationService.sendNotification("This is an email notification");

        // Setter Injection
        NotificationService smsNotificationService = new NotificationService(new SMSService());
        smsNotificationService.sendNotification("This is an SMS notification");


        context.close();

    }
}
