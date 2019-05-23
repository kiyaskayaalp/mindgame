/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinleyici;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import kontrol.Game;
import model.Box;

/**
 *
 * @author Kıyas
 */
public class ButtonListener implements ActionListener {
    
    private ArrayList boxes;

    public ButtonListener()
    {
           
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Box k=null;
        int i =0;
        while(i<getBoxes().size())
        {
            k=(Box)getBoxes().get(i);
            if(k.getActionCommand().equalsIgnoreCase(e.getActionCommand()))
            {
                System.out.println("Bulundu");
                break;
            }
            i++;
        }
        System.out.println(k.getDeger());
        Game.karsilastir(k);
        Game.gameEndControl(boxes);
    }

    /**
     * @return the boxes
     */
    public ArrayList getBoxes() {
        return boxes;
    }

    /**
     * @param boxes the boxes to set
     */
    public void setBoxes(ArrayList boxes) {
        this.boxes = boxes;
    }

    

    
    
    
    
}
