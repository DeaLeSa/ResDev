package fr.dlesaout.resdev.exceptions.utilisateur;

public class MotDePasseException extends RuntimeException {

    public MotDePasseException() {
        super("Le mot de passe saisi ne respecte pas la politique de sécurisation des mots de passe");
    }

}
