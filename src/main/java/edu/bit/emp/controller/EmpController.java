package edu.bit.emp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.emp.page.Criteria;
import edu.bit.emp.page.PageVO;
import edu.bit.emp.service.EmpService;
import edu.bit.emp.validator.EmpValidator;
import edu.bit.emp.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class EmpController {
	private EmpService empService;

	// ���� ����Ʈ
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", empService.getList());
		log.info("list()");
	}

	// ���� ���� �ۼ� ������
	@Transactional
	@GetMapping("/insert_view")
	public void write_view(Model model) throws Exception {
		model.addAttribute("jobList", empService.jobList());
		model.addAttribute("mgrList", empService.mgrList());
		model.addAttribute("deptList", empService.deptList());
		log.info("write_view()");
	}

	// ���� ���� �ۼ�
	@PostMapping("/write")
	public String write(@Validated EmpVO empVO, BindingResult result) {
		log.info("write()");
		empService.write(empVO); // �̰� �� �ؼ� DB�� �� �־����� �־���.

		String page = "redirect:main";
		EmpValidator validator = new EmpValidator();
		validator.validate(empVO, result);

		if (result.hasErrors()) {
			page = "redirect:insert_view";
			List<FieldError> list = result.getFieldErrors();

			if (null != result.getFieldErrors()) {
				for (FieldError fe : result.getFieldErrors()) {
					log.info("Field: " + fe.getField());
					log.info("Code: " + fe.getCode());
					log.info("ObjectName: " + fe.getObjectName());
					log.info("RejectedValue: " + fe.getRejectedValue());
					log.info("DefaultMessage: " + fe.getDefaultMessage());
					// log.info("�����޽���: " + fe.getCode());
				}
			}
		}
		return page;
	}

	@GetMapping("/tables")
	public void tables(Criteria cri, Model model) {
		log.info("tables() ȣ��");
		log.info(cri);
		System.out.println(cri);

		model.addAttribute("list", empService.getList(cri));

		int total = empService.getTotal(cri);
		log.info("total : " + total);
		model.addAttribute("pageMaker", new PageVO(cri, total));
	}

}