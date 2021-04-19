package cn.hstc.handler;

import cn.hstc.pojo.User;
import cn.hstc.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author chen
 * @crete 2021-04-18-19:24
 */
public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection
                                                               principalCollection) {
// 获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new
                SimpleAuthorizationInfo();
//// 给该用户设置角色，角色信息存在t_role表中取
//        authorizationInfo.setRoles(userService.getRoles(username));
        authorizationInfo.setRoles(null);
//// 给该用户设置权限，权限信息存在t_permission表中取
//        authorizationInfo.setStringPermissions(userService.getPermissions(username));
        authorizationInfo.setStringPermissions(null);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken
                                                                 authenticationToken) throws AuthenticationException {
// 根据token获取用户名，如果您不知道该该token怎么来的，先可以不管，下文会解释
        String username = (String) authenticationToken.getPrincipal();
// 根据用户名从数据库中查询该用户
        User user = userService.getByUsername(username);
        if (user != null) {
// 把当前用户存到session中
//            SecurityUtils.getSubject().getSession().setAttribute("user", user);
// 传入用户名和密码进行身份认证，并返回认证信息
            AuthenticationInfo authcInfo = new
                    SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "myRealm");

            return authcInfo;
        } else {
            return null;
        }
    }
}
