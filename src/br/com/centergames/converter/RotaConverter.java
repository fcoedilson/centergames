package br.com.centergames.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.centergames.bean.RotaBean;
import br.com.centergames.entity.Rota;
import br.com.centergames.facade.RotaFacade;

/**
 * 
 */

/**
 * @author deivid
 *
 */
/**
 * @author deivid
 *
 */
@FacesConverter(forClass=Rota.class,value="rotaConverter")
public class RotaConverter implements Converter {

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String str) {
		// TODO Auto-generated method stub
		if(str != null && !str.equals("")){
			RotaBean rotaBean = (RotaBean) ctx.getApplication().getELResolver().
					getValue(ctx.getELContext(), null, "rotaBean");
			RotaFacade rotaFacade = rotaBean.getRotaFacade();
			Rota rota = new Rota(); 
			rota = rotaFacade.findById(rota, new Integer(str));			
			return rota;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || obj.equals("")){
			return null;
		}else{
			Rota rota = (Rota) obj;
			return String.valueOf(rota.getId());
		}
	}
}
