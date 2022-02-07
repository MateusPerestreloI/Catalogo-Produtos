package i.mateus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import i.mateus.model.ProdutoModel;
import i.mateus.repository.CategoriaRepository;
import i.mateus.repository.MarcaRepository;
import i.mateus.repository.ProdutoRepository;

/**
 * O Controller tem a função de interligar o View com o Model
 * Fazendo assim com que a página de produtos consiga acessar o modelo para gravar, buscar e deletar os dados de um banco
 * 
 * @author Mateus I
 *
 */

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	private static final String PRODUTO_PATH = "produto/";
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@Autowired
	public MarcaRepository marcaRepository;
	
	/**
	 * Método que ira buscar os produtos gravados ou inserir um novo produto no banco de dados
	 * 
	 * @param isNew
	 * Parametro passado como 'true' pelo site para identificar se o produto é novo e que precisa ser gravado
	 * 
	 * @param model
	 * Usado para inserir dados em qualquer modelo não sendo especificado qual
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@GetMapping()
	public String get(@RequestParam(required = false) boolean isNew, Model model)
	{
		if(isNew)
		{
			model.addAttribute("produtoModel", new ProdutoModel());
			model.addAttribute("categorias", categoriaRepository.findAll());
			model.addAttribute("marcas", marcaRepository.findAll());
		}
		else
			model.addAttribute("produtos", produtoRepository.findAll());
		
		return PRODUTO_PATH + (isNew ? "produto-novo" : "produtos");
	}
	
	/**
	 * Método que irá buscar um produto especifico podendo alterar os dados
	 * 
	 * @param id
	 * Parametro passado pelo site para identificar o código do produto que deverá ser buscado
	 * 
	 * @param isEdit
	 * Parametro passado como 'true' pelo site para identificar que os dados de um produto existente será alterado
	 * 
	 * @param model
	 * Usado para inserir dados em qualquer modelo não sendo especificado qual
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@GetMapping(value = "/{id}")
	public String getById(@PathVariable("id") long id, @RequestParam(required=false) boolean isEdit, Model model) {

		model.addAttribute("produtoModel", produtoRepository.findById(id).get());
		
		if(isEdit) {
			model.addAttribute("categorias", categoriaRepository.findAll());
			model.addAttribute("marcas", marcaRepository.findAll());
		}
		
		return PRODUTO_PATH + (isEdit ? "produto-editar": "produto-detalhe");
	}
	
	/**
	 * Método que irá gravar os dados do novo produto no banco de dados
	 * 
	 * @param produtoModel
	 * Usado para inserir os dados coletados no modelo de produto
	 * 
	 * @param bindingResult
	 * Irá conferir se algum dos dados passados está com erro
	 * 
	 * @param redirectAttributes
	 * Irá adicionar uma mensagem ao redirecionar a página
	 * 
	 * @param model
	 * Usado para inserir dados em qualquer modelo não sendo especificado qual
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@PostMapping()
	public String newProduct(@Valid ProdutoModel produtoModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if (!bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("mensagemProduto", "Produto cadastrado com sucesso");
			produtoRepository.save(produtoModel);
			return "redirect:/produto";
		} else {
			model.addAttribute("categorias", categoriaRepository.findAll());
			model.addAttribute("marcas", marcaRepository.findAll());
			return PRODUTO_PATH + "produto-novo";
		}
	}
	
	/**
	 * Método que irá gravar os dados alterados de um determinado produto existente
	 * 
	 * @param produtoModel
	 * Usado para inserir os dados coletados no modelo de produto
	 * 
	 * @param bindingResult
	 * Irá conferir se algum dos dados passados está com erro
	 * 
	 * @param redirectAttributes
	 * Irá adicionar uma mensagem ao redirecionar a página
	 * 
	 * @param model
	 * Usado para inserir dados em qualquer modelo não sendo especificado qual
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@PutMapping()
	public String editProduct(@Valid ProdutoModel produtoModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if (!bindingResult.hasErrors()) {
			produtoRepository.save(produtoModel);
		
			redirectAttributes.addFlashAttribute("mensagemProduto", "Produto alterado com sucesso");
			return "redirect:/produto";
		} else {
			model.addAttribute("categorias", categoriaRepository.findAll());
			model.addAttribute("marcas", marcaRepository.findAll());
			return PRODUTO_PATH + "produto-editar";
		}
	}
	
	/**
	 * Método para excluir um determinado produto do banco de dados
	 * 
	 * @param id
	 * Parametro passado pelo site para identificar o produto que será excluido
	 * 
	 * @param redirectAttributes
	 * Irá adicionar uma mensagem que será exibida para página redirecionada
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		
		produtoRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("mensagemProduto", "Produto excluído com sucesso");
		return "redirect:/produto";
	}
}
