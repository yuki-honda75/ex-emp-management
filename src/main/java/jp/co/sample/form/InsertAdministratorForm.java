package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InsertAdministratorForm {
	/** 管理者名 */
	@NotBlank(message = "名前を入力してください")
	private String name;
	/** メールアドレス */
	@Email(message = "Eメール形式で入力してください")
	@Size(min = 1, max = 127, message = "1文字以上127以内で入力してください")
	private String mailAddress;
	/** パスワード */
	@Size(min = 8, max = 15, message = "パスワードは8文字以上15文字以下で入力してください")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name
				+ ", mailAddress=" + mailAddress
				+ ", password=" + password + "]";
	}
}
