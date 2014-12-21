package persistence.beans.dao.impl.cg;

import com.cardiweb.generator.persistence.runtimev3.annotations.DBTableInfos;
import com.cardiweb.generator.persistence.runtimev3.annotations.Constraint;
import com.cardiweb.generator.persistence.runtimev3.annotations.DBFieldInfos;



/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
@DBTableInfos(name="produitcategorie",daoClass=ProduitcategorieDaoCgImpl.class)
public class ProduitcategorieToCgImpl implements persistence.beans.dao.IProduitcategorieTo, java.io.Serializable {
	
	/**
	 * serialVersionUID genere d'apres le nom de la classe
	 */
	private static final long serialVersionUID = 12780L;
	
	private transient ProduitcategorieDaoCgImpl _dao=null;
	protected ProduitcategorieDaoCgImpl getDao() {
		if (_dao==null) {
			_dao = (ProduitcategorieDaoCgImpl)persistence.GeneratorRuntime.getGeneratorRuntime().getImplementation(persistence.beans.dao.IProduitcategorieDao.class);
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
		return (obj!=null) && obj.getClass()==getClass() && ((persistence.beans.dao.impl.cg.ProduitcategorieToCgImpl)obj).getCacheKey().equals(getCacheKey());
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
	
}
