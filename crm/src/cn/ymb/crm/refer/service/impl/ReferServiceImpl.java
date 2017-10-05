package cn.ymb.crm.refer.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.ymb.crm.refer.dao.ReferDao;
import cn.ymb.crm.refer.service.ReferService;
import cn.ymb.crm.refer.domain.CrmRefer;
import cn.ymb.crm.utils.CrmBeanUtils;

public class ReferServiceImpl implements ReferService {
	
	private ReferDao referDao;
	public void setReferDao(ReferDao referDao) {
		this.referDao = referDao;
	}
	@Override
	public void addOrEdit(CrmRefer crmRefer) {
		this.referDao.saveOrUpdate(crmRefer);
	}
	@Override
	public List<CrmRefer> findAll() {
		return this.referDao.findAll();
	}
	@Override
	public CrmRefer findById(String referId) {
		return this.referDao.findById(referId);
	}
	@Override
	public List<CrmRefer> findAll(CrmRefer crmRefer) {
		
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		builder.append(" and status = ?");
		paramsList.add(crmRefer.getStatus());

		if(crmRefer.getCondition() != null && !"".equals(crmRefer.getCondition())){

			builder.append(" and (name like ?");
			paramsList.add("%"+crmRefer.getCondition()+"%");

			builder.append(" or qq like ?");
			paramsList.add("%"+crmRefer.getCondition()+"%");
			builder.append(" or telephone like ?)");
			paramsList.add("%"+crmRefer.getCondition()+"%");
		}
		
		return this.referDao.findAll(builder.toString(), paramsList.toArray());
	}
	@Override
	public void addRefer(CrmRefer crmRefer) {
		// TODO 如何设置关联数据为""
		if(crmRefer.getCrmClass() != null && "".equals(crmRefer.getCrmClass().getClassId())){
			crmRefer.setCrmClass(null);
		}
		if(crmRefer.getCrmCourseType() != null && "".equals(crmRefer.getCrmCourseType().getCourseTypeId())){
			crmRefer.setCrmCourseType(null);
		}
		
		this.referDao.save(crmRefer);
	}
	@Override
	public void updateRefer(CrmRefer crmRefer) {
		CrmRefer findRefer = this.referDao.findById(crmRefer.getReferId());
	
		CrmBeanUtils.changeProperty(crmRefer,findRefer);
		
		if(crmRefer.getCrmClass() != null && "".equals(crmRefer.getCrmClass().getClassId())){
			findRefer.setCrmClass(null);
		}
		if(crmRefer.getCrmCourseType() != null && "".equals(crmRefer.getCrmCourseType().getCourseTypeId())){
			findRefer.setCrmCourseType(null);
		}
	}

}
