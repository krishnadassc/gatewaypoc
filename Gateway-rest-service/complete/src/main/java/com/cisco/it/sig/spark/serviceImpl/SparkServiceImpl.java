package com.cisco.it.sig.spark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.it.sig.spark.contract.ISparkService;
import com.cisco.it.sig.spark.dao.SparkDaoImpl;
import com.cisco.it.sig.spark.entity.MGPayload;


@Service
public class SparkServiceImpl implements ISparkService{

	@Autowired
	private SparkDaoImpl genericMessageService;
	@Override
	public void sendMessage( MGPayload mgPayload) {
		
	}

}
