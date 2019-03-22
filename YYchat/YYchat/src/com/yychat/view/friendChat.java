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
	
	//Center����
	JScrollPane jsp;
	JTextArea jta;

	//South����
	JPanel jp;
	JTextField jtf;//һ���ı�
	JButton jb;
	
	String sender;
	String receiver;
	
	public friendChat(String sender,String receiver){
		this.sender=sender;
		this.receiver=receiver;
		jta=new JTextArea();//�ı����򣬶����ı�
		jta.setEditable(false);
		jta.setForeground(Color.red);
		jsp=new JScrollPane(jta);
		this.add(jsp,"Center");
		
		jp=new JPanel();
		jtf=new JTextField(15);
		jb= new JButton("����");
		jb.addActionListener(this);
		jp.add(jtf);
		jp.add(jb);
		this.add(jp,"South");
		
		this.setSize(350,240);//���ڴ�С
		this.setTitle(sender+"���ں�"+receiver+"����");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);��������ˣ���Ϊ����֮��ͻ�ر�
	    this.setLocationRelativeTo(null);//������ʾ����);
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
			
			//�����������������Ϣ
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