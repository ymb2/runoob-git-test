package cn.ymb.crm.station.service.impl;

import java.util.List;

import cn.ymb.crm.classesm.dao.ClassDao;
import cn.ymb.crm.constant.CommonConstant;
import cn.ymb.crm.station.dao.StationDao;
import cn.ymb.crm.station.service.StationService;
import cn.ymb.crm.classesm.domain.CrmClass;
import cn.ymb.crm.station.domain.CrmStation;
import cn.ymb.crm.student.dao.StudentDao;
import cn.ymb.crm.student.domain.CrmStudent;

public class StationServiceImpl implements StationService {
	
	private StationDao stationDao;
	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	private ClassDao classDao;
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	@Override
	public void addStation(CrmStation crmStation) {
		CrmStudent crmStudent = this.studentDao.findById(crmStation.getCrmStudent().getStudentId());
		crmStudent.setStatus(crmStation.getFlag());
		crmStudent.setCrmClass(crmStation.getAfterClass());
		
		CrmClass beforeClass = this.classDao.findById(crmStation.getBeforeClass().getClassId());
		CrmClass afterClass = this.classDao.findById(crmStation.getAfterClass().getClassId());
		beforeClass.setTotalCount(beforeClass.getTotalCount() -1);
		afterClass.setTotalCount(afterClass.getTotalCount() + 1);
		
		if(CommonConstant.STUDENT_STATUS_UPGRADE.equals(crmStation.getFlag())){
			beforeClass.setUpgradeCount(beforeClass.getUpgradeCount() + 1);
		}
		if(CommonConstant.STUDENT_STATUS_CHANGE.equals(crmStation.getFlag())){
			beforeClass.setChangeCount(beforeClass.getChangeCount() + 1);
		}
		
		
		this.stationDao.save(crmStation);
	}
	@Override
	public List<CrmStation> findAll() {
		return this.stationDao.findAll();
	}
	
	

}
