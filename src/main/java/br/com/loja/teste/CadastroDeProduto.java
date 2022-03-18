package br.com.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.entity.Produto;
import br.com.loja.entity.enuns.Categoria;
import br.com.loja.utils.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {

		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtodao = new ProdutoDao(em);
		Produto p = produtodao.buscarProdutoID(1L);
		System.out.println(p.getPreco());
		
	List<Produto> todos = produtodao.buscarTodos();
	 todos.forEach(p2 -> System.out.println(p.getNome()));
		
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("XIAOMI REDMI","Muito LegalI",new BigDecimal("800"),celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtodao = new ProdutoDao(em);
		CategoriaDao categoriadao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		categoriadao.cadastrar(celulares);
		produtodao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
