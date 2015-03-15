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

import persistence.beans.dao.IClientDao;
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
public abstract class ClientDaoCgImplDefault implements IClientDao {
	
	static protected final Logger logger = Logger.getLogger(ClientDaoCgImplDefault.class);
	
	public ClientDaoCgImplDefault() {
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
		return getGeneratorRuntime().getCache("persistence.beans.dao.IClientTo");
	}
	
	/**
	 * Cette methode permet de regarder dans le cache si cet objet existe deja.<br/>
	 * Si oui, c'est l'objet dans le cache qui est retourne.<br/>
	 * Si non, c'est l'objet passe en parametre qui est retourne.<br/>
	 * @param object l'objet dont il faut tester la presence dans le cache.
	 * @return si l'objet est deja dans le cache, la version en cache. Sinon, l'objet en parametre.
	 * @throws NullPointerException si object est null.
	 */
	protected persistence.beans.dao.impl.cg.ClientToCgImpl selectCacheObject(persistence.beans.dao.impl.cg.ClientToCgImpl object) {
		String key = object.getCacheKey();
		Object cacheValue=getCache().getByKey(key);
		if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			getCache().putByKey(key, object);
			return object;
		}
		return (persistence.beans.dao.impl.cg.ClientToCgImpl)cacheValue;
	}
	
	/**
	 * Cette methode genere une clee chaine unique dependant des arguments.<br/>
	 * Actuellement, elle ne fait que concatener les clees et retourner une chaine.<br/>
	 * @param id la valeur pour id
	 * @return Une chaine representant de facon unique les parametres.
	 */
	protected String getCacheKey(long id) {
		return "persistence.beans.dao.impl.cg.Client_"+id;
	}
	protected String _TABLE_SCHEMA = null;
	protected String _TABLE_NAME = "client";
	protected String _TABLE_FULL_NAME = null;
	protected static String _FIELD_ID = "ID";
	protected static String _FIELD_NOM = "NOM";
	protected static String _FIELD_PRENOM = "PRENOM";
	protected static String _FIELD_TELEPHONE = "TELEPHONE";
	protected static String _FIELD_ADRESSE = "ADRESSE";
	protected static String _FIELD_CODEPOSTAL = "CODE_POSTAL";
	protected static String _FIELD_VILLE = "VILLE";
	protected static String _FIELD_BIRTHDAY = "BIRTHDAY";
	protected static String _FIELD_EMAIL = "EMAIL";
	
	private void initSchema() {
		String s = null;
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.table_name");
		if (s!=null) {
			_TABLE_NAME = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.table_alias");
		if (s!=null) {
			ALIAS.setAlias(s);
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.schema_name");
		if (s==null) {
			s = getGeneratorRuntime().getStringProperty("c-generator.persistence.schema_name");
		}
		if (s!=null) {
			_TABLE_SCHEMA =  "null".equals(s)?null:s;
		}
		_TABLE_FULL_NAME = (_TABLE_SCHEMA==null?"":(_TABLE_SCHEMA+"."))+ "" + _TABLE_NAME + "";
		ALIAS.init(_TABLE_FULL_NAME);
		
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.id.column_name");
		if (s!=null) {
			_FIELD_ID = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.nom.column_name");
		if (s!=null) {
			_FIELD_NOM = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.prenom.column_name");
		if (s!=null) {
			_FIELD_PRENOM = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.telephone.column_name");
		if (s!=null) {
			_FIELD_TELEPHONE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.adresse.column_name");
		if (s!=null) {
			_FIELD_ADRESSE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.codePostal.column_name");
		if (s!=null) {
			_FIELD_CODEPOSTAL = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.ville.column_name");
		if (s!=null) {
			_FIELD_VILLE = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.birthday.column_name");
		if (s!=null) {
			_FIELD_BIRTHDAY = s;
		}
		s = getGeneratorRuntime().getStringProperty("c-generator.persistence.Client.email.column_name");
		if (s!=null) {
			_FIELD_EMAIL = s;
		}
		
		initDeleteQuery();
		initSaveQuery();
	}
	
	/**
	 * Objet representant un alias de la table client.
	 **/
	public static final TableAlias<persistence.beans.dao.IClientTo> ALIAS = new JDBCTableAlias<persistence.beans.dao.IClientTo>(persistence.beans.dao.IClientTo.class, "client", "client");
	/**
	 * Retourne les colonnes pour faire les requetes la table Client.<br>
	 * Méthode à usage générique, utilisez getClientColumns() pour éviter les confusions
	 * @return CLIENT_COLUMNS colonnes pour faire les requetes la table Client
	 */
	public IClientDao.CLIENT_COLUMNS getColumns() {
		return getClientColumns();
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
	 * @Deprecated utiliser la methode getClientColumns() pour eviter de recupere des colonnes qui sont mal initialisees
	 **/
	@Deprecated
	public static interface CLIENT_COLUMNS extends IClientDao.CLIENT_COLUMNS{
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
		 * Objet representant la colonne NOM (propriete nom) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn nom = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, null, java.lang.String.class);
		/**
		 * Objet representant la colonne NOM (propriete nom) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn nomMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, JDBCFunction.MIN, java.lang.String.class);
		/**
		 * Objet representant la colonne NOM (propriete nom) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn nomMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, JDBCFunction.MAX, java.lang.String.class);
		/**
		 * Objet representant la colonne NOM (propriete nom) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn nomCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, JDBCFunction.COUNT, java.lang.String.class);
		/**
		 * Objet representant la colonne NOM (propriete nom) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn nomUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, JDBCFunction.UPPER, java.lang.String.class);
		/**
		 * Objet representant la colonne PRENOM (propriete prenom) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prenom = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, null, java.lang.String.class);
		/**
		 * Objet representant la colonne PRENOM (propriete prenom) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prenomMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, JDBCFunction.MIN, java.lang.String.class);
		/**
		 * Objet representant la colonne PRENOM (propriete prenom) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prenomMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, JDBCFunction.MAX, java.lang.String.class);
		/**
		 * Objet representant la colonne PRENOM (propriete prenom) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prenomCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, JDBCFunction.COUNT, java.lang.String.class);
		/**
		 * Objet representant la colonne PRENOM (propriete prenom) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn prenomUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, JDBCFunction.UPPER, java.lang.String.class);
		/**
		 * Objet representant la colonne TELEPHONE (propriete telephone) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn telephone = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, null, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TELEPHONE (propriete telephone) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn telephoneMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.MIN, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TELEPHONE (propriete telephone) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn telephoneMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.MAX, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TELEPHONE (propriete telephone) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn telephoneCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.COUNT, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TELEPHONE (propriete telephone) aggregee par la fonction sum() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn telephoneSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.SUM, java.lang.Integer.class);
		/**
		 * Objet representant la colonne TELEPHONE (propriete telephone) aggregee par la fonction avg() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn telephoneAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.AVG, java.lang.Integer.class);
		/**
		 * Objet representant la colonne ADRESSE (propriete adresse) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn adresse = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, null, java.lang.String.class);
		/**
		 * Objet representant la colonne ADRESSE (propriete adresse) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn adresseMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, JDBCFunction.MIN, java.lang.String.class);
		/**
		 * Objet representant la colonne ADRESSE (propriete adresse) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn adresseMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, JDBCFunction.MAX, java.lang.String.class);
		/**
		 * Objet representant la colonne ADRESSE (propriete adresse) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn adresseCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, JDBCFunction.COUNT, java.lang.String.class);
		/**
		 * Objet representant la colonne ADRESSE (propriete adresse) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn adresseUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, JDBCFunction.UPPER, java.lang.String.class);
		/**
		 * Objet representant la colonne CODE_POSTAL (propriete codePostal) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn codePostal = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, null, java.lang.String.class);
		/**
		 * Objet representant la colonne CODE_POSTAL (propriete codePostal) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn codePostalMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, JDBCFunction.MIN, java.lang.String.class);
		/**
		 * Objet representant la colonne CODE_POSTAL (propriete codePostal) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn codePostalMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, JDBCFunction.MAX, java.lang.String.class);
		/**
		 * Objet representant la colonne CODE_POSTAL (propriete codePostal) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn codePostalCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, JDBCFunction.COUNT, java.lang.String.class);
		/**
		 * Objet representant la colonne CODE_POSTAL (propriete codePostal) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn codePostalUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, JDBCFunction.UPPER, java.lang.String.class);
		/**
		 * Objet representant la colonne VILLE (propriete ville) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn ville = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, null, java.lang.String.class);
		/**
		 * Objet representant la colonne VILLE (propriete ville) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn villeMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, JDBCFunction.MIN, java.lang.String.class);
		/**
		 * Objet representant la colonne VILLE (propriete ville) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn villeMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, JDBCFunction.MAX, java.lang.String.class);
		/**
		 * Objet representant la colonne VILLE (propriete ville) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn villeCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, JDBCFunction.COUNT, java.lang.String.class);
		/**
		 * Objet representant la colonne VILLE (propriete ville) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn villeUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, JDBCFunction.UPPER, java.lang.String.class);
		/**
		 * Objet representant la colonne BIRTHDAY (propriete birthday) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn birthday = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "birthday", _FIELD_BIRTHDAY, null, java.sql.Timestamp.class);
		/**
		 * Objet representant la colonne BIRTHDAY (propriete birthday) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn birthdayMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "birthday", _FIELD_BIRTHDAY, JDBCFunction.MIN, java.sql.Timestamp.class);
		/**
		 * Objet representant la colonne BIRTHDAY (propriete birthday) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn birthdayMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "birthday", _FIELD_BIRTHDAY, JDBCFunction.MAX, java.sql.Timestamp.class);
		/**
		 * Objet representant la colonne BIRTHDAY (propriete birthday) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn birthdayCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "birthday", _FIELD_BIRTHDAY, JDBCFunction.COUNT, java.sql.Timestamp.class);
		/**
		 * Objet representant la colonne EMAIL (propriete email) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn email = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, null, java.lang.String.class);
		/**
		 * Objet representant la colonne EMAIL (propriete email) aggregee par la fonction min() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn emailMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, JDBCFunction.MIN, java.lang.String.class);
		/**
		 * Objet representant la colonne EMAIL (propriete email) aggregee par la fonction max') a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn emailMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, JDBCFunction.MAX, java.lang.String.class);
		/**
		 * Objet representant la colonne EMAIL (propriete email) aggregee par la fonction count() a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn emailCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, JDBCFunction.COUNT, java.lang.String.class);
		/**
		 * Objet representant la colonne EMAIL (propriete email) a utiliser dans les requetes.
		 */
		@Deprecated
		public static final QueryColumn emailUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, JDBCFunction.UPPER, java.lang.String.class);
	}
	private IClientDao.CLIENT_COLUMNS columns = null;
	/**
	 * Recupere les colonnes/fonctions disponibles pour les requetes.
	 * @author c-generator (c) Cardiweb
	 **/
	public IClientDao.CLIENT_COLUMNS getClientColumns(){
		if (columns == null) {
			IClientDao.CLIENT_COLUMNS temp = new CLIENT_COLUMNS() {
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
				private QueryColumn columnNom = null;
				public QueryColumn getNom(){
					if( columnNom == null ){
						columnNom = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, null, java.lang.String.class);
					}
					return columnNom;
				}
				private QueryColumn columnNomMIN = null;
				public QueryColumn getNomMIN(){
					if( columnNomMIN == null ){
						columnNomMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, JDBCFunction.MIN, java.lang.String.class);
					}
					return columnNomMIN;
				}
				private QueryColumn columnNomMAX = null;
				public QueryColumn getNomMAX(){
					if( columnNomMAX == null ){
						columnNomMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, JDBCFunction.MAX, java.lang.String.class);
					}
					return columnNomMAX;
				}
				private QueryColumn columnNomCOUNT = null;
				public QueryColumn getNomCOUNT(){
					if( columnNomCOUNT == null ){
						columnNomCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, JDBCFunction.COUNT, java.lang.String.class);
					}
					return columnNomCOUNT;
				}
				private QueryColumn columnNomUPPER = null;
				public QueryColumn getNomUPPER(){
					if( columnNomUPPER == null ){
						columnNomUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "nom", _FIELD_NOM, JDBCFunction.UPPER, java.lang.String.class);
					}
					return columnNomUPPER;
				}
				private QueryColumn columnPrenom = null;
				public QueryColumn getPrenom(){
					if( columnPrenom == null ){
						columnPrenom = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, null, java.lang.String.class);
					}
					return columnPrenom;
				}
				private QueryColumn columnPrenomMIN = null;
				public QueryColumn getPrenomMIN(){
					if( columnPrenomMIN == null ){
						columnPrenomMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, JDBCFunction.MIN, java.lang.String.class);
					}
					return columnPrenomMIN;
				}
				private QueryColumn columnPrenomMAX = null;
				public QueryColumn getPrenomMAX(){
					if( columnPrenomMAX == null ){
						columnPrenomMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, JDBCFunction.MAX, java.lang.String.class);
					}
					return columnPrenomMAX;
				}
				private QueryColumn columnPrenomCOUNT = null;
				public QueryColumn getPrenomCOUNT(){
					if( columnPrenomCOUNT == null ){
						columnPrenomCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, JDBCFunction.COUNT, java.lang.String.class);
					}
					return columnPrenomCOUNT;
				}
				private QueryColumn columnPrenomUPPER = null;
				public QueryColumn getPrenomUPPER(){
					if( columnPrenomUPPER == null ){
						columnPrenomUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "prenom", _FIELD_PRENOM, JDBCFunction.UPPER, java.lang.String.class);
					}
					return columnPrenomUPPER;
				}
				private QueryColumn columnTelephone = null;
				public QueryColumn getTelephone(){
					if( columnTelephone == null ){
						columnTelephone = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, null, java.lang.Integer.class);
					}
					return columnTelephone;
				}
				private QueryColumn columnTelephoneMIN = null;
				public QueryColumn getTelephoneMIN(){
					if( columnTelephoneMIN == null ){
						columnTelephoneMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.MIN, java.lang.Integer.class);
					}
					return columnTelephoneMIN;
				}
				private QueryColumn columnTelephoneMAX = null;
				public QueryColumn getTelephoneMAX(){
					if( columnTelephoneMAX == null ){
						columnTelephoneMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.MAX, java.lang.Integer.class);
					}
					return columnTelephoneMAX;
				}
				private QueryColumn columnTelephoneCOUNT = null;
				public QueryColumn getTelephoneCOUNT(){
					if( columnTelephoneCOUNT == null ){
						columnTelephoneCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.COUNT, java.lang.Integer.class);
					}
					return columnTelephoneCOUNT;
				}
				private QueryColumn columnTelephoneSUM = null;
				public QueryColumn getTelephoneSUM(){
					if( columnTelephoneSUM == null ){
						columnTelephoneSUM = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.SUM, java.lang.Integer.class);
					}
					return columnTelephoneSUM;
				}
				private QueryColumn columnTelephoneAVG = null;
				public QueryColumn getTelephoneAVG(){
					if( columnTelephoneAVG == null ){
						columnTelephoneAVG = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.AVG, java.lang.Integer.class);
					}
					return columnTelephoneAVG;
				}
				private QueryColumn columnTelephoneISNULL = null;
				public QueryColumn getTelephoneISNULL(){
					if( columnTelephoneISNULL == null ){
						columnTelephoneISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "telephone", _FIELD_TELEPHONE, JDBCFunction.ISNULL, java.lang.Integer.class);
					}
					return columnTelephoneISNULL;
				}
				private QueryColumn columnAdresse = null;
				public QueryColumn getAdresse(){
					if( columnAdresse == null ){
						columnAdresse = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, null, java.lang.String.class);
					}
					return columnAdresse;
				}
				private QueryColumn columnAdresseMIN = null;
				public QueryColumn getAdresseMIN(){
					if( columnAdresseMIN == null ){
						columnAdresseMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, JDBCFunction.MIN, java.lang.String.class);
					}
					return columnAdresseMIN;
				}
				private QueryColumn columnAdresseMAX = null;
				public QueryColumn getAdresseMAX(){
					if( columnAdresseMAX == null ){
						columnAdresseMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, JDBCFunction.MAX, java.lang.String.class);
					}
					return columnAdresseMAX;
				}
				private QueryColumn columnAdresseCOUNT = null;
				public QueryColumn getAdresseCOUNT(){
					if( columnAdresseCOUNT == null ){
						columnAdresseCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, JDBCFunction.COUNT, java.lang.String.class);
					}
					return columnAdresseCOUNT;
				}
				private QueryColumn columnAdresseUPPER = null;
				public QueryColumn getAdresseUPPER(){
					if( columnAdresseUPPER == null ){
						columnAdresseUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, JDBCFunction.UPPER, java.lang.String.class);
					}
					return columnAdresseUPPER;
				}
				private QueryColumn columnAdresseISNULL = null;
				public QueryColumn getAdresseISNULL(){
					if( columnAdresseISNULL == null ){
						columnAdresseISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "adresse", _FIELD_ADRESSE, JDBCFunction.ISNULL, java.lang.String.class);
					}
					return columnAdresseISNULL;
				}
				private QueryColumn columnCodePostal = null;
				public QueryColumn getCodePostal(){
					if( columnCodePostal == null ){
						columnCodePostal = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, null, java.lang.String.class);
					}
					return columnCodePostal;
				}
				private QueryColumn columnCodePostalMIN = null;
				public QueryColumn getCodePostalMIN(){
					if( columnCodePostalMIN == null ){
						columnCodePostalMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, JDBCFunction.MIN, java.lang.String.class);
					}
					return columnCodePostalMIN;
				}
				private QueryColumn columnCodePostalMAX = null;
				public QueryColumn getCodePostalMAX(){
					if( columnCodePostalMAX == null ){
						columnCodePostalMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, JDBCFunction.MAX, java.lang.String.class);
					}
					return columnCodePostalMAX;
				}
				private QueryColumn columnCodePostalCOUNT = null;
				public QueryColumn getCodePostalCOUNT(){
					if( columnCodePostalCOUNT == null ){
						columnCodePostalCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, JDBCFunction.COUNT, java.lang.String.class);
					}
					return columnCodePostalCOUNT;
				}
				private QueryColumn columnCodePostalUPPER = null;
				public QueryColumn getCodePostalUPPER(){
					if( columnCodePostalUPPER == null ){
						columnCodePostalUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, JDBCFunction.UPPER, java.lang.String.class);
					}
					return columnCodePostalUPPER;
				}
				private QueryColumn columnCodePostalISNULL = null;
				public QueryColumn getCodePostalISNULL(){
					if( columnCodePostalISNULL == null ){
						columnCodePostalISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "codePostal", _FIELD_CODEPOSTAL, JDBCFunction.ISNULL, java.lang.String.class);
					}
					return columnCodePostalISNULL;
				}
				private QueryColumn columnVille = null;
				public QueryColumn getVille(){
					if( columnVille == null ){
						columnVille = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, null, java.lang.String.class);
					}
					return columnVille;
				}
				private QueryColumn columnVilleMIN = null;
				public QueryColumn getVilleMIN(){
					if( columnVilleMIN == null ){
						columnVilleMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, JDBCFunction.MIN, java.lang.String.class);
					}
					return columnVilleMIN;
				}
				private QueryColumn columnVilleMAX = null;
				public QueryColumn getVilleMAX(){
					if( columnVilleMAX == null ){
						columnVilleMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, JDBCFunction.MAX, java.lang.String.class);
					}
					return columnVilleMAX;
				}
				private QueryColumn columnVilleCOUNT = null;
				public QueryColumn getVilleCOUNT(){
					if( columnVilleCOUNT == null ){
						columnVilleCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, JDBCFunction.COUNT, java.lang.String.class);
					}
					return columnVilleCOUNT;
				}
				private QueryColumn columnVilleUPPER = null;
				public QueryColumn getVilleUPPER(){
					if( columnVilleUPPER == null ){
						columnVilleUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, JDBCFunction.UPPER, java.lang.String.class);
					}
					return columnVilleUPPER;
				}
				private QueryColumn columnVilleISNULL = null;
				public QueryColumn getVilleISNULL(){
					if( columnVilleISNULL == null ){
						columnVilleISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "ville", _FIELD_VILLE, JDBCFunction.ISNULL, java.lang.String.class);
					}
					return columnVilleISNULL;
				}
				private QueryColumn columnBirthday = null;
				public QueryColumn getBirthday(){
					if( columnBirthday == null ){
						columnBirthday = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "birthday", _FIELD_BIRTHDAY, null, java.sql.Timestamp.class);
					}
					return columnBirthday;
				}
				private QueryColumn columnBirthdayMIN = null;
				public QueryColumn getBirthdayMIN(){
					if( columnBirthdayMIN == null ){
						columnBirthdayMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "birthday", _FIELD_BIRTHDAY, JDBCFunction.MIN, java.sql.Timestamp.class);
					}
					return columnBirthdayMIN;
				}
				private QueryColumn columnBirthdayMAX = null;
				public QueryColumn getBirthdayMAX(){
					if( columnBirthdayMAX == null ){
						columnBirthdayMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "birthday", _FIELD_BIRTHDAY, JDBCFunction.MAX, java.sql.Timestamp.class);
					}
					return columnBirthdayMAX;
				}
				private QueryColumn columnBirthdayCOUNT = null;
				public QueryColumn getBirthdayCOUNT(){
					if( columnBirthdayCOUNT == null ){
						columnBirthdayCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "birthday", _FIELD_BIRTHDAY, JDBCFunction.COUNT, java.sql.Timestamp.class);
					}
					return columnBirthdayCOUNT;
				}
				private QueryColumn columnBirthdayISNULL = null;
				public QueryColumn getBirthdayISNULL(){
					if( columnBirthdayISNULL == null ){
						columnBirthdayISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "birthday", _FIELD_BIRTHDAY, JDBCFunction.ISNULL, java.sql.Timestamp.class);
					}
					return columnBirthdayISNULL;
				}
				private QueryColumn columnEmail = null;
				public QueryColumn getEmail(){
					if( columnEmail == null ){
						columnEmail = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, null, java.lang.String.class);
					}
					return columnEmail;
				}
				private QueryColumn columnEmailMIN = null;
				public QueryColumn getEmailMIN(){
					if( columnEmailMIN == null ){
						columnEmailMIN = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, JDBCFunction.MIN, java.lang.String.class);
					}
					return columnEmailMIN;
				}
				private QueryColumn columnEmailMAX = null;
				public QueryColumn getEmailMAX(){
					if( columnEmailMAX == null ){
						columnEmailMAX = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, JDBCFunction.MAX, java.lang.String.class);
					}
					return columnEmailMAX;
				}
				private QueryColumn columnEmailCOUNT = null;
				public QueryColumn getEmailCOUNT(){
					if( columnEmailCOUNT == null ){
						columnEmailCOUNT = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, JDBCFunction.COUNT, java.lang.String.class);
					}
					return columnEmailCOUNT;
				}
				private QueryColumn columnEmailUPPER = null;
				public QueryColumn getEmailUPPER(){
					if( columnEmailUPPER == null ){
						columnEmailUPPER = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, JDBCFunction.UPPER, java.lang.String.class);
					}
					return columnEmailUPPER;
				}
				private QueryColumn columnEmailISNULL = null;
				public QueryColumn getEmailISNULL(){
					if( columnEmailISNULL == null ){
						columnEmailISNULL = new JDBCQueryColumn((JDBCTableAlias<?>)ALIAS, "email", _FIELD_EMAIL, JDBCFunction.ISNULL, java.lang.String.class);
					}
					return columnEmailISNULL;
				}
			};
			columns = temp;
		}
		return columns;
	}
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IClientTo
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IClientTo
	 */
	public PersistenceQuery<persistence.beans.dao.IClientTo> newQuery() {
		return new PersistenceQueryClientVersion((persistence.beans.dao.impl.cg.ClientDaoCgImpl)this);
	}
	
	/**
	 * Retourne un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IClientTo dans une sous-requête
	 * @param parentQuery requête parente de la sous-requête
	 * @return un persistence query permettant de faire des recherche sur la classe persistence.beans.dao.IClientTo dans une sous-requête
	 */
	public PersistenceQuery<persistence.beans.dao.IClientTo> newSubQuery(PersistenceQuery<?> parentQuery) {
		return new PersistenceQueryClientVersion((persistence.beans.dao.impl.cg.ClientDaoCgImpl)this, parentQuery);
	}
	
	private static class PersistenceQueryClientVersion extends JDBCPersistenceQuery<persistence.beans.dao.IClientTo> {
		private persistence.beans.dao.impl.cg.ClientDaoCgImpl _dao;
		/**
		 * Constructeur pour ce PersistenceQuery.
		 *
		 * @param dao
		 */
		public PersistenceQueryClientVersion(persistence.beans.dao.impl.cg.ClientDaoCgImpl dao) {
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
		public PersistenceQueryClientVersion(persistence.beans.dao.impl.cg.ClientDaoCgImpl dao, PersistenceQuery<?> parentQuery) {
			super(ALIAS, true, parentQuery);
			_dao=dao;
			init();
		}
		
		@Override
		protected GeneratorRuntime getGeneratorRuntime() {
			return _dao.getGeneratorRuntime();
		}
		
		@Override
		protected persistence.beans.dao.IClientTo loadObjectFromRS(ResultSet rs) {
			
			try {
				
				String ___key = null;
				Object cacheValue = null;
				if (useCache) {
					long id = rs.getLong(_FIELD_ID);
					___key = _dao.getCacheKey(id);
					cacheValue = _dao.getCache().getByKey(___key);
				}
				if (cacheValue==null || cacheValue==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
					
					persistence.beans.dao.impl.cg.ClientToCgImpl object = (persistence.beans.dao.impl.cg.ClientToCgImpl)_dao.create();
					object.setNew(false);
					object.setId(rs.getLong(_FIELD_ID));
					object.setNom(rs.getString(_FIELD_NOM));
					object.setPrenom(rs.getString(_FIELD_PRENOM));
					rs.getObject("TELEPHONE");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setTelephone(rs.getInt(_FIELD_TELEPHONE));
					}
					rs.getObject("ADRESSE");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setAdresse(rs.getString(_FIELD_ADRESSE));
					}
					rs.getObject("CODE_POSTAL");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setCodePostal(rs.getString(_FIELD_CODEPOSTAL));
					}
					rs.getObject("VILLE");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setVille(rs.getString(_FIELD_VILLE));
					}
					rs.getObject("BIRTHDAY");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setBirthday(rs.getTimestamp(_FIELD_BIRTHDAY));
					}
					rs.getObject("EMAIL");
					// On affecte pas quand rs.wasNull() car vaut la valeur par defaut
					if (!rs.wasNull()) {
						object.setEmail(rs.getString(_FIELD_EMAIL));
					}
					
					if (useCache) { _dao.getCache().putByKey(___key, object); }
					return object;
				}
				return (persistence.beans.dao.IClientTo)cacheValue;
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
	
	protected void fillSQLPrimaryParameters(int offset, PreparedStatement pst,persistence.beans.dao.IClientTo obj) throws SQLException {
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
	public Observable<persistence.beans.dao.IClientTo> getById(long id) {
		return getClient(id);
	}
	
	
	/**
	 * Getter principal : retourne l'objet Client en fonction de sa clee.
	 * @param id la valeur de la clee id
	 * @return l'objet correspondant a la clee ou null si aucun objet n'a ete trouve.
	 */
	public Observable<persistence.beans.dao.IClientTo> getClient(long id) {
		String ___key = getCacheKey(id);
		Object retour = getCache().getByKey(___key);
		if (retour==com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime.getNotFound()) {
			return Observable.just((persistence.beans.dao.IClientTo) null);
		} else
		if (retour!=null) {
			return Observable.just((persistence.beans.dao.IClientTo) retour);
		}
		
		return Observable.create((OnSubscribe<persistence.beans.dao.IClientTo>) subscriber -> {
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
					r = newQuery().equal(CLIENT_COLUMNS.id, id)	.getObject().subscribe(obj -> {
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
						subscriber.onNext((persistence.beans.dao.IClientTo) r);
						subscriber.onCompleted();
					}
				}
			}
		})
		
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler())
		.observeOn(getGeneratorRuntime().getObserveOnScheduler());
		
	}
	
	private void initSaveQuery() {
		
		
		INSERT_QUERY = "insert into "+_TABLE_FULL_NAME+" ("+_FIELD_NOM+","+_FIELD_PRENOM+","+_FIELD_TELEPHONE+","+_FIELD_ADRESSE+","+_FIELD_CODEPOSTAL+","+_FIELD_VILLE+","+_FIELD_BIRTHDAY+","+_FIELD_EMAIL+","+_FIELD_ID+") values (?,?,?,?,?,?,?,?,?)";
		UPDATE_QUERY = "update "+_TABLE_FULL_NAME+" set "+_FIELD_NOM+"=?,"+_FIELD_PRENOM+"=?,"+_FIELD_TELEPHONE+"=?,"+_FIELD_ADRESSE+"=?,"+_FIELD_CODEPOSTAL+"=?,"+_FIELD_VILLE+"=?,"+_FIELD_BIRTHDAY+"=?,"+_FIELD_EMAIL+"=? where "+_FIELD_ID+"=?";
	}
	
	private String INSERT_QUERY;
	private String UPDATE_QUERY;
	public Observable<Void> save(persistence.beans.dao.IClientTo _obj) {
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		persistence.beans.dao.impl.cg.ClientToCgImpl obj = (persistence.beans.dao.impl.cg.ClientToCgImpl)_obj;
		
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
						pst.setString(1, obj.getNom());
						pst.setString(2, obj.getPrenom());
						if (obj.getTelephone()==null) { pst.setNull(3 , 4);} else { pst.setInt(3, obj.getTelephone());}
						if (obj.getAdresse()==null) { pst.setNull(4 , 12);} else { pst.setString(4, obj.getAdresse());}
						if (obj.getCodePostal()==null) { pst.setNull(5 , 12);} else { pst.setString(5, obj.getCodePostal());}
						if (obj.getVille()==null) { pst.setNull(6 , 12);} else { pst.setString(6, obj.getVille());}
						if (obj.getBirthday()==null) { pst.setNull(7 , 93);} else { pst.setTimestamp(7, obj.getBirthday());}
						if (obj.getEmail()==null) { pst.setNull(8 , 12);} else { pst.setString(8, obj.getEmail());}
						fillSQLPrimaryParameters(9, pst, obj);
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
	
	private JDBCPersistenceQuery<persistence.beans.dao.IClientTo> _cachePersistenceQuery;
	public void clearListCache() {
		if (_cachePersistenceQuery==null) {
			_cachePersistenceQuery = (JDBCPersistenceQuery<persistence.beans.dao.IClientTo>)newQuery();
		}
		_cachePersistenceQuery.clearListCache(persistence.beans.dao.IClientTo.class);
	}
	
	/**
	 * Cette methode genere toutes les valeurs pour les clee qui n'ont pas encore
	 * ete affectees.
	 *
	 * @param obj
	 */
	protected void generateIds(persistence.beans.dao.impl.cg.ClientToCgImpl obj) {
		if (obj.getId()==-1) {
			obj.setId(generateSpecificIdForId());
		}
	}
	private String DELETE_QUERY;
	private void initDeleteQuery() {
		
		
		DELETE_QUERY="delete from "+_TABLE_FULL_NAME+" where "+_FIELD_ID+"=?";
		
	}
	
	public Observable<Void> delete(persistence.beans.dao.IClientTo _obj) {
		
		if (_obj==null) {
			throw new IllegalArgumentException("obj : null");
		}
		
		return Observable
		.create((OnSubscribe<Void>) subscriber -> {
			persistence.beans.dao.impl.cg.ClientToCgImpl obj = (persistence.beans.dao.impl.cg.ClientToCgImpl)_obj;
			
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
	public persistence.beans.dao.IClientTo create() {
		return new persistence.beans.dao.impl.cg.ClientToCgImpl();
	}
	/**
	 * Retourne la liste de tous les objets en base de donnee.
	 * @return la liste de tous les objets en base de donnee.
	 */
	public Observable<List<persistence.beans.dao.IClientTo>> getList() {
		return newQuery().getList();
	}
	
	/**
	 * TOUTES les proprietes de l'objet sont source sont copiees dans l'objet destination
	 * MEME les blobs (les references des blobs)...
	 * @param src L'objet source depuis lequel copier les proprietes
	 * @param dest L'objet vers lequel copier les proprietes
	 */
	public void copy(persistence.beans.dao.IClientTo src, persistence.beans.dao.IClientTo dest) {
		dest.setId(src.getId());
		dest.setNom(src.getNom());
		dest.setPrenom(src.getPrenom());
		dest.setTelephone(src.getTelephone());
		dest.setAdresse(src.getAdresse());
		dest.setCodePostal(src.getCodePostal());
		dest.setVille(src.getVille());
		dest.setBirthday(src.getBirthday());
		dest.setEmail(src.getEmail());
		
		dest.setNew(src.isNew());
	}
	
}
