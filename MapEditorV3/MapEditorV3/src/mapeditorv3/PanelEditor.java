package mapeditorv3;

import java.awt.Color;

import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelEditor
  extends JPanel
{
  private FrameEditor parent;
  public PanelEditor(FrameEditor fe)
  {
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    parent = fe;
  }

  private void jbInit()
    throws Exception
  {
    this.setLayout( null );
    this.setBackground(Color.white);
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    drawSquare(g);
  }
  public void drawSquare(Graphics g)
  {
    char[][] matrice = parent.getMatrice();
    
      for(int i=0,j=0,x=0,y=0; i<parent.getLine(); i++, y+=15)
      {
        for(j=0, x=0; j<parent.getColumn(); j++, x+=15)
        {
          
          if(matrice[i][j] == ' ')
          {//Non-walkable floor
            g.setColor(new Color(0,0,0));
          }
          else if(matrice[i][j] == '0')
          {//Walkable floor
            g.setColor(new Color(255,255,255));
          }
          else if(matrice[i][j] == '1')
          {//Wall going up
            g.setColor(new Color(255,0,0));
          }
          else if(matrice[i][j] == '2')
          {//Door
            g.setColor(new Color(0,255,0));
          }
          else if(matrice[i][j] == 'v')
          {//Zone1
            g.setColor(new Color(0,255,255));
          }          
          else if(matrice[i][j] == 'b')
          {//Zone2
            g.setColor(new Color(0,215,255));
          }
            else if(matrice[i][j] == 'n')
            {//Zone3
              g.setColor(new Color(0,175,255));
            }
            else if(matrice[i][j] == 'm')
            {//Zone4
              g.setColor(new Color(0,135,255));
            }
          else if(matrice[i][j] == '3')
          {//Zone
            g.setColor(new Color(128,64,0));
          }
          
          g.fillRect(x+1, y+1, 14, 14);
          g.setColor(Color.BLACK);
          g.drawRect(x, y, 15, 15);
        }
      }
    
  }
}
