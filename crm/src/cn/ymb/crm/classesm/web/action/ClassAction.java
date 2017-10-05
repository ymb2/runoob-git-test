package cn.ymb.crm.classesm.web.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.classesm.domain.CrmClass;
import cn.ymb.crm.constant.CommonConstant;
import cn.ymb.crm.coursetype.domain.CrmCourseType;
import cn.ymb.crm.utils.StringUtils;

public class ClassAction extends BaseAction<CrmClass> {

	private static final long serialVersionUID = 86868674223663L;
	

	public String findAll(){
		List<CrmClass> allClass = this.getClassService().findAll();
		this.set("allClass", allClass);
		return "findAll";
	}
	

	public String preAddOrEdit(){

		if(this.getModel().getClassId() != null){
			CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
			this.push(findClass);
		}

		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.set("allCourseType", allCourseType);
		return "preAddOrEdit";
	}

	public String addOrEdit(){
		this.getClassService().addOrEdit(this.getModel());
		return "addOrEdit";
	}

	public String findById(){
		CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
		this.push(findClass);
		return "findById";
	}

	public String ajaxGetClass(){
		List<CrmClass> allClass = this.getClassService().findAll(this.getModel().getCrmCourseType());
		this.put("allClass", allClass);
		return "ajaxGetClass";
	}
	

	public String preUpload(){
		CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
		this.push(findClass);
		return "preUpload";
	}

	private File schedule;
	private String scheduleFileName;
	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}
	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}
	
	public String upload(){
		
		try {

			String parentDir = ServletActionContext.getServletContext().getRealPath(CommonConstant.CLASS_SCHEDULE_DIR);
			String randomName = StringUtils.getUUID();
			File target = new File(parentDir, randomName);
			FileUtils.copyFile(schedule, target);

			this.getModel().setUploadPath(CommonConstant.CLASS_SCHEDULE_DIR + "/" + randomName);
			this.getModel().setUploadFilename(scheduleFileName);
			
			this.getClassService().updateSchedule(this.getModel());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			this.addFieldError("uploadTime", "上传有误" + e.getMessage());
			return "input";
		}
		return "upload";
	}

	public String download(){
		CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
		InputStream is = ServletActionContext.getServletContext().getResourceAsStream(findClass.getUploadPath());
		if(is == null){
			this.addFieldError("uploadFilename", "课表已经不存在，请重新上传");
			return "input";
		}
		this.target = is;
		this.downloadFileName = findClass.getUploadFilename();
		
		return "download";
	}
	private InputStream target;
	public InputStream getTarget() {
		return target;
	}
	private String downloadFileName;
	public String getDownloadFileName() throws UnsupportedEncodingException {
		if(downloadFileName != null){
			return new String(downloadFileName.getBytes(),"ISO-8859-1");
		}
		return downloadFileName;
	}
	
	
	
	
	
}
