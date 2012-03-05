/**
 * 
 */
package br.com.centergames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.centergames.bean.RelogioBean;
import br.com.centergames.entity.Relogio;
import br.com.centergames.facade.RelogioFacade;

/**
 * @author deivid
 *
 */
@FacesConverter(forClass=Relogio.class, value="relogioConverter")
public class RelogioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String str) {
		// TODO Auto-generated method stub
		if(str != null && !str.equals("")){
			RelogioBean relogioBean = (RelogioBean) ctx.getApplication().getELResolver().
					getValue(ctx.getELContext(), null, "relogioBean");
			RelogioFacade relogioFacade = relogioBean.getRelogioFacade();
			Relogio relogio = new Relogio(); 
			relogio = relogioFacade.findById(relogio, new Integer(str));			
			return relogio;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || obj.equals("")){
			return null;
		}else{
			Relogio relogio = (Relogio) obj;
			return String.valueOf(relogio.getId());
		}
	}

}
