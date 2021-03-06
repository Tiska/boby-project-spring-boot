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

import persistence.beans.dao.IBasketDao;
import persistence.beans.dao.IBasketTo;


/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public abstract class BasketDefault {
	
	static final Logger logger = Logger.getLogger(BasketDefault.class);
	
	protected BasketDefault() {
	}
	protected IBasketTo _to = null;
	protected static Optional<Basket> create(IBasketTo to) {
		if (to==null) {
			return Optional.empty();
		}
		Basket retour = new Basket();
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
	
	private static IBasketDao _dao = null;
	protected static IBasketDao getDao() {
		if (_dao==null) {
			_dao = getGeneratorRuntime().getImplementation(IBasketDao.class);
		}
		return _dao;
	}
	
	public static Observable<Optional<Basket>> getById(long id) {
		return getBasket(id);
	}
	
	
	public static Observable<Optional<Basket>> getBasket(long id) {
		return getDao().getById(id).map(to -> Basket.create(to));
	}
	
	public Observable<Void> delete() {
		return getDao().delete(_to);
	}
	
	public Observable<Void> save() {
		return getDao().save(_to);
	}
	
	public static Basket create() {
		Basket retour = create(getDao().create()).get();
		retour.init();
		return retour;
	}
	
	/**
	 * Permet d'initialiser un bean à sa création, lors de l'appel à create() en static.<br>
	 * A surcharger si besoin.
	 */
	protected void init() {
	}
	
	public static class BasketLazyListLoader extends LazyListListLoader<Basket, IBasketTo>{
		public BasketLazyListLoader(List<IBasketTo> source) {
			super(source);
		}
		
		@Override
		public Basket adapt(IBasketTo to) {
			return Basket.create(to).get();
		}
	}
	
	/**
	 * Transforme une liste de To en une liste d'objets business en autorisant l'appel à toArray()
	 */
	protected static List<Basket> toBizList(List<persistence.beans.dao.IBasketTo> source) {
		return new LazyList<Basket>(new BasketLazyListLoader(source), true);
	}
	
	public static Observable<List<Basket>> getList() {
		return getDao().getList().map((List<IBasketTo> tos) -> Basket.toBizList(tos));
	}
	
	/**
	 * Getter lie a l'index client.
	 * REMOTE
	 * @return persistence.beans.biz.Client
	 */
	
	public Observable<Optional<persistence.beans.biz.Client>> getClient() {
		if(getTo(false).getIdClient() == null){
			return Observable.just(Optional.empty());
		}
		return persistence.beans.biz.Client.getClient(getTo(false).getIdClient());
	}
	
	
	/**
	 * Getter lie a l'index client.
	 * REMOTE
	 * @param idClient
	 * @return Observable<List<Basket>>
	 */
	public static Observable<List<Basket>> getBasketListParIdClient(java.lang.Long idClient) {
		return getDao().getBasketListParIdClient(idClient).map((List<IBasketTo> tos) -> Basket.toBizList(tos));
	}
	
	/**
	 * Getter lie a l'index CLIENT_DATE_PAIEMENT.
	 * @param datePaiement la valeur de la colonne datePaiement
	 * @param idClient la valeur de la colonne idClient
	 * @return La liste des objets correspondant aux criteres.
	 */
	public static Observable<java.util.List<persistence.beans.biz.Basket>> getBasketListParDatePaiementEtIdClient(java.sql.Timestamp datePaiement, java.lang.Long idClient) {
		return getDao().getBasketListParDatePaiementEtIdClient(datePaiement, idClient).map((List<IBasketTo> tos) -> Basket.toBizList(tos));
	}
	
	private boolean isCopy = false;
	private IBasketTo getTo(boolean read) {
		if (isCopy || _to.isNew() || read) {
			return _to;
		}
		IBasketTo copy = getDao().create();
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
	 * Obtenir la valeur de la propriete total.
	 *
	 * @return la valeur de la propriete total
	 */
	public int getTotal() {
		return getTo(true).getTotal();
	}
	
	
	/**
	 * Affecte la propriete total.
	 *
	 * @param total la valeur a affecter.
	 */
	public void setTotal(int total) {
		getTo(false).setTotal(total);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete typePayment.
	 *
	 * @return la valeur de la propriete typePayment
	 */
	public int getTypePayment() {
		return getTo(true).getTypePayment();
	}
	
	
	/**
	 * Affecte la propriete typePayment.
	 *
	 * @param typePayment la valeur a affecter.
	 */
	public void setTypePayment(int typePayment) {
		getTo(false).setTypePayment(typePayment);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete date.
	 *
	 * @return la valeur de la propriete date
	 */
	public java.time.LocalDateTime getDate() {
		java.sql.Timestamp timestamp = getTo(false).getDate();
		return java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(timestamp.getTime()), java.time.ZoneId.systemDefault());
	}
	
	/**
	 * Affecte la propriete date.
	 *
	 * @param date la valeur a affecter.
	 */
	public void setDate(java.time.LocalDateTime date) {
		if (date == null) {
			getTo(false).setDate(null);
		} else {
			getTo(false).setDate(new java.sql.Timestamp(date.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli()));
		}
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete idClient.
	 *
	 * @return la valeur de la propriete idClient
	 */
	public Optional<Long> getIdClient() {
		return Optional.ofNullable(getTo(true).getIdClient());
	}
	
	
	/**
	 * Affecte la propriete idClient.
	 *
	 * @param idClient la valeur a affecter.
	 */
	public void setIdClient(Long idClient) {
		getTo(false).setIdClient(idClient);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete datePaiement.
	 *
	 * @return la valeur de la propriete datePaiement
	 */
	public Optional<java.time.LocalDateTime> getDatePaiement() {
		java.sql.Timestamp timestamp = getTo(false).getDatePaiement();
		if (timestamp == null) {
			return Optional.empty();
		}
		return Optional.of(java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(timestamp.getTime()), java.time.ZoneId.systemDefault()));
	}
	
	/**
	 * Affecte la propriete datePaiement.
	 *
	 * @param datePaiement la valeur a affecter.
	 */
	public void setDatePaiement(java.time.LocalDateTime datePaiement) {
		if (datePaiement == null) {
			getTo(false).setDatePaiement(null);
		} else {
			getTo(false).setDatePaiement(new java.sql.Timestamp(datePaiement.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli()));
		}
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
	public void copyFrom(BasketDefault to) {
		setTotal(to.getTotal());
		setTypePayment(to.getTypePayment());
		setDate(to.getDate());
		setIdClient(to.getIdClient().orElse(null));
		setDatePaiement(to.getDatePaiement().orElse(null));
	}
	
	/**
	 * Retourne une copie du biz, prête à être enregistrée en BD.
	 */
	public Basket getCopy() {
		Basket copy = Basket.create();
		copy.copyFrom(this);
		return copy;
	}
	
	
}
