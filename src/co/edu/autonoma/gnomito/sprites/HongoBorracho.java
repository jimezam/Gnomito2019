/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.gnomito.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author educacion
 */
public class HongoBorracho 
        extends Hongo 
        implements Runnable
{
    private int paso;
    private Thread hilo;
    
    public HongoBorracho(int x, int y) {
        super(x, y, 40, 40, Color.YELLOW);
        
        paso = 20;
        
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, ancho, alto);
    }

    @Override
    public int getValorNutricional() {
        return 0;
    }

    @Override
    public void run() {
        
        int[] movX = new int[] {0,     0,    -paso, paso};
        int[] movY = new int[] {-paso, paso, 0,     0};
        
        while(true)
        {
            int rnd = (int)(Math.random() * movX.length);
            
            x = x + movX[rnd];
            y = y + movY[rnd];
            
            try { Thread.sleep(333); } catch (InterruptedException ex) {
                Logger.getLogger(HongoBorracho.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            getContenedor().refrescar();
        }
    }
    
}
