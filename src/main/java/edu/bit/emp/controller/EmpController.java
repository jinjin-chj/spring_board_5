package edu.bit.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.bit.emp.service.EmpService;
import edu.bit.emp.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class EmpController {

	private EmpService empService;

	@GetMapping("/tables")
	public void list(Model model) {
		log.info("tables");
		model.addAttribute("tables", empService.getList());
	}

	@GetMapping("/insert")
	public String insert_view(EmpVO empVO) throws Exception {
		log.info("insert_view");
		empService.insertEmp(empVO);
		return "insert_view.jsp";
	}

}