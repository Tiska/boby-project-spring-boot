package persistence.beans.dao;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public interface IBasketlineTo extends java.io.Serializable {
	
	
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
	 * Obtenir la valeur de la propriete idPrestation.
	 *
	 * @return la valeur de la propriete idPrestation
	 */
	public Long getIdPrestation();
	
	/**
	 * Affecte la propriete idPrestation.
	 *
	 * @param idPrestation la valeur a affecter.
	 */
	public void setIdPrestation(Long idPrestation);
	
	/**
	 * Obtenir la valeur de la propriete idProduit.
	 *
	 * @return la valeur de la propriete idProduit
	 */
	public Long getIdProduit();
	
	/**
	 * Affecte la propriete idProduit.
	 *
	 * @param idProduit la valeur a affecter.
	 */
	public void setIdProduit(Long idProduit);
	
	/**
	 * Obtenir la valeur de la propriete prixAvecReduction.
	 *
	 * @return la valeur de la propriete prixAvecReduction
	 */
	public int getPrixAvecReduction();
	
	/**
	 * Affecte la propriete prixAvecReduction.
	 *
	 * @param prixAvecReduction la valeur a affecter.
	 */
	public void setPrixAvecReduction(int prixAvecReduction);
	
	/**
	 * Obtenir la valeur de la propriete quantite.
	 *
	 * @return la valeur de la propriete quantite
	 */
	public int getQuantite();
	
	/**
	 * Affecte la propriete quantite.
	 *
	 * @param quantite la valeur a affecter.
	 */
	public void setQuantite(int quantite);
	
	/**
	 * Obtenir la valeur de la propriete reduction.
	 *
	 * @return la valeur de la propriete reduction
	 */
	public Integer getReduction();
	
	/**
	 * Affecte la propriete reduction.
	 *
	 * @param reduction la valeur a affecter.
	 */
	public void setReduction(Integer reduction);
	
	/**
	 * Obtenir la valeur de la propriete typeDeReduction.
	 *
	 * @return la valeur de la propriete typeDeReduction
	 */
	public Integer getTypeDeReduction();
	
	/**
	 * Affecte la propriete typeDeReduction.
	 *
	 * @param typeDeReduction la valeur a affecter.
	 */
	public void setTypeDeReduction(Integer typeDeReduction);
	
	/**
	 * Obtenir la valeur de la propriete idBasket.
	 *
	 * @return la valeur de la propriete idBasket
	 */
	public long getIdBasket();
	
	/**
	 * Affecte la propriete idBasket.
	 *
	 * @param idBasket la valeur a affecter.
	 */
	public void setIdBasket(long idBasket);
	
	public boolean isNew();
	
	public void setNew(boolean _new);
	
	
}
