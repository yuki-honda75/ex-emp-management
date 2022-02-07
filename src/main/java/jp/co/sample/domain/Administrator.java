package jp.co.sample.domain;

/**
 * 
 * @author yuki
 *
 */
public class Administrator {
	/** 管理者ID */
	private Integer id;
	/** 管理者名 */
	private String name;
	/** 管理者メールアドレス */
	private String mailAddress;
	/** 管理者パスワード */
	private String password;
	
	public Administrator() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public Administrator(Integer id, String name,
			String mailAddress, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mailAddress = mailAddress;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
		return "Administrator [id=" + id + ", name=" + name
				+ ", mailAddress=" + mailAddress
				+ ", password=" + password + "]";
	}
}
