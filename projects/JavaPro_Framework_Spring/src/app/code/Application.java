package app.code;

import app.staff.administation.Director;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("app.config");
        Director director = context.getBean(Director.class);
        director.manageCompany();
    }
}
