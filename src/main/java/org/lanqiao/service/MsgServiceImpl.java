package org.lanqiao.service;

import java.util.List;
import java.util.Map;

import org.lanqiao.dao.MsgDao;
import org.lanqiao.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MsgServiceImpl implements MsgService{
@Autowired
MsgDao msgDao;
	
	@Override
	public List<Msg> getMsgByPage(int pageNum, int pageSize) {
		return msgDao.getMsgByPage(pageSize*(pageNum-1), pageSize);
	}

	@Override
	public int getMaxPage() {
			int num = msgDao.getMaxPage();
			if(num%2==0){
				num = num/2;
			}else{
				num = num/2+1;
			}
			return num;
	}

	@Override
	public int getMaxPageByMsg(Map map) {
		int num = msgDao.getMaxPageByMsg(map);
		if(num%2==0){
			num = num/2;
		}else{
			num = num/2+1;
		}
		return num;
	}

	@Override
	public List<Msg> searchMsg(Map map) {
		return msgDao.searchMsg(map);
	}


	@Override
	public int insert(Msg record) {
		return msgDao.insert(record);
	}

}
