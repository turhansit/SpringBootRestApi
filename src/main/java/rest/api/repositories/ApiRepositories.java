package rest.api.repositories;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rest.api.model.ApiModel;
import rest.api.services.ApiServices;

@RestController
public class ApiRepositories {

	@Autowired
	private EntityManager em;

	public Object getData(@RequestParam ApiModel request) {
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("mysp");
		query.setParameter("sp_account_nr", request.getAccountNumber());
		query.setParameter("sp_contact_nr", request.getContractNumber());
		query.setParameter("sp_old_maturity_action", request.getOldMaturityAction());
		query.setParameter("sp_new_maturity_action", request.getNewMaturityAction());
		query.setParameter("sp_currency", request.getCurrency());
		query.execute();
		ApiServices as = new ApiServices();
		as.result = (int) query.getOutputParameterValue("sp_result");
		as.message = (String) query.getOutputParameterValue("sp_message");

		Map<String, Object> result = new LinkedHashMap<>(1);
		result.put("ApiJson", as);

		return result;
	}
}
