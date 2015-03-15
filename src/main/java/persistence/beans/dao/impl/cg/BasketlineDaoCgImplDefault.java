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

import persistence.beans.dao.IBasketlineDao;
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
public abstract class BasketlineDaoCgImplDefault implements IBasketlineDao {
	
	static protected final Logger logger = Logger.getLogger(BasketlineDaoCgImplDefault.class);
	
	public BasketlineDaoCgImplDefault() {
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
		return getGeneratorRuntime().getCache("persistence.beans.dao.IBasketlineTo");
	}
	
	/**
	 * Cette methode permet de regarder dans le cache si cet objet existe deja.<br/>
	 * Si oui, c'est l'objet dans le cache qui est retourne.<br/>
	 * Si non, c'est l'objet passe en parametre qui est retourne.<br/>
	 * @param object l'objet dont il faut tester la presence dans le cache.
	 * @return si l'objet est deja dans le cache, la version en cache. Sinon, l'objet en parametre.
	 * @throws NullPointerException si object est null.
	 */
	protected persistence.beans.dao.impl.cg.BasketlineToCgImpl selectCacheObject(persistence.beans.dao.impl.cg.BasketlineToCgImpl object) {
		String key = object.getCacheKey();
		Object cacheValue=getCache().getByKey(key);
		if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			getCache().putByKey(key, object);
			return object;
		}
		return (persistence.beans.dao.impl.cg.BasketlineToCgImpl)cacheValue;
	}
	
	/**
	 * Cette methode genere une clee chaine unique dependant des arguments.<br/>
	 * Actuellement, elle ne fait que concatener les clees et retourner une chaine.<br/>
	 * @param id la valeur pour id
	 * @return Une chaine representant de facon unique les parametres.
	 */
	protected String getCacheKey(long id) {
		return "persistence.beans.dao.impl.cg.Basketline_"+id;
	}
	protected String _TABLE_SCHEMA = null;
	protected String _TABLE_NAME = "basketline";
	protected String _TABLE_FULL_NAME = null;
	protected static String _FIELD_ID = "ID";
	protected static String _FIELD_IDPRESTATION = "ID_PRESTATION";
	protected static String _FIELD_IDPRODUIT = "ID_PRODUIT";
	protected static String _FIELD_PRIXAVECREDUCTION = "PRIX_AVEC_REDUCTION";
	protected static String _FIELD_QUANTITE = "QUANTITE";
	protected static String _FIELD_REDUCTION = "REDUCTION";
	protected static String _FIELD_TYPEDEREDUCTION = "TYPE_DE_REDUCTION";
	protected static String _FIELD_IDBASKET = "ID_BASKET";
	
	private void initSchema() {
		String s = null;
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.table_name");
		if (s!=null) {
			_TABLE_NAME = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.table_alias");
		if (s!=null) {
			ALIAS.setAlias(s);
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.schema_name");
		if (s==null) {
			s = getGeneratorRuntime().getStringProperty("c-generator.persistence.schema_name");
		}
		if (s!=null) {
			_TABLE_SCHEMA =  "null".equals(s)?null:s;
		}
		_TABLE_FULL_NAME = (_TABLE_SCHEMA==null?"":(_TABLE_SCHEMA+"."))+ "" + _TABLE_NAME + "";
		ALIAS.init(_TABLE_FULL_NAME);
		
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.id.column_name");
		if (s!=null) {
			_FIELD_ID = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.idPrestation.column_name");
		if (s!=null) {
			_FIELD_IDPRESTATION = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.idProduit.column_name");
		if (s!=null) {
			_FIELD_IDPRODUIT = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.prixAvecReduction.column_name");
		if (s!=null) {
			_FIELD_PRIXAVECREDUCTION = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.quantite.column_name");
		if (s!=null) {
			_FIELD_QUANTITE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.reduction.column_name");
		if (s!=null) {
			_FIELD_REDUCTION = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.typeDeReduction.column_name");
		if (s!=null) {
			_FIELD_TYPEDEREDUCTION = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Basketline.idBasket.column_name");
		if (s!=null) {
			_FIELD_IDBASKET = s;
		}
		
		initDeleteQuery();
		initSaveQuery();
	}
	
	/**
	 * Objet representant un alias de la table basketline.
	 **/
	public static final TableAlias<persistence.beans.dao.IBasketlineTo> ALIAS = new JDBCTableAlias<persistence.beans.dao.IBasketlineTo>(persistence.beans.dao.IBasketlineTo.class, "basketline", "basketline");
	/**
	 * Retourne les colonnes pour faire les requetes la table Basketline.<br>
	 * Méthode à usage générique, utilisez getBasketlineColumns() pour éviter les confusions
	 * @return BASKETLINE_COLUMNS colonnes pour faire les requetes la table Basketline
	 */
	public IBasketlineDao.BASKETLINE_COLUMNS getColumns() {
		return getBasketlineColumns();
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
	 * @Deprecated utiliser la methode getBasketlineColumns() pour eviter de recupere des colonnes qui sont mal initialisees
	 **/
	@Deprecated
	public static interface BASKETLINE_COLUMNS extends IBasketlineDao.BASKETLINE_COLUMNS{
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
		 * Objet representant la colonne ID_PRESTATION (propriete idPrestation) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestation = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, null, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.MIN, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.MAX, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.COUNT, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.SUM, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION (propriete idPrestation) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.AVG, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT (propriete idProduit) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduit = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, null, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.MIN, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.MAX, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.COUNT, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.SUM, java.lang.Long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT (propriete idProduit) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.AVG, java.lang.Long.class);
		/**
		 * Objet representant la colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAvecReduction = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, null, int.class);
		/**
		 * Objet representant la colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAvecReductionMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAvecReductionMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAvecReductionCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAvecReductionSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne PRIX_AVEC_REDUCTION (propriete prixAvecReduction) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAvecReductionAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.AVG, int.class);
		/**
		 * Objet representant la colonne QUANTITE (propriete quantite) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn quantite = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, null, int.class);
		/**
		 * Objet representant la colonne QUANTITE (propriete quantite) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn quantiteMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne QUANTITE (propriete quantite) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn quantiteMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne QUANTITE (propriete quantite) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn quantiteCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne QUANTITE (propriete quantite) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn quantiteSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne QUANTITE (propriete quantite) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn quantiteAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.AVG, int.class);
		/**
		 * Objet representant la colonne REDUCTION (propriete reduction) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn reduction = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, null, java.lang.Integer.class);
		/**
		 * Objet representant la colonne REDUCTION (propriete reduction) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn reductionMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.MIN, java.lang.Integer.class);
		/**
		 * Objet representant la colonne REDUCTION (propriete reduction) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn reductionMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.MAX, java.lang.Integer.class);
		/**
		 * Objet representant la colonne REDUCTION (propriete reduction) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn reductionCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.COUNT, java.lang.Integer.class);
		/**
		 * Objet representant la colonne REDUCTION (propriete reduction) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn reductionSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.SUM, java.lang.Integer.class);
		/**
		 * Objet representant la colonne REDUCTION (propriete reduction) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn reductionAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.AVG, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TYPE_DE_REDUCTION (propriete typeDeReduction) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typeDeReduction = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, null, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typeDeReductionMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.MIN, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typeDeReductionMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.MAX, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typeDeReductionCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.COUNT, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typeDeReductionSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.SUM, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TYPE_DE_REDUCTION (propriete typeDeReduction) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn typeDeReductionAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.AVG, java.lang.Integer.class);
		/**
		 * Objet representant la colonne ID_BASKET (propriete idBasket) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idBasket = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, null, long.class);
		/**
		 * Objet representant la colonne ID_BASKET (propriete idBasket) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idBasketMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.MIN, long.class);
		/**
		 * Objet representant la colonne ID_BASKET (propriete idBasket) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idBasketMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.MAX, long.class);
		/**
		 * Objet representant la colonne ID_BASKET (propriete idBasket) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idBasketCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.COUNT, long.class);
		/**
		 * Objet representant la colonne ID_BASKET (propriete idBasket) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idBasketSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.SUM, long.class);
		/**
		 * Objet representant la colonne ID_BASKET (propriete idBasket) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idBasketAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.AVG, long.class);
	}
	private IBasketlineDao.BASKETLINE_COLUMNS columns = null;
	/**
	 * Recupere les colonnes/fonctions disponibles pour les requetes.
	 * @author c-generator (c) Cardiweb
	 **/
	public IBasketlineDao.BASKETLINE_COLUMNS getBasketlineColumns(){
		if (columns == null) {
			IBasketlineDao.BASKETLINE_COLUMNS temp = new BASKETLINE_COLUMNS() {
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
				private QueryColumn columnIdPrestation = null;
				public QueryColumn getIdPrestation(){
					if( columnIdPrestation == null ){
						columnIdPrestation = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, null, java.lang.Long.class);
					}
					return columnIdPrestation;
				}
				private QueryColumn columnIdPrestationMIN = null;
				public QueryColumn getIdPrestationMIN(){
					if( columnIdPrestationMIN == null ){
						columnIdPrestationMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.MIN, java.lang.Long.class);
					}
					return columnIdPrestationMIN;
				}
				private QueryColumn columnIdPrestationMAX = null;
				public QueryColumn getIdPrestationMAX(){
					if( columnIdPrestationMAX == null ){
						columnIdPrestationMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.MAX, java.lang.Long.class);
					}
					return columnIdPrestationMAX;
				}
				private QueryColumn columnIdPrestationCOUNT = null;
				public QueryColumn getIdPrestationCOUNT(){
					if( columnIdPrestationCOUNT == null ){
						columnIdPrestationCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.COUNT, java.lang.Long.class);
					}
					return columnIdPrestationCOUNT;
				}
				private QueryColumn columnIdPrestationSUM = null;
				public QueryColumn getIdPrestationSUM(){
					if( columnIdPrestationSUM == null ){
						columnIdPrestationSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.SUM, java.lang.Long.class);
					}
					return columnIdPrestationSUM;
				}
				private QueryColumn columnIdPrestationAVG = null;
				public QueryColumn getIdPrestationAVG(){
					if( columnIdPrestationAVG == null ){
						columnIdPrestationAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.AVG, java.lang.Long.class);
					}
					return columnIdPrestationAVG;
				}
				private QueryColumn columnIdPrestationISNULL = null;
				public QueryColumn getIdPrestationISNULL(){
					if( columnIdPrestationISNULL == null ){
						columnIdPrestationISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestation", _FIELD_IDPRESTATION, JDBCFunction.ISNULL, java.lang.Long.class);
					}
					return columnIdPrestationISNULL;
				}
				private QueryColumn columnIdProduit = null;
				public QueryColumn getIdProduit(){
					if( columnIdProduit == null ){
						columnIdProduit = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, null, java.lang.Long.class);
					}
					return columnIdProduit;
				}
				private QueryColumn columnIdProduitMIN = null;
				public QueryColumn getIdProduitMIN(){
					if( columnIdProduitMIN == null ){
						columnIdProduitMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.MIN, java.lang.Long.class);
					}
					return columnIdProduitMIN;
				}
				private QueryColumn columnIdProduitMAX = null;
				public QueryColumn getIdProduitMAX(){
					if( columnIdProduitMAX == null ){
						columnIdProduitMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.MAX, java.lang.Long.class);
					}
					return columnIdProduitMAX;
				}
				private QueryColumn columnIdProduitCOUNT = null;
				public QueryColumn getIdProduitCOUNT(){
					if( columnIdProduitCOUNT == null ){
						columnIdProduitCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.COUNT, java.lang.Long.class);
					}
					return columnIdProduitCOUNT;
				}
				private QueryColumn columnIdProduitSUM = null;
				public QueryColumn getIdProduitSUM(){
					if( columnIdProduitSUM == null ){
						columnIdProduitSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.SUM, java.lang.Long.class);
					}
					return columnIdProduitSUM;
				}
				private QueryColumn columnIdProduitAVG = null;
				public QueryColumn getIdProduitAVG(){
					if( columnIdProduitAVG == null ){
						columnIdProduitAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.AVG, java.lang.Long.class);
					}
					return columnIdProduitAVG;
				}
				private QueryColumn columnIdProduitISNULL = null;
				public QueryColumn getIdProduitISNULL(){
					if( columnIdProduitISNULL == null ){
						columnIdProduitISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduit", _FIELD_IDPRODUIT, JDBCFunction.ISNULL, java.lang.Long.class);
					}
					return columnIdProduitISNULL;
				}
				private QueryColumn columnPrixAvecReduction = null;
				public QueryColumn getPrixAvecReduction(){
					if( columnPrixAvecReduction == null ){
						columnPrixAvecReduction = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, null, int.class);
					}
					return columnPrixAvecReduction;
				}
				private QueryColumn columnPrixAvecReductionMIN = null;
				public QueryColumn getPrixAvecReductionMIN(){
					if( columnPrixAvecReductionMIN == null ){
						columnPrixAvecReductionMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.MIN, int.class);
					}
					return columnPrixAvecReductionMIN;
				}
				private QueryColumn columnPrixAvecReductionMAX = null;
				public QueryColumn getPrixAvecReductionMAX(){
					if( columnPrixAvecReductionMAX == null ){
						columnPrixAvecReductionMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.MAX, int.class);
					}
					return columnPrixAvecReductionMAX;
				}
				private QueryColumn columnPrixAvecReductionCOUNT = null;
				public QueryColumn getPrixAvecReductionCOUNT(){
					if( columnPrixAvecReductionCOUNT == null ){
						columnPrixAvecReductionCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.COUNT, int.class);
					}
					return columnPrixAvecReductionCOUNT;
				}
				private QueryColumn columnPrixAvecReductionSUM = null;
				public QueryColumn getPrixAvecReductionSUM(){
					if( columnPrixAvecReductionSUM == null ){
						columnPrixAvecReductionSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.SUM, int.class);
					}
					return columnPrixAvecReductionSUM;
				}
				private QueryColumn columnPrixAvecReductionAVG = null;
				public QueryColumn getPrixAvecReductionAVG(){
					if( columnPrixAvecReductionAVG == null ){
						columnPrixAvecReductionAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAvecReduction", _FIELD_PRIXAVECREDUCTION, JDBCFunction.AVG, int.class);
					}
					return columnPrixAvecReductionAVG;
				}
				private QueryColumn columnQuantite = null;
				public QueryColumn getQuantite(){
					if( columnQuantite == null ){
						columnQuantite = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, null, int.class);
					}
					return columnQuantite;
				}
				private QueryColumn columnQuantiteMIN = null;
				public QueryColumn getQuantiteMIN(){
					if( columnQuantiteMIN == null ){
						columnQuantiteMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.MIN, int.class);
					}
					return columnQuantiteMIN;
				}
				private QueryColumn columnQuantiteMAX = null;
				public QueryColumn getQuantiteMAX(){
					if( columnQuantiteMAX == null ){
						columnQuantiteMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.MAX, int.class);
					}
					return columnQuantiteMAX;
				}
				private QueryColumn columnQuantiteCOUNT = null;
				public QueryColumn getQuantiteCOUNT(){
					if( columnQuantiteCOUNT == null ){
						columnQuantiteCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.COUNT, int.class);
					}
					return columnQuantiteCOUNT;
				}
				private QueryColumn columnQuantiteSUM = null;
				public QueryColumn getQuantiteSUM(){
					if( columnQuantiteSUM == null ){
						columnQuantiteSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.SUM, int.class);
					}
					return columnQuantiteSUM;
				}
				private QueryColumn columnQuantiteAVG = null;
				public QueryColumn getQuantiteAVG(){
					if( columnQuantiteAVG == null ){
						columnQuantiteAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "quantite", _FIELD_QUANTITE, JDBCFunction.AVG, int.class);
					}
					return columnQuantiteAVG;
				}
				private QueryColumn columnReduction = null;
				public QueryColumn getReduction(){
					if( columnReduction == null ){
						columnReduction = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, null, java.lang.Integer.class);
					}
					return columnReduction;
				}
				private QueryColumn columnReductionMIN = null;
				public QueryColumn getReductionMIN(){
					if( columnReductionMIN == null ){
						columnReductionMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.MIN, java.lang.Integer.class);
					}
					return columnReductionMIN;
				}
				private QueryColumn columnReductionMAX = null;
				public QueryColumn getReductionMAX(){
					if( columnReductionMAX == null ){
						columnReductionMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.MAX, java.lang.Integer.class);
					}
					return columnReductionMAX;
				}
				private QueryColumn columnReductionCOUNT = null;
				public QueryColumn getReductionCOUNT(){
					if( columnReductionCOUNT == null ){
						columnReductionCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.COUNT, java.lang.Integer.class);
					}
					return columnReductionCOUNT;
				}
				private QueryColumn columnReductionSUM = null;
				public QueryColumn getReductionSUM(){
					if( columnReductionSUM == null ){
						columnReductionSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.SUM, java.lang.Integer.class);
					}
					return columnReductionSUM;
				}
				private QueryColumn columnReductionAVG = null;
				public QueryColumn getReductionAVG(){
					if( columnReductionAVG == null ){
						columnReductionAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.AVG, java.lang.Integer.class);
					}
					return columnReductionAVG;
				}
				private QueryColumn columnReductionISNULL = null;
				public QueryColumn getReductionISNULL(){
					if( columnReductionISNULL == null ){
						columnReductionISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "reduction", _FIELD_REDUCTION, JDBCFunction.ISNULL, java.lang.Integer.class);
					}
					return columnReductionISNULL;
				}
				private QueryColumn columnTypeDeReduction = null;
				public QueryColumn getTypeDeReduction(){
					if( columnTypeDeReduction == null ){
						columnTypeDeReduction = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, null, java.lang.Integer.class);
					}
					return columnTypeDeReduction;
				}
				private QueryColumn columnTypeDeReductionMIN = null;
				public QueryColumn getTypeDeReductionMIN(){
					if( columnTypeDeReductionMIN == null ){
						columnTypeDeReductionMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.MIN, java.lang.Integer.class);
					}
					return columnTypeDeReductionMIN;
				}
				private QueryColumn columnTypeDeReductionMAX = null;
				public QueryColumn getTypeDeReductionMAX(){
					if( columnTypeDeReductionMAX == null ){
						columnTypeDeReductionMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.MAX, java.lang.Integer.class);
					}
					return columnTypeDeReductionMAX;
				}
				private QueryColumn columnTypeDeReductionCOUNT = null;
				public QueryColumn getTypeDeReductionCOUNT(){
					if( columnTypeDeReductionCOUNT == null ){
						columnTypeDeReductionCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.COUNT, java.lang.Integer.class);
					}
					return columnTypeDeReductionCOUNT;
				}
				private QueryColumn columnTypeDeReductionSUM = null;
				public QueryColumn getTypeDeReductionSUM(){
					if( columnTypeDeReductionSUM == null ){
						columnTypeDeReductionSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.SUM, java.lang.Integer.class);
					}
					return columnTypeDeReductionSUM;
				}
				private QueryColumn columnTypeDeReductionAVG = null;
				public QueryColumn getTypeDeReductionAVG(){
					if( columnTypeDeReductionAVG == null ){
						columnTypeDeReductionAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.AVG, java.lang.Integer.class);
					}
					return columnTypeDeReductionAVG;
				}
				private QueryColumn columnTypeDeReductionISNULL = null;
				public QueryColumn getTypeDeReductionISNULL(){
					if( columnTypeDeReductionISNULL == null ){
						columnTypeDeReductionISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "typeDeReduction", _FIELD_TYPEDEREDUCTION, JDBCFunction.ISNULL, java.lang.Integer.class);
					}
					return columnTypeDeReductionISNULL;
				}
				private QueryColumn columnIdBasket = null;
				public QueryColumn getIdBasket(){
					if( columnIdBasket == null ){
						columnIdBasket = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, null, long.class);
					}
					return columnIdBasket;
				}
				private QueryColumn columnIdBasketMIN = null;
				public QueryColumn getIdBasketMIN(){
					if( columnIdBasketMIN == null ){
						columnIdBasketMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.MIN, long.class);
					}
					return columnIdBasketMIN;
				}
				private QueryColumn columnIdBasketMAX = null;
				public QueryColumn getIdBasketMAX(){
					if( columnIdBasketMAX == null ){
						columnIdBasketMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.MAX, long.class);
					}
					return columnIdBasketMAX;
				}
				private QueryColumn columnIdBasketCOUNT = null;
				public QueryColumn getIdBasketCOUNT(){
					if( columnIdBasketCOUNT == null ){
						columnIdBasketCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.COUNT, long.class);
					}
					return columnIdBasketCOUNT;
				}
				private QueryColumn columnIdBasketSUM = null;
				public QueryColumn getIdBasketSUM(){
					if( columnIdBasketSUM == null ){
						columnIdBasketSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.SUM, long.class);
					}
					return columnIdBasketSUM;
				}
				private QueryColumn columnIdBasketAVG = null;
				public QueryColumn getIdBasketAVG(){
					if( columnIdBasketAVG == null ){
						columnIdBasketAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idBasket", _FIELD_IDBASKET, JDBCFunction.AVG, long.class);
					}
					return columnIdBasketAVG;
				}
			};
			columns = temp;
		}
		return columns;
	}
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketlineTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketlineTo
	 */
	public PersistenceQuery<persistence.beans.dao.IBasketlineTo> newQuery() {
		return new PersistenceQueryBasketlineVersion((persistence.beans.dao.impl.cg.BasketlineDaoCgImpl)this);
	}
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketlineTo dans une sous-requête
	 * @param parentQuery requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IBasketlineTo dans une sous-requête
	 */
	public PersistenceQuery<persistence.beans.dao.IBasketlineTo> newSubQuery(PersistenceQuery<?> parentQuery) {
		return new PersistenceQueryBasketlineVersion((persistence.beans.dao.impl.cg.BasketlineDaoCgImpl)this, parentQuery);
	}
	
	private static class PersistenceQueryBasketlineVersion extends JDBCPersistenceQuery<persistence.beans.dao.IBasketlineTo> {
		private persistence.beans.dao.impl.cg.BasketlineDaoCgImpl _dao;
		/**
		 * Constructeur pour ce PersistenceQuery.
		 *
		 * @param dao
		 */
		public PersistenceQueryBasketlineVersion(persistence.beans.dao.impl.cg.BasketlineDaoCgImpl dao) {
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
		public PersistenceQueryBasketlineVersion(persistence.beans.dao.impl.cg.BasketlineDaoCgImpl dao, PersistenceQuery<?> parentQuery) {
			super(ALIAS, true, parentQuery);
			_dao=dao;
			init();
		}
		
		@Override
		protected GeneratorRuntime getGeneratorRuntime() {
			return _dao.getGeneratorRuntime();
		}
		
		@Override
		protected persistence.beans.dao.IBasketlineTo loadObjectFromRS(ResultSet rs) {
			
			try {
				
				String ___key = null;
				Object cacheValue = null;
				if (useCache) {
					long id = rs.getLong(_FIELD_ID);
					___key = _dao.getCacheKey(id);
					cacheValue = _dao.getCache().getByKey(___key);
				}
				if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
					
					persistence.beans.dao.impl.cg.BasketlineToCgImpl object = (persistence.beans.dao.impl.cg.BasketlineToCgImpl)_dao.create();
					object.setNew(false);
					object.setId(rs.getLong(_FIELD_ID));
					rs.getObject("ID_PRESTATION");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setIdPrestation(rs.getLong(_FIELD_IDPRESTATION));
					}
					rs.getObject("ID_PRODUIT");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setIdProduit(rs.getLong(_FIELD_IDPRODUIT));
					}
					object.setPrixAvecReduction(rs.getInt(_FIELD_PRIXAVECREDUCTION));
					object.setQuantite(rs.getInt(_FIELD_QUANTITE));
					rs.getObject("REDUCTION");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setReduction(rs.getInt(_FIELD_REDUCTION));
					}
					rs.getObject("TYPE_DE_REDUCTION");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setTypeDeReduction(rs.getInt(_FIELD_TYPEDEREDUCTION));
					}
					object.setIdBasket(rs.getLong(_FIELD_IDBASKET));
					
					if (useCache) { _dao.getCache().putByKey(___key, object); }
					return object;
				}
				return (persistence.beans.dao.IBasketlineTo)cacheValue;
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
	
	protected void fillSQLPrimaryParameters(int offset, PreparedStatement pst,persistence.beans.dao.IBasketlineTo obj) throws SQLException {
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
	public Observable<persistence.beans.dao.IBasketlineTo> getById(long id) {
		return getBasketline(id);
	}
	
	
	/**
	 * Getter principal : retourne l'objet Basketline en fonction de sa clee.
	 * @param id la valeur de la clee id
	 * @return l'objet correspondant a la clee ou null si aucun objet n'a ete trouve.
	 */
	public Observable<persistence.beans.dao.IBasketlineTo> getBasketline(long id) {
		String ___key = getCacheKey(id);
		Object retour = getCache().getByKey(___key);
		if (retour==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			return Observable.just((persistence.beans.dao.IBasketlineTo) null);
		} else
		if (retour!=null) {
			return Observable.just((persistence.beans.dao.IBasketlineTo) retour);
		}
		
		return Observable.create((OnSubscribe<persistence.beans.dao.IBasketlineTo>) subscriber -> {
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
					r = newQuery().equal(BASKETLINE_COLUMNS.id, id)	.getObject().subscribe(obj -> {
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
						subscriber.onNext((persistence.beans.dao.IBasketlineTo) r);
						subscriber.onCompleted();
					}
				}
			}
		})
		
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler())
		.observeOn(getGeneratorRuntime().getObserveOnScheduler());
		
	}
	
	private void initSaveQuery() {
		
		
		INSERT_QUERY = "insert into "+_TABLE_FULL_NAME+" ("+_FIELD_IDPRESTATION+","+_FIELD_IDPRODUIT+","+_FIELD_PRIXAVECREDUCTION+","+_FIELD_QUANTITE+","+_FIELD_REDUCTION+","+_FIELD_TYPEDEREDUCTION+","+_FIELD_IDBASKET+","+_FIELD_ID+") values (?,?,?,?,?,?,?,?)";
		UPDATE_QUERY = "update "+_TABLE_FULL_NAME+" set "+_FIELD_IDPRESTATION+"=?,"+_FIELD_IDPRODUIT+"=?,"+_FIELD_PRIXAVECREDUCTION+"=?,"+_FIELD_QUANTITE+"=?,"+_FIELD_REDUCTION+"=?,"+_FIELD_TYPEDEREDUCTION+"=?,"+_FIELD_IDBASKET+"=? where "+_FIELD_ID+"=?";
	}
	
	private String INSERT_QUERY;
	private String UPDATE_QUERY;
	public Observable<Void> save(persistence.beans.dao.IBasketlineTo _obj) {
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		persistence.beans.dao.impl.cg.BasketlineToCgImpl obj = (persistence.beans.dao.impl.cg.BasketlineToCgImpl)_obj;
		
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
						if (obj.getIdPrestation()==null) { pst.setNull(1 , -5);} else { pst.setLong(1, obj.getIdPrestation());}
						if (obj.getIdProduit()==null) { pst.setNull(2 , -5);} else { pst.setLong(2, obj.getIdProduit());}
						pst.setInt(3, obj.getPrixAvecReduction());
						pst.setInt(4, obj.getQuantite());
						if (obj.getReduction()==null) { pst.setNull(5 , 4);} else { pst.setInt(5, obj.getReduction());}
						if (obj.getTypeDeReduction()==null) { pst.setNull(6 , 4);} else { pst.setInt(6, obj.getTypeDeReduction());}
						pst.setLong(7, obj.getIdBasket());
						fillSQLPrimaryParameters(8, pst, obj);
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
	
	private JDBCPersistenceQuery<persistence.beans.dao.IBasketlineTo> _cachePersistenceQuery;
	public void clearListCache() {
		if (_cachePersistenceQuery==null) {
			_cachePersistenceQuery = (JDBCPersistenceQuery<persistence.beans.dao.IBasketlineTo>)newQuery();
		}
		_cachePersistenceQuery.clearListCache(persistence.beans.dao.IBasketlineTo.class);
	}
	
	/**
	 * Cette methode genere toutes les valeurs pour les clee qui n'ont pas encore
	 * ete affectees.
	 *
	 * @param obj
	 */
	protected void generateIds(persistence.beans.dao.impl.cg.BasketlineToCgImpl obj) {
		if (obj.getId()==-1) {
			obj.setId(generateSpecificIdForId());
		}
	}
	private String DELETE_QUERY;
	private void initDeleteQuery() {
		
		
		DELETE_QUERY="delete from "+_TABLE_FULL_NAME+" where "+_FIELD_ID+"=?";
		
	}
	
	public Observable<Void> delete(persistence.beans.dao.IBasketlineTo _obj) {
		
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		
		return Observable
		.create((OnSubscribe<Void>) subscriber -> {
			persistence.beans.dao.impl.cg.BasketlineToCgImpl obj = (persistence.beans.dao.impl.cg.BasketlineToCgImpl)_obj;
			
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
	public persistence.beans.dao.IBasketlineTo create() {
		return new persistence.beans.dao.impl.cg.BasketlineToCgImpl();
	}
	/**
	 * Retourne la liste de tous les objets en base de donnee.
	 * @return la liste de tous les objets en base de donnee.
	 */
	public Observable<List<persistence.beans.dao.IBasketlineTo>> getList() {
		return newQuery().getList();
	}
	/**
	 * Getter lie a l'index basket.
	 * @param idBasket la valeur de la colonne idBasket
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IBasketlineTo>> getBasketlineListParIdBasket(long idBasket) {
		return newQuery().equal(BASKETLINE_COLUMNS.idBasket, idBasket).getList();
	}
	/**
	 * Getter lie a l'index presta.
	 * @param idPrestation la valeur de la colonne idPrestation
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IBasketlineTo>> getBasketlineListParIdPrestation(java.lang.Long idPrestation) {
		return newQuery().equal(BASKETLINE_COLUMNS.idPrestation, idPrestation).getList();
	}
	/**
	 * Getter lie a l'index produit.
	 * @param idProduit la valeur de la colonne idProduit
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IBasketlineTo>> getBasketlineListParIdProduit(java.lang.Long idProduit) {
		return newQuery().equal(BASKETLINE_COLUMNS.idProduit, idProduit).getList();
	}
	
	/**
	 * TOUTES les proprietes de l'objet sont source sont copiees dans l'objet destination
	 * MEME les blobs (les references des blobs)...
	 * @param src L'objet source depuis lequel copier les proprietes
	 * @param dest L'objet vers lequel copier les proprietes
	 */
	public void copy(persistence.beans.dao.IBasketlineTo src, persistence.beans.dao.IBasketlineTo dest) {
		dest.setId(src.getId());
		dest.setIdPrestation(src.getIdPrestation());
		dest.setIdProduit(src.getIdProduit());
		dest.setPrixAvecReduction(src.getPrixAvecReduction());
		dest.setQuantite(src.getQuantite());
		dest.setReduction(src.getReduction());
		dest.setTypeDeReduction(src.getTypeDeReduction());
		dest.setIdBasket(src.getIdBasket());
		
		dest.setNew(src.isNew());
	}
	
}
