/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.gnomito.sprites;

import co.edu.autonoma.gnomito.Contenedor;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author educacion
 */
public abstract class Sprite 
{
    protected int x;
    protected int y;
    protected int ancho;
    protected int alto;
    protected Color color;
    protected Contenedor contenedor;

    public Sprite(int x, int y, int ancho, int alto, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    public Sprite(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public abstract void dibujar(Graphics g);

    public boolean hayColision(Sprite otro)
    {
        return otro.getX() < this.getX() + this.getAncho() &
               otro.getX() + otro.getAncho() > this.getX() & 
               otro.getY() < this.getY() + this.getAlto() &
               otro.getY() + otro.getAlto() > this.getY();
    }
    
    public Contenedor getContenedor() {
        return contenedor;
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }
   
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
