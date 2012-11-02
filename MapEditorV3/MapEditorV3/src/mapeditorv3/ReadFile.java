package mapeditorv3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile
{
  private Modele parent;
  public ReadFile(Modele m)
  {
    parent = m;
  }
  
  public void readFile(String fileName)
  {
      int lines=20, columns=30;
    
    BufferedReader br = null;
    String textLine = null;
    String[] columnLine = new String[2];
    
    try{
        try{
            br = new BufferedReader(new FileReader(fileName+ ".mp"));
          
          textLine = br.readLine();
          columnLine = textLine.split(":");
          columns = Integer.parseInt(columnLine[0]);
          lines = Integer.parseInt(columnLine[1]);
          br.readLine();
          br.readLine();
          
          
          char[][] matrice = new char[lines][columns];
          
            textLine = br.readLine();
          
            parent.getParent().setColumn(columns);
            parent.getParent().setLine(lines);
            
            int i=0;
            while(textLine != null){
                for(int j=0; j<columns; j++){
                    matrice[i][j] = textLine.charAt(j);
                }
                textLine = br.readLine();
              
                i++;
            }
            parent.newMatrice(matrice, parent.getParent().getLine(), parent.getParent().getColumn());
        }
        finally{
            br.close();
        }
    }catch(FileNotFoundException fne){
        parent.newFile();    
    }catch(IOException e){
        e.printStackTrace();
    }
  }
  
}
