package persistence.beans.dao;
import com.cardiweb.generator.persistence.runtimev3.QueryColumn;
import rx.Observable;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
interface IBasketDaoDefault {
	
	public Observable<persistence.beans.dao.IBasketTo> getById(long id);
	
	
	public Observable<persistence.beans.dao.IBasketTo> getBasket(long id);
	
	public Observable<Void> save(persistence.beans.dao.IBasketTo Basket);
	public Observable<Void> delete(persistence.beans.dao.IBasketTo Basket);
	public persistence.beans.dao.IBasketTo create();
	public void copy(persistence.beans.dao.IBasketTo src, persistence.beans.dao.IBasketTo dest);
	
	public Observable<java.util.List<persistence.beans.dao.IBasketTo>> getList();
	
	/**
	 * Getter lie a l'index client.
	 * @param idClient la valeur de la colonne idClient
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IBasketTo>> getBasketListParIdClient(long idClient);
	/**
	 * Getter lie a l'index CLIENT_DATE_PAIEMENT.
	 * @param datePaiement la valeur de la colonne datePaiement
	 * @param idClient la valeur de la colonne idClient
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IBasketTo>> getBasketListParDatePaiementEtIdClient(java.sql.Timestamp datePaiement, long idClient);
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketTo
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IBasketTo> newQuery();
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketTo dans une sous-requête
	 * @param queryParent requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketTo dans une sous-requête
	 */
	public com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<persistence.beans.dao.IBasketTo> newSubQuery(com.cardiweb.generator.persistence.runtimev3.PersistenceQuery<?> queryParent);
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Basket.<br>
	 * Méthode à usage générique, utilisez getBasketColumns() pour éviter les confusions
	 * @return BASKET_COLUMNS colonnes pour faire les requetes la table Basket
	 */
	public BASKET_COLUMNS getColumns();
	
	/**
	 * Retourne les colonnes pour faire les requetes la table Basket
	 * @return BASKET_COLUMNS colonnes pour faire les requetes la table Basket
	 */
	public BASKET_COLUMNS getBasketColumns();
	
	/**
	 * Retourne le nom de la table.
	 * @return String le nom de la table
	 */
	public String getTableName();
	
	public static interface BASKET_COLUMNS {
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
		 * colonne TOTAL (propriete total) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTotal();
		/**
		 * colonne TOTAL (propriete total) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTotalMIN();
		/**
		 * colonne TOTAL (propriete total) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTotalMAX();
		/**
		 * colonne TOTAL (propriete total) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTotalCOUNT();
		/**
		 * colonne TOTAL (propriete total) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTotalSUM();
		/**
		 * Objet representant la colonne TOTAL (propriete total) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTotalAVG();
		/**
		 * colonne TYPE_PAYMENT (propriete typePayment) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypePayment();
		/**
		 * colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypePaymentMIN();
		/**
		 * colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypePaymentMAX();
		/**
		 * colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypePaymentCOUNT();
		/**
		 * colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypePaymentSUM();
		/**
		 * Objet representant la colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getTypePaymentAVG();
		/**
		 * colonne DATE (propriete date) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDate();
		/**
		 * colonne DATE (propriete date) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDateMIN();
		/**
		 * colonne DATE (propriete date) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDateMAX();
		/**
		 * colonne DATE (propriete date) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDateCOUNT();
		/**
		 * colonne ID_CLIENT (propriete idClient) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdClient();
		/**
		 * colonne ID_CLIENT (propriete idClient) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdClientMIN();
		/**
		 * colonne ID_CLIENT (propriete idClient) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdClientMAX();
		/**
		 * colonne ID_CLIENT (propriete idClient) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdClientCOUNT();
		/**
		 * colonne ID_CLIENT (propriete idClient) aggregee par la fonction sum() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdClientSUM();
		/**
		 * Objet representant la colonne ID_CLIENT (propriete idClient) aggregee par la fonction avg() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getIdClientAVG();
		/**
		 * colonne DATE_PAIEMENT (propriete datePaiement) a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDatePaiement();
		/**
		 * colonne DATE_PAIEMENT (propriete datePaiement) aggregee par la fonction min() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDatePaiementMIN();
		/**
		 * colonne DATE_PAIEMENT (propriete datePaiement) aggregee par la fonction max') a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDatePaiementMAX();
		/**
		 * colonne DATE_PAIEMENT (propriete datePaiement) aggregee par la fonction count() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDatePaiementCOUNT();
		/**
		 * Objet representant la colonne DATE_PAIEMENT (propriete datePaiement) aggregee par la fonction isnull() a utiliser dans les requetes.
		 * @return QueryColumn
		 */
		public QueryColumn getDatePaiementISNULL();
	}
	
}
