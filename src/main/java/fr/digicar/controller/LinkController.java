package fr.digicar.controller;

import fr.digicar.model.Team;
import fr.digicar.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LinkController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		ModelAndView modelAndView = new ModelAndView("home");

		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("users", teams);

		return modelAndView;
	}
	@RequestMapping(value="/index")
	public ModelAndView indexPage() {

		ModelAndView modelAndView = new ModelAndView("home");

		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("users", teams);

		return modelAndView;
	}
}
