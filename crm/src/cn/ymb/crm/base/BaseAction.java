package cn.ymb.crm.base;

import java.lang.reflect.ParameterizedType;

import cn.ymb.crm.classesm.service.ClassService;
import cn.ymb.crm.coursetype.service.CourseTypeService;
import cn.ymb.crm.department.service.DepartmentService;
import cn.ymb.crm.follow.service.FollowService;
import cn.ymb.crm.graduate.service.GraduateService;
import cn.ymb.crm.post.service.PostService;
import cn.ymb.crm.refer.service.ReferService;
import cn.ymb.crm.runoff.service.RunOffService;
import cn.ymb.crm.staff.service.StaffService;
import cn.ymb.crm.station.service.StationService;
import cn.ymb.crm.student.service.StudentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	
	private Class<T> beanClass;
	
	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			
			ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
			beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
			
			
			t = beanClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	private T t;
	@Override
	public T getModel() {
		return t;
	}

	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	public StaffService getStaffService() {
		return staffService;
	}
	

	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	public PostService getPostService() {
		return postService;
	}

	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	public CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}

	private ClassService classService;
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	public ClassService getClassService() {
		return classService;
	}
	
	private ReferService referService;
	public void setReferService(ReferService referService) {
		this.referService = referService;
	}
	public ReferService getReferService() {
		return referService;
	}
	
	private FollowService followService;
	public void setFollowService(FollowService followService) {
		this.followService = followService;
	}
	public FollowService getFollowService() {
		return followService;
	}
	
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	
	private StationService stationService;
	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}
	public StationService getStationService() {
		return stationService;
	}

	private RunOffService runOffService;
	public void setRunOffService(RunOffService runOffService) {
		this.runOffService = runOffService;
	}
	public RunOffService getRunOffService() {
		return runOffService;
	}
	
	private GraduateService graduateService;
	public void setGraduateService(GraduateService graduateService) {
		this.graduateService = graduateService;
	}
	public GraduateService getGraduateService() {
		return graduateService;
	}

	private int pageNum = 1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageNum() {
		return pageNum;
	}

	private int pageSize = 2;
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	public void put(String key ,Object value){
		ActionContext.getContext().put(key, value);
	}

	public void sessionPut(String key,Object value){
		ActionContext.getContext().getSession().put(key, value);
	}

	public void applicationPut(String key,Object value){
		ActionContext.getContext().getApplication().put(key, value);
	}
	
	public void set(String key ,Object value){
		ActionContext.getContext().getValueStack().set(key, value);
	}

	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}

	public Object get(String o){
		return ActionContext.getContext().get(o);
	}

	public Object sessionGet(String o){
		return ActionContext.getContext().getSession().get(o);
	}

	public Object applicationGet(String o){
		return ActionContext.getContext().getApplication().get(o);
	}
	
	
	
	
}
