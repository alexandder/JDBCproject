package com.example.simplemyjdbc.domian;

public class Coal {
	
	private long id;
	private String name;
	private String type;
	private int percentOfCarbon;
	
	public Coal() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPercentOfCarbon() {
		return percentOfCarbon;
	}
	public void setPercentOfCarbon(int percentOfCarbon) {
		this.percentOfCarbon = percentOfCarbon;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public Coal(String name, String type, int percentOfCarbon) {
		super();
		this.name = name;
		this.type = type;
		this.percentOfCarbon = percentOfCarbon;
	}
	
}
