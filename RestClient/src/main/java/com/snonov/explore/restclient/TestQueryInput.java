package com.snonov.explore.restclient;

public class TestQueryInput {

	private String inputName;
	private String inputValue;
	private boolean isOk;
	
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	public String getInputValue() {
		return inputValue;
	}
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	@Override
	public String toString() {
		return "TestQueryInput [inputName=" + inputName + ", inputValue=" + inputValue + ", isOk=" + isOk + "]";
	}
	
}
