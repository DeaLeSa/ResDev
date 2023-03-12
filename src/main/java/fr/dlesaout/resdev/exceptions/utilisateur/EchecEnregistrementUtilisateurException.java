package fr.dlesaout.resdev.exceptions.utilisateur;

public class EchecEnregistrementUtilisateurException extends RuntimeException {
    public EchecEnregistrementUtilisateurException() {
        super("Un problème est survenu lors de l'enregistrement de l'utilisateur en base de données.");
    }
}
