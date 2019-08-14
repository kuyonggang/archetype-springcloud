package base;

import com.archetype.springcloud.consumer.Consumer1;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * setUp()函数是在众多函数或者说是在一个类类里面最先被调用的函数，而且每执行完一个函数都要从setUp()调用开始后再执行下一个函数，
 * 有几个函数就调用他几次，与位置无关，随便放在那里都是他先被调用。
 *
 * tearDown(）函数是在众多函数执行完后他才被执行，意思就是不管这个类里面有多少函数，他总是最后一个被执行的，与位置无关，
 * 放在那里都行，最后不管测试函数是否执行成功都执行tearDown()方法；如果setUp()方法失败，则认为这个测试项目失败，不会执行测试函数也不执行tearDown()方法。
 *
 * 执行顺序如下：setUp---test_001---setUp---test_002---tearDown
 * 用springbootTest会启动整个Spring application context 但是没有启动server。这个时候自然websocket就会报错。
 * 可以使用webEnvironment 属性@SpringBootTest来进一步优化测试的运行方式
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Consumer1.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        System.out.println("setUp()................");
    }
}
