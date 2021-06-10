package com.residencia.ecommerce.services;

import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.CategoriaRepository;
import com.residencia.ecommerce.repositories.ProdutoRepository;
import com.residencia.ecommerce.vo.ProdutoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    /*- Visualizar todos os produtos ou um específico pelo nome.
    - Criar um novo produto (Com imagem).
    - Editar um produto.
    - Deletar um produto.
    - Visualizar todos os pedidos.
    - Excluir algum pedido.
    */

    @Autowired
    public ProdutoRepository produtoRepository;

    @Autowired
    public CategoriaRepository categoriaRepository;

//******************************************************************************************************************

    public ProdutoVO findByNomeProd(String nome) {
        Produto produto = produtoRepository.findByNomeProduto(nome);
        return converteEntidadeParaVO(produto);
    }

//******************************************************************************************************************

    public List<ProdutoVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
        Pageable page = null;
        List<Produto> listProduto = null;
        List<Produto> listProdutoComPaginacao = null;
        List<ProdutoVO> listProdutoVO = new ArrayList<>();

        try {
            if (null != pagina && null != qtdRegistros) {

                page = PageRequest.of(pagina, qtdRegistros);
                listProdutoComPaginacao = produtoRepository.findAll(page).getContent();

                for (Produto lProduto : listProdutoComPaginacao) {
                    listProdutoVO.add(converteEntidadeParaVO(lProduto));
                }

            } else {
                listProduto = produtoRepository.findAll();

                for (Produto lProduto : listProduto) {
                    listProdutoVO.add(converteEntidadeParaVO(lProduto));
                }
            }
        } catch (Exception e) {
            throw new Exception("Não foi possível recuperar a lista de produtos ::" + e.getMessage());
        }
        return listProdutoVO;
    }

//******************************************************************************************************************


    public long count() {
        return produtoRepository.count();
    }

//******************************************************************************************************************

    public ProdutoVO saveVO(ProdutoVO produtoVO) {
        Produto novaProduto = converteVOParaEntidade(produtoVO);
        Produto produto = produtoRepository.save(novaProduto);

        return converteEntidadeParaVO(produto);
    }

//********************************************************************************************************************

    public Produto update(Produto produto) {

        return produtoRepository.save(produto);
    }


//********************************************************************************************************************

    public boolean delete(Integer id) {
        if (id != null) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private ProdutoVO converteEntidadeParaVO(Produto produto) {
        ProdutoVO produtoVO = new ProdutoVO();

        produtoVO.setProdutoId(produto.getProdutoId());
        produtoVO.setNomeProduto(produto.getNomeProduto());
        produtoVO.setDescricaoProduto(produto.getDescricaoProduto());
        produtoVO.setPrecoProduto(produto.getPrecoProduto());
        produtoVO.setQtdEstoque(produto.getQtdEstoque());
        produtoVO.setImagem(produto.getImagem());

        return produtoVO;
    }

    private Produto converteVOParaEntidade(ProdutoVO produtoVO) {
        Produto produto = new Produto();

        produto.setProdutoId(produtoVO.getProdutoId());
        produto.setNomeProduto(produtoVO.getNomeProduto());
        produto.setDescricaoProduto(produtoVO.getDescricaoProduto());
        produto.setPrecoProduto(produtoVO.getPrecoProduto());
        produto.setQtdEstoque(produtoVO.getQtdEstoque());
        produto.setImagem(produtoVO.getImagem());
        produto.setCategoria(categoriaRepository.getById(produtoVO.getCategoria()));

        return produto;
    }


}
