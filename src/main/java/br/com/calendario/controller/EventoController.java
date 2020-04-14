package br.com.calendario.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.calendario.entity.Evento;
import br.com.calendario.entity.Login;
import br.com.calendario.repository.EventoRepository;
import br.com.calendario.repository.LoginRepository;

@Controller
public class EventoController {

	@Autowired
	EventoRepository dao;

	@Autowired
	LoginRepository ldao;

	@GetMapping("/")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@GetMapping("/logado")
	public ModelAndView logado(HttpServletRequest request, HttpServletResponse response, HttpSession session) {		
		ModelAndView mv = new ModelAndView("sistema");
		mv.addObject("lista", dao.findAll());
		return mv;
	}

	@GetMapping("/logoff")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView("logout");
		try {
		} catch (Exception ex) {

		}
		return mv;
	}

	@PostMapping(value = "/gravar")
	public ModelAndView gravar(@RequestParam String nome, @RequestParam String data, @RequestParam String horario,
			@RequestParam String descricao, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("sistema");
		try {
			Evento e = new Evento(null, nome, data, horario, descricao);			
			dao.save(e);			
			mv.addObject("lista", dao.findAll());
			mv.addObject("msg", "Dados gravados!");
			response.sendRedirect("/logado");
		} catch (Exception ex) {
			mv.addObject("msg", "Erro: " + ex.getMessage());
		}
		return mv;
	}

	@RequestMapping(value = "/excluir/{cod}")
	public void excluir(@PathVariable Long cod, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("sistema");
		try {
			Evento e = dao.findById(cod).get();
			dao.delete(e);
			mv.addObject("lista", dao.findAll());
			response.sendRedirect("/logado");
		} catch (Exception ex) {
		}
	}

	public static Login criptografar(Login lo) {
		lo.gerarCript();
		return lo;
		}

	
	@PostMapping(value = "/login")
	public void logar(@RequestParam String email, @RequestParam String senha, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		
		try {			
			Login l = new Login(null, null, email, senha);		
			l.gerarCript();
			Login resp = ldao.findByEmailAndSenha(email, l.getSenha());
			
			if (resp != null) {
				session.setAttribute("login", resp);
				response.sendRedirect("logado");
			} else {
				response.sendRedirect("/");
				session.setAttribute("erro", "");

			}
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
	}

}
