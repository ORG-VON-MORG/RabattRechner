package com.google.tobias.gottschalk.rabattrechner;

/**
 * Created by Tobias on 17.12.2017.
 */

//G=Grundwert
//W=Prozentwert
//p=prozentsatz



public class berechnungRabatt {

    public double berechneProzentwert(double grundwert, double prozentsatz){
        prozentsatz = prozentsatz/100;

        if(prozentsatz>=0){
            grundwert = grundwert*(prozentsatz/(100))+grundwert;
        }

        if (prozentsatz<0){
            grundwert = grundwert*(prozentsatz/(100))-grundwert;
        }
        return grundwert;
    }

    public double berechneGrundwert(double prozentwert, double prozentsatz){
        prozentsatz = prozentsatz/100;
        return prozentwert/prozentsatz;

    }

    public double berechneProzentsatz(double prozentwert, double grundwert){

        return prozentwert/grundwert;
    }

}
