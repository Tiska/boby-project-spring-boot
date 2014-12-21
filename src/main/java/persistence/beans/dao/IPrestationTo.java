package persistence.beans.dao;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public interface IPrestationTo extends java.io.Serializable {
	
	
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
	 * Obtenir la valeur de la propriete libelle.
	 *
	 * @return la valeur de la propriete libelle
	 */
	public String getLibelle();
	
	/**
	 * Affecte la propriete libelle.
	 *
	 * @param libelle la valeur a affecter.
	 */
	public void setLibelle(String libelle);
	
	/**
	 * Obtenir la valeur de la propriete prix.
	 *
	 * @return la valeur de la propriete prix
	 */
	public int getPrix();
	
	/**
	 * Affecte la propriete prix.
	 *
	 * @param prix la valeur a affecter.
	 */
	public void setPrix(int prix);
	
	/**
	 * Obtenir la valeur de la propriete duree.
	 *
	 * @return la valeur de la propriete duree
	 */
	public int getDuree();
	
	/**
	 * Affecte la propriete duree.
	 *
	 * @param duree la valeur a affecter.
	 */
	public void setDuree(int duree);
	
	/**
	 * Obtenir la valeur de la propriete obsolete.
	 *
	 * @return la valeur de la propriete obsolete
	 */
	public boolean getObsolete();
	
	/**
	 * Affecte la propriete obsolete.
	 *
	 * @param obsolete la valeur a affecter.
	 */
	public void setObsolete(boolean obsolete);
	
	/**
	 * Obtenir la valeur de la propriete idPrestationCateg.
	 *
	 * @return la valeur de la propriete idPrestationCateg
	 */
	public long getIdPrestationCateg();
	
	/**
	 * Affecte la propriete idPrestationCateg.
	 *
	 * @param idPrestationCateg la valeur a affecter.
	 */
	public void setIdPrestationCateg(long idPrestationCateg);
	
	public boolean isNew();
	
	public void setNew(boolean _new);
	
	
}
