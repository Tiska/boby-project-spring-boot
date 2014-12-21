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

import persistence.beans.dao.IPrestationDao;
import persistence.beans.dao.IPrestationTo;


/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public abstract class PrestationDefault {
	
	static final Logger logger = Logger.getLogger(PrestationDefault.class);
	
	protected PrestationDefault() {
	}
	protected IPrestationTo _to = null;
	protected static Optional<Prestation> create(IPrestationTo to) {
		if (to==null) {
			return Optional.empty();
		}
		Prestation retour = new Prestation();
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
	
	private static IPrestationDao _dao = null;
	protected static IPrestationDao getDao() {
		if (_dao==null) {
			_dao = getGeneratorRuntime().getImplementation(IPrestationDao.class);
		}
		return _dao;
	}
	
	public static Observable<Optional<Prestation>> getById(long id) {
		return getPrestation(id);
	}
	
	
	public static Observable<Optional<Prestation>> getPrestation(long id) {
		return getDao().getById(id).map(to -> Prestation.create(to));
	}
	
	public Observable<Void> delete() {
		return Observable
		.create((OnSubscribe<Void>) subscriber -> {
			getDao().delete(_to).subscribe();
			if (!subscriber.isUnsubscribed()) {
				subscriber.onNext(null);
				subscriber.onCompleted();
			}
		})
		.observeOn(getGeneratorRuntime().getObserveOnScheduler())
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler());
	}
	
	public Observable<Void> save() {
		return Observable
		.create((OnSubscribe<Void>) subscriber -> {
			getDao().save(_to).subscribe();
			if (!subscriber.isUnsubscribed()) {
				subscriber.onNext(null);
				subscriber.onCompleted();
			}
		})
		.observeOn(getGeneratorRuntime().getObserveOnScheduler())
		.subscribeOn(getGeneratorRuntime().getSubscribeOnScheduler());
	}
	
	public static Prestation create() {
		Prestation retour = create(getDao().create()).get();
		retour.init();
		return retour;
	}
	
	/**
	 * Permet d'initialiser un bean à sa création, lors de l'appel à create() en static.<br>
	 * A surcharger si besoin.
	 */
	protected void init() {
	}
	
	public static class PrestationLazyListLoader extends LazyListListLoader<Prestation, IPrestationTo>{
		public PrestationLazyListLoader(List<IPrestationTo> source) {
			super(source);
		}
		
		@Override
		public Prestation adapt(IPrestationTo to) {
			return Prestation.create(to).get();
		}
	}
	
	/**
	 * Transforme une liste de To en une liste d'objets business en autorisant l'appel à toArray()
	 */
	protected static List<Prestation> toBizList(List<persistence.beans.dao.IPrestationTo> source) {
		return new LazyList<Prestation>(new PrestationLazyListLoader(source), true);
	}
	
	public static Observable<List<Prestation>> getList() {
		return getDao().getList().map((List<IPrestationTo> tos) -> Prestation.toBizList(tos));
	}
	
	/**
	 * Getter lie a l'index presta_categ.
	 * REMOTE
	 * @return persistence.beans.biz.Prestationcategorie
	 */
	
	public Observable<persistence.beans.biz.Prestationcategorie> getPrestationCateg() {
		return persistence.beans.biz.Prestationcategorie.getPrestationcategorie(getTo(false).getIdPrestationCateg()).map(o -> {return o.get();});
	}
	
	
	/**
	 * Getter lie a l'index presta_categ.
	 * REMOTE
	 * @param idPrestationCateg
	 * @return Observable<List<Prestation>>
	 */
	public static Observable<List<Prestation>> getPrestationListParIdPrestationCateg(long idPrestationCateg) {
		return getDao().getPrestationListParIdPrestationCateg(idPrestationCateg).map((List<IPrestationTo> tos) -> Prestation.toBizList(tos));
	}
	
	
	private boolean isCopy = false;
	private IPrestationTo getTo(boolean read) {
		if (isCopy || _to.isNew() || read) {
			return _to;
		}
		IPrestationTo copy = getDao().create();
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
	 * Obtenir la valeur de la propriete libelle.
	 *
	 * @return la valeur de la propriete libelle
	 */
	public String getLibelle() {
		return getTo(true).getLibelle();
	}
	
	
	/**
	 * Affecte la propriete libelle.
	 *
	 * @param libelle la valeur a affecter.
	 */
	public void setLibelle(String libelle) {
		getTo(false).setLibelle(libelle);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete prix.
	 *
	 * @return la valeur de la propriete prix
	 */
	public int getPrix() {
		return getTo(true).getPrix();
	}
	
	
	/**
	 * Affecte la propriete prix.
	 *
	 * @param prix la valeur a affecter.
	 */
	public void setPrix(int prix) {
		getTo(false).setPrix(prix);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete duree.
	 *
	 * @return la valeur de la propriete duree
	 */
	public int getDuree() {
		return getTo(true).getDuree();
	}
	
	
	/**
	 * Affecte la propriete duree.
	 *
	 * @param duree la valeur a affecter.
	 */
	public void setDuree(int duree) {
		getTo(false).setDuree(duree);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete obsolete.
	 *
	 * @return la valeur de la propriete obsolete
	 */
	public boolean getObsolete() {
		return getTo(true).getObsolete();
	}
	
	
	/**
	 * Affecte la propriete obsolete.
	 *
	 * @param obsolete la valeur a affecter.
	 */
	public void setObsolete(boolean obsolete) {
		getTo(false).setObsolete(obsolete);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete idPrestationCateg.
	 *
	 * @return la valeur de la propriete idPrestationCateg
	 */
	public long getIdPrestationCateg() {
		return getTo(true).getIdPrestationCateg();
	}
	
	
	/**
	 * Affecte la propriete idPrestationCateg.
	 *
	 * @param idPrestationCateg la valeur a affecter.
	 */
	public void setIdPrestationCateg(long idPrestationCateg) {
		getTo(false).setIdPrestationCateg(idPrestationCateg);
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
	public void copyFrom(PrestationDefault to) {
		setLibelle(to.getLibelle());
		setPrix(to.getPrix());
		setDuree(to.getDuree());
		setObsolete(to.getObsolete());
		setIdPrestationCateg(to.getIdPrestationCateg());
	}
	
	/**
	 * Retourne une copie du biz, prête à être enregistrée en BD.
	 */
	public Prestation getCopy() {
		Prestation copy = Prestation.create();
		copy.copyFrom(this);
		return copy;
	}
	
	
}
