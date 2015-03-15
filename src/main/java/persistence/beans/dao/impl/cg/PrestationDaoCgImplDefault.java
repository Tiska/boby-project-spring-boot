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

import persistence.beans.dao.IPrestationDao;
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
public abstract class PrestationDaoCgImplDefault implements IPrestationDao {
	
	static protected final Logger logger = Logger.getLogger(PrestationDaoCgImplDefault.class);
	
	public PrestationDaoCgImplDefault() {
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
		return getGeneratorRuntime().getCache("persistence.beans.dao.IPrestationTo");
	}
	
	/**
	 * Cette methode permet de regarder dans le cache si cet objet existe deja.<br/>
	 * Si oui, c'est l'objet dans le cache qui est retourne.<br/>
	 * Si non, c'est l'objet passe en parametre qui est retourne.<br/>
	 * @param object l'objet dont il faut tester la presence dans le cache.
	 * @return si l'objet est deja dans le cache, la version en cache. Sinon, l'objet en parametre.
	 * @throws NullPointerException si object est null.
	 */
	protected persistence.beans.dao.impl.cg.PrestationToCgImpl selectCacheObject(persistence.beans.dao.impl.cg.PrestationToCgImpl object) {
		String key = object.getCacheKey();
		Object cacheValue=getCache().getByKey(key);
		if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			getCache().putByKey(key, object);
			return object;
		}
		return (persistence.beans.dao.impl.cg.PrestationToCgImpl)cacheValue;
	}
	
	/**
	 * Cette methode genere une clee chaine unique dependant des arguments.<br/>
	 * Actuellement, elle ne fait que concatener les clees et retourner une chaine.<br/>
	 * @param id la valeur pour id
	 * @return Une chaine representant de facon unique les parametres.
	 */
	protected String getCacheKey(long id) {
		return "persistence.beans.dao.impl.cg.Prestation_"+id;
	}
	protected String _TABLE_SCHEMA = null;
	protected String _TABLE_NAME = "prestation";
	protected String _TABLE_FULL_NAME = null;
	protected static String _FIELD_ID = "ID";
	protected static String _FIELD_LIBELLE = "LIBELLE";
	protected static String _FIELD_PRIX = "PRIX";
	protected static String _FIELD_DUREE = "DUREE";
	protected static String _FIELD_OBSOLETE = "OBSOLETE";
	protected static String _FIELD_IDPRESTATIONCATEG = "ID_PRESTATION_CATEG";
	
	private void initSchema() {
		String s = null;
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Prestation.table_name");
		if (s!=null) {
			_TABLE_NAME = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Prestation.table_alias");
		if (s!=null) {
			ALIAS.setAlias(s);
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Prestation.schema_name");
		if (s==null) {
			s = getGeneratorRuntime().getStringProperty("c-generator.persistence.schema_name");
		}
		if (s!=null) {
			_TABLE_SCHEMA =  "null".equals(s)?null:s;
		}
		_TABLE_FULL_NAME = (_TABLE_SCHEMA==null?"":(_TABLE_SCHEMA+"."))+ "" + _TABLE_NAME + "";
		ALIAS.init(_TABLE_FULL_NAME);
		
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Prestation.id.column_name");
		if (s!=null) {
			_FIELD_ID = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Prestation.libelle.column_name");
		if (s!=null) {
			_FIELD_LIBELLE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Prestation.prix.column_name");
		if (s!=null) {
			_FIELD_PRIX = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Prestation.duree.column_name");
		if (s!=null) {
			_FIELD_DUREE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Prestation.obsolete.column_name");
		if (s!=null) {
			_FIELD_OBSOLETE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Prestation.idPrestationCateg.column_name");
		if (s!=null) {
			_FIELD_IDPRESTATIONCATEG = s;
		}
		
		initDeleteQuery();
		initSaveQuery();
	}
	
	/**
	 * Objet representant un alias de la table prestation.
	 **/
	public static final TableAlias<persistence.beans.dao.IPrestationTo> ALIAS = new JDBCTableAlias<persistence.beans.dao.IPrestationTo>(persistence.beans.dao.IPrestationTo.class, "prestation", "prestation");
	/**
	 * Retourne les colonnes pour faire les requetes la table Prestation.<br>
	 * Méthode à usage générique, utilisez getPrestationColumns() pour éviter les confusions
	 * @return PRESTATION_COLUMNS colonnes pour faire les requetes la table Prestation
	 */
	public IPrestationDao.PRESTATION_COLUMNS getColumns() {
		return getPrestationColumns();
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
	 * @Deprecated utiliser la methode getPrestationColumns() pour eviter de recupere des colonnes qui sont mal initialisees
	 **/
	@Deprecated
	public static interface PRESTATION_COLUMNS extends IPrestationDao.PRESTATION_COLUMNS{
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
		 * Objet representant la colonne PRIX (propriete prix) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prix = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, null, int.class);
		/**
		 * Objet representant la colonne PRIX (propriete prix) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne PRIX (propriete prix) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne PRIX (propriete prix) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne PRIX (propriete prix) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne PRIX (propriete prix) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prixAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.AVG, int.class);
		/**
		 * Objet representant la colonne DUREE (propriete duree) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn duree = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, null, int.class);
		/**
		 * Objet representant la colonne DUREE (propriete duree) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn dureeMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.MIN, int.class);
		/**
		 * Objet representant la colonne DUREE (propriete duree) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn dureeMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.MAX, int.class);
		/**
		 * Objet representant la colonne DUREE (propriete duree) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn dureeCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.COUNT, int.class);
		/**
		 * Objet representant la colonne DUREE (propriete duree) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn dureeSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.SUM, int.class);
		/**
		 * Objet representant la colonne DUREE (propriete duree) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn dureeAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.AVG, int.class);
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
		 * Objet representant la colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationCateg = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, null, long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationCategMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.MIN, long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationCategMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.MAX, long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationCategCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.COUNT, long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationCategSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.SUM, long.class);
		/**
		 * Objet representant la colonne ID_PRESTATION_CATEG (propriete idPrestationCateg) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn idPrestationCategAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.AVG, long.class);
	}
	private IPrestationDao.PRESTATION_COLUMNS columns = null;
	/**
	 * Recupere les colonnes/fonctions disponibles pour les requetes.
	 * @author c-generator (c) Cardiweb
	 **/
	public IPrestationDao.PRESTATION_COLUMNS getPrestationColumns(){
		if (columns == null) {
			IPrestationDao.PRESTATION_COLUMNS temp = new PRESTATION_COLUMNS() {
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
				private QueryColumn columnPrix = null;
				public QueryColumn getPrix(){
					if( columnPrix == null ){
						columnPrix = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, null, int.class);
					}
					return columnPrix;
				}
				private QueryColumn columnPrixMIN = null;
				public QueryColumn getPrixMIN(){
					if( columnPrixMIN == null ){
						columnPrixMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.MIN, int.class);
					}
					return columnPrixMIN;
				}
				private QueryColumn columnPrixMAX = null;
				public QueryColumn getPrixMAX(){
					if( columnPrixMAX == null ){
						columnPrixMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.MAX, int.class);
					}
					return columnPrixMAX;
				}
				private QueryColumn columnPrixCOUNT = null;
				public QueryColumn getPrixCOUNT(){
					if( columnPrixCOUNT == null ){
						columnPrixCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.COUNT, int.class);
					}
					return columnPrixCOUNT;
				}
				private QueryColumn columnPrixSUM = null;
				public QueryColumn getPrixSUM(){
					if( columnPrixSUM == null ){
						columnPrixSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.SUM, int.class);
					}
					return columnPrixSUM;
				}
				private QueryColumn columnPrixAVG = null;
				public QueryColumn getPrixAVG(){
					if( columnPrixAVG == null ){
						columnPrixAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prix", _FIELD_PRIX, JDBCFunction.AVG, int.class);
					}
					return columnPrixAVG;
				}
				private QueryColumn columnDuree = null;
				public QueryColumn getDuree(){
					if( columnDuree == null ){
						columnDuree = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, null, int.class);
					}
					return columnDuree;
				}
				private QueryColumn columnDureeMIN = null;
				public QueryColumn getDureeMIN(){
					if( columnDureeMIN == null ){
						columnDureeMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.MIN, int.class);
					}
					return columnDureeMIN;
				}
				private QueryColumn columnDureeMAX = null;
				public QueryColumn getDureeMAX(){
					if( columnDureeMAX == null ){
						columnDureeMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.MAX, int.class);
					}
					return columnDureeMAX;
				}
				private QueryColumn columnDureeCOUNT = null;
				public QueryColumn getDureeCOUNT(){
					if( columnDureeCOUNT == null ){
						columnDureeCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.COUNT, int.class);
					}
					return columnDureeCOUNT;
				}
				private QueryColumn columnDureeSUM = null;
				public QueryColumn getDureeSUM(){
					if( columnDureeSUM == null ){
						columnDureeSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.SUM, int.class);
					}
					return columnDureeSUM;
				}
				private QueryColumn columnDureeAVG = null;
				public QueryColumn getDureeAVG(){
					if( columnDureeAVG == null ){
						columnDureeAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "duree", _FIELD_DUREE, JDBCFunction.AVG, int.class);
					}
					return columnDureeAVG;
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
				private QueryColumn columnIdPrestationCateg = null;
				public QueryColumn getIdPrestationCateg(){
					if( columnIdPrestationCateg == null ){
						columnIdPrestationCateg = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, null, long.class);
					}
					return columnIdPrestationCateg;
				}
				private QueryColumn columnIdPrestationCategMIN = null;
				public QueryColumn getIdPrestationCategMIN(){
					if( columnIdPrestationCategMIN == null ){
						columnIdPrestationCategMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.MIN, long.class);
					}
					return columnIdPrestationCategMIN;
				}
				private QueryColumn columnIdPrestationCategMAX = null;
				public QueryColumn getIdPrestationCategMAX(){
					if( columnIdPrestationCategMAX == null ){
						columnIdPrestationCategMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.MAX, long.class);
					}
					return columnIdPrestationCategMAX;
				}
				private QueryColumn columnIdPrestationCategCOUNT = null;
				public QueryColumn getIdPrestationCategCOUNT(){
					if( columnIdPrestationCategCOUNT == null ){
						columnIdPrestationCategCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.COUNT, long.class);
					}
					return columnIdPrestationCategCOUNT;
				}
				private QueryColumn columnIdPrestationCategSUM = null;
				public QueryColumn getIdPrestationCategSUM(){
					if( columnIdPrestationCategSUM == null ){
						columnIdPrestationCategSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.SUM, long.class);
					}
					return columnIdPrestationCategSUM;
				}
				private QueryColumn columnIdPrestationCategAVG = null;
				public QueryColumn getIdPrestationCategAVG(){
					if( columnIdPrestationCategAVG == null ){
						columnIdPrestationCategAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "idPrestationCateg", _FIELD_IDPRESTATIONCATEG, JDBCFunction.AVG, long.class);
					}
					return columnIdPrestationCategAVG;
				}
			};
			columns = temp;
		}
		return columns;
	}
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IPrestationTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IPrestationTo
	 */
	public PersistenceQuery<persistence.beans.dao.IPrestationTo> newQuery() {
		return new PersistenceQueryPrestationVersion((persistence.beans.dao.impl.cg.PrestationDaoCgImpl)this);
	}
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IPrestationTo dans une sous-requête
	 * @param parentQuery requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IPrestationTo dans une sous-requête
	 */
	public PersistenceQuery<persistence.beans.dao.IPrestationTo> newSubQuery(PersistenceQuery<?> parentQuery) {
		return new PersistenceQueryPrestationVersion((persistence.beans.dao.impl.cg.PrestationDaoCgImpl)this, parentQuery);
	}
	
	private static class PersistenceQueryPrestationVersion extends JDBCPersistenceQuery<persistence.beans.dao.IPrestationTo> {
		private persistence.beans.dao.impl.cg.PrestationDaoCgImpl _dao;
		/**
		 * Constructeur pour ce PersistenceQuery.
		 *
		 * @param dao
		 */
		public PersistenceQueryPrestationVersion(persistence.beans.dao.impl.cg.PrestationDaoCgImpl dao) {
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
		public PersistenceQueryPrestationVersion(persistence.beans.dao.impl.cg.PrestationDaoCgImpl dao, PersistenceQuery<?> parentQuery) {
			super(ALIAS, true, parentQuery);
			_dao=dao;
			init();
		}
		
		@Override
		protected GeneratorRuntime getGeneratorRuntime() {
			return _dao.getGeneratorRuntime();
		}
		
		@Override
		protected persistence.beans.dao.IPrestationTo loadObjectFromRS(ResultSet rs) {
			
			try {
				
				String ___key = null;
				Object cacheValue = null;
				if (useCache) {
					long id = rs.getLong(_FIELD_ID);
					___key = _dao.getCacheKey(id);
					cacheValue = _dao.getCache().getByKey(___key);
				}
				if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
					
					persistence.beans.dao.impl.cg.PrestationToCgImpl object = (persistence.beans.dao.impl.cg.PrestationToCgImpl)_dao.create();
					object.setNew(false);
					object.setId(rs.getLong(_FIELD_ID));
					object.setLibelle(rs.getString(_FIELD_LIBELLE));
					object.setPrix(rs.getInt(_FIELD_PRIX));
					object.setDuree(rs.getInt(_FIELD_DUREE));
					object.setObsolete(rs.getBoolean(_FIELD_OBSOLETE));
					object.setIdPrestationCateg(rs.getLong(_FIELD_IDPRESTATIONCATEG));
					
					if (useCache) { _dao.getCache().putByKey(___key, object); }
					return object;
				}
				return (persistence.beans.dao.IPrestationTo)cacheValue;
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
	
	protected void fillSQLPrimaryParameters(int offset, PreparedStatement pst,persistence.beans.dao.IPrestationTo obj) throws SQLException {
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
	public Observable<persistence.beans.dao.IPrestationTo> getById(long id) {
		return getPrestation(id);
	}
	
	
	/**
	 * Getter principal : retourne l'objet Prestation en fonction de sa clee.
	 * @param id la valeur de la clee id
	 * @return l'objet correspondant a la clee ou null si aucun objet n'a ete trouve.
	 */
	public Observable<persistence.beans.dao.IPrestationTo> getPrestation(long id) {
		String ___key = getCacheKey(id);
		Object retour = getCache().getByKey(___key);
		if (retour==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			return Observable.just((persistence.beans.dao.IPrestationTo) null);
		} else
		if (retour!=null) {
			return Observable.just((persistence.beans.dao.IPrestationTo) retour);
		}
		
		return Observable.create((OnSubscribe<persistence.beans.dao.IPrestationTo>) subscriber -> {
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
					r = newQuery().equal(PRESTATION_COLUMNS.id, id)	.getObject().subscribe(obj -> {
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
						subscriber.onNext((persistence.beans.dao.IPrestationTo) r);
						subscriber.onCompleted();
					}
				}
			}
		})
		
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler())
		.observeOn(getGeneratorRuntime().getObserveOnScheduler());
		
	}
	
	private void initSaveQuery() {
		
		
		INSERT_QUERY = "insert into "+_TABLE_FULL_NAME+" ("+_FIELD_LIBELLE+","+_FIELD_PRIX+","+_FIELD_DUREE+","+_FIELD_OBSOLETE+","+_FIELD_IDPRESTATIONCATEG+","+_FIELD_ID+") values (?,?,?,?,?,?)";
		UPDATE_QUERY = "update "+_TABLE_FULL_NAME+" set "+_FIELD_LIBELLE+"=?,"+_FIELD_PRIX+"=?,"+_FIELD_DUREE+"=?,"+_FIELD_OBSOLETE+"=?,"+_FIELD_IDPRESTATIONCATEG+"=? where "+_FIELD_ID+"=?";
	}
	
	private String INSERT_QUERY;
	private String UPDATE_QUERY;
	public Observable<Void> save(persistence.beans.dao.IPrestationTo _obj) {
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		persistence.beans.dao.impl.cg.PrestationToCgImpl obj = (persistence.beans.dao.impl.cg.PrestationToCgImpl)_obj;
		
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
						pst.setInt(2, obj.getPrix());
						pst.setInt(3, obj.getDuree());
						pst.setBoolean(4, obj.getObsolete());
						pst.setLong(5, obj.getIdPrestationCateg());
						fillSQLPrimaryParameters(6, pst, obj);
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
	
	private JDBCPersistenceQuery<persistence.beans.dao.IPrestationTo> _cachePersistenceQuery;
	public void clearListCache() {
		if (_cachePersistenceQuery==null) {
			_cachePersistenceQuery = (JDBCPersistenceQuery<persistence.beans.dao.IPrestationTo>)newQuery();
		}
		_cachePersistenceQuery.clearListCache(persistence.beans.dao.IPrestationTo.class);
	}
	
	/**
	 * Cette methode genere toutes les valeurs pour les clee qui n'ont pas encore
	 * ete affectees.
	 *
	 * @param obj
	 */
	protected void generateIds(persistence.beans.dao.impl.cg.PrestationToCgImpl obj) {
		if (obj.getId()==-1) {
			obj.setId(generateSpecificIdForId());
		}
	}
	private String DELETE_QUERY;
	private void initDeleteQuery() {
		
		
		DELETE_QUERY="delete from "+_TABLE_FULL_NAME+" where "+_FIELD_ID+"=?";
		
	}
	
	public Observable<Void> delete(persistence.beans.dao.IPrestationTo _obj) {
		
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		
		return Observable
		.create((OnSubscribe<Void>) subscriber -> {
			persistence.beans.dao.impl.cg.PrestationToCgImpl obj = (persistence.beans.dao.impl.cg.PrestationToCgImpl)_obj;
			
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
	public persistence.beans.dao.IPrestationTo create() {
		return new persistence.beans.dao.impl.cg.PrestationToCgImpl();
	}
	/**
	 * Retourne la liste de tous les objets en base de donnee.
	 * @return la liste de tous les objets en base de donnee.
	 */
	public Observable<List<persistence.beans.dao.IPrestationTo>> getList() {
		return newQuery().getList();
	}
	/**
	 * Getter lie a l'index presta_categ.
	 * @param idPrestationCateg la valeur de la colonne idPrestationCateg
	 * @return La liste des objets correspondant aux criteres.
	 */
	public Observable<java.util.List<persistence.beans.dao.IPrestationTo>> getPrestationListParIdPrestationCateg(long idPrestationCateg) {
		return newQuery().equal(PRESTATION_COLUMNS.idPrestationCateg, idPrestationCateg).getList();
	}
	
	/**
	 * TOUTES les proprietes de l'objet sont source sont copiees dans l'objet destination
	 * MEME les blobs (les references des blobs)...
	 * @param src L'objet source depuis lequel copier les proprietes
	 * @param dest L'objet vers lequel copier les proprietes
	 */
	public void copy(persistence.beans.dao.IPrestationTo src, persistence.beans.dao.IPrestationTo dest) {
		dest.setId(src.getId());
		dest.setLibelle(src.getLibelle());
		dest.setPrix(src.getPrix());
		dest.setDuree(src.getDuree());
		dest.setObsolete(src.getObsolete());
		dest.setIdPrestationCateg(src.getIdPrestationCateg());
		
		dest.setNew(src.isNew());
	}
	
}
