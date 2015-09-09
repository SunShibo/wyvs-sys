package com.wyvs.wp.entity;
import java.io.Serializable;
import java.util.Date;

public class TaskDo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**0锁定状态、1可用状态、2未激活状态*/
	public static final int ENABLEDSTATE_DISABLED = 0 ;
	public static final int ENABLEDSTATE_ABLE = 1 ;
	public static final int ENABLEDSTATE_NONACTIVATED = 2 ;

	/**性别 0女、1男*/
	public static final int GENDER_MALE = 1 ;
	public static final int GENDER_FEMALE = 0 ;

	/**1正常状态，2退会状态*/
	public static final int STATE_FORMAL = 1 ;
	public static final int STATE_QUIT = 2 ;

	private Integer id; //主键
	private String subject ;//主题
	private Date createTime ;//创建时间
	private Date endTime ;//计划结束时间
	private String content ;//内容
	private String status ;//状态
	private String level ;//任务级别
	private Date finishTime ;//最总完成时间
	private Integer createUser ;//创建人

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
}

