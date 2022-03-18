package br.com.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.entity.Produto;

public class ProdutoDao {

	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto buscarProdutoID(Long id) {
		return em.find(Produto.class, id);
	}
	public List<Produto>buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createNamedQuery(jpql,Produto.class).getResultList();
	}
	
	public List<Produto>buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
	return em.createNamedQuery(jpql,Produto.class).setParameter("nome", nome).getResultList();
	}
	
	public List<Produto>buscarPorNomeCategoria(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.Categoria.nome = :nome";
	return em.createNamedQuery(jpql,Produto.class).setParameter("nome", nome).getResultList();
	
	}
	
	public BigDecimal buscarPrecoProduto(String nome) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
	return em.createNamedQuery(jpql,BigDecimal.class).setParameter("nome", nome).getSingleResult();
	
	}
}
