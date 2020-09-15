package br.com.devmidia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devmidia.domain.Playlist;
import br.com.devmidia.service.PlayListService;

@Controller
@RequestMapping("playlists")
public class PlayListController {
	@Autowired
	private PlayListService playListService;

	@GetMapping("/listar")
	public ModelAndView ModelAndView(ModelMap model) {
		model.addAttribute("playlists", playListService.recuperar());
		return new ModelAndView("/playlist/list", model);
	}

	@GetMapping("cadastro")
	public String preSalvar(@ModelAttribute("playlist") Playlist playList) {
		return "/playlist/add";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/playlist/add";
		}

		playListService.salvar(playlist);
		attr.addFlashAttribute("mensagem", "Playlist criada com sucesso.");
		return "redirect:/playlists/listar";
	}

	@GetMapping("/{id}/atualizar")
	public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
		Playlist playlist = playListService.recuperarPorId(id);
		model.addAttribute("playlist", playlist);
		return new ModelAndView("/playlist/add", model);
	}

	@PutMapping("/salvar")
	public String atualizar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/playlist/add";
		}
		playListService.atualizar(playlist);
		attr.addFlashAttribute("mensagem", "Playlist atualizada com sucesso.");
		return "redirect:/playlists/listar";
	}
	
	@GetMapping("/{id}/remover")
	public String remover(@PathVariable("id") long id,
	 RedirectAttributes attr) {
		playListService.excluir(id);
	   attr.addFlashAttribute("mensagem", "Playlist excluída com sucesso.");
	   return "redirect:/playlists/listar";
	}
}
