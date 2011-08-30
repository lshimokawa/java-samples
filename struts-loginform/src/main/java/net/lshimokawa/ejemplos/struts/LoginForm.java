package net.lshimokawa.ejemplos.struts;

import org.apache.struts.action.ActionForm;

/**
 * @author Lennon Shimokawa
 */
public class LoginForm extends ActionForm {
	private static final long serialVersionUID = -6899216448826597352L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
