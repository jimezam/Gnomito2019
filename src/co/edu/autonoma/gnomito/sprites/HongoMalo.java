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
public class HongoMalo extends Hongo
{
    public HongoMalo(int x, int y) {
        super(x, y, 50, 50, Color.RED);
    }
    
    @Override
    public int getValorNutricional() {
        return -6;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);
    }
    
}
