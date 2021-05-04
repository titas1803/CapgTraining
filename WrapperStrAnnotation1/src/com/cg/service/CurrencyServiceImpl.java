package com.cg.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("myservice")
public class CurrencyServiceImpl implements ICurrencyService{
	
	@Value("${pmsg}")
	//@Aytowired used to inject other than String and Wrapper
	private String msg;
	@Value("${prate}")
	private double rate;
	
	public void setMsg(String msg) {
		this.msg=msg;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
	public double convertToINR(double usd) {
		// TODO Auto-generated method stub
		return rate*usd;
	}

	@Override
	public String currentState() {
		// TODO Auto-generated method stub
		return msg+" current rate id " + rate;
	}
	

}
