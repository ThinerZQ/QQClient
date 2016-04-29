
/**
 * 我的好友界面，黑名单，陌生人。
 */
package com.qq.client.view;
import java.awt.*;
import com.qq.client.tools.*;
import java.awt.event.*;

import javax.swing.*;
public class QqList  extends JFrame implements ActionListener,MouseListener{

	//定义
	//先处理第一张卡片
	JPanel jphy1,jphy2,jphy3;
	JButton jphy_jb1,jphy_jb2,jphy_jb3;
	JScrollPane jsp ;
	
	
	
	//处理第二章卡片（陌生人）
	JPanel jpmsr1,jpmsr2,jpmsr3;
	JButton jpmsr_jb1,jpmsr_jb2,jpmsr_jb3;
	JScrollPane jpmsr_jsp ;
	CardLayout cl = null;
	
	
	private String userId;
	
	public static void main(String[] args) {
		//QqList ql = new QqList();
	}
	
	public QqList(String userId) 
	{
		this.userId =userId;
		//处理第一个Panel(显示我的好友)
		jphy1 = new JPanel(new BorderLayout());
		
		jphy2 = new JPanel(new GridLayout(50,1,4,4));
		
		jphy3 = new JPanel(new GridLayout(2,1));
		
		jphy_jb1 = new JButton("我的好友");
		jphy_jb2 = new JButton("陌生人");
		jphy_jb2.addActionListener(this);
		jphy_jb3= new JButton("黑名单");
		
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);
		
		//给jpmsr_jb2初始化50个好友
		JLabel [] jbls = new JLabel[50];
		for(int i=0;i<jbls.length;i++)
		{
			jbls[i] = new JLabel(i+1+"",new ImageIcon("image/photo.jpg"),JLabel.LEFT);
			jbls[i].setEnabled(false);
			if(jbls[i].getText().equals(userId))
			{
				jbls[i].setEnabled(true);
			}
			jbls[i].addMouseListener(this);
			jphy2.add(jbls[i]);
		}
		
		jsp  = new JScrollPane(jphy2);
		
		jphy1.add(jphy_jb1,BorderLayout.NORTH);
		jphy1.add(jsp);
		jphy1.add(jphy3,BorderLayout.SOUTH);
		
		
		//处理第二个Panel（显示陌生人）
		jpmsr1 = new JPanel(new BorderLayout());
		
		jpmsr2 = new JPanel(new GridLayout(10,1,4,4));
		
		jpmsr3 = new JPanel(new GridLayout(2,1));
		
		jpmsr_jb1 = new JButton("我的好友");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2 = new JButton("陌生人");
		jpmsr_jb3= new JButton("黑名单");
		
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);
		
		//给jphy2初始化50个好友
		JLabel [] jbls2 = new JLabel[10];
		for(int i=0;i<jbls2.length;i++)
		{
			jbls2[i] = new JLabel(i+1+"",new ImageIcon("image/photo.jpg"),JLabel.LEFT);
			jpmsr2.add(jbls2[i]);
		}
		
		jpmsr_jsp  = new JScrollPane(jpmsr2);
		
		jpmsr1.add(jpmsr3,BorderLayout.NORTH);
		jpmsr1.add(jpmsr_jsp);
		jpmsr1.add(jpmsr_jb3,BorderLayout.SOUTH);
		
		
		//设置卡片式布局
		cl = new CardLayout();
		this.setLayout(cl);
		
		this.add(jphy1,"1");
		this.add(jpmsr1,"2");
		
		
		this.setSize(200,500);
		this.setTitle(userId);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo();
		this.setVisible(true);
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jphy_jb2)
		{
			cl.show(this.getContentPane(), "2");
		}
		else if(e.getSource()==jpmsr_jb1)
		{
			cl.show(this.getContentPane(), "1");
		}
		
	}


	public void mouseClicked(MouseEvent e) {
		//响应用户双击的事件并得到好友的编号
		if(e.getClickCount()==2)
		{
			//得到此好友的编号
			String friendId = ((JLabel)e.getSource()).getText();
			
			QqChat qc = new QqChat(friendId,this.userId);
			ManageQqChat.addQqChat(userId+" "+friendId, qc);
			
			System.out.println("你希望和"+friendId+"聊天");
		}
		
	}


	public void mouseEntered(MouseEvent e) {
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.red);
		
	}


	public void mouseExited(MouseEvent e) {
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.black);
		
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
