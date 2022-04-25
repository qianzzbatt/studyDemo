import com.spring.study.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/15
 **/
public class main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService)context.getBean("userService");
        userService.sayHello();
        userService.talk();
    }
}
