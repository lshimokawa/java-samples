package net.lshimokawa.ejemplos.springwebmvc;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author lshimokawa
 * 
 */
public class ValidatorTestBean {
	@NotEmpty
	private String notEmpty;

	@NotBlank
	private String notBlank;

	@Email
	private String email;

	@Digits(integer = 4, fraction = 0)
	private Integer integer;
	
	public String getNotEmpty() {
		return notEmpty;
	}

	public void setNotEmpty(String notEmpty) {
		this.notEmpty = notEmpty;
	}

	public String getNotBlank() {
		return notBlank;
	}

	public void setNotBlank(String notBlank) {
		this.notBlank = notBlank;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer number) {
		this.integer = number;
	}

}
