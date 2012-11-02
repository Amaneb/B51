package mapeditorv3;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameTexture extends JFrame implements ActionListener {
    private JPanel jPanel1 = new JPanel();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JButton jButton4 = new JButton();
    private JButton jButton5 = new JButton();
  private FlowLayout flowLayout1 = new FlowLayout();
    private Controller parent;
  private JButton jButton6 = new JButton();
    private JButton jButton7 = new JButton();
    private JButton jButton8 = new JButton();
    private JButton jButton9 = new JButton();

    public FrameTexture(Controller c) {
        parent = c;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setTitle("Textures");
        this.setSize(new Dimension(195, 385));
        this.setLocation((parent.getColumn()*15)+20, 0);
        jPanel1.setBounds(new Rectangle(0, 0, 150, 315));
        jPanel1.setLayout(flowLayout1);
        jButton1.setText("Walkable floor");
        jButton2.setText("Non-walkable floor");
        jButton3.setText("Wall");
        jButton4.setText("Door");
        jButton5.setText("Zone1");
        jButton6.setText("Zone2");
        jButton7.setText("Zone3");
        jButton8.setText("Zone4");
        jButton9.setText("Coffre");
    
        jPanel1.add(jButton1, null);
        jPanel1.add(jButton2, null);
        jPanel1.add(jButton3, null);
        jPanel1.add(jButton4, null);
        jPanel1.add(jButton5, null);
        jPanel1.add(jButton6, null);
        jPanel1.add(jButton7, null);
        jPanel1.add(jButton8, null);
        jPanel1.add(jButton9, null);
        this.getContentPane().add(jPanel1, null);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
        jButton6.addActionListener(this);
        jButton7.addActionListener(this);
        jButton8.addActionListener(this);
        jButton9.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton)e.getSource();
        
        if(jb.getText().equals(jButton1.getText()))
            parent.getModele().setTile('0');
        else if(jb.getText().equals(jButton2.getText()))
            parent.getModele().setTile(' ');
        else if(jb.getText().equals(jButton3.getText()))
            parent.getModele().setTile('1');
        else if(jb.getText().equals(jButton4.getText()))
            parent.getModele().setTile('2');
        else if(jb.getText().equals(jButton5.getText()))
            parent.getModele().setTile('v');
        else if(jb.getText().equals(jButton6.getText()))
            parent.getModele().setTile('b');
        else if(jb.getText().equals(jButton7.getText()))
            parent.getModele().setTile('n');
        else if(jb.getText().equals(jButton8.getText()))
            parent.getModele().setTile('m');
        else if(jb.getText().equals(jButton9.getText()))
            parent.getModele().setTile('3');
    }
}
