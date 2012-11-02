package mapeditorv3;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class FrameEditor extends JFrame implements KeyListener, MouseListener, ActionListener
{
  private Controller parent;
  private PanelEditor pe;
  private String fileName;
  private Timer time;
  private int x,y;
  private JMenuBar jMenuBar1 = new JMenuBar();
  private JMenu jMenu1 = new JMenu("File");
  private JMenuItem menuItem;
  private boolean shiftPressed;
  private double diffY, diffX;

    public FrameEditor(Controller c)
  {
    parent = c;
    pe = new PanelEditor(this);
    fileName = "";
    shiftPressed = false;
    diffY = 3.6; //4 à l'école, 3.6 chez Marco
    diffX = 0.6;
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit()
    throws Exception
  {
    this.getContentPane().setLayout( null );
    this.setSize( new Dimension((parent.getColumn()*15)+20, (parent.getLine()*15)+75) );
    //this.setSize( new Dimension((parent.getColumn()*15)+20, (parent.getLine()*15)+48) );
    this.setTitle("Map Editor");

    this.setJMenuBar(jMenuBar1);
        this.getContentPane().add(pe);
        pe.setLocation(0, 0);
        pe.setSize((parent.getColumn() * 15) + 5, (parent.getLine() * 15) + 5);
        pe.setVisible(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        MenuNew mn = new MenuNew();
        MenuOpen mo = new MenuOpen();
        MenuSaveAs msa = new MenuSaveAs();
        MenuSave ms = new MenuSave();

        jMenu1.setMnemonic(KeyEvent.VK_F);
        jMenuBar1.add(jMenu1);

        menuItem = new JMenuItem("New...", KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        menuItem.addActionListener(mn);
        jMenu1.add(menuItem);

        menuItem = new JMenuItem("Open...", KeyEvent.VK_O);
        menuItem.setMnemonic(KeyEvent.VK_O);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        menuItem.addActionListener(mo);
        jMenu1.add(menuItem);

        menuItem = new JMenuItem("Save As...");
        menuItem.setMnemonic(KeyEvent.VK_A);

        menuItem.addActionListener(msa);
        jMenu1.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        menuItem.addActionListener(ms);
        jMenu1.add(menuItem);
    }
  
  public void actionPerformed(ActionEvent e)
  {
    System.out.println("win");
  }

  public void keyTyped(KeyEvent e)
  {
  }

  public void keyPressed(KeyEvent e)
  {
      if(e.getKeyCode() == KeyEvent.VK_SHIFT){
          shiftPressed = true;
      }
  }

  public void keyReleased(KeyEvent e)
  {
      if(e.getKeyCode() == KeyEvent.VK_SHIFT){
          shiftPressed = false;
      }
  }

  public void mouseClicked(MouseEvent e)
  {
  }

  public void mousePressed(MouseEvent e)
  {
      if(((int)((x/15.0)-diffX)) == ((int)((e.getX()/15.0)-diffX)) || ((int)((y/15.0)-diffY)) == ((int)((e.getY()/15.0)-diffY))){
          if(shiftPressed) {
              if(((int)((x/15.0)-diffX)) == ((int)((e.getX()/15.0)-diffX))){
                  if(((int)((y/15.0)-diffY)) < ((int)((e.getY()/15.0)-diffY))){
                      for(int i=((int)((y/15.0)-diffY)), j=((int)((x/15.0)-diffX)); i<=((int)((e.getY()/15.0)-diffY)); i++){
                          parent.setMatrice(i, j);
                      }
                  }
                  else{
                      for(int i=((int)((y/15.0)-diffY)), j=((int)((x/15.0)-diffX)); i>=((int)((e.getY()/15.0)-diffY)); i--){
                          parent.setMatrice(i, j);
                      }
                  }
              }
              else if(((int)((y/15.0)-diffY)) == ((int)((e.getY()/15.0)-diffY))){
                  if(((int)((x/15.0)-diffX)) < ((int)((e.getX()/15.0)-diffX))){
                      for(int i=((int)((y/15.0)-diffY)), j=((int)((x/15.0)-diffX)); j<=((int)((e.getX()/15.0)-diffX)); j++){
                          parent.setMatrice(i, j);
                      }
                  }
                  else{
                      for(int i=((int)((y/15.0)-diffY)), j=((int)((x/15.0)-diffX)); j>=((int)((e.getX()/15.0)-diffX)); j--){
                          parent.setMatrice(i, j);
                      }
                  }
              }
              x = e.getX();
              y = e.getY();
          }
          else{
              x = e.getX();
              y = e.getY();
              parent.setMatrice(((int)((y/15.0)-diffY)), ((int)((x/15.0)-diffX)));
          }
      }
      else if(Math.abs(((int)((x/15.0)-diffX)) - ((int)((e.getX()/15.0)-diffX))) == Math.abs(((int)((y/15.0)-diffY)) - ((int)((e.getY()/15.0)-diffY)))){
          if(shiftPressed) {
              if(((int)((x/15.0)-diffX)) < ((int)((e.getX()/15.0)-diffX))){
                  if(((int)((y/15.0)-diffY)) < ((int)((e.getY()/15.0)-diffY)))
                      for(int i=((int)((y/15.0)-diffY)), j=((int)((x/15.0)-diffX)); i <= ((int)((e.getY()/15.0)-diffY)); i++, j++){
                          parent.setMatrice(i, j);                  
                      }
                    else
                      for(int i=((int)((y/15.0)-diffY)), j=((int)((x/15.0)-diffX)); i >= ((int)((e.getY()/15.0)-diffY)); i--, j++){
                          parent.setMatrice(i, j);                 
                      }
              }
              else{
                  if(((int)((y/15.0)-diffY)) < ((int)((e.getY()/15.0)-diffY)))
                    for(int i=((int)((y/15.0)-diffY)), j=((int)((x/15.0)-diffX)); i <= ((int)((e.getY()/15.0)-diffY)); i++, j--){
                          parent.setMatrice(i, j);                 
                    }
                  else
                    for(int i=((int)((y/15.0)-diffY)), j=((int)((x/15.0)-diffX)); i >= ((int)((e.getY()/15.0)-diffY)); i--, j--){
                          parent.setMatrice(i, j);                
                    }
                  
            }
              x = e.getX();
              y = e.getY();
      } 
          else{
              x = e.getX();
              y = e.getY();
              parent.setMatrice(((int)((y/15.0)-diffY)), ((int)((x/15.0)-diffX)));
          }
      }
      else{
          x = e.getX();
          y = e.getY();
          parent.setMatrice(((int)((y/15.0)-diffY)), ((int)((x/15.0)-diffX)));
      }
    repaint();
  }

  public void mouseReleased(MouseEvent e)
  {
  }

  public void mouseEntered(MouseEvent e)
  {
  }

  public void mouseExited(MouseEvent e)
  {
  }

  public int getLine()
  {
    return parent.getLine();
  }
  
  public int getColumn()
  {
    return parent.getColumn();
  }
  
  public char[][] getMatrice()
  {
    return parent.getMatrice();
  }
  private class MenuNew implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      fileName = "";
      parent.newFile();
      FrameEditor.this.setSize((parent.getColumn()*15)+20, (parent.getLine()*15)+75);
      parent.getFrameTexture().setLocation((parent.getColumn()*15)+20, 0);
        pe.setSize((parent.getColumn()*15)+5, (parent.getLine()*15)+5);
      pe.repaint();
      pe.repaint();
    }
  }
  private class MenuOpen implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
        fileName = JOptionPane.showInputDialog("Enter file name");
      parent.openFile(fileName);
      FrameEditor.this.setSize((parent.getColumn()*15)+20, (parent.getLine()*15)+75);
        parent.getFrameTexture().setLocation((parent.getColumn()*15)+20, 0);
        pe.setSize((parent.getColumn()*15)+5, (parent.getLine()*15)+5);
      pe.repaint();
    }
  }
  private class MenuSaveAs implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
        fileName = JOptionPane.showInputDialog("Enter file name");
      parent.saveAs(fileName);
    }
  }
  private class MenuSave implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if(fileName.length() != 0)
        parent.save(fileName);
      else{
        fileName = JOptionPane.showInputDialog("Enter file name");
        parent.saveAs(fileName);
      }
        
    }
  }
}
