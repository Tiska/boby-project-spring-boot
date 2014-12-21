package api.status;

import java.util.HashSet;
import java.util.Set;


/**
 * Codes retour de l'API
 * 
 * @author antoine.ansel-ext
 *
 */
public class Status {

	private int code;

	private static Set<Integer> codeSet = new HashSet<Integer>();

	public Status(int code) {
		this.code = code;
		// Vérification qu'un code n'est pas déjà utilisé
		if (codeSet.contains(code)) {
			throw new IllegalStateException("Code déjà utilisé : " + code);
		}
		codeSet.add(code);
	}

	public int getCode() {
		return code;
	}

	public final static Status ERREUR_INCONNUE = new Status(-1);
	public final static Status OK = new Status(0);
	public final static Status ERREUR_TECHNIQUE = new Status(1);
	public final static Status ERREUR_TOKEN_INVALIDE = new Status(2);
	public final static Status ERREUR_TOKEN_EXPIRE = new Status(3);
	public final static Status ERREUR_NON_AUTORISE = new Status(4);
	public final static Status ERREUR_PARAMETRES_ENTREE = new Status(5);
	public final static Status ERREUR_IDENTIFICATION_INCORRECTE = new Status(6);
	public final static Status ERREUR_REQUETE_INVALIDE = new Status(7);
	public final static Status ERREUR_OBJET_INCONNU = new Status(8);

}
