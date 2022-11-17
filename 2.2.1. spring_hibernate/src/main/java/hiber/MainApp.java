package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Vlad", "Usov", "usov@mail.ru");
      User user2 = new User("Anton", "Mishura", "mishura@gmail.com");
      User user3 = new User("Stas", "Shevchuk", "shevchuk@mail.com");
      User user4 = new User("Vladimir", "Harin", "harin@gmail.com");

      Car car1 = new Car("Mazda", 5);
      Car car2 = new Car("Nissan", 1);
      Car car3 = new Car("Tesla", 3);
      Car car4 = new Car("Skoda", 6);

//      userService.add(user1.setCar(car1).setUser(user1));
//      userService.add(user2.setCar(car2).setUser(user2));
//      userService.add(user3.setCar(car3).setUser(user3));
//      userService.add(user4.setCar(car4).setUser(user4));

      user1.setCar(car1);
      userService.add(user1);
      user2.setCar(car2);
      userService.add(user2);
      user3.setCar(car3);
      userService.add(user3);
      user4.setCar(car4);
      userService.add(user4);


      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }

      System.out.println(userService.getUserByCar("Mazda", 5));

      context.close();
   }
}
