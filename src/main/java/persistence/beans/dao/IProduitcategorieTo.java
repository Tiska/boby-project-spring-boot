package persistence.beans.dao;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public interface IProduitcategorieTo extends java.io.Serializable {
	
	
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
	
	public boolean isNew();
	
	public void setNew(boolean _new);
	
	
}
