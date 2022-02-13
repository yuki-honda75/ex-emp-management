package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 
 * @author yuki
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	/**
	 * 
	 * @param model 従業員リストを格納するモデル
	 * @return 従業員リストへフォワード
	 */
	@RequestMapping("/showList")
	public String showList(Pageable pageable,Model model) {
		Page<Employee> employeeList = employeeService.showList(pageable);
		model.addAttribute("page", employeeList);
		model.addAttribute("employeeList", employeeList.getContent());
		
		return "employee/list";
	}
	/**
	 * 
	 * @param id 従業員ID
	 * @param model 従業員情報を格納するrequestスコープ
	 * @return 詳細画面へフォワード
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		
		return "employee/detail";
	}
	/**
	 * 
	 * @param form 従業員情報のリクエストパラメータ
	 * @return 詳細画面へリダイレクト
	 */
	@RequestMapping("/update")
	public String update(
			@Validated UpdateEmployeeForm form,
			BindingResult result,
			Model model
			) {
		if (result.hasErrors()) {
			return showDetail(form.getId(), model);
		}
		Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
		System.err.println(form.getHireDate());
		System.err.println(form.getHireDateFormat());
		BeanUtils.copyProperties(form, employee);
		employee.setHireDate(form.getHireDateFormat());
		employee.setSalary(form.getSalaryInt());
		employee.setDependentsCount(form.getDependentsCountInt());
		
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}
}
