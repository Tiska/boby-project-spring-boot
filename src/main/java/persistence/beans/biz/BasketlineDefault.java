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

import persistence.beans.dao.IBasketlineDao;
import persistence.beans.dao.IBasketlineTo;


/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public abstract class BasketlineDefault {
	
	static final Logger logger = Logger.getLogger(BasketlineDefault.class);
	
	protected BasketlineDefault() {
	}
	protected IBasketlineTo _to = null;
	protected static Optional<Basketline> create(IBasketlineTo to) {
		if (to==null) {
			return Optional.empty();
		}
		Basketline retour = new Basketline();
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
	
	private static IBasketlineDao _dao = null;
	protected static IBasketlineDao getDao() {
		if (_dao==null) {
			_dao = getGeneratorRuntime().getImplementation(IBasketlineDao.class);
		}
		return _dao;
	}
	
	public static Observable<Optional<Basketline>> getById(long id) {
		return getBasketline(id);
	}
	
	
	public static Observable<Optional<Basketline>> getBasketline(long id) {
		return getDao().getById(id).map(to -> Basketline.create(to));
	}
	
	public Observable<Void> delete() {
		return getDao().delete(_to);
	}
	
	public Observable<Void> save() {
		return getDao().save(_to);
	}
	
	public static Basketline create() {
		Basketline retour = create(getDao().create()).get();
		retour.init();
		return retour;
	}
	
	/**
	 * Permet d'initialiser un bean à sa création, lors de l'appel à create() en static.<br>
	 * A surcharger si besoin.
	 */
	protected void init() {
	}
	
	public static class BasketlineLazyListLoader extends LazyListListLoader<Basketline, IBasketlineTo>{
		public BasketlineLazyListLoader(List<IBasketlineTo> source) {
			super(source);
		}
		
		@Override
		public Basketline adapt(IBasketlineTo to) {
			return Basketline.create(to).get();
		}
	}
	
	/**
	 * Transforme une liste de To en une liste d'objets business en autorisant l'appel à toArray()
	 */
	protected static List<Basketline> toBizList(List<persistence.beans.dao.IBasketlineTo> source) {
		return new LazyList<Basketline>(new BasketlineLazyListLoader(source), true);
	}
	
	public static Observable<List<Basketline>> getList() {
		return getDao().getList().map((List<IBasketlineTo> tos) -> Basketline.toBizList(tos));
	}
	
	/**
	 * Getter lie a l'index basket.
	 * REMOTE
	 * @return persistence.beans.biz.Basket
	 */
	
	public Observable<persistence.beans.biz.Basket> getBasket() {
		return persistence.beans.biz.Basket.getBasket(getTo(false).getIdBasket()).map(o -> {return o.get();});
	}
	
	
	/**
	 * Getter lie a l'index basket.
	 * REMOTE
	 * @param idBasket
	 * @return Observable<List<Basketline>>
	 */
	public static Observable<List<Basketline>> getBasketlineListParIdBasket(long idBasket) {
		return getDao().getBasketlineListParIdBasket(idBasket).map((List<IBasketlineTo> tos) -> Basketline.toBizList(tos));
	}
	
	/**
	 * Getter lie a l'index presta.
	 * REMOTE
	 * @return persistence.beans.biz.Prestation
	 */
	
	public Observable<Optional<persistence.beans.biz.Prestation>> getPrestation() {
		if(getTo(false).getIdPrestation() == null){
			return Observable.just(Optional.empty());
		}
		return persistence.beans.biz.Prestation.getPrestation(getTo(false).getIdPrestation());
	}
	
	
	/**
	 * Getter lie a l'index presta.
	 * REMOTE
	 * @param idPrestation
	 * @return Observable<List<Basketline>>
	 */
	public static Observable<List<Basketline>> getBasketlineListParIdPrestation(java.lang.Long idPrestation) {
		return getDao().getBasketlineListParIdPrestation(idPrestation).map((List<IBasketlineTo> tos) -> Basketline.toBizList(tos));
	}
	
	/**
	 * Getter lie a l'index produit.
	 * REMOTE
	 * @return persistence.beans.biz.Produit
	 */
	
	public Observable<Optional<persistence.beans.biz.Produit>> getProduit() {
		if(getTo(false).getIdProduit() == null){
			return Observable.just(Optional.empty());
		}
		return persistence.beans.biz.Produit.getProduit(getTo(false).getIdProduit());
	}
	
	
	/**
	 * Getter lie a l'index produit.
	 * REMOTE
	 * @param idProduit
	 * @return Observable<List<Basketline>>
	 */
	public static Observable<List<Basketline>> getBasketlineListParIdProduit(java.lang.Long idProduit) {
		return getDao().getBasketlineListParIdProduit(idProduit).map((List<IBasketlineTo> tos) -> Basketline.toBizList(tos));
	}
	
	
	private boolean isCopy = false;
	private IBasketlineTo getTo(boolean read) {
		if (isCopy || _to.isNew() || read) {
			return _to;
		}
		IBasketlineTo copy = getDao().create();
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
	 * Obtenir la valeur de la propriete idPrestation.
	 *
	 * @return la valeur de la propriete idPrestation
	 */
	public Optional<Long> getIdPrestation() {
		return Optional.ofNullable(getTo(true).getIdPrestation());
	}
	
	
	/**
	 * Affecte la propriete idPrestation.
	 *
	 * @param idPrestation la valeur a affecter.
	 */
	public void setIdPrestation(Long idPrestation) {
		getTo(false).setIdPrestation(idPrestation);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete idProduit.
	 *
	 * @return la valeur de la propriete idProduit
	 */
	public Optional<Long> getIdProduit() {
		return Optional.ofNullable(getTo(true).getIdProduit());
	}
	
	
	/**
	 * Affecte la propriete idProduit.
	 *
	 * @param idProduit la valeur a affecter.
	 */
	public void setIdProduit(Long idProduit) {
		getTo(false).setIdProduit(idProduit);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete prixAvecReduction.
	 *
	 * @return la valeur de la propriete prixAvecReduction
	 */
	public int getPrixAvecReduction() {
		return getTo(true).getPrixAvecReduction();
	}
	
	
	/**
	 * Affecte la propriete prixAvecReduction.
	 *
	 * @param prixAvecReduction la valeur a affecter.
	 */
	public void setPrixAvecReduction(int prixAvecReduction) {
		getTo(false).setPrixAvecReduction(prixAvecReduction);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete quantite.
	 *
	 * @return la valeur de la propriete quantite
	 */
	public int getQuantite() {
		return getTo(true).getQuantite();
	}
	
	
	/**
	 * Affecte la propriete quantite.
	 *
	 * @param quantite la valeur a affecter.
	 */
	public void setQuantite(int quantite) {
		getTo(false).setQuantite(quantite);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete reduction.
	 *
	 * @return la valeur de la propriete reduction
	 */
	public Optional<Integer> getReduction() {
		return Optional.ofNullable(getTo(true).getReduction());
	}
	
	
	/**
	 * Affecte la propriete reduction.
	 *
	 * @param reduction la valeur a affecter.
	 */
	public void setReduction(Integer reduction) {
		getTo(false).setReduction(reduction);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete typeDeReduction.
	 *
	 * @return la valeur de la propriete typeDeReduction
	 */
	public Optional<Integer> getTypeDeReduction() {
		return Optional.ofNullable(getTo(true).getTypeDeReduction());
	}
	
	
	/**
	 * Affecte la propriete typeDeReduction.
	 *
	 * @param typeDeReduction la valeur a affecter.
	 */
	public void setTypeDeReduction(Integer typeDeReduction) {
		getTo(false).setTypeDeReduction(typeDeReduction);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete idBasket.
	 *
	 * @return la valeur de la propriete idBasket
	 */
	public long getIdBasket() {
		return getTo(true).getIdBasket();
	}
	
	
	/**
	 * Affecte la propriete idBasket.
	 *
	 * @param idBasket la valeur a affecter.
	 */
	public void setIdBasket(long idBasket) {
		getTo(false).setIdBasket(idBasket);
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
	public void copyFrom(BasketlineDefault to) {
		setIdPrestation(to.getIdPrestation().orElse(null));
		setIdProduit(to.getIdProduit().orElse(null));
		setPrixAvecReduction(to.getPrixAvecReduction());
		setQuantite(to.getQuantite());
		setReduction(to.getReduction().orElse(null));
		setTypeDeReduction(to.getTypeDeReduction().orElse(null));
		setIdBasket(to.getIdBasket());
	}
	
	/**
	 * Retourne une copie du biz, prête à être enregistrée en BD.
	 */
	public Basketline getCopy() {
		Basketline copy = Basketline.create();
		copy.copyFrom(this);
		return copy;
	}
	
	
}
