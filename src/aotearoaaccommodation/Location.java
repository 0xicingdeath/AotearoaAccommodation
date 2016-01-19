/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aotearoaaccommodation;

/**
 *
 * @author nataliechin
 */
public class Location 
{
 String name, place, type, info, month; 
 double cost; 
 byte date;
 
 public int compareTo(Location other)
 {
     return place.compareTo(other.place);
 }
}

