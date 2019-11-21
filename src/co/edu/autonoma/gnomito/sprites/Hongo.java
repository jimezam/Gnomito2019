/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.gnomito.sprites;

import java.awt.Color;

/**
 *
 * @author educacion
 */
public abstract class Hongo extends Sprite
{
    public static final int HONGO_BUENO = 1;
    public static final int HONGO_MALO = 2;
    public static final int HONGO_BORRACHO = 3;
    
    public Hongo(int x, int y, int ancho, int alto, Color color) {
        super(x, y, ancho, alto, color);
    }
    
    // abstract dibujar
    
    public abstract int getValorNutricional();
}
