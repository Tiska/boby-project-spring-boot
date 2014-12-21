package persistence.beans.dao;
import com.cardiweb.generator.persistence.runtimev3.QueryColumn;
import rx.Observable;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
interface IPrestationDaoDefault {
	
	public Observable<persistence.beans.dao.IPrestationTo> getById(long id);
	
	
	public Observable<persistence.beans.dao.IPrestationTo> getPrestation(long id);
	
	public Observable<Void> save(persistence.beans.dao.IPrestationTo Prestation);
	public Observable<Void> delete(persistence.beans.dao.IPrestationTo Prestation);
	public persistence.beans.dao.IPrestationTo create();
	public void copy(persistence.beans.dao.IPrestationTo src, persistence.beans.dao.IPrestationTo dest);
	
	public Observable<java.util.List<persistence.beans.dao.IPrestationTo>> getList();
	
	/**
	 * Getter lie a l'index presta_categ.
	 * @param idPrestationCateg la valeur de la colonne idPrestationCateg
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IPrestationTo>> getPrestationListParIdPrestationCateg(long idPrestationCateg);
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IPrestationTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IPrestationTo
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IPrestationTo> newQuery();
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IPrestationTo dans une sous-requête
	 * @param queryParent requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IPrestationTo dans une sous-requête
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IPrestationTo> newSubQuery(com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<?> queryParent);
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Prestation.<br>
	 * Méthode à usage générique, utilisez getPrestationColumns() pour éviter les confusions
	 * @return PRESTATION_COLUMNS colonnes pour faire les requetes la table Prestation
	 */
	public PRESTATION_COLUMNS getColumns();
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Prestation
	 * @return PRESTATION_COLUMNS colonnes pour faire les requetes la table Prestation
	 */
	public PRESTATION_COLUMNS getPrestationColumns();
	
	/**
	 * Retourne le nom de la table.
	 * @return String le nom de la table
	 */
	public String getTableName();
	
	public static interface PRESTATION_COLUMNS {
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
		 * colonne LIBELLE (propriete libelle) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getLibelle();
		/**
		 * colonne LIBELLE (propriete libelle) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getLibelleMIN();
		/**
		 * colonne LIBELLE (propriete libelle) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getLibelleMAX();
		/**
		 * colonne LIBELLE (propriete libelle) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getLibelleCOUNT();
		/**
		 * Objet representant la colonne LIBELLE (propriete libelle) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getLibelleUPPER();
		/**
		 * colonne PRIX (propriete prix) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrix();
		/**
		 * colonne PRIX (propriete prix) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixMIN();
		/**
		 * colonne PRIX (propriete prix) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixMAX();
		/**
		 * colonne PRIX (propriete prix) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixCOUNT();
		/**
		 * colonne PRIX (propriete prix) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixSUM();
		/**
		 * Objet representant la colonne PRIX (propriete prix) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAVG();
		/**
		 * colonne DUREE (propriete duree) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDuree();
		/**
		 * colonne DUREE (propriete duree) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDureeMIN();
		/**
		 * colonne DUREE (propriete duree) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDureeMAX();
		/**
		 * colonne DUREE (propriete duree) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDureeCOUNT();
		/**
		 * colonne DUREE (propriete duree) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDureeSUM();
		/**
		 * Objet representant la colonne DUREE (propriete duree) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDureeAVG();
		/**
		 * colonne OBSOLETE (propriete obsolete) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getObsolete();
		/**
		 * colonne OBSOLETE (propriete obsolete) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getObsoleteMIN();
		/**
		 * colonne OBSOLETE (propriete obsolete) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getObsoleteMAX();
		/**
		 * colonne OBSOLETE (propriete obsolete) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getObsoleteCOUNT();
		/**
		 * colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationCateg();
		/**
		 * colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationCategMIN();
		/**
		 * colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationCategMAX();
		/**
		 * colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationCategCOUNT();
		/**
		 * colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationCategSUM();
		/**
		 * Objet representant la colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationCategAVG();
	}
	
}
