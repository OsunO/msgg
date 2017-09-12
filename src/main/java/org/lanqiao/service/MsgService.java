package org.lanqiao.service;

import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Msg;

public interface MsgService {
    List<Msg> getMsgByPage(int pageNum,int pageSize);
    
    int getMaxPage();
    int getMaxPageByMsg(Map map);
    
    List<Msg> searchMsg(Map map);

    int insert(Msg record);

}
