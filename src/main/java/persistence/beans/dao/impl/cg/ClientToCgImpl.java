package persistence.beans.dao.impl.cg;

import com.cardiweb.generator.persistence.runtimev3.annotations.DBTableInfos;
import com.cardiweb.generator.persistence.runtimev3.annotations.Constraint;
import com.cardiweb.generator.persistence.runtimev3.annotations.DBFieldInfos;



/**
 * Cette classe est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
@DBTableInfos(name="client",daoClass=ClientDaoCgImpl.class)
public class ClientToCgImpl implements persistence.beans.dao.IClientTo, java.io.Serializable {
	
	/**
	 * serialVersionUID genere d'apres le nom de la classe
	 */
	private static final long serialVersionUID = 1641L;
	
	private transient ClientDaoCgImpl _dao=null;
	protected ClientDaoCgImpl getDao() {
		if (_dao==null) {
			_dao = (ClientDaoCgImpl)persistence.GeneratorRuntime.getGeneratorRuntime().getImplementation(persistence.beans.dao.IClientDao.class);
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
		return (obj!=null) && obj.getClass()==getClass() && ((persistence.beans.dao.impl.cg.ClientToCgImpl)obj).getCacheKey().equals(getCacheKey());
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
	private java.lang.String _nom = null;
	/**
	 * Obtenir la valeur de la propriete nom.
	 *
	 * @return la valeur de la propriete nom
	 */
	
	@DBFieldInfos(name="NOM")
	@Constraint(nullable=false,maxlength=45,primary=false,unique=false,fieldOrder=2)
	public java.lang.String getNom() {
		return _nom;
	}
	/**
	 * Affecte la propriete nom.
	 *
	 * @param nom la valeur a affecter.
	 * @throws IllegalArgumentException si la valeur depasse nom.length() caracteres.
	 */
	public void setNom(java.lang.String nom) {
		if (nom!=null && nom.length()>45) {
			throw new IllegalArgumentException("Le champ 'nom' ne doit pas faire plus de 45 caracteres. Impossible de l'affecter avec \""+nom+"\" ("+nom.length()+" caracteres).");
		}
		if (nom==null) {
			throw new IllegalArgumentException("Le champ 'nom' ne peut être null.");
		}
		_nom=nom;
	}
	private java.lang.String _prenom = null;
	/**
	 * Obtenir la valeur de la propriete prenom.
	 *
	 * @return la valeur de la propriete prenom
	 */
	
	@DBFieldInfos(name="PRENOM")
	@Constraint(nullable=false,maxlength=45,primary=false,unique=false,fieldOrder=3)
	public java.lang.String getPrenom() {
		return _prenom;
	}
	/**
	 * Affecte la propriete prenom.
	 *
	 * @param prenom la valeur a affecter.
	 * @throws IllegalArgumentException si la valeur depasse prenom.length() caracteres.
	 */
	public void setPrenom(java.lang.String prenom) {
		if (prenom!=null && prenom.length()>45) {
			throw new IllegalArgumentException("Le champ 'prenom' ne doit pas faire plus de 45 caracteres. Impossible de l'affecter avec \""+prenom+"\" ("+prenom.length()+" caracteres).");
		}
		if (prenom==null) {
			throw new IllegalArgumentException("Le champ 'prenom' ne peut être null.");
		}
		_prenom=prenom;
	}
	private java.lang.Integer _telephone = null;
	/**
	 * Obtenir la valeur de la propriete telephone.
	 *
	 * @return la valeur de la propriete telephone
	 */
	
	@DBFieldInfos(name="TELEPHONE")
	@Constraint(nullable=true,primary=false,unique=false,fieldOrder=4)
	public java.lang.Integer getTelephone() {
		return _telephone;
	}
	/**
	 * Affecte la propriete telephone.
	 *
	 * @param telephone la valeur a affecter.
	 */
	public void setTelephone(java.lang.Integer telephone) {
		_telephone=telephone;
	}
	private java.lang.String _adresse = null;
	/**
	 * Obtenir la valeur de la propriete adresse.
	 *
	 * @return la valeur de la propriete adresse
	 */
	
	@DBFieldInfos(name="ADRESSE")
	@Constraint(nullable=true,maxlength=100,primary=false,unique=false,fieldOrder=5)
	public java.lang.String getAdresse() {
		return _adresse;
	}
	/**
	 * Affecte la propriete adresse.
	 *
	 * @param adresse la valeur a affecter.
	 * @throws IllegalArgumentException si la valeur depasse adresse.length() caracteres.
	 */
	public void setAdresse(java.lang.String adresse) {
		if (adresse!=null && adresse.length()>100) {
			throw new IllegalArgumentException("Le champ 'adresse' ne doit pas faire plus de 100 caracteres. Impossible de l'affecter avec \""+adresse+"\" ("+adresse.length()+" caracteres).");
		}
		_adresse=adresse;
	}
	private java.lang.String _codePostal = null;
	/**
	 * Obtenir la valeur de la propriete codePostal.
	 *
	 * @return la valeur de la propriete codePostal
	 */
	
	@DBFieldInfos(name="CODE_POSTAL")
	@Constraint(nullable=true,maxlength=10,primary=false,unique=false,fieldOrder=6)
	public java.lang.String getCodePostal() {
		return _codePostal;
	}
	/**
	 * Affecte la propriete codePostal.
	 *
	 * @param codePostal la valeur a affecter.
	 * @throws IllegalArgumentException si la valeur depasse codePostal.length() caracteres.
	 */
	public void setCodePostal(java.lang.String codePostal) {
		if (codePostal!=null && codePostal.length()>10) {
			throw new IllegalArgumentException("Le champ 'codePostal' ne doit pas faire plus de 10 caracteres. Impossible de l'affecter avec \""+codePostal+"\" ("+codePostal.length()+" caracteres).");
		}
		_codePostal=codePostal;
	}
	private java.lang.String _ville = null;
	/**
	 * Obtenir la valeur de la propriete ville.
	 *
	 * @return la valeur de la propriete ville
	 */
	
	@DBFieldInfos(name="VILLE")
	@Constraint(nullable=true,maxlength=100,primary=false,unique=false,fieldOrder=7)
	public java.lang.String getVille() {
		return _ville;
	}
	/**
	 * Affecte la propriete ville.
	 *
	 * @param ville la valeur a affecter.
	 * @throws IllegalArgumentException si la valeur depasse ville.length() caracteres.
	 */
	public void setVille(java.lang.String ville) {
		if (ville!=null && ville.length()>100) {
			throw new IllegalArgumentException("Le champ 'ville' ne doit pas faire plus de 100 caracteres. Impossible de l'affecter avec \""+ville+"\" ("+ville.length()+" caracteres).");
		}
		_ville=ville;
	}
	private java.sql.Timestamp _birthday = null;
	/**
	 * Obtenir la valeur de la propriete birthday.
	 *
	 * @return la valeur de la propriete birthday
	 */
	
	@DBFieldInfos(name="BIRTHDAY")
	@Constraint(nullable=true,primary=false,unique=false,fieldOrder=8)
	public java.sql.Timestamp getBirthday() {
		return _birthday;
	}
	/**
	 * Affecte la propriete birthday.
	 *
	 * @param birthday la valeur a affecter.
	 */
	public void setBirthday(java.sql.Timestamp birthday) {
		_birthday=birthday;
	}
	private java.lang.String _email = null;
	/**
	 * Obtenir la valeur de la propriete email.
	 *
	 * @return la valeur de la propriete email
	 */
	
	@DBFieldInfos(name="EMAIL")
	@Constraint(nullable=true,maxlength=50,primary=false,unique=false,fieldOrder=9)
	public java.lang.String getEmail() {
		return _email;
	}
	/**
	 * Affecte la propriete email.
	 *
	 * @param email la valeur a affecter.
	 * @throws IllegalArgumentException si la valeur depasse email.length() caracteres.
	 */
	public void setEmail(java.lang.String email) {
		if (email!=null && email.length()>50) {
			throw new IllegalArgumentException("Le champ 'email' ne doit pas faire plus de 50 caracteres. Impossible de l'affecter avec \""+email+"\" ("+email.length()+" caracteres).");
		}
		_email=email;
	}
	
}
