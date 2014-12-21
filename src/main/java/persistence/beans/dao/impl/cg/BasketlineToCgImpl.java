package persistence.beans.dao.impl.cg;

import com.cardiweb.generator.persistence.runtimev3.annotations.DBTableInfos;
import com.cardiweb.generator.persistence.runtimev3.annotations.Constraint;
import com.cardiweb.generator.persistence.runtimev3.annotations.DBFieldInfos;
import com.cardiweb.generator.persistence.runtimev3.annotations.ForeignKey;


/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
@DBTableInfos(name="basketline",daoClass=BasketlineDaoCgImpl.class)
public class BasketlineToCgImpl implements persistence.beans.dao.IBasketlineTo, java.io.Serializable {
	
	/**
	 * serialVersionUID genere d'apres le nom de la classe
	 */
	private static final long serialVersionUID = 4804L;
	
	private transient BasketlineDaoCgImpl _dao=null;
	protected BasketlineDaoCgImpl getDao() {
		if (_dao==null) {
			_dao = (BasketlineDaoCgImpl)persistence.GeneratorRuntime.getGeneratorRuntime().getImplementation(persistence.beans.dao.IBasketlineDao.class);
		}
		return _dao;
	}
	
	private boolean _new = true;
	public boolean isNew() {
		return _new;
	}
	public void setNew(boolean b) {
		_new=b;
	}
	public boolean getNew() {
		return _new;
	}
	
	private String _cacheKey = null;
	/**
	 * Retourne une clee unique pour l'objet.
	 * @return une clee unique pour l'objet
	 */
	public String getCacheKey() {
		if (_cacheKey==null) {
			_cacheKey=getDao().getCacheKey(_id);
		}
		return _cacheKey;
	}
	
	/**
	 * Appele automatiquement a chaque sauvegarde ou lors de la suppression de l'objet.
	 * Par defaut, ne fait rien.
	 */
	public void clearLocalCache() {
	}
	
	/**
	 * @see java.lang.Object#equals(Object obj)
	 */
	@Override
	public boolean equals(Object obj) {
		if(this.isNew()){
			return super.equals(obj);
		}
		return (obj!=null) && obj.getClass()==getClass() && ((persistence.beans.dao.impl.cg.BasketlineToCgImpl)obj).getCacheKey().equals(getCacheKey());
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getCacheKey().hashCode();
	}
	
	private long _id = -1;
	/**
	 * Obtenir la valeur de la propriete id.
	 *
	 * @return la valeur de la propriete id
	 */
	
	@DBFieldInfos(name="ID")
	@Constraint(nullable=false,primary=true,primaryOrder=0,unique=true,fieldOrder=1)
	public long getId() {
		return _id;
	}
	/**
	 * Affecte la propriete id.
	 *
	 * @param id la valeur a affecter.
	 */
	public void setId(long id) {
		_id=id;
	}
	private java.lang.Long _idPrestation = null;
	/**
	 * Obtenir la valeur de la propriete idPrestation.
	 *
	 * @return la valeur de la propriete idPrestation
	 */
	
	@DBFieldInfos(name="ID_PRESTATION")
	@Constraint(nullable=true,primary=false,unique=false,fieldOrder=2)
	@ForeignKey(name="basketlineIdPrestationToPrestationId", referenceTo=persistence.beans.dao.IPrestationTo.class, referenceDao=persistence.beans.dao.IPrestationDao.class, referenceListMethod="getList", referenceObjectMethod="getPrestation", referenceProperty="id")
	public java.lang.Long getIdPrestation() {
		return _idPrestation;
	}
	/**
	 * Affecte la propriete idPrestation.
	 *
	 * @param idPrestation la valeur a affecter.
	 */
	public void setIdPrestation(java.lang.Long idPrestation) {
		_idPrestation=idPrestation;
	}
	private java.lang.Long _idProduit = null;
	/**
	 * Obtenir la valeur de la propriete idProduit.
	 *
	 * @return la valeur de la propriete idProduit
	 */
	
