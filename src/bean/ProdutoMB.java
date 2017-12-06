package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.ITipoProdutoDAO;
import dao.TipoProdutoDAO;
import model.TipoProduto;

@ManagedBean
@SessionScoped
public class ProdutoMB implements Serializable{
	private static final long serialVersionUID = -5614822306223785484L;

	private List<TipoProduto> listaTP = new ArrayList<TipoProduto>();
	private ITipoProdutoDAO tpDAO = new TipoProdutoDAO();
	
	private TipoProduto tipoProduto = new TipoProduto();
	
	public TipoProduto getTipoProduto(){
		return tipoProduto;
	}
	
	public void setTipoProduto(TipoProduto tp){
		tipoProduto = tp;
	}

	public List<TipoProduto> getListaTP() {
		return listaTP;
	}

	public void setListaTP(List<TipoProduto> listaTP) {
		this.listaTP = listaTP;
	}

	public String adicionar(){
		tpDAO.adicionar(tipoProduto);
		tipoProduto = new TipoProduto();
		FacesMessage msg = new FacesMessage("Tipo Produto adicionado");
		FacesContext.getCurrentInstance().addMessage( null, msg);
		return "";
	}
	
	
	
}
