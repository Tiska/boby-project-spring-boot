package persistence.beans.dao;
import com.cardiweb.generator.persistence.runtimev3.QueryColumn;
import rx.Observable;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
interface IProduitDaoDefault {
	
	public Observable<persistence.beans.dao.IProduitTo> getById(long id);
	
	
	public Observable<persistence.beans.dao.IProduitTo> getProduit(long id);
	
	public Observable<Void> save(persistence.beans.dao.IProduitTo Produit);
	public Observable<Void> delete(persistence.beans.dao.IProduitTo Produit);
	public persistence.beans.dao.IProduitTo create();
	public void copy(persistence.beans.dao.IProduitTo src, persistence.beans.dao.IProduitTo dest);
	
	public Observable<java.util.List<persistence.beans.dao.IProduitTo>> getList();
	
	/**
	 * Getter lie a l'index produit_categ.
	 * @param idProduitCateg la valeur de la colonne idProduitCateg
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IProduitTo>> getProduitListParIdProduitCateg(long idProduitCateg);
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitTo
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IProduitTo> newQuery();
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitTo dans une sous-requête
	 * @param queryParent requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitTo dans une sous-requête
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IProduitTo> newSubQuery(com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<?> queryParent);
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Produit.<br>
	 * Méthode à usage générique, utilisez getProduitColumns() pour éviter les confusions
	 * @return PRODUIT_COLUMNS colonnes pour faire les requetes la table Produit
	 */
	public PRODUIT_COLUMNS getColumns();
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Produit
	 * @return PRODUIT_COLUMNS colonnes pour faire les requetes la table Produit
	 */
	public PRODUIT_COLUMNS getProduitColumns();
	
	/**
	 * Retourne le nom de la table.
	 * @return String le nom de la table
	 */
	public String getTableName();
	
	public static interface PRODUIT_COLUMNS {
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
		 * colonne STOCK (propriete stock) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getStock();
		/**
		 * colonne STOCK (propriete stock) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getStockMIN();
		/**
		 * colonne STOCK (propriete stock) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getStockMAX();
		/**
		 * colonne STOCK (propriete stock) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getStockCOUNT();
		/**
		 * colonne STOCK (propriete stock) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getStockSUM();
		/**
		 * Objet representant la colonne STOCK (propriete stock) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getStockAVG();
		/**
		 * colonne PRIX_ACHAT (propriete prixAchat) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAchat();
		/**
		 * colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAchatMIN();
		/**
		 * colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAchatMAX();
		/**
		 * colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAchatCOUNT();
		/**
		 * colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAchatSUM();
		/**
		 * Objet representant la colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAchatAVG();
		/**
		 * colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixVenteCalcule();
		/**
		 * colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixVenteCalculeMIN();
		/**
		 * colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixVenteCalculeMAX();
		/**
		 * colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixVenteCalculeCOUNT();
		/**
		 * colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixVenteCalculeSUM();
		/**
		 * Objet representant la colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixVenteCalculeAVG();
		/**
		 * colonne COEFFICIANT (propriete coefficiant) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCoefficiant();
		/**
		 * colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCoefficiantMIN();
		/**
		 * colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCoefficiantMAX();
		/**
		 * colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCoefficiantCOUNT();
		/**
		 * colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCoefficiantSUM();
		/**
		 * Objet representant la colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getCoefficiantAVG();
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
		 * colonne ID_PRODUIT_CATEG (propriete idProduitCateg) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitCateg();
		/**
		 * colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitCategMIN();
		/**
		 * colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitCategMAX();
		/**
		 * colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitCategCOUNT();
		/**
		 * colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitCategSUM();
		/**
		 * Objet representant la colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitCategAVG();
	}
	
}
