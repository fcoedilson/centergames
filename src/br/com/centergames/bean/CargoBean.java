/**
 * 
 */
package br.com.centergames.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.centergames.entity.Cargo;
import br.com.centergames.facade.CargoFacade;

/**
 * @author deivid
 *
 */
@Scope("session")
@Component("cargoBean")
public class CargoBean implements Serializable{

	private static final long serialVersionUID = -5931256816425466243L;
	

	private Cargo cargo;
	private Cargo cargoSelecionado;
	private List<Cargo> lista;
	
	@Autowired
	private CargoFacade cargoFacade;
	
	@PostConstruct
	public void init(){
		cargo = new Cargo();
		lista = cargoFacade.findAll(cargo);
	}
	
	public String listar(){
		lista = cargoFacade.findAll(cargo);
		return "cargoLista";
	}
		
	public String novo(){
		cargo = new Cargo();
		return "cargo";
	}
	
	public String voltar(){
		return "cargoLista";
	}
	
	public String editar(){
		return "cargo";
	}
	
	public String salvar(){
		cargoFacade.save(cargo);
		return listar();
	}
	
	public void excluir(){
		cargoFacade.delete(cargo);
		cargo = new Cargo();
		listar();
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Cargo getCargoSelecionado() {
		return cargoSelecionado;
	}

	public void setCargoSelecionado(Cargo cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}

	public List<Cargo> getLista() {
		return lista;
	}

	public void setLista(List<Cargo> lista) {
		this.lista = lista;
	}

	public CargoFacade getCargoFacade() {
		return cargoFacade;
	}

	public void setCargoFacade(CargoFacade cargoFacade) {
		this.cargoFacade = cargoFacade;
	}

}
