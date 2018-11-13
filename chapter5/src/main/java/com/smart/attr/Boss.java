package com.smart.attr;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ArrayList;
import com.smart.Car;
import java.util.HashMap;
public class Boss{
	private Car car = new Car();
	private List favorites = new ArrayList();
	private Map jobs = new HashMap();
	private Properties mails = new Properties();
	
	public Properties getMails() {
		return this.mails;
	}
	public void setMails(Properties mails) {
		this.mails = mails;
	}
	public Map getJosb() {
		return this.jobs;
	}
	public void setJobs(Map jobs) {
		this.jobs = jobs;
	}
	public List getFavorites() {
		return this.favorites;
	}
	public void setFavorites(List favorites) {
		this.favorites = favorites;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	
	public Car getCar() {
		return this.car;
	}
	
}