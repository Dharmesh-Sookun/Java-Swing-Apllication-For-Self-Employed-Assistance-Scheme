package com.example.mra_seas;

public class BankAccountDetails {

	private String bankName = "";
	private String account_holder_name = "";
	private String bank_account_num = "";

	public BankAccountDetails(String bankName, String account_holder_name, String bank_account_num) {
		this.bankName = bankName;
		this.account_holder_name = account_holder_name;
		this.bank_account_num = bank_account_num;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccount_holder_name() {
		return this.account_holder_name;
	}

	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}

	public String getBank_account_num() {
		return this.bank_account_num;
	}

	public void setBank_account_num(String bank_account_num) {
		this.bank_account_num = bank_account_num;
	}

}
