package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 
 * @author yuki
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;
	
	@Autowired
	private HttpSession session;
	/**
	 * 
	 * @return 従業員パラメータ
	 */
	@ModelAttribute 
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}
	/**
	 * 
	 * @return ログイン情報
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	/**
	 * 
	 * @return 登録画面へフォワード
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	/**
	 * 
	 * @param form 管理者情報
	 * @return ログイン画面へリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(
			@Validated InsertAdministratorForm form, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return toInsert();
		}
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		administratorService.insert(administrator);
		return "redirect:/";
	}
	/**
	 * 
	 * @return ログイン画面へフォワード
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	/**
	 * 
	 * @param form ログイン情報
	 * @param model エラーメッセージを格納
	 * @return 従業員一覧へフォワード
	 */
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		if (administrator == null) {
			model.addAttribute("error", "メールアドレスまたはパスワードが不正です。");
			return toLogin();
		}
		
		session.setAttribute("administratorName", administrator.getName());
		return "forward:/employee/showList";
	}
	/**
	 * 
	 * @return ログイン画面へフォワード
	 */
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
