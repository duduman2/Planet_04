package login.service.face;

import javax.servlet.http.HttpServletRequest;

import dto.UserInfo;

public interface LoginService {

	public UserInfo getJoinUserInfo(HttpServletRequest req);

	public void join(UserInfo userinfo);

	public UserInfo getLoginUserInfo(HttpServletRequest req);

	public boolean login(UserInfo userInfo);

	public UserInfo info(UserInfo userInfo);

	

}
