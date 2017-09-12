package org.lanqiao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.lanqiao.entity.Msg;
import org.lanqiao.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MsgController {
@Autowired
MsgService msgService;
   

   @RequestMapping("getMsg")
   public String getMsg(String p,HttpSession session){
	   int pageSize = 2;
	   int pageNum = 0;
	   if(p != null){
		   pageNum = Integer.parseInt(p);
	   }else{
		   pageNum = 1;
	   }
	   int maxPage = msgService.getMaxPage();
	   List<Msg> mList = msgService.getMsgByPage(pageNum, pageSize);
	   for (Msg msg : mList) {
		System.out.println(msg);
	}
	   session.setAttribute("mList",mList);
	   session.setAttribute("pageNum",pageNum);
	   session.setAttribute("maxPage",maxPage);
	   return "message";
   }
   
   
   
   @RequestMapping("sendMsg")
   public String sendMsg(Msg msg){
	   Date d= new Date();
	  
	   msg.setTime(d);
	   msgService.insert(msg);
	   return "redirect:getMsg";
   }
   
   
//   @RequestMapping("searchMsg")
//   public String searchMsg(String p,String title,String starTime,String endTime,HttpSession session){
//	   int pageSize = 2;
//	   int pageNum = 1;
//	   if(p != null){
//		   pageNum = Integer.parseInt(p);
//	   }else{
//		   pageNum = 1;
//	   }
//	   int beginPage = pageSize * (pageNum-1);
//	   HashMap<String,Object> searchMap = new HashMap<String,Object>();
//	   SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//	   Date sTime = null;
//	   Date eTime = null;
//			try {
//				if(starTime != null && starTime != ""){
//				   sTime = s.parse(starTime);
//				}
//				if(endTime != null && endTime != ""){
//					eTime = s.parse(endTime);
//				}
//				if(title == ""){
//					title = null;
//				}else{
//					title = "%"+title+"%";
//				}
//				
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	   
//	   searchMap.put("title",title);
//		searchMap.put("starTime", sTime);
//		searchMap.put("endTime", eTime);
//		searchMap.put("pageSize", pageSize);
//		searchMap.put("beginPage", beginPage);
//		int maxPage = msgService.getMaxPageByMsg(searchMap);
//		List<Msg> mList = msgService.searchMsg(searchMap);
//		session.setAttribute("mList",mList);
//		session.setAttribute("pageNum",pageNum);
//	    session.setAttribute("maxPage",maxPage);
//		return "message";
//   }
   @RequestMapping("searchMsg")
   public String searchMsg1(String p,Map<String, Object> searchMap,HttpSession session){
	   int pageSize = 2;
	   int pageNum = 1;
	   if(p != null){
		   pageNum = Integer.parseInt(p);
	   }else{
		   pageNum = 1;
	   }
	   int beginPage = pageSize * (pageNum-1);
	   searchMap.put("pageSize", pageSize);
	   searchMap.put("beginPage", beginPage);
	   int maxPage = msgService.getMaxPageByMsg(searchMap);
	   List<Msg> mList = msgService.searchMsg(searchMap);
	   session.setAttribute("mList",mList);
	   session.setAttribute("pageNum",pageNum);
	   session.setAttribute("maxPage",maxPage);
	   return "message";
   }
}
