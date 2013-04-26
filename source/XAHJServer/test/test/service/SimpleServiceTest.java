package test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.evalley.domain.Blog;
import com.evalley.service.SimpleService;

/**
 * Description of this file.
 * User: Xiong Neng
 * Date: 12-9-14
 * Time: 下午3:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SimpleServiceTest {
    @Autowired
    private SimpleService simpleService;

    @Test
    public void testInsertBlog() throws Exception {
        Blog blog = new Blog();
        blog.setId(100L);
        blog.setAuthor("Yidao");
        blog.setContent("This is a very cool article");
        blog.setTitle("Oh My God!");
        simpleService.insertBlog(blog);
    }

    @Test
    public void testSelectBlog() throws Exception {
        simpleService.selectBlog(100L);
    }

}
