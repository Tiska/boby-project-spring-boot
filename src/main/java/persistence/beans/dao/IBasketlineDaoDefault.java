package persistence.beans.dao;
import com.cardiweb.generator.persistence.runtimev3.QueryColumn;
import rx.Observable;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
interface IBasketlineDaoDefault {
	
	public Observable<persistence.beans.dao.IBasketlineTo> getById(long id);
	
	
	public Observable<persistence.beans.dao.IBasketlineTo> getBasketline(long id);
	
	public Observable<Void> save(persistence.beans.dao.IBasketlineTo Basketline);
	public Observable<Void> delete(persistence.beans.dao.IBasketlineTo Basketline);
	public persistence.beans.dao.IBasketlineTo create();
	public void copy(persistence.beans.dao.IBasketlineTo src, persistence.beans.dao.IBasketlineTo dest);
	
	public Observable<java.util.List<persistence.beans.dao.IBasketlineTo>> getList();
	
	/**
	 * Getter lie a l'index basket.
	 * @param idBasket la valeur de la colonne idBasket
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IBasketlineTo>> getBasketlineListParIdBasket(long idBasket);
	/**
	 * Getter lie a l'index presta.
	 * @param idPrestation la valeur de la colonne idPrestation
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IBasketlineTo>> getBasketlineListParIdPrestation(java.lang.Long idPrestation);
	/**
	 * Getter lie a l'index produit.
	 * @param idProduit la valeur de la colonne idProduit
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IBasketlineTo>> getBasketlineListParIdProduit(java.lang.Long idProduit);
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketlineTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketlineTo
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IBasketlineTo> newQuery();
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketlineTo dans une sous-requête
	 * @param queryParent requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketlineTo dans une sous-requête
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IBasketlineTo> newSubQuery(com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<?> queryParent);
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Basketline.<br>
	 * Méthode à usage générique, utilisez getBasketlineColumns() pour éviter les confusions
	 * @return BASKETLINE_COLUMNS colonnes pour faire les requetes la table Basketline
	 */
	public BASKETLINE_COLUMNS getColumns();
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Basketline
	 * @return BASKETLINE_COLUMNS colonnes pour faire les requetes la table Basketline
	 */
	public BASKETLINE_COLUMNS getBasketlineColumns();
	
	/**
	 * Retourne le nom de la table.
	 * @return String le nom de la table
	 */
	public String getTableName();
	
	public static interface BASKETLINE_COLUMNS {
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
		 * colonne ID_PRESTATION (propriete idPrestation) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestation();
		/**
		 * colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationMIN();
		/**
		 * colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationMAX();
		/**
		 * colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationCOUNT();
		/**
		 * colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationSUM();
		/**
		 * Objet representant la colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationAVG();
		/**
		 * Objet representant la colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdPrestationISNULL();
		/**
		 * colonne ID_PRODUIT (propriete idProduit) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduit();
		/**
		 * colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitMIN();
		/**
		 * colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitMAX();
		/**
		 * colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitCOUNT();
		/**
		 * colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitSUM();
		/**
		 * Objet representant la colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitAVG();
		/**
		 * Objet representant la colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdProduitISNULL();
		/**
		 * colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAvecReduction();
		/**
		 * colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAvecReductionMIN();
		/**
		 * colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAvecReductionMAX();
		/**
		 * colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAvecReductionCOUNT();
		/**
		 * colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAvecReductionSUM();
		/**
		 * Objet representant la colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getPrixAvecReductionAVG();
		/**
		 * colonne QUANTITE (propriete quantite) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getQuantite();
		/**
		 * colonne QUANTITE (propriete quantite) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getQuantiteMIN();
		/**
		 * colonne QUANTITE (propriete quantite) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getQuantiteMAX();
		/**
		 * colonne QUANTITE (propriete quantite) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getQuantiteCOUNT();
		/**
		 * colonne QUANTITE (propriete quantite) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getQuantiteSUM();
		/**
		 * Objet representant la colonne QUANTITE (propriete quantite) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getQuantiteAVG();
		/**
		 * colonne REDUCTION (propriete reduction) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getReduction();
		/**
		 * colonne REDUCTION (propriete reduction) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getReductionMIN();
		/**
		 * colonne REDUCTION (propriete reduction) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getReductionMAX();
		/**
		 * colonne REDUCTION (propriete reduction) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getReductionCOUNT();
		/**
		 * colonne REDUCTION (propriete reduction) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getReductionSUM();
		/**
		 * Objet representant la colonne REDUCTION (propriete reduction) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getReductionAVG();
		/**
		 * Objet representant la colonne REDUCTION (propriete reduction) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getReductionISNULL();
		/**
		 * colonne TYPE_DE_REDUCTION (propriete typeDeReduction) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypeDeReduction();
		/**
		 * colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypeDeReductionMIN();
		/**
		 * colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypeDeReductionMAX();
		/**
		 * colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypeDeReductionCOUNT();
		/**
		 * colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypeDeReductionSUM();
		/**
		 * Objet representant la colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypeDeReductionAVG();
		/**
		 * Objet representant la colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypeDeReductionISNULL();
		/**
		 * colonne ID_BASKET (propriete idBasket) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdBasket();
		/**
		 * colonne ID_BASKET (propriete idBasket) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdBasketMIN();
		/**
		 * colonne ID_BASKET (propriete idBasket) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdBasketMAX();
		/**
		 * colonne ID_BASKET (propriete idBasket) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdBasketCOUNT();
		/**
		 * colonne ID_BASKET (propriete idBasket) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdBasketSUM();
		/**
		 * Objet representant la colonne ID_BASKET (propriete idBasket) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdBasketAVG();
	}
	
}
