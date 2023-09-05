import javax.swing.*;
import java.awt.event.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class login1 implements ActionListener
{
    JTextField t1,t2;
    JButton b;
    login1()
    {
        JFrame frame = new JFrame("LOGIN");
        t1 = new JTextField();
        t2 = new JTextField();
        b = new JButton("Submit");
        b.addActionListener(this); 
        t1.setBounds(50,50,500,30);  
        t2.setBounds(50,150,500,30);  
        t2.setEditable(false);
        b.setBounds(50, 100, 90, 30);
        frame.add(t1);
        frame.add(t2);
        frame.add(b);
        frame.setSize(600,300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public String findDigest(String s)
    {
        try{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(s.getBytes());
        byte[] digest = md.digest();      
        System.out.println(digest);
        StringBuffer hexString = new StringBuffer();
      
        for (int i = 0;i<digest.length;i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        System.out.println(hexString.toString());
        return hexString.toString();
    }
    catch(NoSuchAlgorithmException e)
    {
        return "Oops!!";
    }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String s1 = t1.getText();
        String s2 = findDigest(s1);
        t2.setText(s2);
    }
    public static void main(String args[]) throws Exception
    {
        new login1();
        
    }
}
