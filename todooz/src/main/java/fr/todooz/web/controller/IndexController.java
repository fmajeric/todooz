package fr.todooz.web.controller;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.todooz.domain.DummyData;
import fr.todooz.domain.Task;
import fr.todooz.service.TaskService;

@Controller
public class IndexController {
	@Inject
	private TaskService taskService;

	@RequestMapping({ "/", "/index" })
	public String index(Model model) {
		model.addAttribute("tasks", DummyData.tasks());

		return "index";
	}
	
	@PostConstruct
	public void bootstrap() {
		if (taskService == null){
		  
		}

	}

}
