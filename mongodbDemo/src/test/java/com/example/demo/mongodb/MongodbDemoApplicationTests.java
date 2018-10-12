package com.example.demo.mongodb;

import com.example.demo.mongodb.domain.User;
import com.example.demo.mongodb.service.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MongodbDemoApplication.class)
public class MongodbDemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setup(){
		userRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {
		// 创建三个user, 并验证User总数
		userRepository.save(new User(1L, "didi", 30));
		userRepository.save(new User(2L, "mama", 40));
		userRepository.save(new User(3L, "kaka", 50));
		Assert.assertEquals(3, userRepository.findAll().size());

/*		// 删除一个User，再验证User总数
		User u = userRepository.findOne(1L);
		userRepository.delete(u);
		Assert.assertEquals(2, userRepository.findAll().size());*/

		// 删除一个User，再验证User总数
		User u = userRepository.findByUsername("mama");
		userRepository.delete(u);
		Assert.assertEquals(2, userRepository.findAll().size());
	}
}
