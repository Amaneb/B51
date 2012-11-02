package mapeditorv3;

import javax.swing.JFrame;

public class Controller
{
  private int line, column;
  private Modele m;
  private FrameEditor frameEditor;
  private FrameTexture frameTexture;
  
  public Controller()
  {
    String rep;
    try{
      /*rep = JOptionPane.showInputDialog("Enter number of column");
      column = Integer.parseInt(rep);
      
      rep = JOptionPane.showInputDialog("Enter number of line");
      line = Integer.parseInt(rep);*/
        column = 30;
        line = 20;
      m = new Modele(this);
      frameEditor = new FrameEditor(this);
        frameEditor.setLocation(0,0);
      
      frameEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTexture = new FrameTexture(this);
        frameTexture.setVisible(true);
        frameTexture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEditor.setVisible(true);
    }
    catch(NumberFormatException e)
    {
      System.exit(1);
    }
  }
  
  public void newFile()
  {
    m.newFile();
  }
  
  public void openFile(String name)
  {
    m.openFile(name);
  }
  
  public void saveAs(String name)
  {
    m.saveAs(name);
  }
  
  public void save(String name)
  {
    m.save(name);
  }
  
  public void setMatrice(int line, int column)
  {
    m.setMatrice(line, column);
  }
  
  public void setLine(int line){
      this.line = line;
  }
  
    public void setColumn(int column){
        this.column = column;
    }
  
    public FrameEditor getFrameEditor(){
        return frameEditor;
    }

    public FrameTexture getFrameTexture(){
        return frameTexture;
    }
    
    public Modele getModele(){
        return m;
    }
  
  public char[][] getMatrice()
  {
    return m.getMatrice();
  }
   
  public int getLine()
  {
    return line;
  }
  
  public int getColumn()
  {
    return column;
  }
}
