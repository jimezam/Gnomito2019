/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.gnomito.sprites;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author educacion
 */
public class HongoBueno extends Hongo
{
    public HongoBueno(int x, int y) {
        super(x, y, 30, 30, Color.BLUE);
    }
    
    @Override
    public int getValorNutricional() {
        return 6;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);
    }
    
}
