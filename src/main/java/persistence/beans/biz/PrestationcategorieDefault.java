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

import persistence.beans.dao.IPrestationcategorieDao;
import persistence.beans.dao.IPrestationcategorieTo;


/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public abstract class PrestationcategorieDefault {
	
	static final Logger logger = Logger.getLogger(PrestationcategorieDefault.class);
	
	protected PrestationcategorieDefault() {
	}
	protected IPrestationcategorieTo _to = null;
	protected static Optional<Prestationcategorie> create(IPrestationcategorieTo to) {
		if (to==null) {
			return Optional.empty();
		}
		Prestationcategorie retour = new Prestationcategorie();
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
	
	private static IPrestationcategorieDao _dao = null;
	protected static IPrestationcategorieDao getDao() {
		if (_dao==null) {
			_dao = getGeneratorRuntime().getImplementation(IPrestationcategorieDao.class);
		}
		return _dao;
	}
	
	public static Observable<Optional<Prestationcategorie>> getById(long id) {
		return getPrestationcategorie(id);
	}
	
	
	public static Observable<Optional<Prestationcategorie>> getPrestationcategorie(long id) {
		return getDao().getById(id).map(to -> Prestationcategorie.create(to));
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
	
	public static Prestationcategorie create() {
		Prestationcategorie retour = create(getDao().create()).get();
		retour.init();
		return retour;
	}
	
	/**
	 * Permet d'initialiser un bean à sa création, lors de l'appel à create() en static.<br>
	 * A surcharger si besoin.
	 */
	protected void init() {
	}
	
	public static class PrestationcategorieLazyListLoader extends LazyListListLoader<Prestationcategorie, IPrestationcategorieTo>{
		public PrestationcategorieLazyListLoader(List<IPrestationcategorieTo> source) {
			super(source);
		}
		
		@Override
		public Prestationcategorie adapt(IPrestationcategorieTo to) {
			return Prestationcategorie.create(to).get();
		}
	}
	
	/**
	 * Transforme une liste de To en une liste d'objets business en autorisant l'appel à toArray()
	 */
	protected static List<Prestationcategorie> toBizList(List<persistence.beans.dao.IPrestationcategorieTo> source) {
		return new LazyList<Prestationcategorie>(new PrestationcategorieLazyListLoader(source), true);
	}
	
	public static Observable<List<Prestationcategorie>> getList() {
		return getDao().getList().map((List<IPrestationcategorieTo> tos) -> Prestationcategorie.toBizList(tos));
	}
	
	
	private boolean isCopy = false;
	private IPrestationcategorieTo getTo(boolean read) {
		if (isCopy || _to.isNew() || read) {
			return _to;
		}
		IPrestationcategorieTo copy = getDao().create();
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
	public void copyFrom(PrestationcategorieDefault to) {
		setLibelle(to.getLibelle());
	}
	
	/**
	 * Retourne une copie du biz, prête à être enregistrée en BD.
	 */
	public Prestationcategorie getCopy() {
		Prestationcategorie copy = Prestationcategorie.create();
		copy.copyFrom(this);
		return copy;
	}
	
	
}
