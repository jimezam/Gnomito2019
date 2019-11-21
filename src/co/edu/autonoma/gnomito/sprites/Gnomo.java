/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.gnomito.sprites;

import co.edu.autonoma.gnomito.excepciones.MovimientoGnomoInvalido;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author educacion
 */
public class Gnomo extends Sprite
{
    private int paso;
    
    public Gnomo(int x, int y) {
        super(x, y, 30, 70, Color.MAGENTA);
        
        paso = 10;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);
    }
    
    public void comer(Hongo hongo)
    {
        setX(getX() - hongo.getValorNutricional()/2);
        setY(getY() - hongo.getValorNutricional()/2);        
        setAncho(getAncho() + hongo.getValorNutricional()/2);
        setAlto(getAlto() + hongo.getValorNutricional()/2);
        
        getContenedor().refrescar();
    }
    
    public boolean mover(int direccion)
    {
        switch(direccion)
        {
            case KeyEvent.VK_UP:
                y -= paso;
            break;

            case KeyEvent.VK_DOWN:
                y += paso;
            break;

            case KeyEvent.VK_LEFT:
                x -= paso;
            break;

            case KeyEvent.VK_RIGHT:
                x += paso;
            break;

            default:
                throw new MovimientoGnomoInvalido();
            // break;
        }
        
        getContenedor().refrescar();
        
        return true;
    }
}
