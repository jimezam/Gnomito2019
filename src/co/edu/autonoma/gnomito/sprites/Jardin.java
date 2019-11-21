/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.gnomito.sprites;

import co.edu.autonoma.gnomito.Contenedor;
import co.edu.autonoma.gnomito.excepciones.TipoHongoInvalidoException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author educacion
 */
public class Jardin extends Sprite implements Contenedor
{
    protected ArrayList<Hongo> hongos;
    protected Gnomo gnomito;

    public Jardin(int x, int y, int ancho, int alto) {
        super(x, y, ancho, alto, Color.GREEN);
        
        hongos = new ArrayList<Hongo>();
        gnomito = new Gnomo(0, 0);
        
        int gx = (ancho - gnomito.getAncho())/2;
        int gy = (alto - gnomito.getAlto())/2;
        
        gnomito.setX(gx);
        gnomito.setY(gy);
        gnomito.setContenedor(this);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);
        
        for(Hongo h : hongos)
            h.dibujar(g);
        
        gnomito.dibujar(g);
    }
    
    private Hongo crearHongo(int type)
    {
        Hongo h = null;
        
        if(type == Hongo.HONGO_BUENO)
            h = new HongoBueno(0, 0);
        else
            if(type == Hongo.HONGO_MALO)
                h = new HongoMalo(0, 0);
            else
                throw new TipoHongoInvalidoException();
        
        int x = (int)(Math.random() * ancho - h.getAncho());
        int y = (int)(Math.random() * alto - h.getAlto());                        
        
        h.setX(x);
        h.setY(y);
        
        return h;        
    }
   
    public void keyPressed(int tecla)
    {
        if(tecla == KeyEvent.VK_B)
        {
            hongos.add(crearHongo(Hongo.HONGO_BUENO));
            contenedor.refrescar();
        }
        
        if(tecla == KeyEvent.VK_M)
        {
            hongos.add(crearHongo(Hongo.HONGO_MALO));
            contenedor.refrescar();
        }
        
        if(tecla == KeyEvent.VK_UP |
           tecla == KeyEvent.VK_DOWN |
           tecla == KeyEvent.VK_LEFT |
           tecla == KeyEvent.VK_RIGHT)
        {
            if(gnomito.mover(tecla))
            {
                manejarComidaHongos();
            }
        }
    }

    private void manejarComidaHongos()
    {
        for(int i=0; i<hongos.size(); i++)
        {
            Hongo hongo = hongos.get(i);
            
            if(gnomito.hayColision(hongo))
            {
                gnomito.comer(hongo);
                hongos.remove(hongo);
                i --;
            }
        }
    }
    
    @Override
    public void refrescar() {
        getContenedor().refrescar();
    }
}
