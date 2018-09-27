import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gt.wide.bean.User;
import com.gt.wide.mapper.UserMapper;


public class UserDaoTest {

	@Test
	public void testChangePassword() {
		AbstractApplicationContext ac
		= new ClassPathXmlApplicationContext(
				"spring-dao.xml");

		UserMapper userMapper
		= ac.getBean("userMapper", UserMapper.class);

		User data = userMapper.findUserByUsername("admin");
		System.out.println(data);
		ac.close();
	}

	public static void main(String[] args) {
		AbstractApplicationContext ac
		= new ClassPathXmlApplicationContext(
				"spring-mapper.xml");

		UserMapper userMapper
		= ac.getBean("userMapper", UserMapper.class);

		User data = userMapper.findUserByUsername("admin");
		System.out.println(data);
		ac.close();
	}

}
