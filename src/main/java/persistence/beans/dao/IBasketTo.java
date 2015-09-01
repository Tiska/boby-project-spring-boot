package persistence.beans.dao;

/**
 * Cette interface est autogeneree par c-generator.<br/>
 *
 * @author c-generator (c) Cardiweb
 */
public interface IBasketTo extends java.io.Serializable {
	
	
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
	 * Obtenir la valeur de la propriete total.
	 *
	 * @return la valeur de la propriete total
	 */
	public int getTotal();
	
	/**
	 * Affecte la propriete total.
	 *
	 * @param total la valeur a affecter.
	 */
	public void setTotal(int total);
	
	/**
	 * Obtenir la valeur de la propriete typePayment.
	 *
	 * @return la valeur de la propriete typePayment
	 */
	public int getTypePayment();
	
	/**
	 * Affecte la propriete typePayment.
	 *
	 * @param typePayment la valeur a affecter.
	 */
	public void setTypePayment(int typePayment);
	
	/**
	 * Obtenir la valeur de la propriete date.
	 *
	 * @return la valeur de la propriete date
	 */
	public java.sql.Timestamp getDate();
	
	/**
	 * Affecte la propriete date.
	 *
	 * @param date la valeur a affecter.
	 */
	public void setDate(java.sql.Timestamp date);
	
	/**
	 * Obtenir la valeur de la propriete idClient.
	 *
	 * @return la valeur de la propriete idClient
	 */
	public Long getIdClient();
	
	/**
	 * Affecte la propriete idClient.
	 *
	 * @param idClient la valeur a affecter.
	 */
	public void setIdClient(Long idClient);
	
	/**
	 * Obtenir la valeur de la propriete datePaiement.
	 *
	 * @return la valeur de la propriete datePaiement
	 */
	public java.sql.Timestamp getDatePaiement();
	
	/**
	 * Affecte la propriete datePaiement.
	 *
	 * @param datePaiement la valeur a affecter.
	 */
	public void setDatePaiement(java.sql.Timestamp datePaiement);
	
	public boolean isNew();
	
	public void setNew(boolean _new);
	
	
}
