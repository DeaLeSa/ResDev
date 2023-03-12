package fr.dlesaout.resdev.exceptions.utilisateur;

public class MotDePasseSecuriteFaibleException extends RuntimeException {

    public MotDePasseSecuriteFaibleException() {
        super("Un compte a déjà été créé avec cette adresse email.");
    }

}
