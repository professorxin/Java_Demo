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

    {
        hashMap.put("asdfgh","1c0f159ddeb7dca24ee3be653a2614d1");
        super.setName("abc");
    }


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name= (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles=getRoleByName(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }


    private Set<String> getRoleByName(String name) {
        Set<String> set=new HashSet<String>();
        set.add("admin");
        return set;
    }



    //从数据库中取出所需的，构建simpleAuthenticationInfo对象返回，与UsernamePasswordToken对比
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name= (String) authenticationToken.getPrincipal();
        String password=getPasswordByname(name);
        if(password==null){
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(name,password,"abc");
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(""));
        return simpleAuthenticationInfo;
    }

    private String getPasswordByname(String name) {
        String password=hashMap.get(name);
        return password;
    }

    public static void main(String agrs[]){
        Md5Hash md5Hash=new Md5Hash("123456","opp");
        System.out.println(md5Hash.toString());
    }
}
