/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization_exceptions;

/**
 *
 * @author Nicolas
 */
public class PasDePlaceException extends Exception{
     public PasDePlaceException()
    {
        super("Pas de place.");
    }
    
    public PasDePlaceException(String message)
    {
        super(message);
    }
}
