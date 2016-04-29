/**
 * 验证用户登录
 */


package com.qq.client.model;
import com.qq.common.*;
public class QqClientUser {

	public boolean checkUser(User u)
	{
		
		
		return new QqClientConnectionServer().sendUserMassageToServer(u);
	}
}
