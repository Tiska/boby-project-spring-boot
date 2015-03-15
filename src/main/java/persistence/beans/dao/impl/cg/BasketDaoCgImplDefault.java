package persistence.beans.dao.impl.cg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.schedulers.Schedulers;

import org.apache.log4j.Logger;

import persistence.beans.dao.IBasketDao;
import com.cardiweb.generator.persistence.runtimev3.Cache;
import com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime;
import com.cardiweb.generator.persistence.runtimev3.PersistenceException;
import com.cardiweb.generator.persistence.runtimev3.PersistenceQuery;
import com.cardiweb.generator.persistence.runtimev3.QueryColumn;
import com.cardiweb.generator.persistence.runtimev3.TableAlias;
import com.cardiweb.generator.persistence.runtimev3.impl.jdbc.JDBCPersistenceQuery;
import com.cardiweb.generator.persistence.runtimev3.impl.jdbc.JDBCQueryColumn;
import com.cardiweb.generator.persistence.runtimev3.impl.jdbc.JDBCQueryColumn.JDBCFunction;
import com.cardiweb.generator.persistence.runtimev3.impl.jdbc.JDBCTableAlias;

/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public abstract class BasketDaoCgImplDefault implements IBasketDao {
	
	static protected final Logger logger = Logger.getLogger(BasketDaoCgImplDefault.class);
	
	public BasketDaoCgImplDefault() {
	}
	
	private com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime _generatorRuntime = null;
	public com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime getGeneratorRuntime() {
		return _generatorRuntime;
	}
	public void setGeneratorRuntime(com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime runtime) {
		this._generatorRuntime=runtime;
		initSchema();
	}
	
	/************************************************************
	Section liee au CACHE.
	Fournit les methodes necessaires a la gestion d'un cache
	En fournissant une implementation de cache differente dans
	le GeneratorRuntime, on peut, par exemple, gerer une
	expiration des objets.
	 ************************************************************/
	
	/**
	 * Obtenir l'objet gerant le cache liee a cette classe.
	 * @return l'objet gerant le cache liee a cette classe
	 */
	public Cache getCache() {
		return getGeneratorRuntime().getCache("persistence.beans.dao.IBasketTo");
	}
	
	/**
	 * Cette methode permet de regarder dans le cache si cet objet existe deja.<br/>
	 * Si oui, c'est l'objet dans le cache qui est retourne.<br/>
	 * Si non, c'est l'objet passe en parametre qui est retourne.<br/>
	 * @param object l'objet dont il faut tester la presence dans le cache.
	 * @return si l'objet est deja dans le cache, la version en cache. Sinon, l'objet en parametre.
	 * @throws NullPointerException si object est null.
	 */
	protected persistence.beans.dao.impl.cg.BasketToCgImpl selectCacheObject(persistence.beans.dao.impl.cg.BasketToCgImpl object) {
		String key = object.getCacheKey();
		Object cacheValue=getCache().getByKey(key);
		if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			getCache().putByKey(key, object);
			return object;
		}
		return (persistence.beans.dao.impl.cg.BasketToCgImpl)cacheValue;
	}
	
	/**
	 * Cette methode genere une clee chaine unique dependant des arguments.<br/>
	 * Actuellement, elle ne fait que concatener les clees et retourner une chaine.<br/>
	 * @param id la valeur pour id
	 * @return Une chaine representant de facon unique les parametres.
	 */
	protected String getCacheKey(long id) {
		return "persistence.beans.dao.impl.cg.Basket_"+id;
	}
	protected String _TABLE_SCHEMA = null;
	protected String _TABLE_NAME = "basket";
	protected String _TABLE_FULL_NAME = null;
	protected static String _FIELD_ID = "ID";
	protected static String _FIELD_TOTAL = "TOTAL";
	protected static String _FIELD_TYPEPAYMENT = "TYPE_PAYMENT";
	protected static String _FIELD_DATE = "DATE";
	protected static String _FIELD_IDCLIENT = "ID_CLIENT";
	
	private void initSchema() {
		String s = null;
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basket.table_name");
		if (s!=null) {
			_TABLE_NAME = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basket.table_alias");
		if (s!=null) {
			ALIAS.setAlias(s);
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basket.schema_name");
		if (s==null) {
			s = getGeneratorRuntime().getStringProperty("c-generator.persistence.schema_name");
		}
		if (s!=null) {
			_TABLE_SCHEMA =  "null".equals(s)?null:s;
		}
		_TABLE_FULL_NAME = (_TABLE_SCHEMA==null?"":(_TABLE_SCHEMA+"."))+ "" + _TABLE_NAME + "";
		ALIAS.init(_TABLE_FULL_NAME);
		
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basket.id.column_name");
		if (s!=null) {
			_FIELD_ID = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basket.total.column_name");
		if (s!=null) {
			_FIELD_TOTAL = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basket.typePayment.column_name");
		if (s!=null) {
			_FIELD_TYPEPAYMENT = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basket.date.column_name");
		if (s!=null) {
			_FIELD_DATE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basket.idClient.column_name");
		if (s!=null) {
			_FIELD_IDCLIENT = s;
		}
		
		initDeleteQuery();
		initSaveQuery();
	}
	
	/**
	 * Objet representant un alias de la table basket.
	 **/
	public static final TableAlias<persistence.beans.dao.IBasketTo> ALIAS = new JDBCTableAlias<persistence.beans.dao.IBasketTo>(persistence.beans.dao.IBasketTo.class, "basket", "basket");
	/**
	 * Retourne les colonnes pour faire les requetes la table Basket.<br>
	 * Méthode à usage générique, utilisez getBasketColumns() pour éviter les confusions
	 * @return BASKET_COLUMNS colonnes pour faire les requetes la table Basket
	 */
	public IBasketDao.BASKET_COLUMNS getColumns() {
		return getBasketColumns();
	}
	/**
	 * Retourne le nom de la table.
	 * @return String le nom de la table
	 */
	public String getTableName() {
		return _TABLE_NAME;
	}
	/**
	 * Classe regroupant les colonnes/fonctions disponibles pour les requetes.
	 * @author c-generator (c) Cardiweb
	 * @Deprecated utiliser la methode getBasketColumns() pour eviter de recupere des colonnes qui sont mal initialisees
	 **/
	@Deprecated
	public static interface BASKET_COLUMNS extends IBasketDao.BASKET_COLUMNS{
		/**
		 * Objet representant la colonne ID (propriete id) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn id = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, null, long.class);
		/**
		 * Objet representant la colonne ID (propriete id) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.MIN, long.class);
		/**
		 * Objet representant la colonne ID (propriete id) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.MAX, long.class);
		/**
		 * Objet representant la colonne ID (propriete id) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.COUNT, long.class);
		/**
		 * Objet representant la colonne ID (propriete id) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.SUM, long.class);
		/**
		 * Objet representant la colonne ID (propriete id) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.AVG, long.class);
		/**
		 * Objet representant la colonne TOTAL (propriete total) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn total = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, null, int.class);
		/**
		 * Objet representant la colonne TOTAL (propriete total) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn totalMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne TOTAL (propriete total) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn totalMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne TOTAL (propriete total) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn totalCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne TOTAL (propriete total) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn totalSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne TOTAL (propriete total) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn totalAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.AVG, int.class);
		/**
		 * Objet representant la colonne TYPE_PAYMENT (propriete typePayment) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typePayment = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, null, int.class);
		/**
		 * Objet representant la colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typePaymentMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typePaymentMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typePaymentCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typePaymentSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne TYPE_PAYMENT (propriete typePayment) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typePaymentAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.AVG, int.class);
		/**
		 * Objet representant la colonne DATE (propriete date) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn date = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "date", _FIELD_DATE, null, java.sql.Timestamp.class);
		/**
		 * Objet representant la colonne DATE (propriete date) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn dateMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "date", _FIELD_DATE, JDBCFunction.MIN, java.sql.Timestamp.class);
		/**
		 * Objet representant la colonne DATE (propriete date) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn dateMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "date", _FIELD_DATE, JDBCFunction.MAX, java.sql.Timestamp.class);
		/**
		 * Objet representant la colonne DATE (propriete date) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn dateCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "date", _FIELD_DATE, JDBCFunction.COUNT, java.sql.Timestamp.class);
		/**
		 * Objet representant la colonne ID_CLIENT (propriete idClient) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idClient = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, null, long.class);
		/**
		 * Objet representant la colonne ID_CLIENT (propriete idClient) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idClientMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.MIN, long.class);
		/**
		 * Objet representant la colonne ID_CLIENT (propriete idClient) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idClientMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.MAX, long.class);
		/**
		 * Objet representant la colonne ID_CLIENT (propriete idClient) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idClientCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.COUNT, long.class);
		/**
		 * Objet representant la colonne ID_CLIENT (propriete idClient) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idClientSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.SUM, long.class);
		/**
		 * Objet representant la colonne ID_CLIENT (propriete idClient) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idClientAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.AVG, long.class);
	}
	private IBasketDao.BASKET_COLUMNS columns = null;
	/**
	 * Recupere les colonnes/fonctions disponibles pour les requetes.
	 * @author c-generator (c) Cardiweb
	 **/
	public IBasketDao.BASKET_COLUMNS getBasketColumns(){
		if (columns == null) {
			IBasketDao.BASKET_COLUMNS temp = new BASKET_COLUMNS() {
				private QueryColumn columnId = null;
				public QueryColumn getId(){
					if( columnId == null ){
						columnId = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, null, long.class);
					}
					return columnId;
				}
				private QueryColumn columnIdMIN = null;
				public QueryColumn getIdMIN(){
					if( columnIdMIN == null ){
						columnIdMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.MIN, long.class);
					}
					return columnIdMIN;
				}
				private QueryColumn columnIdMAX = null;
				public QueryColumn getIdMAX(){
					if( columnIdMAX == null ){
						columnIdMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.MAX, long.class);
					}
					return columnIdMAX;
				}
				private QueryColumn columnIdCOUNT = null;
				public QueryColumn getIdCOUNT(){
					if( columnIdCOUNT == null ){
						columnIdCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.COUNT, long.class);
					}
					return columnIdCOUNT;
				}
				private QueryColumn columnIdSUM = null;
				public QueryColumn getIdSUM(){
					if( columnIdSUM == null ){
						columnIdSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.SUM, long.class);
					}
					return columnIdSUM;
				}
				private QueryColumn columnIdAVG = null;
				public QueryColumn getIdAVG(){
					if( columnIdAVG == null ){
						columnIdAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "id", _FIELD_ID, JDBCFunction.AVG, long.class);
					}
					return columnIdAVG;
				}
				private QueryColumn columnTotal = null;
				public QueryColumn getTotal(){
					if( columnTotal == null ){
						columnTotal = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, null, int.class);
					}
					return columnTotal;
				}
				private QueryColumn columnTotalMIN = null;
				public QueryColumn getTotalMIN(){
					if( columnTotalMIN == null ){
						columnTotalMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.MIN, int.class);
					}
					return columnTotalMIN;
				}
				private QueryColumn columnTotalMAX = null;
				public QueryColumn getTotalMAX(){
					if( columnTotalMAX == null ){
						columnTotalMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.MAX, int.class);
					}
					return columnTotalMAX;
				}
				private QueryColumn columnTotalCOUNT = null;
				public QueryColumn getTotalCOUNT(){
					if( columnTotalCOUNT == null ){
						columnTotalCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.COUNT, int.class);
					}
					return columnTotalCOUNT;
				}
				private QueryColumn columnTotalSUM = null;
				public QueryColumn getTotalSUM(){
					if( columnTotalSUM == null ){
						columnTotalSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.SUM, int.class);
					}
					return columnTotalSUM;
				}
				private QueryColumn columnTotalAVG = null;
				public QueryColumn getTotalAVG(){
					if( columnTotalAVG == null ){
						columnTotalAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "total", _FIELD_TOTAL, JDBCFunction.AVG, int.class);
					}
					return columnTotalAVG;
				}
				private QueryColumn columnTypePayment = null;
				public QueryColumn getTypePayment(){
					if( columnTypePayment == null ){
						columnTypePayment = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, null, int.class);
					}
					return columnTypePayment;
				}
				private QueryColumn columnTypePaymentMIN = null;
				public QueryColumn getTypePaymentMIN(){
					if( columnTypePaymentMIN == null ){
						columnTypePaymentMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.MIN, int.class);
					}
					return columnTypePaymentMIN;
				}
				private QueryColumn columnTypePaymentMAX = null;
				public QueryColumn getTypePaymentMAX(){
					if( columnTypePaymentMAX == null ){
						columnTypePaymentMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.MAX, int.class);
					}
					return columnTypePaymentMAX;
				}
				private QueryColumn columnTypePaymentCOUNT = null;
				public QueryColumn getTypePaymentCOUNT(){
					if( columnTypePaymentCOUNT == null ){
						columnTypePaymentCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.COUNT, int.class);
					}
					return columnTypePaymentCOUNT;
				}
				private QueryColumn columnTypePaymentSUM = null;
				public QueryColumn getTypePaymentSUM(){
					if( columnTypePaymentSUM == null ){
						columnTypePaymentSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.SUM, int.class);
					}
					return columnTypePaymentSUM;
				}
				private QueryColumn columnTypePaymentAVG = null;
				public QueryColumn getTypePaymentAVG(){
					if( columnTypePaymentAVG == null ){
						columnTypePaymentAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typePayment", _FIELD_TYPEPAYMENT, JDBCFunction.AVG, int.class);
					}
					return columnTypePaymentAVG;
				}
				private QueryColumn columnDate = null;
				public QueryColumn getDate(){
					if( columnDate == null ){
						columnDate = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "date", _FIELD_DATE, null, java.sql.Timestamp.class);
					}
					return columnDate;
				}
				private QueryColumn columnDateMIN = null;
				public QueryColumn getDateMIN(){
					if( columnDateMIN == null ){
						columnDateMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "date", _FIELD_DATE, JDBCFunction.MIN, java.sql.Timestamp.class);
					}
					return columnDateMIN;
				}
				private QueryColumn columnDateMAX = null;
				public QueryColumn getDateMAX(){
					if( columnDateMAX == null ){
						columnDateMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "date", _FIELD_DATE, JDBCFunction.MAX, java.sql.Timestamp.class);
					}
					return columnDateMAX;
				}
				private QueryColumn columnDateCOUNT = null;
				public QueryColumn getDateCOUNT(){
					if( columnDateCOUNT == null ){
						columnDateCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "date", _FIELD_DATE, JDBCFunction.COUNT, java.sql.Timestamp.class);
					}
					return columnDateCOUNT;
				}
				private QueryColumn columnIdClient = null;
				public QueryColumn getIdClient(){
					if( columnIdClient == null ){
						columnIdClient = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, null, long.class);
					}
					return columnIdClient;
				}
				private QueryColumn columnIdClientMIN = null;
				public QueryColumn getIdClientMIN(){
					if( columnIdClientMIN == null ){
						columnIdClientMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.MIN, long.class);
					}
					return columnIdClientMIN;
				}
				private QueryColumn columnIdClientMAX = null;
				public QueryColumn getIdClientMAX(){
					if( columnIdClientMAX == null ){
						columnIdClientMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.MAX, long.class);
					}
					return columnIdClientMAX;
				}
				private QueryColumn columnIdClientCOUNT = null;
				public QueryColumn getIdClientCOUNT(){
					if( columnIdClientCOUNT == null ){
						columnIdClientCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.COUNT, long.class);
					}
					return columnIdClientCOUNT;
				}
				private QueryColumn columnIdClientSUM = null;
				public QueryColumn getIdClientSUM(){
					if( columnIdClientSUM == null ){
						columnIdClientSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.SUM, long.class);
					}
					return columnIdClientSUM;
				}
				private QueryColumn columnIdClientAVG = null;
				public QueryColumn getIdClientAVG(){
					if( columnIdClientAVG == null ){
						columnIdClientAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idClient", _FIELD_IDCLIENT, JDBCFunction.AVG, long.class);
					}
					return columnIdClientAVG;
				}
			};
			columns = temp;
		}
		return columns;
	}
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketTo
	 */
	public PersistenceQuery<persistence.beans.dao.IBasketTo> newQuery() {
		return new PersistenceQueryBasketVersion((persistence.beans.dao.impl.cg.BasketDaoCgImpl)this);
	}
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketTo dans une sous-requête
	 * @param parentQuery requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketTo dans une sous-requête
	 */
	public PersistenceQuery<persistence.beans.dao.IBasketTo> newSubQuery(PersistenceQuery<?> parentQuery) {
		return new PersistenceQueryBasketVersion((persistence.beans.dao.impl.cg.BasketDaoCgImpl)this, parentQuery);
	}
	
	private static class PersistenceQueryBasketVersion extends JDBCPersistenceQuery<persistence.beans.dao.IBasketTo> {
		private persistence.beans.dao.impl.cg.BasketDaoCgImpl _dao;
		/**
		 * Constructeur pour ce PersistenceQuery.
		 *
		 * @param dao
		 */
		public PersistenceQueryBasketVersion(persistence.beans.dao.impl.cg.BasketDaoCgImpl dao) {
			super(ALIAS, true);
			_dao=dao;
			init();
		}
		
		/**
		 * Construire une sous-requête pour ce PersistenceQuery.
		 *
		 * @param dao
		 * @param parentQuery
		 */
		public PersistenceQueryBasketVersion(persistence.beans.dao.impl.cg.BasketDaoCgImpl dao, PersistenceQuery<?> parentQuery) {
			super(ALIAS, true, parentQuery);
			_dao=dao;
			init();
		}
		
		@Override
		protected GeneratorRuntime getGeneratorRuntime() {
			return _dao.getGeneratorRuntime();
		}
		
		@Override
		protected persistence.beans.dao.IBasketTo loadObjectFromRS(ResultSet rs) {
			
			try {
				
				String ___key = null;
				Object cacheValue = null;
				if (useCache) {
					long id = rs.getLong(_FIELD_ID);
					___key = _dao.getCacheKey(id);
					cacheValue = _dao.getCache().getByKey(___key);
				}
				if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
					
					persistence.beans.dao.impl.cg.BasketToCgImpl object = (persistence.beans.dao.impl.cg.BasketToCgImpl)_dao.create();
					object.setNew(false);
					object.setId(rs.getLong(_FIELD_ID));
					object.setTotal(rs.getInt(_FIELD_TOTAL));
					object.setTypePayment(rs.getInt(_FIELD_TYPEPAYMENT));
					object.setDate(rs.getTimestamp(_FIELD_DATE));
					object.setIdClient(rs.getLong(_FIELD_IDCLIENT));
					
					if (useCache) { _dao.getCache().putByKey(___key, object); }
					return object;
				}
				return (persistence.beans.dao.IBasketTo)cacheValue;
			} catch (SQLException sqle) {
				throw new PersistenceException("", sqle);
			}
		}
		
		private static List<String> primaryKeyColumnList = new java.util.ArrayList<String>();
		static {
			List<String> l = new java.util.ArrayList<String>();
			l.add(_FIELD_ID);
			primaryKeyColumnList=l;
		}
		@Override
		protected List<String> getPrimaryKeyColumnList() {
			return primaryKeyColumnList;
		}
	}
	
	protected void fillSQLPrimaryParameters(int offset, PreparedStatement pst,persistence.beans.dao.IBasketTo obj) throws SQLException {
		// visibilite 'protected' afin de pouvoir etre utilise par les blobs.
		pst.setLong(0+offset, obj.getId());
	}
	
	/**
	 * Methode de generation de la propriete id.<br/>
	 * Cette methode ne doit rien affecter mais simplement renvoyer la valeur.<br/>
	 * @return une id genere pour la propriete id de l'objet en cours.
	 */
	protected long generateSpecificIdForId() {
		return getGeneratorRuntime().generateLongId();
	}
	public Observable<persistence.beans.dao.IBasketTo> getById(long id) {
		return getBasket(id);
	}
	
	
	/**
	 * Getter principal : retourne l'objet Basket en fonction de sa clee.
	 * @param id la valeur de la clee id
	 * @return l'objet correspondant a la clee ou null si aucun objet n'a ete trouve.
	 */
	public Observable<persistence.beans.dao.IBasketTo> getBasket(long id) {
		String ___key = getCacheKey(id);
		Object retour = getCache().getByKey(___key);
		if (retour==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			return Observable.just((persistence.beans.dao.IBasketTo) null);
		} else
		if (retour!=null) {
			return Observable.just((persistence.beans.dao.IBasketTo) retour);
		}
		
		return Observable.create((OnSubscribe<persistence.beans.dao.IBasketTo>) subscriber -> {
			synchronized(getCache()) {
				Object r = getCache().getByKey(___key);
				if (r==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
					if (!subscriber.isUnsubscribed()) {
						subscriber.onNext(null);
						subscriber.onCompleted();
					}
					return;
				} else
				if (r==null) {
					r = newQuery().equal(BASKET_COLUMNS.id, id)	.getObject().subscribe(obj -> {
						try {
							if (obj == null) {
								getCache().putByKey(___key, com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound());
							} else {
								getCache().putByKey(___key, obj);
							}
							if (!subscriber.isUnsubscribed()) {
								subscriber.onNext(obj);
							}
						} finally {
							if (!subscriber.isUnsubscribed()) {
								subscriber.onCompleted();
							}
						}
					});
					
				} else {
					if (!subscriber.isUnsubscribed()) {
						subscriber.onNext((persistence.beans.dao.IBasketTo) r);
						subscriber.onCompleted();
					}
				}
			}
		})
		
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler())
		.observeOn(getGeneratorRuntime().getObserveOnScheduler());
		
	}
	
	private void initSaveQuery() {
		
		
		INSERT_QUERY = "insert into "+_TABLE_FULL_NAME+" ("+_FIELD_TOTAL+","+_FIELD_TYPEPAYMENT+","+_FIELD_DATE+","+_FIELD_IDCLIENT+","+_FIELD_ID+") values (?,?,?,?,?)";
		UPDATE_QUERY = "update "+_TABLE_FULL_NAME+" set "+_FIELD_TOTAL+"=?,"+_FIELD_TYPEPAYMENT+"=?,"+_FIELD_DATE+"=?,"+_FIELD_IDCLIENT+"=? where "+_FIELD_ID+"=?";
	}
	
	private String INSERT_QUERY;
	private String UPDATE_QUERY;
	public Observable<Void> save(persistence.beans.dao.IBasketTo _obj) {
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		persistence.beans.dao.impl.cg.BasketToCgImpl obj = (persistence.beans.dao.impl.cg.BasketToCgImpl)_obj;
		
		return Observable
		.create((OnSubscribe<Void>) subscriber -> {
			try {
				String query=obj.isNew()?INSERT_QUERY:UPDATE_QUERY;
				if (query!=null) {
					if (obj.isNew()) { generateIds(obj); }
					Connection c = getGeneratorRuntime().getConnection();
					PreparedStatement pst = null;
					try {
						pst = c.prepareStatement(query);
						pst.setInt(1, obj.getTotal());
						pst.setInt(2, obj.getTypePayment());
						pst.setTimestamp(3, obj.getDate());
						pst.setLong(4, obj.getIdClient());
						fillSQLPrimaryParameters(5, pst, obj);
						pst.executeUpdate();
					} finally {
						if (pst!=null) try { pst.close(); } catch (Exception e) { logger.error("", e); }
						getGeneratorRuntime().freeConnection(c);
					}
				}
				if (obj.isNew()) {
					getCache().putByKey(obj.getCacheKey(), obj);
				} else {
					getCache().removeByKey(obj.getCacheKey());
					getCache().putByKey(obj.getCacheKey(), obj);
				}
				clearListCache();
				obj.setNew(false);
				obj.clearLocalCache();
				
				if (!subscriber.isUnsubscribed()) {
					subscriber.onNext(null);
				}
			} catch (Exception e) {
				throw new RuntimeException("Erreur lors de la sauvegarde de l'objet "+obj.getCacheKey(), e);
			} finally {
				if (!subscriber.isUnsubscribed()) {
					subscriber.onCompleted();
				}
			}
		})
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler())
		.observeOn(getGeneratorRuntime().getObserveOnScheduler());
	}
	
	private JDBCPersistenceQuery<persistence.beans.dao.IBasketTo> _cachePersistenceQuery;
	public void clearListCache() {
		if (_cachePersistenceQuery==null) {
			_cachePersistenceQuery = (JDBCPersistenceQuery<persistence.beans.dao.IBasketTo>)newQuery();
		}
		_cachePersistenceQuery.clearListCache(persistence.beans.dao.IBasketTo.class);
	}
	
	/**
	 * Cette methode genere toutes les valeurs pour les clee qui n'ont pas encore
	 * ete affectees.
	 *
	 * @param obj
	 */
	protected void generateIds(persistence.beans.dao.impl.cg.BasketToCgImpl obj) {
		if (obj.getId()==-1) {
			obj.setId(generateSpecificIdForId());
		}
	}
	private String DELETE_QUERY;
	private void initDeleteQuery() {
		
		
		DELETE_QUERY="delete from "+_TABLE_FULL_NAME+" where "+_FIELD_ID+"=?";
		
	}
	
	public Observable<Void> delete(persistence.beans.dao.IBasketTo _obj) {
		
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		
		return Observable
		.create((OnSubscribe<Void>) subscriber -> {
			persistence.beans.dao.impl.cg.BasketToCgImpl obj = (persistence.beans.dao.impl.cg.BasketToCgImpl)_obj;
			
			try {
				Connection c = getGeneratorRuntime().getConnection();
				PreparedStatement pst = null;
				try {
					pst = c.prepareStatement(DELETE_QUERY);
					fillSQLPrimaryParameters(1, pst, obj);
					pst.executeUpdate();
				} finally {
					if (pst!=null) try { pst.close(); } catch (Exception e) { logger.error("", e); }
					getGeneratorRuntime().freeConnection(c);
				}
				
				getCache().removeByKey(obj.getCacheKey());
				obj.clearLocalCache();
				clearListCache();
				
				if (!subscriber.isUnsubscribed()) {
					subscriber.onNext(null);
				}
			} catch (Exception e) {
				throw new RuntimeException("Erreur lors de la suppression de l'objet "+obj.getCacheKey(), e);
			} finally {
				if (!subscriber.isUnsubscribed()) {
					subscriber.onCompleted();
				}
			}
		})
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler())
		.observeOn(getGeneratorRuntime().getObserveOnScheduler());
	}
	public persistence.beans.dao.IBasketTo create() {
		return new persistence.beans.dao.impl.cg.BasketToCgImpl();
	}
	/**
	 * Retourne la liste de tous les objets en base de donnee.
	 * @return la liste de tous les objets en base de donnee.
	 */
	public Observable<List<persistence.beans.dao.IBasketTo>> getList() {
		return newQuery().getList();
	}
	/**
	 * Getter lie a l'index client.
	 * @param idClient la valeur de la colonne idClient
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IBasketTo>> getBasketListParIdClient(long idClient) {
		return newQuery().equal(BASKET_COLUMNS.idClient, idClient).getList();
	}
	
	/**
	 * TOUTES les proprietes de l'objet sont source sont copiees dans l'objet destination
	 * MEME les blobs (les references des blobs)...
	 * @param src L'objet source depuis lequel copier les proprietes
	 * @param dest L'objet vers lequel copier les proprietes
	 */
	public void copy(persistence.beans.dao.IBasketTo src, persistence.beans.dao.IBasketTo dest) {
		dest.setId(src.getId());
		dest.setTotal(src.getTotal());
		dest.setTypePayment(src.getTypePayment());
		dest.setDate(src.getDate());
		dest.setIdClient(src.getIdClient());
		
		dest.setNew(src.isNew());
	}
	
}
