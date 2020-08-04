/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad2;

/**
 *
 * @author Tester 3
 */
public class Parciales {

    
    public int nparciales;
    /**
     * @return the promedio
     */
    public int getPromedio() {
        _promedio = (_parcial1+_parcial2+_parcial3+_proyecto)/nparciales;
        return _promedio;
    }

    /**
     * @param promedio the promedio to set
     */
    public void setPromedio(int promedio) {
        this._promedio = promedio;
    }

    public Parciales(int p1, int p2, int p3) {
        _parcial1 = p1;
        _parcial2 = p2;
        _parcial3 = p3;
        nparciales = 3;
    }
    
    public Parciales() {
        nparciales = 3;
    }
    
    public Parciales(int p1, int p2, int p3, int py) {
        _parcial1 = p1;
        _parcial2 = p2;
        _parcial3 = p3;
        _proyecto = py;
        nparciales = 4;
    }
    /**
     * @return the _parcial1
     */
    public int getParcial1() {
        return _parcial1;
    }

    /**
     * @param _parcial1 the _parcial1 to set
     */
    public void setParcial1(int _parcial1) {
        this._parcial1 = _parcial1;
    }

    /**
     * @return the _parcial2
     */
    public int getParcial2() {
        return _parcial2;
    }

    /**
     * @param _parcial2 the _parcial2 to set
     */
    public void setParcial2(int _parcial2) {
        this._parcial2 = _parcial2;
    }

    /**
     * @return the _parcial3
     */
    public int getParcial3() {
        return _parcial3;
    }

    /**
     * @param _parcial3 the _parcial3 to set
     */
    public void setParcial3(int _parcial3) {
        this._parcial3 = _parcial3;
    }

    /**
     * @return the _proyecto
     */
    public int getProyecto() {
        return _proyecto;
    }

    /**
     * @param _proyecto the _proyecto to set
     */
    public void setProyecto(int _proyecto) {
        this._proyecto = _proyecto;
    }
    
    private int _promedio;
    
    

    /**
     * @return the _fin
     */
    
    
    public String convertToString() {
        setPromedio((_parcial1+_parcial2+_parcial3+_proyecto)/nparciales);
        return 
        "        " + Integer.toString(this._parcial1) + 
        "        " + Integer.toString(this._parcial2) + 
        "        " + Integer.toString(this._parcial3) + 
        "        " + Integer.toString(this._proyecto) + 
        "        " + Integer.toString(this.getPromedio());
    }
    private int _parcial1, _parcial2, _parcial3, _proyecto;
    
}
