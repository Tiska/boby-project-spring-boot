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

import persistence.beans.dao.IProduitcategorieDao;
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
public abstract class ProduitcategorieDaoCgImplDefault implements IProduitcategorieDao {
	
	static protected final Logger logger = Logger.getLogger(ProduitcategorieDaoCgImplDefault.class);
	
	public ProduitcategorieDaoCgImplDefault() {
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
		return getGeneratorRuntime().getCache("persistence.beans.dao.IProduitcategorieTo");
	}
	
	/**
	 * Cette methode permet de regarder dans le cache si cet objet existe deja.<br/>
	 * Si oui, c'est l'objet dans le cache qui est retourne.<br/>
	 * Si non, c'est l'objet passe en parametre qui est retourne.<br/>
	 * @param object l'objet dont il faut tester la presence dans le cache.
	 * @return si l'objet est deja dans le cache, la version en cache. Sinon, l'objet en parametre.
	 * @throws NullPointerException si object est null.
	 */
	protected persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl selectCacheObject(persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl object) {
		String key = object.getCacheKey();
		Object cacheValue=getCache().getByKey(key);
		if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			getCache().putByKey(key, object);
			return object;
		}
		return (persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl)cacheValue;
	}
	
	/**
	 * Cette methode genere une clee chaine unique dependant des arguments.<br/>
	 * Actuellement, elle ne fait que concatener les clees et retourner une chaine.<br/>
	 * @param id la valeur pour id
	 * @return Une chaine representant de facon unique les parametres.
	 */
	protected String getCacheKey(long id) {
		return "persistence.beans.dao.impl.cg.Produitcategorie_"+id;
	}
	protected String _TABLE_SCHEMA = null;
	protected String _TABLE_NAME = "produitcategorie";
	protected String _TABLE_FULL_NAME = null;
	protected static String _FIELD_ID = "ID";
	protected static String _FIELD_LIBELLE = "LIBELLE";
	
	private void initSchema() {
		String s = null;
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produitcategorie.table_name");
		if (s!=null) {
			_TABLE_NAME = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produitcategorie.table_alias");
		if (s!=null) {
			ALIAS.setAlias(s);
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produitcategorie.schema_name");
		if (s==null) {
			s = getGeneratorRuntime().getStringProperty("c-generator.persistence.schema_name");
		}
		if (s!=null) {
			_TABLE_SCHEMA =  "null".equals(s)?null:s;
		}
		_TABLE_FULL_NAME = (_TABLE_SCHEMA==null?"":(_TABLE_SCHEMA+"."))+ "" + _TABLE_NAME + "";
		ALIAS.init(_TABLE_FULL_NAME);
		
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produitcategorie.id.column_name");
		if (s!=null) {
			_FIELD_ID = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Produitcategorie.libelle.column_name");
		if (s!=null) {
			_FIELD_LIBELLE = s;
		}
		
		initDeleteQuery();
		initSaveQuery();
	}
	
	/**
	 * Objet representant un alias de la table produitcategorie.
	 **/
	public static final TableAlias<persistence.beans.dao.IProduitcategorieTo> ALIAS = new JDBCTableAlias<persistence.beans.dao.IProduitcategorieTo>(persistence.beans.dao.IProduitcategorieTo.class, "produitcategorie", "produitcategorie");
	/**
	 * Retourne les colonnes pour faire les requetes la table Produitcategorie.<br>
	 * Méthode à usage générique, utilisez getProduitcategorieColumns() pour éviter les confusions
	 * @return PRODUITCATEGORIE_COLUMNS colonnes pour faire les requetes la table Produitcategorie
	 */
	public IProduitcategorieDao.PRODUITCATEGORIE_COLUMNS getColumns() {
		return getProduitcategorieColumns();
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
	 * @Deprecated utiliser la methode getProduitcategorieColumns() pour eviter de recupere des colonnes qui sont mal initialisees
	 **/
	@Deprecated
	public static interface PRODUITCATEGORIE_COLUMNS extends IProduitcategorieDao.PRODUITCATEGORIE_COLUMNS{
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
	}
	private IProduitcategorieDao.PRODUITCATEGORIE_COLUMNS columns = null;
	/**
	 * Recupere les colonnes/fonctions disponibles pour les requetes.
	 * @author c-generator (c) Cardiweb
	 **/
	public IProduitcategorieDao.PRODUITCATEGORIE_COLUMNS getProduitcategorieColumns(){
		if (columns == null) {
			IProduitcategorieDao.PRODUITCATEGORIE_COLUMNS temp = new PRODUITCATEGORIE_COLUMNS() {
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
			};
			columns = temp;
		}
		return columns;
	}
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitcategorieTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitcategorieTo
	 */
	public PersistenceQuery<persistence.beans.dao.IProduitcategorieTo> newQuery() {
		return new PersistenceQueryProduitcategorieVersion((persistence.beans.dao.impl.cg.ProduitcategorieDaoCgImpl)this);
	}
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitcategorieTo dans une sous-requête
	 * @param parentQuery requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IProduitcategorieTo dans une sous-requête
	 */
	public PersistenceQuery<persistence.beans.dao.IProduitcategorieTo> newSubQuery(PersistenceQuery<?> parentQuery) {
		return new PersistenceQueryProduitcategorieVersion((persistence.beans.dao.impl.cg.ProduitcategorieDaoCgImpl)this, parentQuery);
	}
	
	private static class PersistenceQueryProduitcategorieVersion extends JDBCPersistenceQuery<persistence.beans.dao.IProduitcategorieTo> {
		private persistence.beans.dao.impl.cg.ProduitcategorieDaoCgImpl _dao;
		/**
		 * Constructeur pour ce PersistenceQuery.
		 *
		 * @param dao
		 */
		public PersistenceQueryProduitcategorieVersion(persistence.beans.dao.impl.cg.ProduitcategorieDaoCgImpl dao) {
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
		public PersistenceQueryProduitcategorieVersion(persistence.beans.dao.impl.cg.ProduitcategorieDaoCgImpl dao, PersistenceQuery<?> parentQuery) {
			super(ALIAS, true, parentQuery);
			_dao=dao;
			init();
		}
		
		@Override
		protected GeneratorRuntime getGeneratorRuntime() {
			return _dao.getGeneratorRuntime();
		}
		
		@Override
		protected persistence.beans.dao.IProduitcategorieTo loadObjectFromRS(ResultSet rs) {
			
			try {
				
				String ___key = null;
				Object cacheValue = null;
				if (useCache) {
					long id = rs.getLong(_FIELD_ID);
					___key = _dao.getCacheKey(id);
					cacheValue = _dao.getCache().getByKey(___key);
				}
				if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
					
					persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl object = (persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl)_dao.create();
					object.setNew(false);
					object.setId(rs.getLong(_FIELD_ID));
					object.setLibelle(rs.getString(_FIELD_LIBELLE));
					
					if (useCache) { _dao.getCache().putByKey(___key, object); }
					return object;
				}
				return (persistence.beans.dao.IProduitcategorieTo)cacheValue;
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
	
	protected void fillSQLPrimaryParameters(int offset, PreparedStatement pst,persistence.beans.dao.IProduitcategorieTo obj) throws SQLException {
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
	public Observable<persistence.beans.dao.IProduitcategorieTo> getById(long id) {
		return getProduitcategorie(id);
	}
	
	
	/**
	 * Getter principal : retourne l'objet Produitcategorie en fonction de sa clee.
	 * @param id la valeur de la clee id
	 * @return l'objet correspondant a la clee ou null si aucun objet n'a ete trouve.
	 */
	public Observable<persistence.beans.dao.IProduitcategorieTo> getProduitcategorie(long id) {
		String ___key = getCacheKey(id);
		Object retour = getCache().getByKey(___key);
		if (retour==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			return Observable.just((persistence.beans.dao.IProduitcategorieTo) null);
		} else
		if (retour!=null) {
			return Observable.just((persistence.beans.dao.IProduitcategorieTo) retour);
		}
		
		return Observable.create((OnSubscribe<persistence.beans.dao.IProduitcategorieTo>) subscriber -> {
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
					r = newQuery().equal(PRODUITCATEGORIE_COLUMNS.id, id)	.getObject().subscribe(obj -> {
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
						subscriber.onNext((persistence.beans.dao.IProduitcategorieTo) r);
						subscriber.onCompleted();
					}
				}
			}
		})
		
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler())
		.observeOn(getGeneratorRuntime().getObserveOnScheduler());
		
	}
	
	private void initSaveQuery() {
		
		
		INSERT_QUERY = "insert into "+_TABLE_FULL_NAME+" ("+_FIELD_LIBELLE+","+_FIELD_ID+") values (?,?)";
		UPDATE_QUERY = "update "+_TABLE_FULL_NAME+" set "+_FIELD_LIBELLE+"=? where "+_FIELD_ID+"=?";
	}
	
	private String INSERT_QUERY;
	private String UPDATE_QUERY;
	public Observable<Void> save(persistence.beans.dao.IProduitcategorieTo _obj) {
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl obj = (persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl)_obj;
		
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
						fillSQLPrimaryParameters(2, pst, obj);
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
	
	private JDBCPersistenceQuery<persistence.beans.dao.IProduitcategorieTo> _cachePersistenceQuery;
	public void clearListCache() {
		if (_cachePersistenceQuery==null) {
			_cachePersistenceQuery = (JDBCPersistenceQuery<persistence.beans.dao.IProduitcategorieTo>)newQuery();
		}
		_cachePersistenceQuery.clearListCache(persistence.beans.dao.IProduitcategorieTo.class);
	}
	
	/**
	 * Cette methode genere toutes les valeurs pour les clee qui n'ont pas encore
	 * ete affectees.
	 *
	 * @param obj
	 */
	protected void generateIds(persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl obj) {
		if (obj.getId()==-1) {
			obj.setId(generateSpecificIdForId());
		}
	}
	private String DELETE_QUERY;
	private void initDeleteQuery() {
		
		
		DELETE_QUERY="delete from "+_TABLE_FULL_NAME+" where "+_FIELD_ID+"=?";
		
	}
	
	public Observable<Void> delete(persistence.beans.dao.IProduitcategorieTo _obj) {
		
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		
		return Observable
		.create((OnSubscribe<Void>) subscriber -> {
			persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl obj = (persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl)_obj;
			
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
	public persistence.beans.dao.IProduitcategorieTo create() {
		return new persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl();
	}
	/**
	 * Retourne la liste de tous les objets en base de donnee.
	 * @return la liste de tous les objets en base de donnee.
	 */
	public Observable<List<persistence.beans.dao.IProduitcategorieTo>> getList() {
		return newQuery().getList();
	}
	
	/**
	 * TOUTES les proprietes de l'objet sont source sont copiees dans l'objet destination
	 * MEME les blobs (les references des blobs)...
	 * @param src L'objet source depuis lequel copier les proprietes
	 * @param dest L'objet vers lequel copier les proprietes
	 */
	public void copy(persistence.beans.dao.IProduitcategorieTo src, persistence.beans.dao.IProduitcategorieTo dest) {
		dest.setId(src.getId());
		dest.setLibelle(src.getLibelle());
		
		dest.setNew(src.isNew());
	}
	
}
