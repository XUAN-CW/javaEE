/**
 * @author XUAN
 * @date 2020/10/7 - 20:34
 * @references
 * @purpose
 * @errors
 */
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    //查询操作
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    @Test
    //插入操作
    public void test2() throws IOException {

        //模拟user对象
        User user = new User();
        //不改代码就运行，第二此运行时会报错，因为 id 为主键
        user.setId(47);
        user.setUsername("1xx");
        user.setPassword("abc");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//在此设置为 true ，后面就不用手动提交
        //执行操作  参数：namespace+id
        sqlSession.insert("userMapper.save",user);

        //mybatis执行更新操作  提交事务
        //sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //修改操作
    public void test3() throws IOException {

        //模拟user对象
        User user = new User();
        user.setId(147);
        user.setUsername("lucy");
        user.setPassword("123");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        sqlSession.update("userMapper.update",user);

        //mybatis执行更新操作  提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //删除操作
    public void test4() throws IOException {

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        sqlSession.delete("userMapper.delete",147);

        //mybatis执行更新操作  提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //查询一个对象
    public void test5() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        User user = sqlSession.selectOne("userMapper.findById", 1);
        //打印数据
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }

}
