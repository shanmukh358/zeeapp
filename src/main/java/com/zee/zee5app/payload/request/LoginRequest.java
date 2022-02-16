package com.zee.zee5app.payload.request;

import javax.validation.constraints.*;


public class LoginRequest {
	   @NotBlank
	   private String username;

		@NotBlank
		private String password;

		public String getusername() {
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