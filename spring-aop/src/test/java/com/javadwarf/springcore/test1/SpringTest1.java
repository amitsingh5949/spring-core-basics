package com.javadwarf.springcore.test1;

import com.javadwarf.springcore.aop1.beans.Game;
import com.javadwarf.springcore.aop1.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)

public class SpringTest1 {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    Game game;

    @Test
    public void test1(){
        String result = game.playGame();
        assertTrue(result=="Chicago Cubs" || result == "RedSoxs");
    }
}
/*@Transactional
@Commit
@Rollback
@DirtiesContext*/