package dao;

import java.util.List;

import model.TipoProduto;

public interface ITipoProdutoDAO {
	
	void adicionar(TipoProduto tp);
	List<TipoProduto> pesquisar();

}
