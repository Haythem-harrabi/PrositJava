package tn.esprit.gestion.Entite;

public class ZooFullException extends Exception {

    public ZooFullException(){
        super();
        System.err.println("Error : Zoo is full !!!!!");
    }
}
