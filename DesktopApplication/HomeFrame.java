import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;

class HomeFrame extends JFrame{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;


HomeFrame(){

c=getContentPane();
c.setLayout(new FlowLayout());
btnAdd=new JButton("ADD");
btnView=new JButton("VIEW");
btnUpdate=new JButton("UPDATE");
btnDelete=new JButton("DELETE");
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
btnAdd.addKeyListener(new L1());
btnView.addKeyListener(new L2());
btnUpdate.addKeyListener(new L3());
btnDelete.addKeyListener(new L4());
this.addWindowListener(new L5());

setSize(320,200);
setTitle("STUDENT MANAGEMENT SYSTEM");
setLocationRelativeTo(null);
this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
setVisible(true);

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
AddFrame a=new AddFrame();
dispose();
}
});

btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
ViewFrame v=new ViewFrame();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
UpdateFrame u=new UpdateFrame();
dispose();
}
});

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
DeleteFrame d=new DeleteFrame();
dispose();
}
});

}

public static void main(String args[]){
HomeFrame h=new HomeFrame();
}

class L1 implements KeyListener{
public void keyPressed(KeyEvent ke){
if(ke.getKeyCode()==KeyEvent.VK_ENTER){
try{
AddFrame a=new AddFrame();
dispose();
}
catch(Exception e){
}}}
public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}
}

class L2 implements KeyListener{
public void keyPressed(KeyEvent ke){
if(ke.getKeyCode()==KeyEvent.VK_ENTER){
try{
ViewFrame v=new ViewFrame();
dispose();
}
catch(Exception e){
}}}
public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}
}

class L3 implements KeyListener{
public void keyPressed(KeyEvent ke){
if(ke.getKeyCode()==KeyEvent.VK_ENTER){
try{
UpdateFrame u=new UpdateFrame();
dispose();
}
catch(Exception e){
}}}
public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}
}

class L4 implements KeyListener{
public void keyPressed(KeyEvent ke){
if(ke.getKeyCode()==KeyEvent.VK_ENTER){
try{
DeleteFrame d=new DeleteFrame();
dispose();
}
catch(Exception e){
}}}
public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}
}

class L5 implements WindowListener{
public void windowActivated(WindowEvent e){}
public void windowDeactivated(WindowEvent e){}
public void windowOpened(WindowEvent e){}
public void windowClosed(WindowEvent e){}
public void windowClosing(WindowEvent e){
int output=JOptionPane.showConfirmDialog(c,"Do you want to Exit");
if(output==JOptionPane.YES_OPTION){
	System.exit(1);
}
else{btnAdd.requestFocus();}

}
public void windowIconified(WindowEvent e){}
public void windowDeiconified(WindowEvent e){}
}
}

class Db{

public void addStudent(int rno,String name){
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="insert into student values(?,?)";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1,rno);
pst.setString(2,name);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"records inserted");
con.close();
}
catch(SQLException se){
JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}
}

public String viewStudent(){
StringBuffer sb=new StringBuffer();
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
Statement stmt=con.createStatement();
String sql="select * from student";
ResultSet rs=stmt.executeQuery(sql);
while(rs.next()){
sb.append("Rno :"+rs.getInt(1)+" Name:"+rs.getString(2)+"\n");
}
con.close();
}
catch(SQLException se){
JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}
return sb.toString();
}

public void updateStudent(String name,int rno){
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="update student set name=? where rno=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,name);
pst.setInt(2,rno);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"records updated");
con.close();
}
catch(SQLException se){
JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}
}

public void deleteStudent(int rno){
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="delete from student where rno=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1,rno);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"records deleted");
con.close();
}
catch(SQLException se){
JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}
}


}
