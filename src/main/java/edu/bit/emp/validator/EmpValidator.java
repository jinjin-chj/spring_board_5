package edu.bit.emp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.bit.emp.vo.EmpVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class EmpValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		// ������ EmpVO�� Ÿ�� ������ ����
		return EmpVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		log.info("validate()");
		EmpVO empVO = (EmpVO) obj;

		int empno = empVO.getEmpno();
		if (empno == 0) {
			log.info("empno is 0");
			errors.rejectValue("empno", "trouble", "wrong empno");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empno", "trouble");
	}
}