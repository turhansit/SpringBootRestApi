package rest.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = "mysp", procedureName = "My_Stored_Procedure", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sp_account_nr", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sp_contact_nr", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sp_old_maturity_action", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sp_new_maturity_action", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sp_currency", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "sp_result", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "sp_message", type = String.class),

		}) })

public class ApiModel {

	@Id
	@JsonProperty("accountNumber")
	private String accountNumber;

	@JsonProperty("contractNumber")
	private String contractNumber;

	@JsonProperty("oldMaturityAction")
	private int oldMaturityAction;

	@JsonProperty("newMaturityAction")
	private int newMaturityAction;

	@JsonProperty("currency")
	private String currency;

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public int getOldMaturityAction() {
		return oldMaturityAction;
	}

	public void setOldMaturityAction(int oldMaturityAction) {
		this.oldMaturityAction = oldMaturityAction;
	}

	public int getNewMaturityAction() {
		return newMaturityAction;
	}

	public void setNewMaturityAction(int newMaturityAction) {
		this.newMaturityAction = newMaturityAction;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}