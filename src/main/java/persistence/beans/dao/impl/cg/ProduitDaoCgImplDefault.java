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

import persistence.beans.dao.IProduitDao;
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
public abstract class ProduitDaoCgImplDefault implements IProduitDao {
	
	static protected final Logger logger = Logger.getLogger(ProduitDaoCgImplDefault.class);
	
	public ProduitDaoCgImplDefault() {
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
		return getGeneratorRuntime().getCache("persistence.beans.dao.IProduitTo");
	}
	
	/**
	 * Cette methode permet de regarder dans le cache si cet objet existe deja.<br/>
	 * Si oui, c'est l'objet dans le cache qui est retourne.<br/>
	 * Si non, c'est l'objet passe en parametre qui est retourne.<br/>
	 * @param object l'objet dont il faut tester la presence dans le cache.
	 * @return si l'objet est deja dans le cache, la version en cache. Sinon, l'objet en parametre.
	 * @throws NullPointerException si object est null.
	 */
	protected persistence.beans.dao.impl.cg.ProduitToCgImpl selectCacheObject(persistence.beans.dao.impl.cg.ProduitToCgImpl object) {
		String key = object.getCacheKey();
		Object cacheValue=getCache().getByKey(key);
		if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			getCache().putByKey(key, object);
			return object;
		}
		return (persistence.beans.dao.impl.cg.ProduitToCgImpl)cacheValue;
	}
	
	/**
	 * Cette methode genere une clee chaine unique dependant des arguments.<br/>
	 * Actuellement, elle ne fait que concatener les clees et retourner une chaine.<br/>
	 * @param id la valeur pour id
	 * @return Une chaine representant de facon unique les parametres.
	 */
	protected String getCacheKey(long id) {
		return "persistence.beans.dao.impl.cg.Produit_"+id;
	}
	protected String _TABLE_SCHEMA = null;
	protected String _TABLE_NAME = "produit";
	protected String _TABLE_FULL_NAME = null;
	protected static String _FIELD_ID = "ID";
	protected static String _FIELD_LIBELLE = "LIBELLE";
	protected static String _FIELD_STOCK = "STOCK";
	protected static String _FIELD_PRIXACHAT = "PRIX_ACHAT";
	protected static String _FIELD_PRIXVENTECALCULE = "PRIX_VENTE_CALCULE";
	protected static String _FIELD_COEFFICIANT = "COEFFICIANT";
	protected static String _FIELD_OBSOLETE = "OBSOLETE";
	protected static String _FIELD_IDPRODUITCATEG = "ID_PRODUIT_CATEG";
	
	private void initSchema() {
		String s = null;
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.table_name");
		if (s!=null) {
			_TABLE_NAME = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.table_alias");
		if (s!=null) {
			ALIAS.setAlias(s);
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.schema_name");
		if (s==null) {
			s = getGeneratorRuntime().getStringProperty("c-generator.persistence.schema_name");
		}
		if (s!=null) {
			_TABLE_SCHEMA =  "null".equals(s)?null:s;
		}
		_TABLE_FULL_NAME = (_TABLE_SCHEMA==null?"":(_TABLE_SCHEMA+"."))+ "" + _TABLE_NAME + "";
		ALIAS.init(_TABLE_FULL_NAME);
		
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.id.column_name");
		if (s!=null) {
			_FIELD_ID = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.libelle.column_name");
		if (s!=null) {
			_FIELD_LIBELLE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.stock.column_name");
		if (s!=null) {
			_FIELD_STOCK = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.prixAchat.column_name");
		if (s!=null) {
			_FIELD_PRIXACHAT = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.prixVenteCalcule.column_name");
		if (s!=null) {
			_FIELD_PRIXVENTECALCULE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.coefficiant.column_name");
		if (s!=null) {
			_FIELD_COEFFICIANT = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.obsolete.column_name");
		if (s!=null) {
			_FIELD_OBSOLETE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produit.idProduitCateg.column_name");
		if (s!=null) {
			_FIELD_IDPRODUITCATEG = s;
		}
		
		initDeleteQuery();
		initSaveQuery();
	}
	
	/**
	 * Objet representant un alias de la table produit.
	 **/
	public static final TableAlias<persistence.beans.dao.IProduitTo> ALIAS = new JDBCTableAlias<persistence.beans.dao.IProduitTo>(persistence.beans.dao.IProduitTo.class, "produit", "produit");
	/**
	 * Retourne les colonnes pour faire les requetes la table Produit.<br>
	 * Méthode à usage générique, utilisez getProduitColumns() pour éviter les confusions
	 * @return PRODUIT_COLUMNS colonnes pour faire les requetes la table Produit
	 */
	public IProduitDao.PRODUIT_COLUMNS getColumns() {
		return getProduitColumns();
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
	 * @Deprecated utiliser la methode getProduitColumns() pour eviter de recupere des colonnes qui sont mal initialisees
	 **/
	@Deprecated
	public static interface PRODUIT_COLUMNS extends IProduitDao.PRODUIT_COLUMNS{
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
		 * Objet representant la colonne LIBELLE (propriete libelle) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn libelle = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, null, java.lang.String.class);
		/**
		 * Objet representant la colonne LIBELLE (propriete libelle) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn libelleMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, JDBCFunction.MIN, java.lang.String.class);
		/**
		 * Objet representant la colonne LIBELLE (propriete libelle) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn libelleMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, JDBCFunction.MAX, java.lang.String.class);
		/**
		 * Objet representant la colonne LIBELLE (propriete libelle) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn libelleCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, JDBCFunction.COUNT, java.lang.String.class);
		/**
		 * Objet representant la colonne LIBELLE (propriete libelle) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn libelleUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, JDBCFunction.UPPER, java.lang.String.class);
		/**
		 * Objet representant la colonne STOCK (propriete stock) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn stock = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, null, int.class);
		/**
		 * Objet representant la colonne STOCK (propriete stock) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn stockMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne STOCK (propriete stock) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn stockMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne STOCK (propriete stock) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn stockCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne STOCK (propriete stock) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn stockSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne STOCK (propriete stock) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn stockAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.AVG, int.class);
		/**
		 * Objet representant la colonne PRIX_ACHAT (propriete prixAchat) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAchat = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, null, int.class);
		/**
		 * Objet representant la colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAchatMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAchatMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAchatCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAchatSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne PRIX_ACHAT (propriete prixAchat) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAchatAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.AVG, int.class);
		/**
		 * Objet representant la colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixVenteCalcule = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, null, int.class);
		/**
		 * Objet representant la colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixVenteCalculeMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixVenteCalculeMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixVenteCalculeCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixVenteCalculeSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne PRIX_VENTE_CALCULE (propriete prixVenteCalcule) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixVenteCalculeAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.AVG, int.class);
		/**
		 * Objet representant la colonne COEFFICIANT (propriete coefficiant) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn coefficiant = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, null, int.class);
		/**
		 * Objet representant la colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn coefficiantMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn coefficiantMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn coefficiantCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn coefficiantSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne COEFFICIANT (propriete coefficiant) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn coefficiantAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.AVG, int.class);
		/**
		 * Objet representant la colonne OBSOLETE (propriete obsolete) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn obsolete = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "obsolete", _FIELD_OBSOLETE, null, boolean.class);
		/**
		 * Objet representant la colonne OBSOLETE (propriete obsolete) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn obsoleteMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "obsolete", _FIELD_OBSOLETE, JDBCFunction.MIN, boolean.class);
		/**
		 * Objet representant la colonne OBSOLETE (propriete obsolete) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn obsoleteMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "obsolete", _FIELD_OBSOLETE, JDBCFunction.MAX, boolean.class);
		/**
		 * Objet representant la colonne OBSOLETE (propriete obsolete) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn obsoleteCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "obsolete", _FIELD_OBSOLETE, JDBCFunction.COUNT, boolean.class);
		/**
		 * Objet representant la colonne ID_PRODUIT_CATEG (propriete idProduitCateg) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitCateg = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, null, long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitCategMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.MIN, long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitCategMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.MAX, long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitCategCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.COUNT, long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitCategSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.SUM, long.class);
		/**
		 * Objet representant la colonne ID_PRODUIT_CATEG (propriete idProduitCateg) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idProduitCategAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.AVG, long.class);
	}
	private IProduitDao.PRODUIT_COLUMNS columns = null;
	/**
	 * Recupere les colonnes/fonctions disponibles pour les requetes.
	 * @author c-generator (c) Cardiweb
	 **/
	public IProduitDao.PRODUIT_COLUMNS getProduitColumns(){
		if (columns == null) {
			IProduitDao.PRODUIT_COLUMNS temp = new PRODUIT_COLUMNS() {
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
				private QueryColumn columnLibelle = null;
				public QueryColumn getLibelle(){
					if( columnLibelle == null ){
						columnLibelle = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, null, java.lang.String.class);
					}
					return columnLibelle;
				}
				private QueryColumn columnLibelleMIN = null;
				public QueryColumn getLibelleMIN(){
					if( columnLibelleMIN == null ){
						columnLibelleMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, JDBCFunction.MIN, java.lang.String.class);
					}
					return columnLibelleMIN;
				}
				private QueryColumn columnLibelleMAX = null;
				public QueryColumn getLibelleMAX(){
					if( columnLibelleMAX == null ){
						columnLibelleMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, JDBCFunction.MAX, java.lang.String.class);
					}
					return columnLibelleMAX;
				}
				private QueryColumn columnLibelleCOUNT = null;
				public QueryColumn getLibelleCOUNT(){
					if( columnLibelleCOUNT == null ){
						columnLibelleCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, JDBCFunction.COUNT, java.lang.String.class);
					}
					return columnLibelleCOUNT;
				}
				private QueryColumn columnLibelleUPPER = null;
				public QueryColumn getLibelleUPPER(){
					if( columnLibelleUPPER == null ){
						columnLibelleUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "libelle", _FIELD_LIBELLE, JDBCFunction.UPPER, java.lang.String.class);
					}
					return columnLibelleUPPER;
				}
				private QueryColumn columnStock = null;
				public QueryColumn getStock(){
					if( columnStock == null ){
						columnStock = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, null, int.class);
					}
					return columnStock;
				}
				private QueryColumn columnStockMIN = null;
				public QueryColumn getStockMIN(){
					if( columnStockMIN == null ){
						columnStockMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.MIN, int.class);
					}
					return columnStockMIN;
				}
				private QueryColumn columnStockMAX = null;
				public QueryColumn getStockMAX(){
					if( columnStockMAX == null ){
						columnStockMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.MAX, int.class);
					}
					return columnStockMAX;
				}
				private QueryColumn columnStockCOUNT = null;
				public QueryColumn getStockCOUNT(){
					if( columnStockCOUNT == null ){
						columnStockCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.COUNT, int.class);
					}
					return columnStockCOUNT;
				}
				private QueryColumn columnStockSUM = null;
				public QueryColumn getStockSUM(){
					if( columnStockSUM == null ){
						columnStockSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.SUM, int.class);
					}
					return columnStockSUM;
				}
				private QueryColumn columnStockAVG = null;
				public QueryColumn getStockAVG(){
					if( columnStockAVG == null ){
						columnStockAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "stock", _FIELD_STOCK, JDBCFunction.AVG, int.class);
					}
					return columnStockAVG;
				}
				private QueryColumn columnPrixAchat = null;
				public QueryColumn getPrixAchat(){
					if( columnPrixAchat == null ){
						columnPrixAchat = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, null, int.class);
					}
					return columnPrixAchat;
				}
				private QueryColumn columnPrixAchatMIN = null;
				public QueryColumn getPrixAchatMIN(){
					if( columnPrixAchatMIN == null ){
						columnPrixAchatMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.MIN, int.class);
					}
					return columnPrixAchatMIN;
				}
				private QueryColumn columnPrixAchatMAX = null;
				public QueryColumn getPrixAchatMAX(){
					if( columnPrixAchatMAX == null ){
						columnPrixAchatMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.MAX, int.class);
					}
					return columnPrixAchatMAX;
				}
				private QueryColumn columnPrixAchatCOUNT = null;
				public QueryColumn getPrixAchatCOUNT(){
					if( columnPrixAchatCOUNT == null ){
						columnPrixAchatCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.COUNT, int.class);
					}
					return columnPrixAchatCOUNT;
				}
				private QueryColumn columnPrixAchatSUM = null;
				public QueryColumn getPrixAchatSUM(){
					if( columnPrixAchatSUM == null ){
						columnPrixAchatSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.SUM, int.class);
					}
					return columnPrixAchatSUM;
				}
				private QueryColumn columnPrixAchatAVG = null;
				public QueryColumn getPrixAchatAVG(){
					if( columnPrixAchatAVG == null ){
						columnPrixAchatAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixAchat", _FIELD_PRIXACHAT, JDBCFunction.AVG, int.class);
					}
					return columnPrixAchatAVG;
				}
				private QueryColumn columnPrixVenteCalcule = null;
				public QueryColumn getPrixVenteCalcule(){
					if( columnPrixVenteCalcule == null ){
						columnPrixVenteCalcule = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, null, int.class);
					}
					return columnPrixVenteCalcule;
				}
				private QueryColumn columnPrixVenteCalculeMIN = null;
				public QueryColumn getPrixVenteCalculeMIN(){
					if( columnPrixVenteCalculeMIN == null ){
						columnPrixVenteCalculeMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.MIN, int.class);
					}
					return columnPrixVenteCalculeMIN;
				}
				private QueryColumn columnPrixVenteCalculeMAX = null;
				public QueryColumn getPrixVenteCalculeMAX(){
					if( columnPrixVenteCalculeMAX == null ){
						columnPrixVenteCalculeMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.MAX, int.class);
					}
					return columnPrixVenteCalculeMAX;
				}
				private QueryColumn columnPrixVenteCalculeCOUNT = null;
				public QueryColumn getPrixVenteCalculeCOUNT(){
					if( columnPrixVenteCalculeCOUNT == null ){
						columnPrixVenteCalculeCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.COUNT, int.class);
					}
					return columnPrixVenteCalculeCOUNT;
				}
				private QueryColumn columnPrixVenteCalculeSUM = null;
				public QueryColumn getPrixVenteCalculeSUM(){
					if( columnPrixVenteCalculeSUM == null ){
						columnPrixVenteCalculeSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.SUM, int.class);
					}
					return columnPrixVenteCalculeSUM;
				}
				private QueryColumn columnPrixVenteCalculeAVG = null;
				public QueryColumn getPrixVenteCalculeAVG(){
					if( columnPrixVenteCalculeAVG == null ){
						columnPrixVenteCalculeAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prixVenteCalcule", _FIELD_PRIXVENTECALCULE, JDBCFunction.AVG, int.class);
					}
					return columnPrixVenteCalculeAVG;
				}
				private QueryColumn columnCoefficiant = null;
				public QueryColumn getCoefficiant(){
					if( columnCoefficiant == null ){
						columnCoefficiant = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, null, int.class);
					}
					return columnCoefficiant;
				}
				private QueryColumn columnCoefficiantMIN = null;
				public QueryColumn getCoefficiantMIN(){
					if( columnCoefficiantMIN == null ){
						columnCoefficiantMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.MIN, int.class);
					}
					return columnCoefficiantMIN;
				}
				private QueryColumn columnCoefficiantMAX = null;
				public QueryColumn getCoefficiantMAX(){
					if( columnCoefficiantMAX == null ){
						columnCoefficiantMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.MAX, int.class);
					}
					return columnCoefficiantMAX;
				}
				private QueryColumn columnCoefficiantCOUNT = null;
				public QueryColumn getCoefficiantCOUNT(){
					if( columnCoefficiantCOUNT == null ){
						columnCoefficiantCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.COUNT, int.class);
					}
					return columnCoefficiantCOUNT;
				}
				private QueryColumn columnCoefficiantSUM = null;
				public QueryColumn getCoefficiantSUM(){
					if( columnCoefficiantSUM == null ){
						columnCoefficiantSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.SUM, int.class);
					}
					return columnCoefficiantSUM;
				}
				private QueryColumn columnCoefficiantAVG = null;
				public QueryColumn getCoefficiantAVG(){
					if( columnCoefficiantAVG == null ){
						columnCoefficiantAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "coefficiant", _FIELD_COEFFICIANT, JDBCFunction.AVG, int.class);
					}
					return columnCoefficiantAVG;
				}
				private QueryColumn columnObsolete = null;
				public QueryColumn getObsolete(){
					if( columnObsolete == null ){
						columnObsolete = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "obsolete", _FIELD_OBSOLETE, null, boolean.class);
					}
					return columnObsolete;
				}
				private QueryColumn columnObsoleteMIN = null;
				public QueryColumn getObsoleteMIN(){
					if( columnObsoleteMIN == null ){
						columnObsoleteMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "obsolete", _FIELD_OBSOLETE, JDBCFunction.MIN, boolean.class);
					}
					return columnObsoleteMIN;
				}
				private QueryColumn columnObsoleteMAX = null;
				public QueryColumn getObsoleteMAX(){
					if( columnObsoleteMAX == null ){
						columnObsoleteMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "obsolete", _FIELD_OBSOLETE, JDBCFunction.MAX, boolean.class);
					}
					return columnObsoleteMAX;
				}
				private QueryColumn columnObsoleteCOUNT = null;
				public QueryColumn getObsoleteCOUNT(){
					if( columnObsoleteCOUNT == null ){
						columnObsoleteCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "obsolete", _FIELD_OBSOLETE, JDBCFunction.COUNT, boolean.class);
					}
					return columnObsoleteCOUNT;
				}
				private QueryColumn columnIdProduitCateg = null;
				public QueryColumn getIdProduitCateg(){
					if( columnIdProduitCateg == null ){
						columnIdProduitCateg = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, null, long.class);
					}
					return columnIdProduitCateg;
				}
				private QueryColumn columnIdProduitCategMIN = null;
				public QueryColumn getIdProduitCategMIN(){
					if( columnIdProduitCategMIN == null ){
						columnIdProduitCategMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.MIN, long.class);
					}
					return columnIdProduitCategMIN;
				}
				private QueryColumn columnIdProduitCategMAX = null;
				public QueryColumn getIdProduitCategMAX(){
					if( columnIdProduitCategMAX == null ){
						columnIdProduitCategMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.MAX, long.class);
					}
					return columnIdProduitCategMAX;
				}
				private QueryColumn columnIdProduitCategCOUNT = null;
				public QueryColumn getIdProduitCategCOUNT(){
					if( columnIdProduitCategCOUNT == null ){
						columnIdProduitCategCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.COUNT, long.class);
					}
					return columnIdProduitCategCOUNT;
				}
				private QueryColumn columnIdProduitCategSUM = null;
				public QueryColumn getIdProduitCategSUM(){
					if( columnIdProduitCategSUM == null ){
						columnIdProduitCategSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.SUM, long.class);
					}
					return columnIdProduitCategSUM;
				}
				private QueryColumn columnIdProduitCategAVG = null;
				public QueryColumn getIdProduitCategAVG(){
					if( columnIdProduitCategAVG == null ){
						columnIdProduitCategAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idProduitCateg", _FIELD_IDPRODUITCATEG, JDBCFunction.AVG, long.class);
					}
					return columnIdProduitCategAVG;
				}
			};
			columns = temp;
		}
		return columns;
	}
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitTo
	 */
	public PersistenceQuery<persistence.beans.dao.IProduitTo> newQuery() {
		return new PersistenceQueryProduitVersion((persistence.beans.dao.impl.cg.ProduitDaoCgImpl)this);
	}
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitTo dans une sous-requête
	 * @param parentQuery requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitTo dans une sous-requête
	 */
	public PersistenceQuery<persistence.beans.dao.IProduitTo> newSubQuery(PersistenceQuery<?> parentQuery) {
		return new PersistenceQueryProduitVersion((persistence.beans.dao.impl.cg.ProduitDaoCgImpl)this, parentQuery);
	}
	
	private static class PersistenceQueryProduitVersion extends JDBCPersistenceQuery<persistence.beans.dao.IProduitTo> {
		private persistence.beans.dao.impl.cg.ProduitDaoCgImpl _dao;
		/**
		 * Constructeur pour ce PersistenceQuery.
		 *
		 * @param dao
		 */
		public PersistenceQueryProduitVersion(persistence.beans.dao.impl.cg.ProduitDaoCgImpl dao) {
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
		public PersistenceQueryProduitVersion(persistence.beans.dao.impl.cg.ProduitDaoCgImpl dao, PersistenceQuery<?> parentQuery) {
			super(ALIAS, true, parentQuery);
			_dao=dao;
			init();
		}
		
		@Override
		protected GeneratorRuntime getGeneratorRuntime() {
			return _dao.getGeneratorRuntime();
		}
		
		@Override
		protected persistence.beans.dao.IProduitTo loadObjectFromRS(ResultSet rs) {
			
			try {
				
				String ___key = null;
				Object cacheValue = null;
				if (useCache) {
					long id = rs.getLong(_FIELD_ID);
					___key = _dao.getCacheKey(id);
					cacheValue = _dao.getCache().getByKey(___key);
				}
				if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
					
					persistence.beans.dao.impl.cg.ProduitToCgImpl object = (persistence.beans.dao.impl.cg.ProduitToCgImpl)_dao.create();
					object.setNew(false);
					object.setId(rs.getLong(_FIELD_ID));
					object.setLibelle(rs.getString(_FIELD_LIBELLE));
					object.setStock(rs.getInt(_FIELD_STOCK));
					object.setPrixAchat(rs.getInt(_FIELD_PRIXACHAT));
					object.setPrixVenteCalcule(rs.getInt(_FIELD_PRIXVENTECALCULE));
					object.setCoefficiant(rs.getInt(_FIELD_COEFFICIANT));
					object.setObsolete(rs.getBoolean(_FIELD_OBSOLETE));
					object.setIdProduitCateg(rs.getLong(_FIELD_IDPRODUITCATEG));
					
					if (useCache) { _dao.getCache().putByKey(___key, object); }
					return object;
				}
				return (persistence.beans.dao.IProduitTo)cacheValue;
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
	
	protected void fillSQLPrimaryParameters(int offset, PreparedStatement pst,persistence.beans.dao.IProduitTo obj) throws SQLException {
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
	public Observable<persistence.beans.dao.IProduitTo> getById(long id) {
		return getProduit(id);
	}
	
	
	/**
	 * Getter principal : retourne l'objet Produit en fonction de sa clee.
	 * @param id la valeur de la clee id
	 * @return l'objet correspondant a la clee ou null si aucun objet n'a ete trouve.
	 */
	public Observable<persistence.beans.dao.IProduitTo> getProduit(long id) {
		String ___key = getCacheKey(id);
		Object retour = getCache().getByKey(___key);
		if (retour==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			return Observable.just((persistence.beans.dao.IProduitTo) null);
		} else
		if (retour!=null) {
			return Observable.just((persistence.beans.dao.IProduitTo) retour);
		}
		
		return Observable.create((OnSubscribe<persistence.beans.dao.IProduitTo>) subscriber -> {
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
					r = newQuery().equal(PRODUIT_COLUMNS.id, id)	.getObject().subscribe(obj -> {
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
						subscriber.onNext((persistence.beans.dao.IProduitTo) r);
						subscriber.onCompleted();
					}
				}
			}
		})
		
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler())
		.observeOn(getGeneratorRuntime().getObserveOnScheduler());
		
	}
	
	private void initSaveQuery() {
		
		
		INSERT_QUERY = "insert into "+_TABLE_FULL_NAME+" ("+_FIELD_LIBELLE+","+_FIELD_STOCK+","+_FIELD_PRIXACHAT+","+_FIELD_PRIXVENTECALCULE+","+_FIELD_COEFFICIANT+","+_FIELD_OBSOLETE+","+_FIELD_IDPRODUITCATEG+","+_FIELD_ID+") values (?,?,?,?,?,?,?,?)";
		UPDATE_QUERY = "update "+_TABLE_FULL_NAME+" set "+_FIELD_LIBELLE+"=?,"+_FIELD_STOCK+"=?,"+_FIELD_PRIXACHAT+"=?,"+_FIELD_PRIXVENTECALCULE+"=?,"+_FIELD_COEFFICIANT+"=?,"+_FIELD_OBSOLETE+"=?,"+_FIELD_IDPRODUITCATEG+"=? where "+_FIELD_ID+"=?";
	}
	
	private String INSERT_QUERY;
	private String UPDATE_QUERY;
	public Observable<Void> save(persistence.beans.dao.IProduitTo _obj) {
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		persistence.beans.dao.impl.cg.ProduitToCgImpl obj = (persistence.beans.dao.impl.cg.ProduitToCgImpl)_obj;
		
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
						pst.setString(1, obj.getLibelle());
						pst.setInt(2, obj.getStock());
						pst.setInt(3, obj.getPrixAchat());
						pst.setInt(4, obj.getPrixVenteCalcule());
						pst.setInt(5, obj.getCoefficiant());
						pst.setBoolean(6, obj.getObsolete());
						pst.setLong(7, obj.getIdProduitCateg());
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
	
	private JDBCPersistenceQuery<persistence.beans.dao.IProduitTo> _cachePersistenceQuery;
	public void clearListCache() {
		if (_cachePersistenceQuery==null) {
			_cachePersistenceQuery = (JDBCPersistenceQuery<persistence.beans.dao.IProduitTo>)newQuery();
		}
		_cachePersistenceQuery.clearListCache(persistence.beans.dao.IProduitTo.class);
	}
	
	/**
	 * Cette methode genere toutes les valeurs pour les clee qui n'ont pas encore
	 * ete affectees.
	 *
	 * @param obj
	 */
	protected void generateIds(persistence.beans.dao.impl.cg.ProduitToCgImpl obj) {
		if (obj.getId()==-1) {
			obj.setId(generateSpecificIdForId());
		}
	}
	private String DELETE_QUERY;
	private void initDeleteQuery() {
		
		
		DELETE_QUERY="delete from "+_TABLE_FULL_NAME+" where "+_FIELD_ID+"=?";
		
	}
	
	public Observable<Void> delete(persistence.beans.dao.IProduitTo _obj) {
		
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		
		return Observable
		.create((OnSubscribe<Void>) subscriber -> {
			persistence.beans.dao.impl.cg.ProduitToCgImpl obj = (persistence.beans.dao.impl.cg.ProduitToCgImpl)_obj;
			
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
	public persistence.beans.dao.IProduitTo create() {
		return new persistence.beans.dao.impl.cg.ProduitToCgImpl();
	}
	/**
	 * Retourne la liste de tous les objets en base de donnee.
	 * @return la liste de tous les objets en base de donnee.
	 */
	public Observable<List<persistence.beans.dao.IProduitTo>> getList() {
		return newQuery().getList();
	}
	/**
	 * Getter lie a l'index produit_categ.
	 * @param idProduitCateg la valeur de la colonne idProduitCateg
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IProduitTo>> getProduitListParIdProduitCateg(long idProduitCateg) {
		return newQuery().equal(PRODUIT_COLUMNS.idProduitCateg, idProduitCateg).getList();
	}
	
	/**
	 * TOUTES les proprietes de l'objet sont source sont copiees dans l'objet destination
	 * MEME les blobs (les references des blobs)...
	 * @param src L'objet source depuis lequel copier les proprietes
	 * @param dest L'objet vers lequel copier les proprietes
	 */
	public void copy(persistence.beans.dao.IProduitTo src, persistence.beans.dao.IProduitTo dest) {
		dest.setId(src.getId());
		dest.setLibelle(src.getLibelle());
		dest.setStock(src.getStock());
		dest.setPrixAchat(src.getPrixAchat());
		dest.setPrixVenteCalcule(src.getPrixVenteCalcule());
		dest.setCoefficiant(src.getCoefficiant());
		dest.setObsolete(src.getObsolete());
		dest.setIdProduitCateg(src.getIdProduitCateg());
		
		dest.setNew(src.isNew());
	}
	
}
