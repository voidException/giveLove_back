package org.geilove.controller;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.vo.FollowVo;
import org.geilove.pojo.DoubleFans;
import org.geilove.requestParam.FollowParam;
import org.geilove.service.WatchService;
@Controller
@RequestMapping("/watch")
public class Watch {
	//调用service层，还没
	@Resource
	private WatchService watchService;
	
	
	@RequestMapping(value="/dowatch",method=RequestMethod.POST)
	public @ResponseBody FollowVo doWatch(@RequestBody FollowParam followParam ){
		FollowVo followVo=new FollowVo();
		DoubleFans  dbfans=new DoubleFans();
		dbfans.setUseridfollowe(followParam.getUserIDFollow());
	    dbfans.setUseridbefocus(followParam.getUserIDBeFocus());
	    dbfans.setPaytag(followParam.getPaytag());
	    Date date=new Date();
	    dbfans.setPaydate(date);
	    dbfans.setGroupid((byte)1);
	    dbfans.setSpecialfollow((byte)1);
	    dbfans.setDoublefans((byte)1);
	    Integer tag=watchService.doWatch(dbfans);	
	    followVo.setWathctag(tag);
	    if(tag==1){
	    	
	    	followVo.setWatchtips("成功了");
	    }else{
	    	followVo.setWatchtips("失败了");;
	    }
	    
	    
		return followVo ;
	}
	

}














