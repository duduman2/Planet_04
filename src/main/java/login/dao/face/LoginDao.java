package login.dao.face;

import java.sql.Connection;

import dto.UserInfo;

public interface LoginDao {

	int selectCntUserInfoByU_idU_pw(Connection conn, UserInfo userinfo);

	UserInfo selectUserInfoByU_id(Connection conn, UserInfo userinfo);

	int insert(Connection conn, UserInfo userinfo);

	


}
