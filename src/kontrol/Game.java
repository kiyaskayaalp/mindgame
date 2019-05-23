/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrol;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Box;

/**
 *
 * @author Kıyas
 */
public class Game {
    static int gamepuan=0;
    private static  int tiklama=1;
    private static Box box1,box2;
    public static void karsilastir(Box box)
    {
        if(tiklama==1)
        {
            tiklama=2;
            box.setText(box.getDeger());
            box1=box;
            
        }
        else if(tiklama==2)
        {
            box2=box;
            tiklama=1;
            if(box1.getActionCommand().equalsIgnoreCase(box2.getActionCommand()))
            {
                box1.setText("");
                box2.setText("");
                box1.setSelected(false);
                box2.setSelected(false);
                
            }
            else if(box1.getDeger().equalsIgnoreCase(box2.getDeger()))
            {
                box2.setText(box2.getDeger());
                box1.setEnabled(false);
                box2.setEnabled(false);
                box1.setDurum(false);
                box2.setDurum(false);
                gamepuan+=50;
            }
            else
            {
                box1.setText("");
                box2.setText("");
                box1.setSelected(false);
                box2.setSelected(false);
                gamepuan-=20;
            }
            
        }
    }
    
    public static void gameEndControl(ArrayList boxes)
    {
         Box k=null;
         int bul=0;
       
        for(int i=0; i<boxes.size(); i++)
        {
            k=(Box)boxes.get(i);
            if(k.isDurum())
                bul=1;
            
        }
        if(bul==0)
        {
            gamepuan=gamepuan*boxes.size();
            TimeControl.zamaniDurdur();
            JOptionPane jop1=new JOptionPane("Oyun Bitti",JOptionPane.INFORMATION_MESSAGE,JOptionPane.DEFAULT_OPTION);
            JDialog dlg1=jop1.createDialog("Mesaj");
            dlg1.setVisible(true);
        }
            
        
    }
    
}
