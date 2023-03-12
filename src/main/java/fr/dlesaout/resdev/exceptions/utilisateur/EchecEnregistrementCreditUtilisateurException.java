package fr.dlesaout.resdev.exceptions.utilisateur;

public class EchecEnregistrementCreditUtilisateurException extends RuntimeException {

    public EchecEnregistrementCreditUtilisateurException() {
        super("Un problème est survenu lors de l'enregistrement du crédit utilisateur initial en base de données.");
    }

}
