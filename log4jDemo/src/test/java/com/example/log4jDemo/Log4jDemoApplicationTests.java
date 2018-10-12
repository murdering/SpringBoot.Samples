package com.example.log4jDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Log4jDemoApplication.class)
public class Log4jDemoApplicationTests {

	private Logger logger = Logger.getLogger(getClass());

	@Test
	public void contextLoads() throws Exception {
		logger.info("输出info");
		logger.debug("输出debug");
		logger.error("输出error");
	}

}
