/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dinleyici.ButtonListener;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToggleButton;

/**
 *
 * @author Kıyas
 */
public class Box extends JToggleButton 
{
    private String deger;
    private boolean durum;

    public Box(ButtonListener dd,String deger) 
    {
        this.addActionListener(dd);
        this.setDeger(deger);
        this.setText(deger);
    }

    /**
     * @return the deger
     */
    public String getDeger() 
    {
        return deger;
    }

    /**
     * @param deger the deger to set
     */
    public void setDeger(String deger) 
    {
        this.deger = deger;
    }

    /**
     * @return the durum
     */
    public boolean isDurum() 
    {
        return durum;
    }

    /**
     * @param durum the durum to set
     */
    public void setDurum(boolean durum) 
    {
        this.durum = durum;
    }

   
    
}
