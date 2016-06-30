package com.cisco.it.sig.spark.contract;

import com.cisco.it.sig.spark.entity.MGPayload;

/**
 * ISparkService is the base spark interface contains methods for business operations
 * @author ashsunda
 *
 */
public interface ISparkService {

	public void sendMessage(MGPayload msg);
	
	
}
