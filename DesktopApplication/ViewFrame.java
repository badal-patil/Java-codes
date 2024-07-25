import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewFrame extends JFrame{
Container c;
TextArea txtData;
JButton btnBack;
JPanel p1,p2;

ViewFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1=new JPanel();
txtData=new TextArea(4,25);
p1.add(txtData);
c.add(p1);
txtData.addKeyListener(new L1());

p2=new JPanel();
btnBack=new JButton("BACK");
p2.add(btnBack);
c.add(p2);
btnBack.addKeyListener(new L2());

txtData.setText(new Db().viewStudent());

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame h=new HomeFrame();
dispose();
}
});

setSize(320,200);
setTitle("VIEW STUDENT");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}

class L1 implements KeyListener{
public void keyPressed(KeyEvent ke){
if(ke.getKeyCode()==KeyEvent.VK_TAB){
btnBack.requestFocus();
}}
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

}}}
public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}
}

}
