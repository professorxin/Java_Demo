package shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import realm.CustomRealm;

public class CustomRealmTest {

    @Test
    public void Test(){

        CustomRealm customRealm=new CustomRealm();
        //构件SercurityManager的环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        //设置自定义的Realm
        defaultSecurityManager.setRealm(customRealm);

        //加密
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher);

        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject= SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("asdfgh","123456");
        subject.login(token);
        System.out.println("认证是否成功:"+subject.isAuthenticated());

        subject.checkRoles("admin");
    }
}
