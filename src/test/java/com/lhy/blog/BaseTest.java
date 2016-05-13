package com.lhy.blog;

import com.lhy.blog.domain.User;
import com.lhy.blog.service.UserService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by lhy on 16/5/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @Autowired
    private UserService userService;

    @BeforeClass
    public static void doBeforeClass() {
        System.out.println("doBeforeClass");
    }

    @AfterClass
    public static void doAfterClass() {
        LOGGER.info("doAfterClass");
    }

    @Before
    public void doBeforeTestMethod() {
        LOGGER.info("doBeforeTestMethod");
    }

    @After
    public void doAfterTestMethod() {
        LOGGER.info("doAfterTestMethod");
    }

    @Test
    public void testGetUser() {
        LOGGER.info("testGetUser()");
        User user = userService.getUserById(1);
        assertThat(user.getId(), is(1));
        assertThat(user.getId(), lessThan(10));
        assertThat(user.getAccount(), is("lhy"));
        assertThat(user.getAvatar(), not("avatar"));
        assertThat(user.getAvatar(), containsString("nul"));
    }

    @Test
    @Ignore("Not ready yet.")
    public void ignore() {}

}
