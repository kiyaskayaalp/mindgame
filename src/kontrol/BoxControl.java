/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrol;

import dinleyici.ButtonListener;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import model.Box;

/**
 *
 * @author Kıyas
 */
public class BoxControl 
    {
    private ButtonListener buttonListener;
    private JPanel panel;
    private ArrayList boxes=new ArrayList();
    private ArrayList rndNum=new ArrayList();
    private int boxNum=0;
    private String yerlesimDuzeni;
    
    public BoxControl(JPanel pnl,String yerlesim) 
    {
        this.panel=pnl;
        this.yerlesimDuzeni=yerlesim;
        buttonListener = new ButtonListener();
    }
    
    public void boxCreate(int adet)
    {
        Game.gamepuan=0;
        if(adet%2==1)
           adet++;
        this.boxNum=adet;
        for(int i=0; i<adet; i++)
          rndNum.add(0);
        rastgeleSayilarUret();
        for(int i=0; i<adet; i++)
          System.out.println(rndNum.get(i).toString());
        panel.removeAll();
        panel.repaint();
        panel.setPreferredSize(new Dimension(panel.getWidth(),panel.getHeight()));
        GridLayout gl=new GridLayout(2,adet/2);
        FlowLayout fl=new FlowLayout(1);
        if(yerlesimDuzeni.equalsIgnoreCase("GridLayout"))
           panel.setLayout(gl);
        else if(yerlesimDuzeni.equalsIgnoreCase("FlowLayout"))
            panel.setLayout(fl);      
        for(int i=0; i<adet; i++)
        {
            Box newbox;
            newbox=new Box(buttonListener,rndNum.get(i).toString());
            newbox.setDurum(true);
            newbox.setActionCommand(Integer.toString(i));
            newbox.setPreferredSize(new Dimension(75,75));
            boxes.add(newbox);
            newbox.setVisible(true);
            panel.add(newbox);
        }
        buttonListener.setBoxes(boxes);
        panel.doLayout(); 
    }
    
    public void rastgeleSayilarUret()
    {
        Random rnd1=new Random();
        int tutulan;
        Integer i,j;
        for(i=1; i<=(boxNum/2); i++)
        {
            for(j=1; j<=2; j++)
            {
                for(;;)
                {
                    tutulan=rnd1.nextInt(boxNum);
                    if(rndNum.get(tutulan).equals(0))
                    break;
                }
                rndNum.set(tutulan,i);
            }
        }
    }
    public void buttonsHide()
    {
        for(int i=0; i<boxes.size(); i++)
        {
            ((Box)(boxes.get(i))).setText("");
            ((Box)(boxes.get(i))).setEnabled(true);
            
        }
    }
}
