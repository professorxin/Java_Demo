package shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class IniRealmTest {


    @Test
    public void Test(){
        IniRealm iniRealm=new IniRealm("classpath:user.ini");
        //构件SercurityManager的环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject= SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("asdfgh","123456");
        subject.login(token);
        System.out.println("认证是否成功:"+subject.isAuthenticated());

        //subject.logout();
        //System.out.println("认证是否成功:"+subject.isAuthenticated());

        subject.checkRoles("admin");
        subject.checkPermission("user:delete");
    }
}
