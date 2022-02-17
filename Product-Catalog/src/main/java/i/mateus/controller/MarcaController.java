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

import i.mateus.model.MarcaModel;
import i.mateus.repository.MarcaRepository;


/**
 * O Controller tem a função de interligar o View com o Model
 * Fazendo assim com que a página de marca consiga acessar o modelo para gravar, buscar e deletar os dados de um banco
 * 
 * @author Mateus I
 *
 */
@Controller
@RequestMapping("/marca")
public class MarcaController {
	private static final String MARCA_PATH = "marca/";

	@Autowired
	public MarcaRepository marcaRepository;
	
	/**
	 * Método que ira buscar as marcas gravadas ou inserir uma nova marca no banco de dados
	 * 
	 * @param isNew
	 * Parametro passado como 'true' pelo site para identificar se a marca é nova e que precisa ser gravada
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
			model.addAttribute("marcaModel", new MarcaModel());	
		} else {
			model.addAttribute("marcas", marcaRepository.findAll());	
		}
		
		return MARCA_PATH + (isNew ? "marca-nova" : "marcas");
	}
	
	/**
	 * Método que irá buscar uma marca especifica podendo alterar os dados
	 * 
	 * @param id
	 * Parametro passado pelo site para identificar o código da marca que deverá ser buscado
	 * 
	 * @param isEdit
	 * Parametro passado como 'true' pelo site para identificar que os dados de uma marca existente será alterado
	 * 
	 * @param model
	 * Usado para inserir dados em qualquer modelo não sendo especificado qual
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@GetMapping(value = "/{id}")
	public String getById(@PathVariable("id") long id, @RequestParam(required=false) boolean isEdit, Model model) {

		model.addAttribute("marcaModel", marcaRepository.findById(id).get());
		
		return MARCA_PATH + (isEdit ? "marca-editar": "marca-detalhe");
	}


	/**
	 * Método que irá gravar os dados da nova marca no banco de dados
	 * 
	 * @param categoriaModel
	 * Usado para inserir os dados coletados no modelo de marca
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
	public String save(@Valid MarcaModel marcaModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (!bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("mensagemMarca", "Marca cadastrada com sucesso");
			marcaRepository.save(marcaModel);
			return "redirect:/marca";
		} else {
			return MARCA_PATH + "marca-nova";
		}
	}

	/**
	 * Método que irá gravar os dados alterados de uma determinada marca existente
	 * 
	 * @param categoriaModel
	 * Usado para inserir os dados coletados no modelo de marca
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
	public String edit(@Valid MarcaModel MarcaModel, 
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (!bindingResult.hasErrors()) {
			marcaRepository.save(MarcaModel);
		
			redirectAttributes.addFlashAttribute("mensagemMarca", "Marca alterada com sucesso");
			return "redirect:/marca";
		} else {
			return MARCA_PATH + "marca-editar";
		}
	}
	
	/**
	 * Método para excluir uma determinada marca do banco de dados
	 * 	
	 * @param id
	 * Parametro passado pelo site para identificar a marca que será excluida
	 * 
	 * @param redirectAttributes
	 * Irá adicionar uma mensagem que será exibida para página redirecionada
	 * 
	 * @return
	 * Irá retornar o endereço da página que será encaminhado
	 */
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		
		marcaRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("mensagemMarca", "Marca excluída com sucesso");
		return "redirect:/marca";
	}
	
}
