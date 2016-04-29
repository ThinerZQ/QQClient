/**
 * 这是与好友的聊天界面
 * 因为客户端处于读取状态，所以作为线程
 */

package com.qq.client.view;

import java.awt.*;
import com.qq.client.tools.*;
import java.awt.event.*;

import javax.swing.*;
import com.qq.common.*;
import java.io.*;
public class QqChat extends JFrame implements ActionListener{

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	
	String userId;
	String friendId;
	Massage m;
	public static void main(String[] args) {
		
		//QqChat qc = new QqChat("1");

	}
	public QqChat(String friendId,String userId){
		
		this.friendId=friendId;
		this.userId = userId;
		jta = new JTextArea();
		jtf = new JTextField(20);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta);
		this.add(jp,BorderLayout.SOUTH);
		
		this.setSize(400,300);
		this.setTitle(userId+" 正在和  "+friendId+" 聊天");
		this.setIconImage(new ImageIcon("image/qq.jpg").getImage());
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//写一个方法，显示消息
	public void showMassage(Massage m)
	{
		String info = m.getSender()+" 对 "+m.getGetter()+" 说  "+m.getNews()+"   "+m.getSendTime()+"\r\n";
		this.jta.append(info);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb)
		{
			String info = this.userId+" 对 "+this.friendId+" 说 "+jtf.getText();
			this.jta.append(info);
			
			Massage m = new Massage();
			m.setSender(this.userId);
			m.setGetter(this.friendId);
			m.setNews(this.jtf.getText());
			m.setSendTime(new java.util.Date().toString());
			//发送给服务器
			try {
				

				ObjectOutputStream oos = new ObjectOutputStream
				(ManageClientConnectServerThread.getClientConnectServerThread(userId).getS().getOutputStream());
				oos.writeObject(m);
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		
	}
	
	

}