	@DBFieldInfos(name="ID_PRODUIT")
	@Constraint(nullable=true,primary=false,unique=false,fieldOrder=3)
	@ForeignKey(name="basketlineIdProduitToProduitId", referenceTo=persistence.beans.dao.IProduitTo.class, referenceDao=persistence.beans.dao.IProduitDao.class, referenceListMethod="getList", referenceObjectMethod="getProduit", referenceProperty="id")
	public java.lang.Long getIdProduit() {
		return _idProduit;
	}
	/**
	 * Affecte la propriete idProduit.
	 *
	 * @param idProduit la valeur a affecter.
	 */
	public void setIdProduit(java.lang.Long idProduit) {
		_idProduit=idProduit;
	}
	private int _prixAvecReduction = -1;
	/**
	 * Obtenir la valeur de la propriete prixAvecReduction.
	 *
	 * @return la valeur de la propriete prixAvecReduction
	 */
	
	@DBFieldInfos(name="PRIX_AVEC_REDUCTION")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=4)
	public int getPrixAvecReduction() {
		return _prixAvecReduction;
	}
	/**
	 * Affecte la propriete prixAvecReduction.
	 *
	 * @param prixAvecReduction la valeur a affecter.
	 */
	public void setPrixAvecReduction(int prixAvecReduction) {
		_prixAvecReduction=prixAvecReduction;
	}
	private int _quantite = -1;
	/**
	 * Obtenir la valeur de la propriete quantite.
	 *
	 * @return la valeur de la propriete quantite
	 */
	
	@DBFieldInfos(name="QUANTITE")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=5)
	public int getQuantite() {
		return _quantite;
	}
	/**
	 * Affecte la propriete quantite.
	 *
	 * @param quantite la valeur a affecter.
	 */
	public void setQuantite(int quantite) {
		_quantite=quantite;
	}
	private java.lang.Integer _reduction = null;
	/**
	 * Obtenir la valeur de la propriete reduction.
	 *
	 * @return la valeur de la propriete reduction
	 */
	
	@DBFieldInfos(name="REDUCTION")
	@Constraint(nullable=true,primary=false,unique=false,fieldOrder=6)
	public java.lang.Integer getReduction() {
		return _reduction;
	}
	/**
	 * Affecte la propriete reduction.
	 *
	 * @param reduction la valeur a affecter.
	 */
	public void setReduction(java.lang.Integer reduction) {
		_reduction=reduction;
	}
	private java.lang.Integer _typeDeReduction = null;
	/**
	 * Obtenir la valeur de la propriete typeDeReduction.
	 *
	 * @return la valeur de la propriete typeDeReduction
	 */
	
	@DBFieldInfos(name="TYPE_DE_REDUCTION")
	@Constraint(nullable=true,primary=false,unique=false,fieldOrder=7)
	public java.lang.Integer getTypeDeReduction() {
		return _typeDeReduction;
	}
	/**
	 * Affecte la propriete typeDeReduction.
	 *
	 * @param typeDeReduction la valeur a affecter.
	 */
	public void setTypeDeReduction(java.lang.Integer typeDeReduction) {
		_typeDeReduction=typeDeReduction;
	}
	private long _idBasket = -1;
	/**
	 * Obtenir la valeur de la propriete idBasket.
	 *
	 * @return la valeur de la propriete idBasket
	 */
	
	@DBFieldInfos(name="ID_BASKET")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=8)
	@ForeignKey(name="basketlineIdBasketToBasketId", referenceTo=persistence.beans.dao.IBasketTo.class, referenceDao=persistence.beans.dao.IBasketDao.class, referenceListMethod="getList", referenceObjectMethod="getBasket", referenceProperty="id")
	public long getIdBasket() {
		return _idBasket;
	}
	/**
	 * Affecte la propriete idBasket.
	 *
	 * @param idBasket la valeur a affecter.
	 */
	public void setIdBasket(long idBasket) {
		_idBasket=idBasket;
	}
	
}
