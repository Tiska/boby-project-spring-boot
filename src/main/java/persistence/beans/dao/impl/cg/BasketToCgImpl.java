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
@DBTableInfos(name="basket",daoClass=BasketDaoCgImpl.class)
public class BasketToCgImpl implements persistence.beans.dao.IBasketTo, java.io.Serializable {
	
	/**
	 * serialVersionUID genere d'apres le nom de la classe
	 */
	private static final long serialVersionUID = 1632L;
	
	private transient BasketDaoCgImpl _dao=null;
	protected BasketDaoCgImpl getDao() {
		if (_dao==null) {
			_dao = (BasketDaoCgImpl)persistence.GeneratorRuntime.getGeneratorRuntime().getImplementation(persistence.beans.dao.IBasketDao.class);
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
		return (obj!=null) && obj.getClass()==getClass() && ((persistence.beans.dao.impl.cg.BasketToCgImpl)obj).getCacheKey().equals(getCacheKey());
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
	private int _total = -1;
	/**
	 * Obtenir la valeur de la propriete total.
	 *
	 * @return la valeur de la propriete total
	 */
	
	@DBFieldInfos(name="TOTAL")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=2)
	public int getTotal() {
		return _total;
	}
	/**
	 * Affecte la propriete total.
	 *
	 * @param total la valeur a affecter.
	 */
	public void setTotal(int total) {
		_total=total;
	}
	private int _typePayment = -1;
	/**
	 * Obtenir la valeur de la propriete typePayment.
	 *
	 * @return la valeur de la propriete typePayment
	 */
	
	@DBFieldInfos(name="TYPE_PAYMENT")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=3)
	public int getTypePayment() {
		return _typePayment;
	}
	/**
	 * Affecte la propriete typePayment.
	 *
	 * @param typePayment la valeur a affecter.
	 */
	public void setTypePayment(int typePayment) {
		_typePayment=typePayment;
	}
	private java.sql.Timestamp _date = null;
	/**
	 * Obtenir la valeur de la propriete date.
	 *
	 * @return la valeur de la propriete date
	 */
	
	@DBFieldInfos(name="DATE")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=4)
	public java.sql.Timestamp getDate() {
		return _date;
	}
	/**
	 * Affecte la propriete date.
	 *
	 * @param date la valeur a affecter.
	 */
	public void setDate(java.sql.Timestamp date) {
		if (date==null) {
			throw new IllegalArgumentException("Le champ 'date' ne peut être null.");
		}
		_date=date;
	}
	private long _idClient = -1;
	/**
	 * Obtenir la valeur de la propriete idClient.
	 *
	 * @return la valeur de la propriete idClient
	 */
	
	@DBFieldInfos(name="ID_CLIENT")
	@Constraint(nullable=false,primary=false,unique=false,fieldOrder=5)
	@ForeignKey(name="basketIdClientToClientId", referenceTo=persistence.beans.dao.IClientTo.class, referenceDao=persistence.beans.dao.IClientDao.class, referenceListMethod="getList", referenceObjectMethod="getClient", referenceProperty="id")
	public long getIdClient() {
		return _idClient;
	}
	/**
	 * Affecte la propriete idClient.
	 *
	 * @param idClient la valeur a affecter.
	 */
	public void setIdClient(long idClient) {
		_idClient=idClient;
	}
	private java.sql.Timestamp _datePaiement = null;
	/**
	 * Obtenir la valeur de la propriete datePaiement.
	 *
	 * @return la valeur de la propriete datePaiement
	 */
	
	@DBFieldInfos(name="DATE_PAIEMENT")
	@Constraint(nullable=true,primary=false,unique=false,fieldOrder=6)
	public java.sql.Timestamp getDatePaiement() {
		return _datePaiement;
	}
	/**
	 * Affecte la propriete datePaiement.
	 *
	 * @param datePaiement la valeur a affecter.
	 */
	public void setDatePaiement(java.sql.Timestamp datePaiement) {
		_datePaiement=datePaiement;
	}
	
}
