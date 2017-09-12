package org.lanqiao.dao;

import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Msg;

public interface MsgDao {
    int deleteByPrimaryKey(Integer msgId);

    int insert(Msg record);

    int insertSelective(Msg record);

    Msg selectByPrimaryKey(Integer msgId);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);
    List<Msg> getMsgByPage(int pageNum,int pageSize);
    
    int getMaxPage();
    int getMaxPageByMsg(Map map);
    
    List<Msg> searchMsg(Map map);

}