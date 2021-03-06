package com.yychat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;

import com.yychat.model.Message;
import com.yychatclient.control.ClientConnect;

public class friendChat extends JFrame implements ActionListener{
	
	//Center部分
	JScrollPane jsp;
	JTextArea jta;

	//South部分
	JPanel jp;
	JTextField jtf;//一行文本
	JButton jb;
	
	String sender;
	String receiver;
	
	public friendChat(String sender,String receiver){
		this.sender=sender;
		this.receiver=receiver;
		jta=new JTextArea();//文本区域，多行文本
		jta.setEditable(false);
		jta.setForeground(Color.red);
		jsp=new JScrollPane(jta);
		this.add(jsp,"Center");
		
		jp=new JPanel();
		jtf=new JTextField(15);
		jb= new JButton("发送");
		jb.addActionListener(this);
		jp.add(jtf);
		jp.add(jb);
		this.add(jp,"South");
		
		this.setSize(350,240);//窗口大小
		this.setTitle(sender+"正在和"+receiver+"聊天");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);不用这个了，因为发送之后就会关闭
	    this.setLocationRelativeTo(null);//居中显示窗口);
	    this.setVisible(true);
	}
	public static void main(String[] args) {
		friendChat friendChat=new friendChat("1","2");
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb){
			jta.append(jtf.getText()+"\r\n");
			
			//向服务器发送聊天信息
			Message mess=new Message();
			mess.setSender(sender);
			mess.setReceiver(receiver);
			mess.setContent(jtf.getText());
			mess.setMessageType(Message.message_Common);
			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(ClientConnect.s.getOutputStream());
				oos.writeObject(mess);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
