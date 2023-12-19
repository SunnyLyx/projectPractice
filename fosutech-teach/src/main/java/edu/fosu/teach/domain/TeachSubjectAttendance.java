package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 作业统计表 teach_subject_attendance
 *  */
public class TeachSubjectAttendance extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	@Id
	private Integer id;
	/** 班级ID */
	private String classId;
	/** 项目ID */
	private String subjectId;
	/** 项目开始时间 */
	private Date attendanceStarttime;
	/** 项目结束时间 */
	private Date attendanceEndtime;
	/** 项目名称 */
	private String subjectname;
	/** 作业优人数 */
	private Integer bestnum;
	/** 作业良人数 */
	private Integer goodnum;
	/** 作业差人数 */
	private Integer poornum;
	/** 作业未完成人数 */
	private Integer unfinishednum;
	/** 班级总人数 */
	private Integer studentnum;
	/** 作业优占比 */
	private String bestAttendance;
	/** 作业良占比 */
	private String goodAttendance;
	/** 作业差占比 */
	private String poorAttendance;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setClassId(String classId) 
	{
		this.classId = classId;
	}

	public String getClassId() 
	{
		return classId;
	}
	public void setSubjectId(String subjectId) 
	{
		this.subjectId = subjectId;
	}

	public String getSubjectId() 
	{
		return subjectId;
	}
	public void setAttendanceStarttime(Date attendanceStarttime) 
	{
		this.attendanceStarttime = attendanceStarttime;
	}

	public Date getAttendanceStarttime() 
	{
		return attendanceStarttime;
	}
	public void setAttendanceEndtime(Date attendanceEndtime) 
	{
		this.attendanceEndtime = attendanceEndtime;
	}

	public Date getAttendanceEndtime() 
	{
		return attendanceEndtime;
	}
	public void setSubjectname(String subjectname) 
	{
		this.subjectname = subjectname;
	}

	public String getSubjectname() 
	{
		return subjectname;
	}
	public void setBestnum(Integer bestnum) 
	{
		this.bestnum = bestnum;
	}

	public Integer getBestnum() 
	{
		return bestnum;
	}
	public void setGoodnum(Integer goodnum) 
	{
		this.goodnum = goodnum;
	}

	public Integer getGoodnum() 
	{
		return goodnum;
	}
	public void setPoornum(Integer poornum) 
	{
		this.poornum = poornum;
	}

	public Integer getPoornum() 
	{
		return poornum;
	}
	public void setUnfinishednum(Integer unfinishednum) 
	{
		this.unfinishednum = unfinishednum;
	}

	public Integer getUnfinishednum() 
	{
		return unfinishednum;
	}
	public void setStudentnum(Integer studentnum) 
	{
		this.studentnum = studentnum;
	}

	public Integer getStudentnum() 
	{
		return studentnum;
	}
	public void setBestAttendance(String bestAttendance) 
	{
		this.bestAttendance = bestAttendance;
	}

	public String getBestAttendance() 
	{
		return bestAttendance;
	}
	public void setGoodAttendance(String goodAttendance) 
	{
		this.goodAttendance = goodAttendance;
	}

	public String getGoodAttendance() 
	{
		return goodAttendance;
	}
	public void setPoorAttendance(String poorAttendance) 
	{
		this.poorAttendance = poorAttendance;
	}

	public String getPoorAttendance() 
	{
		return poorAttendance;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classId", getClassId())
            .append("subjectId", getSubjectId())
            .append("attendanceStarttime", getAttendanceStarttime())
            .append("attendanceEndtime", getAttendanceEndtime())
            .append("subjectname", getSubjectname())
            .append("bestnum", getBestnum())
            .append("goodnum", getGoodnum())
            .append("poornum", getPoornum())
            .append("unfinishednum", getUnfinishednum())
            .append("studentnum", getStudentnum())
            .append("bestAttendance", getBestAttendance())
            .append("goodAttendance", getGoodAttendance())
            .append("poorAttendance", getPoorAttendance())
            .toString();
    }
}
