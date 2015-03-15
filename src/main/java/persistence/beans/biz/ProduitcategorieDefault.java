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

import persistence.beans.dao.IProduitcategorieDao;
import persistence.beans.dao.IProduitcategorieTo;


/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public abstract class ProduitcategorieDefault {
	
	static final Logger logger = Logger.getLogger(ProduitcategorieDefault.class);
	
	protected ProduitcategorieDefault() {
	}
	protected IProduitcategorieTo _to = null;
	protected static Optional<Produitcategorie> create(IProduitcategorieTo to) {
		if (to==null) {
			return Optional.empty();
		}
		Produitcategorie retour = new Produitcategorie();
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
	
	private static IProduitcategorieDao _dao = null;
	protected static IProduitcategorieDao getDao() {
		if (_dao==null) {
			_dao = getGeneratorRuntime().getImplementation(IProduitcategorieDao.class);
		}
		return _dao;
	}
	
	public static Observable<Optional<Produitcategorie>> getById(long id) {
		return getProduitcategorie(id);
	}
	
	
	public static Observable<Optional<Produitcategorie>> getProduitcategorie(long id) {
		return getDao().getById(id).map(to -> Produitcategorie.create(to));
	}
	
	public Observable<Void> delete() {
		return getDao().delete(_to);
	}
	
	public Observable<Void> save() {
		return getDao().save(_to);
	}
	
	public static Produitcategorie create() {
		Produitcategorie retour = create(getDao().create()).get();
		retour.init();
		return retour;
	}
	
	/**
	 * Permet d'initialiser un bean à sa création, lors de l'appel à create() en static.<br>
	 * A surcharger si besoin.
	 */
	protected void init() {
	}
	
	public static class ProduitcategorieLazyListLoader extends LazyListListLoader<Produitcategorie, IProduitcategorieTo>{
		public ProduitcategorieLazyListLoader(List<IProduitcategorieTo> source) {
			super(source);
		}
		
		@Override
		public Produitcategorie adapt(IProduitcategorieTo to) {
			return Produitcategorie.create(to).get();
		}
	}
	
	/**
	 * Transforme une liste de To en une liste d'objets business en autorisant l'appel à toArray()
	 */
	protected static List<Produitcategorie> toBizList(List<persistence.beans.dao.IProduitcategorieTo> source) {
		return new LazyList<Produitcategorie>(new ProduitcategorieLazyListLoader(source), true);
	}
	
	public static Observable<List<Produitcategorie>> getList() {
		return getDao().getList().map((List<IProduitcategorieTo> tos) -> Produitcategorie.toBizList(tos));
	}
	
	
	private boolean isCopy = false;
	private IProduitcategorieTo getTo(boolean read) {
		if (isCopy || _to.isNew() || read) {
			return _to;
		}
		IProduitcategorieTo copy = getDao().create();
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
	public void copyFrom(ProduitcategorieDefault to) {
		setLibelle(to.getLibelle());
	}
	
	/**
	 * Retourne une copie du biz, prête à être enregistrée en BD.
	 */
	public Produitcategorie getCopy() {
		Produitcategorie copy = Produitcategorie.create();
		copy.copyFrom(this);
		return copy;
	}
	
	
}
