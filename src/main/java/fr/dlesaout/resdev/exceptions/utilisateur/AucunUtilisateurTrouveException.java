package fr.dlesaout.resdev.exceptions.utilisateur;

public class AucunUtilisateurTrouveException extends RuntimeException {
    public AucunUtilisateurTrouveException() {
        super("Aucun autilisateur trouvé.");
    }
}
