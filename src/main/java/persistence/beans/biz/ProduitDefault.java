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

import persistence.beans.dao.IProduitDao;
import persistence.beans.dao.IProduitTo;


/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public abstract class ProduitDefault {
	
	static final Logger logger = Logger.getLogger(ProduitDefault.class);
	
	protected ProduitDefault() {
	}
	protected IProduitTo _to = null;
	protected static Optional<Produit> create(IProduitTo to) {
		if (to==null) {
			return Optional.empty();
		}
		Produit retour = new Produit();
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
	
	private static IProduitDao _dao = null;
	protected static IProduitDao getDao() {
		if (_dao==null) {
			_dao = getGeneratorRuntime().getImplementation(IProduitDao.class);
		}
		return _dao;
	}
	
	public static Observable<Optional<Produit>> getById(long id) {
		return getProduit(id);
	}
	
	
	public static Observable<Optional<Produit>> getProduit(long id) {
		return getDao().getById(id).map(to -> Produit.create(to));
	}
	
	public Observable<Void> delete() {
		return getDao().delete(_to);
	}
	
	public Observable<Void> save() {
		return getDao().save(_to);
	}
	
	public static Produit create() {
		Produit retour = create(getDao().create()).get();
		retour.init();
		return retour;
	}
	
	/**
	 * Permet d'initialiser un bean à sa création, lors de l'appel à create() en static.<br>
	 * A surcharger si besoin.
	 */
	protected void init() {
	}
	
	public static class ProduitLazyListLoader extends LazyListListLoader<Produit, IProduitTo>{
		public ProduitLazyListLoader(List<IProduitTo> source) {
			super(source);
		}
		
		@Override
		public Produit adapt(IProduitTo to) {
			return Produit.create(to).get();
		}
	}
	
	/**
	 * Transforme une liste de To en une liste d'objets business en autorisant l'appel à toArray()
	 */
	protected static List<Produit> toBizList(List<persistence.beans.dao.IProduitTo> source) {
		return new LazyList<Produit>(new ProduitLazyListLoader(source), true);
	}
	
	public static Observable<List<Produit>> getList() {
		return getDao().getList().map((List<IProduitTo> tos) -> Produit.toBizList(tos));
	}
	
	/**
	 * Getter lie a l'index produit_categ.
	 * REMOTE
	 * @return persistence.beans.biz.Produitcategorie
	 */
	
	public Observable<persistence.beans.biz.Produitcategorie> getProduitCateg() {
		return persistence.beans.biz.Produitcategorie.getProduitcategorie(getTo(false).getIdProduitCateg()).map(o -> {return o.get();});
	}
	
	
	/**
	 * Getter lie a l'index produit_categ.
	 * REMOTE
	 * @param idProduitCateg
	 * @return Observable<List<Produit>>
	 */
	public static Observable<List<Produit>> getProduitListParIdProduitCateg(long idProduitCateg) {
		return getDao().getProduitListParIdProduitCateg(idProduitCateg).map((List<IProduitTo> tos) -> Produit.toBizList(tos));
	}
	
	
	private boolean isCopy = false;
	private IProduitTo getTo(boolean read) {
		if (isCopy || _to.isNew() || read) {
			return _to;
		}
		IProduitTo copy = getDao().create();
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
	 * Obtenir la valeur de la propriete stock.
	 *
	 * @return la valeur de la propriete stock
	 */
	public int getStock() {
		return getTo(true).getStock();
	}
	
	
	/**
	 * Affecte la propriete stock.
	 *
	 * @param stock la valeur a affecter.
	 */
	public void setStock(int stock) {
		getTo(false).setStock(stock);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete prixAchat.
	 *
	 * @return la valeur de la propriete prixAchat
	 */
	public int getPrixAchat() {
		return getTo(true).getPrixAchat();
	}
	
	
	/**
	 * Affecte la propriete prixAchat.
	 *
	 * @param prixAchat la valeur a affecter.
	 */
	public void setPrixAchat(int prixAchat) {
		getTo(false).setPrixAchat(prixAchat);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete prixVenteCalcule.
	 *
	 * @return la valeur de la propriete prixVenteCalcule
	 */
	public int getPrixVenteCalcule() {
		return getTo(true).getPrixVenteCalcule();
	}
	
	
	/**
	 * Affecte la propriete prixVenteCalcule.
	 *
	 * @param prixVenteCalcule la valeur a affecter.
	 */
	public void setPrixVenteCalcule(int prixVenteCalcule) {
		getTo(false).setPrixVenteCalcule(prixVenteCalcule);
	}
	
	
	
	/**
	 * Obtenir la valeur de la propriete coefficiant.
	 *
	 * @return la valeur de la propriete coefficiant
	 */
	public int getCoefficiant() {
		return getTo(true).getCoefficiant();
	}
	
	
	/**
	 * Affecte la propriete coefficiant.
	 *
	 * @param coefficiant la valeur a affecter.
	 */
	public void setCoefficiant(int coefficiant) {
		getTo(false).setCoefficiant(coefficiant);
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
	 * Obtenir la valeur de la propriete idProduitCateg.
	 *
	 * @return la valeur de la propriete idProduitCateg
	 */
	public long getIdProduitCateg() {
		return getTo(true).getIdProduitCateg();
	}
	
	
	/**
	 * Affecte la propriete idProduitCateg.
	 *
	 * @param idProduitCateg la valeur a affecter.
	 */
	public void setIdProduitCateg(long idProduitCateg) {
		getTo(false).setIdProduitCateg(idProduitCateg);
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
	public void copyFrom(ProduitDefault to) {
		setLibelle(to.getLibelle());
		setStock(to.getStock());
		setPrixAchat(to.getPrixAchat());
		setPrixVenteCalcule(to.getPrixVenteCalcule());
		setCoefficiant(to.getCoefficiant());
		setObsolete(to.getObsolete());
		setIdProduitCateg(to.getIdProduitCateg());
	}
	
	/**
	 * Retourne une copie du biz, prête à être enregistrée en BD.
	 */
	public Produit getCopy() {
		Produit copy = Produit.create();
		copy.copyFrom(this);
		return copy;
	}
	
	
}
