package com.example.mra_seas;

public class SpouseDetails {

	private String spouse_nid = "";
	private String spouse_name = "";
	private String spouse_passport_num = "";
	private String spouse_occupation = "";

	public SpouseDetails(String spouse_nid, String spouse_name, String spouse_passport_num, String spouse_occupation) {
		this.spouse_nid = spouse_nid;
		this.spouse_name = spouse_name;
		this.spouse_passport_num = spouse_passport_num;
		this.spouse_occupation = spouse_occupation;
	}

	public String getSpouse_nid() {
		return this.spouse_nid;
	}

	public void setSpouse_nid(String spouse_nid) {
		this.spouse_nid = spouse_nid;
	}

	public String getSpouse_name() {
		return this.spouse_name;
	}

	public void setSpouse_name(String spouse_name) {
		this.spouse_name = spouse_name;
	}

	public String getSpouse_passport_num() {
		return this.spouse_passport_num;
	}

	public void setSpouse_passport_num(String spouse_passport_num) {
		this.spouse_passport_num = spouse_passport_num;
	}

	public String getSpouse_occupation() {
		return this.spouse_occupation;
	}

	public void setSpouse_occupation(String spouse_occupation) {
		this.spouse_occupation = spouse_occupation;
	}

}
