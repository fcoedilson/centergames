/**
 * 
 */
package br.com.centergames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.centergames.bean.TipoMesaBean;
import br.com.centergames.entity.TipoMesa;
import br.com.centergames.facade.TipoMesaFacade;

/**
 * @author deivid
 *
 */
@FacesConverter(forClass=TipoMesa.class, value="tpMesaConverter")
public class TipoMesaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String str) {
		// TODO Auto-generated method stub
		if(str != null && !str.equals("")){
			TipoMesaBean tpMesaBean = (TipoMesaBean) ctx.getApplication().getELResolver().
					getValue(ctx.getELContext(), null, "tpMesaBean");
			TipoMesaFacade tpMesaFacade = tpMesaBean.getTpMesaFacade();
			TipoMesa tpMesa = new TipoMesa(); 
			tpMesa = tpMesaFacade.findById(tpMesa, new Integer(str));			
			return tpMesa;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || obj.equals("")){
			return null;
		}else{
			TipoMesa tpMesa = (TipoMesa) obj;
			return String.valueOf(tpMesa.getId());
		}
	}

}
