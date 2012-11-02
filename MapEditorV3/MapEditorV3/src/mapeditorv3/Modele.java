package mapeditorv3;

import javax.swing.JOptionPane;

public class Modele
{
  private char[][] matrice;
  private Controller parent;
  private char tile;
  public Modele(Controller c)
  {
    parent = c;
    tile = '0';
    matrice = new char[parent.getLine()][parent.getColumn()];
    
    for(int i=0,j=0; i<parent.getLine(); i++)
    {
      for(j=0 ; j<parent.getColumn(); j++)
      {
        matrice[i][j] = '0';
      }
    }
  }
  
  public void newFile()
  {
      String rep;
      rep = JOptionPane.showInputDialog("Enter number of column");
        parent.setColumn(Integer.parseInt(rep));
        
        rep = JOptionPane.showInputDialog("Enter number of line");
        parent.setLine(Integer.parseInt(rep));
      matrice = new char[parent.getLine()][parent.getColumn()];
    for(int i=0,j=0; i<parent.getLine(); i++)
    {
      for(j=0 ; j<parent.getColumn(); j++)
      {
        matrice[i][j] = '0';
      }
    }
  }
  
  public void openFile(String name)
  {
    ReadFile rf = new ReadFile(this);
    rf.readFile(name);
  }
  
  public void saveAs(String name)
  {
    WriteFile wf = new WriteFile(this);
    wf.writeFile(name);
  }
  
  public void save(String name)
  {
    WriteFile wf = new WriteFile(this);
    wf.writeFile(name);
  }
  
  public void newMatrice(char[][] matrice, int line, int column){
      this.matrice = new char[line][column];
      this.matrice = matrice;
  }
  
  public void setMatrice(int line, int column)
  {
    this.matrice[line][column] = tile;
  }
  
  public void setTile(char tile){
      this.tile = tile;
  }
  
  public char getTile(){
      return tile;
  }
  
  public Controller getParent()
  {
    return parent;
  }
  
  public char[][] getMatrice()
  {
    return matrice;
  }
}
