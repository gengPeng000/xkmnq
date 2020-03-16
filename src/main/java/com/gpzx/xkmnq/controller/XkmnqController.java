package com.gpzx.xkmnq.controller;

import com.gpzx.xkmnq.dao.JiachengRespostory;
import com.gpzx.xkmnq.dao.MapperRespostory;
import com.gpzx.xkmnq.domain.Jiacheng;
import com.gpzx.xkmnq.domain.Xiake;
import com.gpzx.xkmnq.eunm.No;
import com.gpzx.xkmnq.po.XiakePo;
import com.gpzx.xkmnq.service.JiachengService;
import com.gpzx.xkmnq.service.XiakeService;
import com.gpzx.xkmnq.service.impl.XiakeServiceImpl;
import com.gpzx.xkmnq.vo.ResultVo;
import com.gpzx.xkmnq.vo.ShuXingVo;
import com.gpzx.xkmnq.vo.ShuxingPingfenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @Autowired
    private JiachengService jiachengService;
    @Autowired
    private MapperRespostory mapperrespostory;
    @Autowired
    private JiachengRespostory respostory;
   /**
    * @Author Gengpeng
    * @Description //TODO
    * @Date 15:58 2020/3/14
    * @Param  Array[data{ },data{ }... ]
    *
    * @return com.gpzx.xkmnq.vo.ResultVo
    **/
   @PostMapping (value = "/findPingfen")
   public ResultVo getPingfen(@RequestBody List<XiakePo> xiakePos){
//       System.out.println(xiakePoarray.length);
       //1 根据前台传入的po数组  用等级 名字 两个参数查询侠客数据
       //2 将查询结果放入list  代入计算规则  返回评分对象给前台
//       List<XiakePo> xiakePos=new ArrayList<>();
////       for (XiakePo xiakePo:xiakePoarray) {
//           xiakePos.add(xiakePo);
////       }
       ResultVo resultVo=new ResultVo();
       ShuxingPingfenVo shuxingPingfenVo=new ShuxingPingfenVo();
       ShuXingVo shuXingVo=new ShuXingVo();
       List<Map<String,Double>> maps = getJiacheng(xiakePos);
       shuXingVo=getShuxingVo(shuXingVo,xiakePos);
       //用侠客列表xiakeList  和加成列表maps 来计算评分
       int pingfen=getPingfen(shuXingVo,maps);
       shuxingPingfenVo.setJiachengMaps(maps);
       shuxingPingfenVo.setShuXingVo(shuXingVo);
       shuxingPingfenVo.setPingfen(pingfen);
       resultVo.setCode(1);
       resultVo.setMsg("成功");
       resultVo.setData(shuxingPingfenVo);
       return resultVo;
   }

   //取得属性VO
    public  ShuXingVo getShuxingVo(ShuXingVo shuXingVo,List<XiakePo> xiakePos){
        List<Xiake> xiakeList=new ArrayList<>();
        int sumqixue=0;
        int sumgongji=0;
        int sumshanbi=0;
        int summingzhong=0;
        int sumbaoji=0;
        int sumkangbao=0;
        int sumgedang=0;
        int sumpofang=0;
        for (XiakePo xiaokepo:xiakePos) {
            //亲密度
            int qinmidu=xiaokepo.getQinmidu();
            Xiake xiake=xiakeService.findByNameAndLevelAndQinmidu(xiaokepo.getName(),xiaokepo.getLevel(),qinmidu);
            xiakeList.add(xiake);
            //设置返回前台的属性VO
            if(No.YI.getNumber()==xiaokepo.getNumber()){
                sumqixue+= new Double(xiake.getQixue()*No.YI.getJiacheng()).intValue();
                sumgongji+= new Double(xiake.getGongji()*No.YI.getJiacheng()).intValue();
                sumshanbi+= new Double(xiake.getShanbi()*No.YI.getJiacheng()).intValue();
                summingzhong+= new Double(xiake.getMingzhong()*No.YI.getJiacheng()).intValue();
                sumbaoji+= new Double(xiake.getBaoji()*No.YI.getJiacheng()).intValue();
                sumkangbao+= new Double(xiake.getKangbao()*No.YI.getJiacheng()).intValue();
                sumgedang+= new Double(xiake.getGedang()*No.YI.getJiacheng()).intValue();
                sumpofang+= new Double(xiake.getPofang()*No.YI.getJiacheng()).intValue();
            }
            if(No.ER.getNumber()==xiaokepo.getNumber()){
                sumqixue+= new Double(xiake.getQixue()*No.ER.getJiacheng()).intValue();
                sumgongji+= new Double(xiake.getGongji()*No.ER.getJiacheng()).intValue();
                sumshanbi+= new Double(xiake.getShanbi()*No.ER.getJiacheng()).intValue();
                summingzhong+= new Double(xiake.getMingzhong()*No.ER.getJiacheng()).intValue();
                sumbaoji+= new Double(xiake.getBaoji()*No.ER.getJiacheng()).intValue();
                sumkangbao+= new Double(xiake.getKangbao()*No.ER.getJiacheng()).intValue();
                sumgedang+= new Double(xiake.getGedang()*No.ER.getJiacheng()).intValue();
                sumpofang+= new Double(xiake.getPofang()*No.ER.getJiacheng()).intValue();
            }
            if(No.SAN.getNumber()==xiaokepo.getNumber()){
                sumqixue+= new Double(xiake.getQixue()*No.SAN.getJiacheng()).intValue();
                sumgongji+= new Double(xiake.getGongji()*No.SAN.getJiacheng()).intValue();
                sumshanbi+= new Double(xiake.getShanbi()*No.SAN.getJiacheng()).intValue();
                summingzhong+= new Double(xiake.getMingzhong()*No.SAN.getJiacheng()).intValue();
                sumbaoji+= new Double(xiake.getBaoji()*No.SAN.getJiacheng()).intValue();
                sumkangbao+= new Double(xiake.getKangbao()*No.SAN.getJiacheng()).intValue();
                sumgedang+= new Double(xiake.getGedang()*No.SAN.getJiacheng()).intValue();
                sumpofang+= new Double(xiake.getPofang()*No.SAN.getJiacheng()).intValue();
            }
            if(No.SI.getNumber()==xiaokepo.getNumber()){
                sumqixue+= new Double(xiake.getQixue()*No.SI.getJiacheng()).intValue();
                sumgongji+= new Double(xiake.getGongji()*No.SI.getJiacheng()).intValue();
                sumshanbi+= new Double(xiake.getShanbi()*No.SI.getJiacheng()).intValue();
                summingzhong+= new Double(xiake.getMingzhong()*No.SI.getJiacheng()).intValue();
                sumbaoji+= new Double(xiake.getBaoji()*No.SI.getJiacheng()).intValue();
                sumkangbao+= new Double(xiake.getKangbao()*No.SI.getJiacheng()).intValue();
                sumgedang+= new Double(xiake.getGedang()*No.SI.getJiacheng()).intValue();
                sumpofang+= new Double(xiake.getPofang()*No.SI.getJiacheng()).intValue();
            }
            if(No.WU.getNumber()==xiaokepo.getNumber()){
                sumqixue+= new Double(xiake.getQixue()*No.WU.getJiacheng()).intValue();
                sumgongji+= new Double(xiake.getGongji()*No.WU.getJiacheng()).intValue();
                sumshanbi+= new Double(xiake.getShanbi()*No.WU.getJiacheng()).intValue();
                summingzhong+= new Double(xiake.getMingzhong()*No.WU.getJiacheng()).intValue();
                sumbaoji+= new Double(xiake.getBaoji()*No.WU.getJiacheng()).intValue();
                sumkangbao+= new Double(xiake.getKangbao()*No.WU.getJiacheng()).intValue();
                sumgedang+= new Double(xiake.getGedang()*No.WU.getJiacheng()).intValue();
                sumpofang+= new Double(xiake.getPofang()*No.WU.getJiacheng()).intValue();
            }
            if(No.LIU.getNumber()==xiaokepo.getNumber()){
                sumqixue+= new Double(xiake.getQixue()*No.LIU.getJiacheng()).intValue();
                sumgongji+= new Double(xiake.getGongji()*No.LIU.getJiacheng()).intValue();
                sumshanbi+= new Double(xiake.getShanbi()*No.LIU.getJiacheng()).intValue();
                summingzhong+= new Double(xiake.getMingzhong()*No.LIU.getJiacheng()).intValue();
                sumbaoji+= new Double(xiake.getBaoji()*No.LIU.getJiacheng()).intValue();
                sumkangbao+= new Double(xiake.getKangbao()*No.LIU.getJiacheng()).intValue();
                sumgedang+= new Double(xiake.getGedang()*No.LIU.getJiacheng()).intValue();
                sumpofang+= new Double(xiake.getPofang()*No.LIU.getJiacheng()).intValue();
            }
        }
        //属性VO
        shuXingVo.setQixue(sumqixue);
        shuXingVo.setGongji(sumgongji);
        shuXingVo.setShanbi(sumshanbi);
        shuXingVo.setMingzhong(summingzhong);
        shuXingVo.setBaoji(sumbaoji);
        shuXingVo.setKangbao(sumkangbao);
        shuXingVo.setGedang(sumgedang);
        shuXingVo.setPofang(sumpofang);
        return shuXingVo;
    }


   //评分计算
   public int getPingfen(ShuXingVo shuXingVo,List<Map<String,Double>> maps){
       int zonggongji=shuXingVo.getGongji();
       int zongqixue=shuXingVo.getQixue();
       int zongshanbi=shuXingVo.getShanbi();
       int zonggedang=shuXingVo.getGedang();
       int zongbaoji=shuXingVo.getBaoji();
       int zongkangbao=shuXingVo.getKangbao();
       int zongmingzhong=shuXingVo.getMingzhong();
       int zongpofang=shuXingVo.getPofang();
       for (Map<String,Double> map:maps) {
           if(map.containsKey("攻击")){
               zonggongji+=new Double(shuXingVo.getGongji()*map.get("攻击")).intValue();
           }
           if(map.containsKey("气血")){
               zongqixue+=new Double(shuXingVo.getQixue()*map.get("气血")).intValue();
           }
           if(map.containsKey("闪避")){
               zongshanbi+=new Double(shuXingVo.getShanbi()*map.get("闪避")).intValue();
           }
           if(map.containsKey("格挡")){
               zonggedang+=new Double(shuXingVo.getGedang()*map.get("格挡")).intValue();
           }
           if(map.containsKey("暴击")){
               zongbaoji+=new Double(shuXingVo.getBaoji()*map.get("暴击")).intValue();
           }
           if(map.containsKey("抗暴")){
               zongkangbao+=new Double(shuXingVo.getKangbao()*map.get("抗暴")).intValue();
           }
           if(map.containsKey("命中")){
               zongmingzhong+=new Double(shuXingVo.getMingzhong()*map.get("命中")).intValue();
           }
           if(map.containsKey("破防")){
               zongpofang+=new Double(shuXingVo.getPofang()*map.get("破防")).intValue();
           }
       }
       int pingfen=zonggongji*5+zongqixue*1/6+(zongshanbi+zonggedang+zongbaoji+zongkangbao+zongmingzhong+zongpofang)*4;
       return pingfen;
   }


   //加成列表
   public  List<Map<String,Double>> getJiacheng(List<XiakePo> xiakePos){
       List<Map<String,Double>> maps=new ArrayList<>();
       Map<String,Double> map1=new HashMap<>();
       Map<String,Double> map2=new HashMap<>();
       Map<String,Double> map3=new HashMap<>();
       Map<String,Double> map4=new HashMap<>();
       Map<String,Double> map5=new HashMap<>();
       Map<String,Double> map6=new HashMap<>();
       Map<String,Double> map7=new HashMap<>();
       Map<String,Double> map8=new HashMap<>();
       List<String> jibans=new ArrayList<>();
       List<String> shuxings=new ArrayList<>();
       List<Double>  shuzhis=new ArrayList<>();
       for (XiakePo xiakePo:xiakePos) {
           //前台传进来的六个侠客名字
           jibans.add(xiakePo.getName());
       }
       for (XiakePo xiakePo:xiakePos) {
           //通过主侠客查询加成列表
           List<Jiacheng> jiachengs=respostory.findByZhuxiake(xiakePo.getName());
           //如果羁绊侠客在六个名字中  就取出羁绊属性来
           for (Jiacheng jiacheng:jiachengs) {
               if(jibans.contains(jiacheng.getJibanxiake())){
                   shuxings.add(jiacheng.getJiachengshuxing());
                   shuzhis.add(Double.valueOf(jiacheng.getJiachengshuzhi()));
               }
           }
       }
       //羁绊属性相同的  对应数值相加
           for (int i = 0; i < shuxings.size(); i++) {
               if(shuxings.get(i).equals("攻击")){
                   double a=shuzhis.get(i);
                   double sum=0.0;
                   sum+=a;
                   map1.put("攻击",sum);
                   maps.add(map1);
               }
               if(shuxings.get(i).equals("气血")){
                   double a=shuzhis.get(i);
                   double sum=0.0;
                   sum+=a;
                   map2.put("气血",sum);
                   maps.add(map2);
               }
               if(shuxings.get(i).equals("闪避")){
                   double a=shuzhis.get(i);
                   double sum=0.0;
                   sum+=a;
                   map3.put("闪避",sum);
                   maps.add(map3);
               }
               if(shuxings.get(i).equals("格挡")){
                   double a=shuzhis.get(i);
                   double sum=0.0;
                   sum+=a;
                   map4.put("格挡",sum);
                   maps.add(map4);
               }
               if(shuxings.get(i).equals("暴击")){
                   double a=shuzhis.get(i);
                   double sum=0.0;
                   sum+=a;
                   map5.put("暴击",sum);
                   maps.add(map5);
               }
               if(shuxings.get(i).equals("抗暴")){
                   double a=shuzhis.get(i);
                   double sum=0.0;
                   sum+=a;
                   map6.put("抗暴",sum);
                   maps.add(map6);
               }
               if(shuxings.get(i).equals("命中")){
                   double a=shuzhis.get(i);
                   double sum=0.0;
                   sum+=a;
                   map7.put("命中",sum);
                   maps.add(map7);
               }
               if(shuxings.get(i).equals("破防")){
                   double a=shuzhis.get(i);
                   double sum=0.0;
                   sum+=a;
                   map8.put("破防",sum);
                   maps.add(map8);
               }
       }

       return maps;
   }


    @GetMapping(value = "findbiaoshi")
    public  ResultVo getValue(int level) {
       ResultVo resultVo=new ResultVo();
        String value="";
        if(level<4){
            value=mapperrespostory.findByLevel(0).getValue();
        }
        if(level>3&&level<8){
            value=mapperrespostory.findByLevel(4).getValue();
        }
        if(level>7&&level<12){
            value=mapperrespostory.findByLevel(8).getValue();
        }
        if(level>11&&level<16){
            value=mapperrespostory.findByLevel(12).getValue();
        }
        if(level>15&&level<20){
            value=mapperrespostory.findByLevel(16).getValue();
        }
        if(level>19&&level<24){
            value=mapperrespostory.findByLevel(20).getValue();
        }
        if(level>23&&level<28){
            value=mapperrespostory.findByLevel(24).getValue();
        }
        if(level>27&&level<32){
            value=mapperrespostory.findByLevel(28).getValue();
        }
        if(level>31&&level<36){
            value=mapperrespostory.findByLevel(32).getValue();
        }
        if(level>35&&level<40){
            value=mapperrespostory.findByLevel(36).getValue();
        }
        resultVo.setCode(1001);
        resultVo.setMsg("成功");
        resultVo.setData(value);
        return resultVo;
    }




}
