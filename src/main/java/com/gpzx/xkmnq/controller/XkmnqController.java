package com.gpzx.xkmnq.controller;

import com.gpzx.xkmnq.domain.Xiake;
import com.gpzx.xkmnq.po.XiakePo;
import com.gpzx.xkmnq.service.XiakeService;
import com.gpzx.xkmnq.service.impl.XiakeServiceImpl;
import com.gpzx.xkmnq.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName XkmnqController
 * @Author admin
 * @Date 2020/3/14 15:36
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/xkmnq")
public class XkmnqController {

    @Autowired
    private XiakeService xiakeService;
   /**
    * @Author Gengpeng
    * @Description //TODO
    * @Date 15:58 2020/3/14
    * @Param  Array[data{ },data{ }... ]
    *
    * @return com.gpzx.xkmnq.vo.ResultVo
    **/
   @GetMapping(value = "/findPingfen")
   public ResultVo getPingfen(List<XiakePo> xiakePos){
       //1 根据前台传入的po数组  用等级 名字 两个参数查询侠客数据
       //2 将查询结果放入list  代入计算规则  返回评分对象给前台
       List<Xiake> xiakeList=new ArrayList<>();
       for (XiakePo xiaokepo:xiakePos) {
        Xiake xiake=xiakeService.findByNameAndLevel(xiaokepo.getName(),xiaokepo.getLevel());
       }


       return null;
   }

}
