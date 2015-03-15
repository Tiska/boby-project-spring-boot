package persistence.beans.biz;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.cardiweb.clazylist.LazyList;
import com.cardiweb.clazylist.LazyListListLoader;
import com.cardiweb.generator.persistence.runtimev3.GeneratorRuntime;

import org.apache.log4j.Logger;

import rx.Observable;
import rx.Observable.OnSubscribe;

import persistence.beans.dao.IClientDao;
import persistence.beans.dao.IClientTo;


/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public abstract class ClientDefault {
	
	static final Logger logger = Logger.getLogger(ClientDefault.class);
	
	protected ClientDefault() {
	}
	protected IClientTo _to = null;
	protected static Optional<Client> create(IClientTo to) {
		if (to==null) {
			return Optional.empty();
		}
		Client retour = new Client();
		retour._to=to;
		return Optional.of(retour);
	}
	
	
	
	protected static GeneratorRuntime _generatorRuntime = null;
	protected static GeneratorRuntime getGeneratorRuntime() {
		if (_generatorRuntime==null) {
			_generatorRuntime=persistence.GeneratorRuntime.getGeneratorRuntime();
		}
		return _generatorRuntime;
	}
	
	private static IClientDao _dao = null;
	protected static IClientDao getDao() {
		if (_dao==null) {
			_dao = getGeneratorRuntime().getImplementation(IClientDao.class);
		}
		return _dao;
	}
	
	public static Observable<Optional<Client>> getById(long id) {
		return getClient(id);
	}
	
	
	public static Observable<Optional<Client>> getClient(long id) {
		return getDao().getById(id).map(to -> Client.create(to));
	}
	
	public Observable<Void> delete() {
		return getDao().delete(_to);
	}
	
	public Observable<Void> save() {
		return getDao().save(_to);
	}
	
	public static Client create() {
		Client retour = create(getDao().create()).get();
		retour.init();
		return retour;
	}
	
	/**
	 * Permet d'initialiser un bean à sa création, lors de l'appel à create() en static.<br>
	 * A surcharger si besoin.
	 */
	protected void init() {
	}
	
	public static class ClientLazyListLoader extends LazyListListLoader<Client, IClientTo>{
		public ClientLazyListLoader(List<IClientTo> source) {
			super(source);
		}
		
		@Override
		public Client adapt(IClientTo to) {
			return Client.create(to).get();
		}
	}
	
	/**
	 * Transforme une liste de To en une liste d'objets business en autorisant l'appel à toArray()
	 */
	protected static List<Client> toBizList(List<persistence.beans.dao.IClientTo> source) {
		return new LazyList<Client>(new ClientLazyListLoader(source), true);
	}
	
	public static Observable<List<Client>> getList() {
		return getDao().getList().map((List<IClientTo> tos) -> Client.toBizList(tos));
	}
	
	
	private boolean isCopy = false;
	private IClientTo getTo(boolean read) {
		if (isCopy || _to.isNew() || read) {
			return _to;
		}
		IClientTo copy = getDao().create();
		getDao().copy(_to, copy);
		_to=copy;
		isCopy=true;
		return _to;
	}
	
	
	/**
	 * Obtenir la valeur de la propriete id.
	 *
	 * @return la valeur de la propriete id
	 */
	public long getId() {
		return getTo(true).getId();
	}
	
	
	/**
	 * Affecte la propriete id.
	 *
	 * @param id la valeur a affecter.
	 */
	public void setId(long id) {
		getTo(false).setId(id);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete nom.
	 *
	 * @return la valeur de la propriete nom
	 */
	public String getNom() {
		return getTo(true).getNom();
	}
	
	
	/**
	 * Affecte la propriete nom.
	 *
	 * @param nom la valeur a affecter.
	 */
	public void setNom(String nom) {
		getTo(false).setNom(nom);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete prenom.
	 *
	 * @return la valeur de la propriete prenom
	 */
	public String getPrenom() {
		return getTo(true).getPrenom();
	}
	
	
	/**
	 * Affecte la propriete prenom.
	 *
	 * @param prenom la valeur a affecter.
	 */
	public void setPrenom(String prenom) {
		getTo(false).setPrenom(prenom);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete telephone.
	 *
	 * @return la valeur de la propriete telephone
	 */
	public Optional<Integer> getTelephone() {
		return Optional.ofNullable(getTo(true).getTelephone());
	}
	
	
	/**
	 * Affecte la propriete telephone.
	 *
	 * @param telephone la valeur a affecter.
	 */
	public void setTelephone(Integer telephone) {
		getTo(false).setTelephone(telephone);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete adresse.
	 *
	 * @return la valeur de la propriete adresse
	 */
	public Optional<String> getAdresse() {
		return Optional.ofNullable(getTo(true).getAdresse());
	}
	
	
	/**
	 * Affecte la propriete adresse.
	 *
	 * @param adresse la valeur a affecter.
	 */
	public void setAdresse(String adresse) {
		getTo(false).setAdresse(adresse);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete codePostal.
	 *
	 * @return la valeur de la propriete codePostal
	 */
	public Optional<String> getCodePostal() {
		return Optional.ofNullable(getTo(true).getCodePostal());
	}
	
	
	/**
	 * Affecte la propriete codePostal.
	 *
	 * @param codePostal la valeur a affecter.
	 */
	public void setCodePostal(String codePostal) {
		getTo(false).setCodePostal(codePostal);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete ville.
	 *
	 * @return la valeur de la propriete ville
	 */
	public Optional<String> getVille() {
		return Optional.ofNullable(getTo(true).getVille());
	}
	
	
	/**
	 * Affecte la propriete ville.
	 *
	 * @param ville la valeur a affecter.
	 */
	public void setVille(String ville) {
		getTo(false).setVille(ville);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete birthday.
	 *
	 * @return la valeur de la propriete birthday
	 */
	public Optional<java.time.LocalDateTime> getBirthday() {
		java.sql.Timestamp timestamp = getTo(false).getBirthday();
		if (timestamp == null) {
			return Optional.empty();
		}
		return Optional.of(java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(timestamp.getTime()), java.time.ZoneId.systemDefault()));
	}
	
	/**
	 * Affecte la propriete birthday.
	 *
	 * @param birthday la valeur a affecter.
	 */
	public void setBirthday(java.time.LocalDateTime birthday) {
		if (birthday == null) {
			getTo(false).setBirthday(null);
		} else {
			getTo(false).setBirthday(new java.sql.Timestamp(birthday.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli()));
		}
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete email.
	 *
	 * @return la valeur de la propriete email
	 */
	public Optional<String> getEmail() {
		return Optional.ofNullable(getTo(true).getEmail());
	}
	
	
	/**
	 * Affecte la propriete email.
	 *
	 * @param email la valeur a affecter.
	 */
	public void setEmail(String email) {
		getTo(false).setEmail(email);
	}
	
	
	
	public boolean isNew() {
		return _to.isNew();
	}
	
	public void setNew(boolean _new) {
		_to.setNew(_new);
	}
	
	/**
	 * Copie une entité vers l'objet courant.
	 * Les blobs sont copiés mais pas les attributs clés.
	 * @param to L'entité que l'on veut copier vers l'objet courant
	 */
	public void copyFrom(ClientDefault to) {
		setNom(to.getNom());
		setPrenom(to.getPrenom());
		setTelephone(to.getTelephone().orElse(null));
		setAdresse(to.getAdresse().orElse(null));
		setCodePostal(to.getCodePostal().orElse(null));
		setVille(to.getVille().orElse(null));
		setBirthday(to.getBirthday().orElse(null));
		setEmail(to.getEmail().orElse(null));
	}
	
	/**
	 * Retourne une copie du biz, prête à être enregistrée en BD.
	 */
	public Client getCopy() {
		Client copy = Client.create();
		copy.copyFrom(this);
		return copy;
	}
	
	
}
