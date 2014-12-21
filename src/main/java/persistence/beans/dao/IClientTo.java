package persistence.beans.dao;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public interface IClientTo extends java.io.Serializable {
	
	
	/**
	 * Obtenir la valeur de la propriete id.
	 *
	 * @return la valeur de la propriete id
	 */
	public long getId();
	
	/**
	 * Affecte la propriete id.
	 *
	 * @param id la valeur a affecter.
	 */
	public void setId(long id);
	
	/**
	 * Obtenir la valeur de la propriete nom.
	 *
	 * @return la valeur de la propriete nom
	 */
	public String getNom();
	
	/**
	 * Affecte la propriete nom.
	 *
	 * @param nom la valeur a affecter.
	 */
	public void setNom(String nom);
	
	/**
	 * Obtenir la valeur de la propriete prenom.
	 *
	 * @return la valeur de la propriete prenom
	 */
	public String getPrenom();
	
	/**
	 * Affecte la propriete prenom.
	 *
	 * @param prenom la valeur a affecter.
	 */
	public void setPrenom(String prenom);
	
	/**
	 * Obtenir la valeur de la propriete telephone.
	 *
	 * @return la valeur de la propriete telephone
	 */
	public Integer getTelephone();
	
	/**
	 * Affecte la propriete telephone.
	 *
	 * @param telephone la valeur a affecter.
	 */
	public void setTelephone(Integer telephone);
	
	/**
	 * Obtenir la valeur de la propriete adresse.
	 *
	 * @return la valeur de la propriete adresse
	 */
	public String getAdresse();
	
	/**
	 * Affecte la propriete adresse.
	 *
	 * @param adresse la valeur a affecter.
	 */
	public void setAdresse(String adresse);
	
	/**
	 * Obtenir la valeur de la propriete codePostal.
	 *
	 * @return la valeur de la propriete codePostal
	 */
	public String getCodePostal();
	
	/**
	 * Affecte la propriete codePostal.
	 *
	 * @param codePostal la valeur a affecter.
	 */
	public void setCodePostal(String codePostal);
	
	/**
	 * Obtenir la valeur de la propriete ville.
	 *
	 * @return la valeur de la propriete ville
	 */
	public String getVille();
	
	/**
	 * Affecte la propriete ville.
	 *
	 * @param ville la valeur a affecter.
	 */
	public void setVille(String ville);
	
	/**
	 * Obtenir la valeur de la propriete birthday.
	 *
	 * @return la valeur de la propriete birthday
	 */
	public java.sql.Timestamp getBirthday();
	
	/**
	 * Affecte la propriete birthday.
	 *
	 * @param birthday la valeur a affecter.
	 */
	public void setBirthday(java.sql.Timestamp birthday);
	
	/**
	 * Obtenir la valeur de la propriete email.
	 *
	 * @return la valeur de la propriete email
	 */
	public String getEmail();
	
	/**
	 * Affecte la propriete email.
	 *
	 * @param email la valeur a affecter.
	 */
	public void setEmail(String email);
	
	public boolean isNew();
	
	public void setNew(boolean _new);
	
	
}
