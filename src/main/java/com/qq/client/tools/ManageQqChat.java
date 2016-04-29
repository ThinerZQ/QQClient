/**
 * 这是管理QQ聊天界面的类
 */

package com.qq.client.tools;
import java.util.*;
import com.qq.client.view.*;
public class ManageQqChat {

	private static HashMap hm = new HashMap<String, QqChat>();
	//加入
	public static void addQqChat(String userIdFriendId,QqChat qqChat)
	{
		hm.put(userIdFriendId, qqChat);
	}
	
	//取出
	public static QqChat getQqChat(String userIdFriendId)
	{
		return (QqChat)hm.get(userIdFriendId);
	}
}
