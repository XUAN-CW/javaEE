package edu.guet;

import edu.guet.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author XUAN
 * @date 2020/10/29 - 20:09
 * @references
 * @purpose
 * @errors
 */
public class CRUDTest {

    @Test
    public void Create() throws IOException {
        //模拟user对象
        User user = new User();
        user.setUsername("Create");
        user.setPassword("Create");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作  参数：namespace+id
        sqlSession.insert("userMapper.create",user);

        //mybatis执行更新操作  提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }


    @Test
    public void Retrieve() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        for (User u:userList) {
            System.out.println(u.getPassword());
        }
        //释放资源
        sqlSession.close();
    }

    @Test
    public void avgPrice() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Double> userList = sqlSession.selectList("userMapper.avgPrice");
        //打印数据
        System.out.println(userList);
        for (Double u:userList) {
            System.out.println(u);
        }
        //释放资源
        sqlSession.close();
    }


    @Test
    public void Delete() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        sqlSession.delete("userMapper.delete",2);

        //mybatis执行更新操作  提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

}
