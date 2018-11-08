package realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    HashMap<String,String> hashMap=new HashMap<String, String>();
    Set<String> set=new HashSet<String>();

    //存储了账号和md5和盐值加密后的密码
    {
        hashMap.put("asdfgh","003dc55c5d91addfead4a4fa347c4f2d");
        //可以先忽略这个
        super.setName("abc");
    }


    //取出所需的角色和权限，构建simpleAuthorizationInfo对象返回，进行权限认证
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name= (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles=getRoleByName(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }


    //存储了账号和对应的角色
    private Set<String> getRoleByName(String name) {
        Set<String> set=new HashSet<String>();
        set.add("admin");
        return set;
    }



    //取出所需的密码，构建simpleAuthenticationInfo对象返回，与UsernamePasswordToken进行认证对比
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name= (String) authenticationToken.getPrincipal();
        String password=getPasswordByname(name);
        if(password==null){
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(name,password,"abc");
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("asdfgh"));
        return simpleAuthenticationInfo;
    }

    private String getPasswordByname(String name) {
        String password=hashMap.get(name);
        return password;
    }


    //003dc55c5d91addfead4a4fa347c4f2d这个密码就是从这里的出来的
    public static void main(String agrs[]){
        Md5Hash md5Hash=new Md5Hash("123456","asdfgh");
        System.out.println(md5Hash.toString());
    }
}
