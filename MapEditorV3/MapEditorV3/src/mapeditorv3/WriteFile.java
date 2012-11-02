package mapeditorv3;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import javax.swing.JOptionPane;

public class WriteFile
{
  private Modele parent;
  public WriteFile(Modele m)
  {
    parent = m;
  }
  
  public void writeFile(String fileName)
  {
    char[][] matrice = parent.getMatrice();
    BufferedWriter bfw = null;
    try
    {
      try{
          String rep = "";
        bfw = new BufferedWriter(new FileWriter(fileName+".mp"));
        bfw.write(parent.getParent().getColumn() + ":"+parent.getParent().getLine());
          bfw.newLine();
        bfw.newLine();
        bfw.newLine();
        for(int i=0, j=0; i<parent.getParent().getLine(); i++){
          for(j=0; j<parent.getParent().getColumn(); j++){
            bfw.write(matrice[i][j]);
          }
            if(i+1<parent.getParent().getLine())
                bfw.newLine();
        }
      }
      finally
      {
        bfw.close();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
