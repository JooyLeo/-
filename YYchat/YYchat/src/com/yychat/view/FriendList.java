package com.yychat.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class FriendList extends JFrame implements ActionListener,MouseListener{//顶层容器
 CardLayout cardLayout;//卡片布局
 
 JPanel myFriendPanel;
 JButton myFriendJButton;
 
 JScrollPane myFriendJScrollPane;
 JPanel myFriendListJPanel;
 static final int FRIENDCOUNT=51;
 JLabel[] myFriendJLabel=new JLabel[FRIENDCOUNT];//定义有错
 
 
 JPanel myFriendStrangerPanel1;
 JPanel myStrangerBlackListJPanel;
 JButton myStrangerJButton;
 JButton blackListJButton;
 
 JPanel myStrangerPanel;
 JPanel myblackListPanel;
 
 JPanel myFriendStrangerPanel;
 JButton myFriendJButton1;
 JButton myStrangerJButton1;
 JButton myFriendJButton2;
 JButton myStrangerJButton2;
 JButton blackListJButton1;
 JButton blackListJButton2;
 
 String userName;
 public FriendList(String userName){
	 this.userName=userName;//局部变量给成员变量的userName赋值
 
	 
	 //我的好友卡片
  
  myFriendPanel=new JPanel(new BorderLayout());//边界布局
  //System.out.printin(myFriendPanel.getLayou());
  
  myFriendJButton=new JButton("我的好友");
  myFriendPanel.add(myFriendJButton,"North");
  
  //中部组建
  myFriendListJPanel=new JPanel(new GridLayout(FRIENDCOUNT-1,1));
  for(int i=1;i<FRIENDCOUNT;i++){
   myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/YY1.gif"),JLabel.LEFT);
   myFriendJLabel[i].addMouseListener(this);//添加鼠标监听器
   myFriendListJPanel.add(myFriendJLabel[i]);
  }
  
  myFriendJScrollPane=new JScrollPane(myFriendListJPanel);
  myFriendPanel.add(myFriendJScrollPane);
  
  myStrangerBlackListJPanel=new JPanel(new GridLayout(2,1));//网络布局
  myStrangerJButton=new JButton("我的陌生人");
  //添加事件监听器
  myStrangerJButton.addActionListener(this);
  
  blackListJButton=new JButton("黑名单");
  blackListJButton.addActionListener(this);
  myStrangerBlackListJPanel.add(myStrangerJButton);
  myStrangerBlackListJPanel.add(blackListJButton);
  myFriendPanel.add(myStrangerBlackListJPanel,"South");
  
  //陌生人卡片
  
  myStrangerPanel = new JPanel(new BorderLayout());
  
  myFriendStrangerPanel=new JPanel(new GridLayout(2,1));
  myFriendJButton1=new JButton("我的好友");//添加监听器
  myFriendJButton1.addActionListener(this);
  blackListJButton1=new JButton("黑名单");
  blackListJButton1.addActionListener(this);
  
  myStrangerJButton1=new JButton("我的陌生人");
  myFriendStrangerPanel.add(myFriendJButton1);
  myFriendStrangerPanel.add(myStrangerJButton1);
  myStrangerPanel.add(myFriendStrangerPanel,"North");
  
  
  
  myStrangerPanel.add(blackListJButton1,"South");
  
  
  //黑名单卡片
  
  myFriendStrangerPanel1 =new JPanel(new BorderLayout());
  myFriendStrangerPanel1=new JPanel(new GridLayout(3,1));
  
  myblackListPanel=new JPanel(new BorderLayout());
  myFriendJButton2=new JButton("我的好友");
  myFriendJButton2.addActionListener(this);
  blackListJButton2=new JButton("黑名单");//添加监听器
  myStrangerJButton2=new JButton("我的陌生人");
  myStrangerJButton2.addActionListener(this);
  myFriendStrangerPanel1.add(myFriendJButton2);
  myFriendStrangerPanel1.add(myStrangerJButton2);
  myFriendStrangerPanel1.add(blackListJButton2);
  myblackListPanel.add(myFriendStrangerPanel1,"North");
  
  cardLayout=new CardLayout();
  this.setLayout(cardLayout);
  this.add(myFriendPanel,"1");
  this.add(myStrangerPanel,"2");
  this.add(myblackListPanel,"3");
  this.setSize(250,500);
  this.setTitle(userName+"的好友列表");
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setLocationRelativeTo(null);
  this.setVisible(true);
 }
 
 public static void main(String[] args){
  //FriendList friendList=new FriendList();
  
 }
 
 @Override
 public void actionPerformed(ActionEvent argo){
  if(argo.getSource()==myStrangerJButton){
   cardLayout.show(this.getContentPane(), "2");
  }
  if(argo.getSource()==blackListJButton){
    cardLayout.show(this.getContentPane(), "3");
    
   }
  ///////////////////////////////
  if(argo.getSource()==myFriendJButton1){
    cardLayout.show(this.getContentPane(), "1");
   }
  if(argo.getSource()==blackListJButton1){
    cardLayout.show(this.getContentPane(), "3");
   }
  if(argo.getSource()==myFriendJButton2){
    cardLayout.show(this.getContentPane(), "1");
   }
  if(argo.getSource()==myStrangerJButton2){
    cardLayout.show(this.getContentPane(), "2");
   }
 
  
 }
@Override
public void mouseClicked(MouseEvent arg0) {
 // TODO Auto-generated method stub
 
}
@Override
public void mouseEntered(MouseEvent e) {
 JLabel jLabel=(JLabel)e.getSource();
 jLabel.setForeground(Color.red);
 
}
@Override
public void mouseExited(MouseEvent e) {
 JLabel jLabel=(JLabel)e.getSource();
 jLabel.setForeground(Color.black);
 
}
@Override
public void mousePressed(MouseEvent arg0) {
 // TODO Auto-generated method stub
 
}
@Override
public void mouseReleased(MouseEvent arg0) {
	if(arg0.getClickCount()==2){
		JLabel jlbl=(JLabel)arg0.getSource();
		String receiver=jlbl.getText();
		arg0.getSource();
		new friendChat(this.userName,receiver);
	}
 
}
}