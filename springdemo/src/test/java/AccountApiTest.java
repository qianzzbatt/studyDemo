import com.spring.study.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/17
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml"})
public class AccountApiTest {

    @Resource
    private IAccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("1","2",100);
    }

}
