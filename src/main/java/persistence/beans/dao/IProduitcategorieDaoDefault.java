package persistence.beans.dao;
import com.cardiweb.generator.persistence.runtimev3.QueryColumn;
import rx.Observable;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
interface IProduitcategorieDaoDefault {
	
	public Observable<persistence.beans.dao.IProduitcategorieTo> getById(long id);
	
	
	public Observable<persistence.beans.dao.IProduitcategorieTo> getProduitcategorie(long id);
	
	public Observable<Void> save(persistence.beans.dao.IProduitcategorieTo Produitcategorie);
	public Observable<Void> delete(persistence.beans.dao.IProduitcategorieTo Produitcategorie);
	public persistence.beans.dao.IProduitcategorieTo create();
	public void copy(persistence.beans.dao.IProduitcategorieTo src, persistence.beans.dao.IProduitcategorieTo dest);
	
	public Observable<java.util.List<persistence.beans.dao.IProduitcategorieTo>> getList();
	
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitcategorieTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitcategorieTo
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IProduitcategorieTo> newQuery();
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitcategorieTo dans une sous-requête
	 * @param queryParent requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitcategorieTo dans une sous-requête
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IProduitcategorieTo> newSubQuery(com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<?> queryParent);
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Produitcategorie.<br>
	 * Méthode à usage générique, utilisez getProduitcategorieColumns() pour éviter les confusions
	 * @return PRODUITCATEGORIE_COLUMNS colonnes pour faire les requetes la table Produitcategorie
	 */
	public PRODUITCATEGORIE_COLUMNS getColumns();
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Produitcategorie
	 * @return PRODUITCATEGORIE_COLUMNS colonnes pour faire les requetes la table Produitcategorie
	 */
	public PRODUITCATEGORIE_COLUMNS getProduitcategorieColumns();
	
	/**
	 * Retourne le nom de la table.
	 * @return String le nom de la table
	 */
	public String getTableName();
	
	public static interface PRODUITCATEGORIE_COLUMNS {
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
	}
	
}
