/**
 * 
 */
package br.com.centergames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.centergames.bean.EstadoBean;
import br.com.centergames.entity.Estado;
import br.com.centergames.facade.EstadoFacade;

/**
 * @author deivid
 *
 */
@FacesConverter(forClass=Estado.class)
public class EstadoConverter implements Converter {

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String str) {
		// TODO Auto-generated method stub
		if(str != null && !str.equals("")){
			EstadoBean estadoBean = (EstadoBean) ctx.getApplication().getELResolver().
					getValue(ctx.getELContext(), null, "estadoBean");
			EstadoFacade estadoFacade = estadoBean.getEstadoFacade();
			Estado estado = new Estado(); 
			estado = estadoFacade.findById(estado, new Integer(str));
			return estado;
		}else{
			return null;
		}
		
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
			Estado estado = (Estado) obj;
			return String.valueOf(estado.getId());
		}
	}

}
