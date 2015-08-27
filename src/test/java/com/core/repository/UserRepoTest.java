package com.core.repository;

import com.SpringDataConfig;
import com.core.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataConfig.class)
public class UserRepoTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Before
    @Transactional
    @Rollback(false)
    public void setup() {
        user = new User();
        user.setName("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode("admin"));
        userRepository.save(user);
    }


    @Test
    public void test() throws Exception {
        User user = userRepository.findOne(this.user.getId());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertNotNull(user);
        assertEquals(user.getName(), "admin");
        //assertEquals(user.getPassword(), encoder.encode("admin"));

    }
}
