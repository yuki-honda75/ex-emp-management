package jp.co.sample.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * @author yuki
 *
 */
public class UpdateEmployeeForm {
	/** 従業員ID */
	private String id;
	/** 名前 */
	@NotBlank(message = "名前を入力してください")
	private String name;
	/** 画像 */
	private String image;
	/** 性別 */
	@NotEmpty(message = "選択してください")
	private String gender;
	/** 入社日 */
	@NotBlank(message = "日付を入れてください")
	private String hireDate;
	/** メースアドレス */
	@Email(message = "Eメール形式で入力してください")
	@Size(min = 1, max = 127, message = "1文字以上127文字以下で入力してください")
	private String mailAddress;
	/** 郵便番号 */
	@NotBlank(message = "郵便番号を入力してください")
	@Pattern(regexp = "^[0-9]{3}-[0-9]{4}$", message = "郵便番号形式にしてください")
	private String zipCode;
	/** 住所 */
	@NotBlank(message = "住所を入力してください")
	private String address;
	/** 電話番号 */
	@NotBlank(message = "電話番号を入力してください")
	@Pattern(regexp = "^[0-9]{2,4}-[0-9]{2,4}-[0-9]{2,4}$", message = "電話番号形式にしてください")
	private String telephone;
	/** 給料 */
	@NotBlank(message = "給料を入力してください")
	private String salary;
	/** 特性 */
	@NotBlank(message = "特性を入力してください")
	private String characteristics;
	/** 扶養人数 */
	@NotBlank(message = "扶養人数を入力してください（いない場合は0）")
	@Pattern(regexp = "^[0-9]+$", message = "数値を入力してください")
	private String dependentsCount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHireDate() {
		return hireDate;
	}
	public Date getHireDateFormat(){
		SimpleDateFormat format = new SimpleDateFormat();
		Date hireDateFormat = null;
		try {
			hireDateFormat = format.parse(hireDate);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return hireDateFormat;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public Integer getCharacteristicsInt() {
		return Integer.parseInt(characteristics);
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", name="
				+ name + ", image=" + image + ", gender="
				+ gender + ", hireDate=" + hireDate
				+ ", mailAddress=" + mailAddress
				+ ", zipCode=" + zipCode + ", address="
				+ address + ", telephone=" + telephone
				+ ", salary=" + salary
				+ ", characteristics=" + characteristics
				+ ", dependentsCount=" + dependentsCount
				+ "]";
	}
	
}
