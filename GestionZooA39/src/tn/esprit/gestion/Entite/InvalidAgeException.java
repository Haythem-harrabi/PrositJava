package tn.esprit.gestion.Entite;

public class InvalidAgeException extends Exception {

    public InvalidAgeException(){
        super();
        System.err.println("Erreur : Age ne peut pas être négatif");
    }
}
