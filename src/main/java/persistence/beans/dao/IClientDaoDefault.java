package persistence.beans.dao;
import com.cardiweb.generator.persistence.runtimev3.QueryColumn;
import rx.Observable;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
interface IClientDaoDefault {
	
	public Observable<persistence.beans.dao.IClientTo> getById(long id);
	
	
	public Observable<persistence.beans.dao.IClientTo> getClient(long id);
	
	public Observable<Void> save(persistence.beans.dao.IClientTo Client);
	public Observable<Void> delete(persistence.beans.dao.IClientTo Client);
	public persistence.beans.dao.IClientTo create();
	public void copy(persistence.beans.dao.IClientTo src, persistence.beans.dao.IClientTo dest);
	
	public Observable<java.util.List<persistence.beans.dao.IClientTo>> getList();
	
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IClientTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IClientTo
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IClientTo> newQuery();
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IClientTo dans une sous-requête
	 * @param queryParent requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IClientTo dans une sous-requête
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IClientTo> newSubQuery(com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<?> queryParent);
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Client.<br>
	 * Méthode à usage générique, utilisez getClientColumns() pour éviter les confusions
	 * @return CLIENT_COLUMNS colonnes pour faire les requetes la table Client
	 */
	public CLIENT_COLUMNS getColumns();
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Client
	 * @return CLIENT_COLUMNS colonnes pour faire les requetes la table Client
	 */
	public CLIENT_COLUMNS getClientColumns();
	
	/**
	 * Retourne le nom de la table.
	 * @return String le nom de la table
	 */
	public String getTableName();
	
	public static interface CLIENT_COLUMNS {
		/**
		 * colonne ID (propriete id) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getId();
		/**
		 * colonne ID (propriete id) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdMIN();
		/**
		 * colonne ID (propriete id) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdMAX();
		/**
		 * colonne ID (propriete id) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdCOUNT();
		/**
		 * colonne ID (propriete id) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdSUM();
		/**
		 * Objet representant la colonne ID (propriete id) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdAVG();
		/**
		 * colonne NOM (propriete nom) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getNom();
		/**
		 * colonne NOM (propriete nom) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getNomMIN();
		/**
		 * colonne NOM (propriete nom) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getNomMAX();
		/**
		 * colonne NOM (propriete nom) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getNomCOUNT();
		/**
		 * Objet representant la colonne NOM (propriete nom) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getNomUPPER();
		/**
		 * colonne PRENOM (propriete prenom) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrenom();
		/**
		 * colonne PRENOM (propriete prenom) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrenomMIN();
		/**
		 * colonne PRENOM (propriete prenom) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrenomMAX();
		/**
		 * colonne PRENOM (propriete prenom) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrenomCOUNT();
		/**
		 * Objet representant la colonne PRENOM (propriete prenom) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrenomUPPER();
		/**
		 * colonne TELEPHONE (propriete telephone) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTelephone();
		/**
		 * colonne TELEPHONE (propriete telephone) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTelephoneMIN();
		/**
		 * colonne TELEPHONE (propriete telephone) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTelephoneMAX();
		/**
		 * colonne TELEPHONE (propriete telephone) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTelephoneCOUNT();
		/**
		 * colonne TELEPHONE (propriete telephone) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTelephoneSUM();
		/**
		 * Objet representant la colonne TELEPHONE (propriete telephone) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTelephoneAVG();
		/**
		 * Objet representant la colonne TELEPHONE (propriete telephone) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTelephoneISNULL();
		/**
		 * colonne ADRESSE (propriete adresse) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getAdresse();
		/**
		 * colonne ADRESSE (propriete adresse) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getAdresseMIN();
		/**
		 * colonne ADRESSE (propriete adresse) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getAdresseMAX();
		/**
		 * colonne ADRESSE (propriete adresse) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getAdresseCOUNT();
		/**
		 * Objet representant la colonne ADRESSE (propriete adresse) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getAdresseUPPER();
		/**
		 * Objet representant la colonne ADRESSE (propriete adresse) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getAdresseISNULL();
		/**
		 * colonne CODE_POSTAL (propriete codePostal) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCodePostal();
		/**
		 * colonne CODE_POSTAL (propriete codePostal) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCodePostalMIN();
		/**
		 * colonne CODE_POSTAL (propriete codePostal) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCodePostalMAX();
		/**
		 * colonne CODE_POSTAL (propriete codePostal) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCodePostalCOUNT();
		/**
		 * Objet representant la colonne CODE_POSTAL (propriete codePostal) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCodePostalUPPER();
		/**
		 * Objet representant la colonne CODE_POSTAL (propriete codePostal) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCodePostalISNULL();
		/**
		 * colonne VILLE (propriete ville) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getVille();
		/**
		 * colonne VILLE (propriete ville) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getVilleMIN();
		/**
		 * colonne VILLE (propriete ville) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getVilleMAX();
		/**
		 * colonne VILLE (propriete ville) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getVilleCOUNT();
		/**
		 * Objet representant la colonne VILLE (propriete ville) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getVilleUPPER();
		/**
		 * Objet representant la colonne VILLE (propriete ville) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getVilleISNULL();
		/**
		 * colonne BIRTHDAY (propriete birthday) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getBirthday();
		/**
		 * colonne BIRTHDAY (propriete birthday) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getBirthdayMIN();
		/**
		 * colonne BIRTHDAY (propriete birthday) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getBirthdayMAX();
		/**
		 * colonne BIRTHDAY (propriete birthday) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getBirthdayCOUNT();
		/**
		 * Objet representant la colonne BIRTHDAY (propriete birthday) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getBirthdayISNULL();
		/**
		 * colonne EMAIL (propriete email) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getEmail();
		/**
		 * colonne EMAIL (propriete email) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getEmailMIN();
		/**
		 * colonne EMAIL (propriete email) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getEmailMAX();
		/**
		 * colonne EMAIL (propriete email) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getEmailCOUNT();
		/**
		 * Objet representant la colonne EMAIL (propriete email) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getEmailUPPER();
		/**
		 * Objet representant la colonne EMAIL (propriete email) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getEmailISNULL();
	}
	
}
