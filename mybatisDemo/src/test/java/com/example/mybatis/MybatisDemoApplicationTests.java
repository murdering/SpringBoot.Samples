package com.example.mybatis;

import com.example.mybatis.domain.User;
import com.example.mybatis.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisDemoApplication.class)
public class MybatisDemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CacheManager cacheManager;

	@Test
	@Rollback
	public void findByName() throws Exception {
		userMapper.insert("A", 20);

		User u = userMapper.findByName("A");
		Assert.assertEquals(20, u.getAge().intValue());

	}

	@Test
	@Rollback
	public void insertByMap() throws Exception {
		userMapper.deleteByName("MapTest");

		// insert map
		Map<String, Object> map = new HashMap<>();
		map.put("name", "MapTest");
		map.put("age", 40);

		userMapper.insertByMap(map);

		User u = userMapper.findByName("MapTest");
		Assert.assertEquals(40, u.getAge().intValue());
	}

	@Test
	@Rollback
	public void insertObject() throws Exception {
		userMapper.deleteByName("InsertObject");

		// insert Object
		User ua = new User();
		ua.setAge(30);
		ua.setName("InsertObject");

		userMapper.insertByUser(ua);

		User u = userMapper.findByName("InsertObject");
		Assert.assertEquals(30, u.getAge().intValue());
	}

	@Test
	@Rollback
	public void crudTest() throws Exception {
		// create
		userMapper.insert("CRUDTest", 1);
		// research
		User u = userMapper.findByName("CRUDTest");
		Assert.assertEquals(1, u.getAge().intValue());

		//Update
		u.setAge(11);
		userMapper.update(u);
		Assert.assertEquals(11, u.getAge().intValue());

		// delete
		userMapper.delete(u.getId());
		u = userMapper.findByName("CRUDTest");
		Assert.assertEquals(null, u);
	}

	@Test
	@Rollback
	public void findAll() throws Exception{
		List<User> userList = userMapper.findAll();

		for(User user : userList){
			Assert.assertNotEquals(null, user.getId());
			Assert.assertNotEquals(null, user.getName());
		}
	}

	@Test
	@Rollback
	public void cacheTest() throws Exception{
		User u = userMapper.findByName("aaa");

		System.out.println("第一次查询：" + u.getAge());

		User u2 = userMapper.findByName("aaa");

		System.out.println("第二次查询：" + u2.getAge());

		u.setAge(20);
		userMapper.update(u);
		User u3 = userMapper.findByName("aaa");

		System.out.println("第三次查询：" + u2.getAge());
	}
}
