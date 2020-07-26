package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.UserModel;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {
	@Inject
	OrdersBusinessInterface services;
	
	@EJB
	MyTimerService timer;

	public String onSubmit() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		UserModel userModel = context.getApplication().evaluateExpressionGet(context, "#{userModel}", UserModel.class);
		
		services.test();
		
		timer.setTimer(10000);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("userModel", userModel);
		
		return "Response.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		return services;
	}
	
}
