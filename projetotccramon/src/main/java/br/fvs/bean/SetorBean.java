package br.fvs.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.fvs.dao.SetorDAO;
import br.fvs.model.Setor;

@ManagedBean(name="bsetor")
@RequestScoped
public class SetorBean {
	
	private Setor setor = new Setor();
	private List<Setor> list;
	private SetorDAO setorDAO = new SetorDAO();
	private FacesContext context = FacesContext.getCurrentInstance();
	
	public List<Setor> getList(){
		return setorDAO.listOrderBy("description");
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	public String remove(){
		if(setorDAO.remove(setor))
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Setor excluído com sucesso!", ""));
		return "";
	}
	
	public String chamaTela(){
		return "/userdti/setor";
	}
	
	public String save(){
		if(setor.getDescription().equals("")){
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Preencha os campos Obrigatórios (*)", ""));
			return null;
		}
		if(setor.getId()==null){
			if(setorDAO.add(setor))
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Setor salvo com sucesso!", ""));
		} else {
			if(setorDAO.update(setor))
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Setor editado com sucesso!", ""));
		}
		
		
		return "/userdti/setorlist";
	}
	
	

}
