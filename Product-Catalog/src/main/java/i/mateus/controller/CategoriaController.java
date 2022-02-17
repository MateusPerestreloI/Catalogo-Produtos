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

import i.mateus.model.CategoriaModel;
import i.mateus.repository.CategoriaRepository;

/**
 * O Controller tem a função de interligar o View com o Model
 * Fazendo assim com que a página de categoria consiga acessar o modelo para gravar, buscar e deletar os dados de um banco
 * 
 * @author Mateus I
 *
 */
@Controller
@RequestMapping("/categoria")
public class CategoriaController{
	private static final String CATEGORIA_PATH = "categoria/";

	@Autowired
	public CategoriaRepository categoriaRepository;
		
	/**
	 * Método que ira buscar as categorias gravadas ou inserir uma nova categoria no banco de dados
	 * 
	 * @param isNew
	 * Parametro passado como 'true' pelo site para identificar se a categoria é nova e que precisa ser gravada
	 * 
	 * @param model
	 * Usado para inserir dados em qualquer modelo não sendo especificado qual
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@GetMapping()
	public String get(@RequestParam(required=false) boolean isNew, Model model) {	
		
		if(isNew) {
			model.addAttribute("categoriaModel", new CategoriaModel());	
		} else {
			model.addAttribute("categorias", categoriaRepository.findAll());	
		}
		
		return CATEGORIA_PATH + (isNew ? "categoria-nova" : "categorias");
	}
	
	/**
	 * Método que irá buscar uma categoria especifica podendo alterar os dados
	 * 
	 * @param id
	 * Parametro passado pelo site para identificar o código da categoria que deverá ser buscado
	 * 
	 * @param isEdit
	 * Parametro passado como 'true' pelo site para identificar que os dados de uma categoria existente será alterado
	 * 
	 * @param model
	 * Usado para inserir dados em qualquer modelo não sendo especificado qual
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@GetMapping(value = "/{id}")
	public String getById(@PathVariable("id") long id, @RequestParam(required=false) boolean isEdit, Model model) {

		model.addAttribute("categoriaModel", categoriaRepository.findById(id).get());
		
		return CATEGORIA_PATH + (isEdit ? "categoria-editar": "categoria-detalhe");
	}
	
	/**
	 * Método que irá gravar os dados da nova categoria no banco de dados
	 * 
	 * @param categoriaModel
	 * Usado para inserir os dados coletados no modelo de categoria
	 * 
	 * @param bindingResult
	 * Irá conferir se algum dos dados passados está com erro
	 * 
	 * @param redirectAttributes
	 * Irá adicionar uma mensagem ao redirecionar a página
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@PostMapping()
	public String save(@Valid CategoriaModel categoriaModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (!bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("mensagemCategoria", "Categoria cadastrada com sucesso");
			categoriaRepository.save(categoriaModel);
			return "redirect:/categoria";
		} else {
			return CATEGORIA_PATH + "categoria-nova";
		}
	}
	
	/**
	 * Método que irá gravar os dados alterados de uma determinada categoria existente
	 * 
	 * @param categoriaModel
	 * Usado para inserir os dados coletados no modelo de categoria
	 * 
	 * @param bindingResult
	 * Irá conferir se algum dos dados passados está com erro
	 * 
	 * @param redirectAttributes
	 * Irá adicionar uma mensagem ao redirecionar a página
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@PutMapping()
	public String edit(@Valid CategoriaModel categoriaModel, 
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (!bindingResult.hasErrors()) {
			categoriaRepository.save(categoriaModel);
		
			redirectAttributes.addFlashAttribute("mensagemCategoria", "Categoria alterada com sucesso");
			return "redirect:/categoria";
		} else {
			return CATEGORIA_PATH + "categoria-editar";
		}
	}
	
	/**
	 * Método para excluir uma determinada categoria do banco de dados
	 * 	
	 * @param id
	 * Parametro passado pelo site para identificar a categoria que será excluida
	 * 
	 * @param redirectAttributes
	 * Irá adicionar uma mensagem que será exibida para página redirecionada
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		
		categoriaRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("mensagemCategoria", "Categoria excluída com sucesso");
		return "redirect:/categoria";
	}
}
