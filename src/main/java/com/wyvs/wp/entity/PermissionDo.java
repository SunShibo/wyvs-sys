package com.wyvs.wp.entity;
import java.io.Serializable;
import java.util.Date;

public class PermissionDo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id; //主键

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

