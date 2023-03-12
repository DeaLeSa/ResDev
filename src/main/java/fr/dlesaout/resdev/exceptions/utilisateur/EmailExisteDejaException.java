package fr.dlesaout.resdev.exceptions.utilisateur;

public class EmailExisteDejaException extends RuntimeException {

    public EmailExisteDejaException(String message) {
        super(message);
    }

}
