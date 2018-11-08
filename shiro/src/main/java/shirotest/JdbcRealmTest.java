package shirotest;

//import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class JdbcRealmTest {

/*    DruidDataSource dataSource=new DruidDataSource();

    {
        dataSource.setUrl("jdbc:mysql://localhost:3306/realm_test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }*/



    @Test
    public void Test(){

/*        JdbcRealm jdbcRealm=new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);
        String sql="select password from users where username=?";
        jdbcRealm.setAuthenticationQuery(sql);

        //构件SercurityManager的环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject= SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("asdfgh","123456");
        subject.login(token);
        System.out.println("认证是否成功:"+subject.isAuthenticated());

        //subject.logout();
        //System.out.println("认证是否成功:"+subject.isAuthenticated());

        subject.checkRoles("admin");
        subject.checkPermission("user:delete");*/
    }
}
