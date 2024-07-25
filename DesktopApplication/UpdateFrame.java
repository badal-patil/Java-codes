import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UpdateFrame extends JFrame{
Container c;
JLabel lblRno,lblName;
JTextField txtRno,txtName;
JButton btnSave,btnBack;
JPanel p1,p2;

UpdateFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1=new JPanel();
lblRno=new JLabel("RNO.");
txtRno=new JTextField(3);
lblName=new JLabel("NAME");
txtName=new JTextField(10);
p1.add(lblRno);
p1.add(txtRno);
p1.add(lblName);
p1.add(txtName);
c.add(p1);

p2=new JPanel();
btnSave=new JButton("SAVE");
btnBack=new JButton("BACK");
p2.add(btnSave);
p2.add(btnBack);
c.add(p2);

btnSave.addKeyListener(new L1());
btnBack.addKeyListener(new L2());

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
try{
String name=txtName.getText();
String rno=txtRno.getText();
if(name.length()==0){
JOptionPane.showMessageDialog(new JDialog(),"INVALID DETAILS");
txtRno.setText("");
txtName.setText("");
txtRno.requestFocus();
}
else{
new Db().addStudent(Integer.parseInt(rno),name);
}
}

catch(Exception e){
JOptionPane.showMessageDialog(c,"INVALID DETAILS");
txtRno.setText("");
txtName.setText("");
txtRno.requestFocus();
}
}
});

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame h=new HomeFrame();
dispose();
}
});

setSize(320,200);
setTitle("UPDATE STUDENT");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

class L1 implements KeyListener{
public void keyPressed(KeyEvent ke){
if(ke.getKeyCode()==KeyEvent.VK_ENTER){
try{
String name=txtName.getText();
String rno=txtRno.getText();
if(name.length()==0){
JOptionPane.showMessageDialog(new JDialog(),"INVALID DETAILS");
txtRno.setText("");
txtName.setText("");
txtRno.requestFocus();
}
else{
new Db().addStudent(Integer.parseInt(rno),name);
}}
catch(Exception e){
JOptionPane.showMessageDialog(c,"INVALID DETAILS");
txtRno.setText("");
txtName.setText("");
txtRno.requestFocus();
}}}
public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}
}

class L2 implements KeyListener{
public void keyPressed(KeyEvent ke){
if(ke.getKeyCode()==KeyEvent.VK_ENTER){
try{
HomeFrame h=new HomeFrame();
dispose();
}
catch(Exception e){
JOptionPane.showMessageDialog(c,"INVALID DETAILS");
txtRno.setText("");
txtName.setText("");
txtRno.requestFocus();
}}}
public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}
}

}
