package persistence.beans.dao;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public interface IProduitTo extends java.io.Serializable {
	
	
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
	 * Obtenir la valeur de la propriete stock.
	 *
	 * @return la valeur de la propriete stock
	 */
	public int getStock();
	
	/**
	 * Affecte la propriete stock.
	 *
	 * @param stock la valeur a affecter.
	 */
	public void setStock(int stock);
	
	/**
	 * Obtenir la valeur de la propriete prixAchat.
	 *
	 * @return la valeur de la propriete prixAchat
	 */
	public int getPrixAchat();
	
	/**
	 * Affecte la propriete prixAchat.
	 *
	 * @param prixAchat la valeur a affecter.
	 */
	public void setPrixAchat(int prixAchat);
	
	/**
	 * Obtenir la valeur de la propriete prixVenteCalcule.
	 *
	 * @return la valeur de la propriete prixVenteCalcule
	 */
	public int getPrixVenteCalcule();
	
	/**
	 * Affecte la propriete prixVenteCalcule.
	 *
	 * @param prixVenteCalcule la valeur a affecter.
	 */
	public void setPrixVenteCalcule(int prixVenteCalcule);
	
	/**
	 * Obtenir la valeur de la propriete coefficiant.
	 *
	 * @return la valeur de la propriete coefficiant
	 */
	public int getCoefficiant();
	
	/**
	 * Affecte la propriete coefficiant.
	 *
	 * @param coefficiant la valeur a affecter.
	 */
	public void setCoefficiant(int coefficiant);
	
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
	 * Obtenir la valeur de la propriete idProduitCateg.
	 *
	 * @return la valeur de la propriete idProduitCateg
	 */
	public long getIdProduitCateg();
	
	/**
	 * Affecte la propriete idProduitCateg.
	 *
	 * @param idProduitCateg la valeur a affecter.
	 */
	public void setIdProduitCateg(long idProduitCateg);
	
	public boolean isNew();
	
	public void setNew(boolean _new);
	
	
}
