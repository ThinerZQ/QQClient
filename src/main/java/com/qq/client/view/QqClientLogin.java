/**
 * qq客户端登陆界面
 */
package com.qq.client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Vector;

import javax.swing.*;

import com.qq.client.model.QqClientUser;
import com.qq.common.*;
public class QqClientLogin extends JFrame implements ActionListener{

	//定义北部需要的组件
	JLabel jbl1;
	
	//定义中部需要的组件
	//选项卡窗口
	//JTabbedPane jtp;
	JPanel jp2,jp3,jp4,jp5;
	JLabel jp2_jbl1 ,jp2_jbl2,jp2_jbl3,jp2_jbl4,jp2_jbl5,jp2_jbl6;
	
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;
	JComboBox jcb;
	
	
	//定义南部需要的组件
	JPanel jp1 ;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	public static void main(String[] args) {
		
		QqClientLogin qcl = new QqClientLogin();
	}
	public QqClientLogin()
	{
		//处理北部
		jbl1 = new JLabel(new ImageIcon(getUrl("image/QQ.jpg")));

		
		//处理南部
		jp1 = new JPanel();
		
		jp1_jb1 = new JButton(new ImageIcon(getUrl("image/denglu.jpg")));
		jp1_jb1.addActionListener(this );
		
		
		jp1_jb1.setPreferredSize(new Dimension(68, 21));
		jp1_jb2 = new JButton(new ImageIcon(getUrl("image/shezhi.jpg")));
		jp1_jb2.setPreferredSize(new Dimension(69, 22));
		jp1_jb3 = new JButton(new ImageIcon(getUrl("image/duozhanghao.jpg")));
		jp1_jb3.setPreferredSize(new Dimension(69, 21));
		
		//把三个按钮放入到jp1下面
		jp1.add(jp1_jb3,FlowLayout.LEFT);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb1,FlowLayout.RIGHT);
		
		//处理中部
		jp2 = new JPanel(new GridLayout(3,3)); 
		jp5 = new JPanel(new BorderLayout());
		
		jp2_jbl1 = new JLabel("QQ号码",JLabel.CENTER);
		
		jp2_jbl2 = new JLabel("QQ密码",JLabel.CENTER);
		jp2_jbl3 = new JLabel("忘记密码",JLabel.CENTER);
		jp2_jbl4 = new JLabel("自动登陆",JLabel.CENTER);
		jp2_jbl5 = new JLabel("申请QQ号",JLabel.CENTER);
		jp2_jbl6 = new JLabel(new ImageIcon(getUrl("image/touxiang.jpg")));
		
		
		jp2_jtf = new JTextField();
		jp2_jpf = new JPasswordField();
		
		jp2_jcb1 = new JCheckBox("自动登陆");
		jp2_jcb2 = new JCheckBox("记住密码");
		
		Vector item = new Vector();
		
		item.add(new ImageIcon(getUrl("image/shangxian.jpg")));
		item.add(new ImageIcon(getUrl("image/Qwoba.jpg")));
		item.add(new ImageIcon(getUrl("image/likai.jpg")));
		item.add(new ImageIcon(getUrl("image/manglu.jpg")));
		item.add(new ImageIcon(getUrl("image/qingwudarao.jpg")));
		item.add(new ImageIcon(getUrl("image/yinsheng.jpg")));
		jcb = new JComboBox(item);
		
		//按书序加入到jp2
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jbl5);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jcb);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jcb1);
		jp5.add(jp2_jbl6,BorderLayout.WEST);
		jp5.add(jp2,BorderLayout.CENTER);
		
		//创建选项卡窗口
		//jtp = new JTabbedPane();
		//jtp.add("QQ号码",jp2);
		//jp3 = new JPanel();
		//jp4 = new JPanel();
		//jtp.add("手机号码",jp3);
		//jtp.add("电子邮件",jp4);
		
		
		this.add(jbl1,BorderLayout.NORTH);
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jp5,BorderLayout.CENTER);
		this.setSize(392,262);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jp1_jb1)
		{
			QqClientUser qcu = new QqClientUser();
			User u = new User();
			u.setUserId(jp2_jtf.getText().trim());
			u.setPassWord(new String(jp2_jpf.getPassword()));
			if(qcu.checkUser(u))
			{
				QqList ql = new QqList(u.getUserId());
				this.dispose();
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "username or password error");
			}
		}
		
	}
	private URL getUrl(String filename){
		return this.getClass().getClassLoader().getResource(filename);
	}

}
