/**
 * 
 */
package br.com.centergames.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.component.panel.Panel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.centergames.entity.Cliente;
import br.com.centergames.entity.Funcionario;
import br.com.centergames.entity.Locacao;
import br.com.centergames.entity.Mesa;
import br.com.centergames.entity.Relogio;
import br.com.centergames.entity.Rota;
import br.com.centergames.entity.TipoMesa;
import br.com.centergames.entity.TrocaRelogio;
import br.com.centergames.facade.TrocaRelogioFacade;

/**
 * @author deivid
 *
 */
@Component("trocaBean")
@Scope("session")
public class TrocaRelogioBean implements Serializable{

	private static final long serialVersionUID = 1167819410939279358L;
	
	private TrocaRelogio trocaRelogio;
	private List<Mesa> mesas;
	private List<Relogio> relogios;
	
	private Mesa mesaSelecionada;
	
	private Boolean enableInfoMesa;
	
	//Componentes da tela
	private Panel panelInfo;
	
	@Autowired
	private TrocaRelogioFacade trocaRelogioFacade;

	@PostConstruct
	public void init(){
		setTrocaRelogio(new TrocaRelogio());
		setEnableInfoMesa(false);
		mesas = getMesasLocadas();
		setMesaSelecionada(new Mesa());
		mesaSelecionada.setLocacao(new Locacao());
		mesaSelecionada.setRelogio(new Relogio());
		mesaSelecionada.setTipoMesa(new TipoMesa());
		mesaSelecionada.getLocacao().setCliente(new Cliente());
		mesaSelecionada.getLocacao().setFuncionario(new Funcionario());
		mesaSelecionada.getLocacao().setRota(new Rota());
		relogios = getRelogiosDisponiveis();
	}
	
	private List<Relogio> getRelogiosDisponiveis() {
		// TODO Auto-generated method stub
		return trocaRelogioFacade.findRelogiosDisponiveis();
	}

	public List<Mesa> getMesasLocadas(){
		return trocaRelogioFacade.findMesasLocadas();
	}
	
	public List<Mesa> completeMesa(String query) {  
        List<Mesa> suggestions = new ArrayList<Mesa>();  
        if(mesas != null){
	        for(Mesa m : mesas) {  
	            if(m.getId().toString().startsWith(query))  
	                suggestions.add(m);  
	        }  
        }
        return suggestions;  
    }
	
	public List<Relogio> completeRelogio(String query) {  
        List<Relogio> suggestions = new ArrayList<Relogio>();  
        if(relogios != null){
	        for(Relogio r : relogios) {  
	            if(r.getNumero().toString().startsWith(query))  
	                suggestions.add(r);  
	        }  
        }
        return suggestions;  
    }  
	
	public String novo(){
		init();
		return "";
	}
	
	public void limpar(){
		init();
	}
	
	public String salvar(){
		trocaRelogio.setDataTroca(new Date());
		trocaRelogioFacade.save(trocaRelogio);
		return "";
	}
	
	public TrocaRelogio getTrocaRelogio() {
		return trocaRelogio;
	}
	public void setTrocaRelogio(TrocaRelogio trocaRelogio) {
		this.trocaRelogio = trocaRelogio;
	}
	public List<Mesa> getMesas() {
		return mesas;
	}
	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
	public TrocaRelogioFacade getTrocaRelogioFacade() {
		return trocaRelogioFacade;
	}
	public void setTrocaRelogioFacade(TrocaRelogioFacade trocaRelogioFacade) {
		this.trocaRelogioFacade = trocaRelogioFacade;
	}

	public Boolean getEnableInfoMesa() {
		return enableInfoMesa;
	}

	public void setEnableInfoMesa(Boolean enableInfoMesa) {
		this.enableInfoMesa = enableInfoMesa;
	}

	public List<Relogio> getRelogios() {
		return relogios;
	}

	public void setRelogios(List<Relogio> relogios) {
		this.relogios = relogios;
	}

	public Panel getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(Panel panelInfo) {
		this.panelInfo = panelInfo;
	}

	public Mesa getMesaSelecionada() {
		return mesaSelecionada;
	}

	public void setMesaSelecionada(Mesa mesaSelecionada) {
		this.mesaSelecionada = mesaSelecionada;
	}

}
