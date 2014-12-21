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
@DBTableInfos(name="produit",daoClass=ProduitDaoCgImpl.class)
public class ProduitToCgImpl implements persistence.beans.dao.IProduitTo, java.io.Serializable {
	
	/**
	 * serialVersionUID genere d'apres le nom de la classe
	 */
	private static final long serialVersionUID = 2325L;
	
	private transient ProduitDaoCgImpl _dao=null;
	protected ProduitDaoCgImpl getDao() {
		if (_dao==null) {
			_dao = (ProduitDaoCgImpl)persistence.GeneratorRuntime.getGeneratorRuntime().getImplementation(persistence.beans.dao.IProduitDao.class);
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
		return (obj!=null) && obj.getClass()==getClass() && ((persistence.beans.dao.impl.cg.ProduitToCgImpl)obj).getCacheKey().equals(getCacheKey());
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
	private java.lang.String _libelle = null;
	/**
	 * Obtenir la valeur de la propriete libelle.
	 *
	 * @return la valeur de la propriete libelle
	 */
	
	@DBFieldInfos(name="LIBELLE")
	@Constraint(nullable=false,maxlength=100,primary=false,unique=false,fieldOrder=2)
	public java.lang.String getLibelle() {
		return _libelle;
	}
	/**
	 * Affecte la propriete libelle.
	 *
	 * @param libelle la valeur a affecter.
	 * @throws IllegalArgumentException si la valeur depasse libelle.length() caracteres.
	 */
	public void setLibelle(java.lang.String libelle) {
		if (libelle!=null && libelle.length()>100) {
			throw new IllegalArgumentException("Le champ 'libelle' ne doit pas faire plus de 100 caracteres. Impossible de l'affecter avec \""+libelle+"\" ("+libelle.length()+" caracteres).");
		}
		if (libelle==null) {
			throw new IllegalArgumentException("Le champ 'libelle' ne peut être null.");
		}
		_libelle=libelle;
	}
	private int _stock = -1;
	/**
	 * Obtenir la valeur de la propriete stock.
	 *
	 * @return la valeur de la propriete stock
	 */
	
	@DBFieldInfos(name="STOCK")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=3)
	public int getStock() {
		return _stock;
	}
	/**
	 * Affecte la propriete stock.
	 *
	 * @param stock la valeur a affecter.
	 */
	public void setStock(int stock) {
		_stock=stock;
	}
	private int _prixAchat = -1;
	/**
	 * Obtenir la valeur de la propriete prixAchat.
	 *
	 * @return la valeur de la propriete prixAchat
	 */
	
	@DBFieldInfos(name="PRIX_ACHAT")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=4)
	public int getPrixAchat() {
		return _prixAchat;
	}
	/**
	 * Affecte la propriete prixAchat.
	 *
	 * @param prixAchat la valeur a affecter.
	 */
	public void setPrixAchat(int prixAchat) {
		_prixAchat=prixAchat;
	}
	private int _prixVenteCalcule = -1;
	/**
	 * Obtenir la valeur de la propriete prixVenteCalcule.
	 *
	 * @return la valeur de la propriete prixVenteCalcule
	 */
	
	@DBFieldInfos(name="PRIX_VENTE_CALCULE")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=5)
	public int getPrixVenteCalcule() {
		return _prixVenteCalcule;
	}
	/**
	 * Affecte la propriete prixVenteCalcule.
	 *
	 * @param prixVenteCalcule la valeur a affecter.
	 */
	public void setPrixVenteCalcule(int prixVenteCalcule) {
		_prixVenteCalcule=prixVenteCalcule;
	}
	private int _coefficiant = -1;
	/**
	 * Obtenir la valeur de la propriete coefficiant.
	 *
	 * @return la valeur de la propriete coefficiant
	 */
	
	@DBFieldInfos(name="COEFFICIANT")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=6)
	public int getCoefficiant() {
		return _coefficiant;
	}
	/**
	 * Affecte la propriete coefficiant.
	 *
	 * @param coefficiant la valeur a affecter.
	 */
	public void setCoefficiant(int coefficiant) {
		_coefficiant=coefficiant;
	}
	private boolean _obsolete = false;
	/**
	 * Obtenir la valeur de la propriete obsolete.
	 *
	 * @return la valeur de la propriete obsolete
	 */
	
	@DBFieldInfos(name="OBSOLETE")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=7)
	public boolean getObsolete() {
		return _obsolete;
	}
	/**
	 * Affecte la propriete obsolete.
	 *
	 * @param obsolete la valeur a affecter.
	 */
	public void setObsolete(boolean obsolete) {
		_obsolete=obsolete;
	}
	private long _idProduitCateg = -1;
	/**
	 * Obtenir la valeur de la propriete idProduitCateg.
	 *
	 * @return la valeur de la propriete idProduitCateg
	 */
	
	@DBFieldInfos(name="ID_PRODUIT_CATEG")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=8)
	@ForeignKey(name="produitIdProduitCategToProduitcategorieId", referenceTo=persistence.beans.dao.IProduitcategorieTo.class, referenceDao=persistence.beans.dao.IProduitcategorieDao.class, referenceListMethod="getList", referenceObjectMethod="getProduitcategorie", referenceProperty="id")
	public long getIdProduitCateg() {
		return _idProduitCateg;
	}
	/**
	 * Affecte la propriete idProduitCateg.
	 *
	 * @param idProduitCateg la valeur a affecter.
	 */
	public void setIdProduitCateg(long idProduitCateg) {
		_idProduitCateg=idProduitCateg;
	}
	
}
