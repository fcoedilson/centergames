/**
 * 
 */
package br.com.centergames.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.centergames.bean.ValorFichaBean;
import br.com.centergames.entity.ValorFicha;
import br.com.centergames.facade.ValorFichaFacade;

/**
 * @author deivid
 *
 */
@FacesConverter(forClass=ValorFicha.class, value="valorFichaConverter")
public class ValorFichaConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String str) {
		// TODO Auto-generated method stub
		if(str != null && !str.equals("")){
			ValorFichaBean vlrFichaBean = (ValorFichaBean) ctx.getApplication().getELResolver().
					getValue(ctx.getELContext(), null, "vlFichaBean");
			ValorFichaFacade vlrFichaFacade = vlrFichaBean.getVlFichaFacade();
			ValorFicha vlrFicha = new ValorFicha(); 
			vlrFicha = vlrFichaFacade.findById(vlrFicha, new Integer(str));			
			return vlrFicha;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || obj.equals("")){
			return null;
		}else{
			ValorFicha vlrFicha = (ValorFicha) obj;
			return String.valueOf(vlrFicha.getId());
		}
	}
}
