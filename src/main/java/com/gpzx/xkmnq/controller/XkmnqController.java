package com.gpzx.xkmnq.controller;

import com.gpzx.xkmnq.dao.JiachengRespostory;
import com.gpzx.xkmnq.dao.MapperRespostory;
import com.gpzx.xkmnq.domain.Jiacheng;
import com.gpzx.xkmnq.domain.Xiake;
import com.gpzx.xkmnq.eunm.No;
import com.gpzx.xkmnq.po.XiakeDto;
import com.gpzx.xkmnq.po.XiakePo;
import com.gpzx.xkmnq.service.JiachengService;
import com.gpzx.xkmnq.service.XiakeService;
import com.gpzx.xkmnq.service.impl.XiakeServiceImpl;
import com.gpzx.xkmnq.utils.QinmiduValue;
import com.gpzx.xkmnq.vo.ResultVo;
import com.gpzx.xkmnq.vo.ShuXingVo;
import com.gpzx.xkmnq.vo.ShuxingPingfenVo;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Array;
import java.text.DecimalFormat;
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
       ShuXingVo shuXingVo1=new ShuXingVo();

       List<XiakePo> xiakePoList=new ArrayList<>();
       for (XiakePo xiakePo:xiakePos) {
           if(xiakePo!=null){
               xiakePoList.add(xiakePo);
           }
       }
       Map<String,String> maps = getJiacheng(xiakePoList);
       Map<String,Double> doubleMap=getJiachengDouble(xiakePoList);
       shuXingVo1=getShuxingVo(shuXingVo1,xiakePoList);
       //用侠客列表xiakeList  和加成列表maps 来计算评分
       int pingfen=getPingfen(shuXingVo1,doubleMap);
       shuxingPingfenVo.setJiachengMaps(maps);
       ShuXingVo shuXingVo=getZuiHouShuxing(shuXingVo1,doubleMap);
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

    //最终属性计算
    public ShuXingVo getZuiHouShuxing(ShuXingVo shuXingVo,Map<String,Double> map){
        int zonggongji=shuXingVo.getGongji();
        int zongqixue=shuXingVo.getQixue();
        int zongshanbi=shuXingVo.getShanbi();
        int zonggedang=shuXingVo.getGedang();
        int zongbaoji=shuXingVo.getBaoji();
        int zongkangbao=shuXingVo.getKangbao();
        int zongmingzhong=shuXingVo.getMingzhong();
        int zongpofang=shuXingVo.getPofang();
//       for (Map<String,Double> map:maps) {
        if(map.containsKey("gongji")){
            zonggongji+=new Double(shuXingVo.getGongji()*map.get("gongji")).intValue();
            shuXingVo.setGongji(zonggongji);
        }
        if(map.containsKey("qixue")){
            zongqixue+=new Double(shuXingVo.getQixue()*map.get("qixue")).intValue();
            shuXingVo.setQixue(zongqixue);
        }
        if(map.containsKey("shanbi")){
            zongshanbi+=new Double(shuXingVo.getShanbi()*map.get("shanbi")).intValue();
            shuXingVo.setShanbi(zongshanbi);
        }
        if(map.containsKey("gedang")){
            zonggedang+=new Double(shuXingVo.getGedang()*map.get("gedang")).intValue();
            shuXingVo.setGedang(zonggedang);
        }
        if(map.containsKey("baoji")){
            zongbaoji+=new Double(shuXingVo.getBaoji()*map.get("baoji")).intValue();
            shuXingVo.setBaoji(zongbaoji);
        }
        if(map.containsKey("kangbao")){
            zongkangbao+=new Double(shuXingVo.getKangbao()*map.get("kangbao")).intValue();
            shuXingVo.setKangbao(zongkangbao);
        }
        if(map.containsKey("mingzhong")){
            zongmingzhong+=new Double(shuXingVo.getMingzhong()*map.get("mingzhong")).intValue();
            shuXingVo.setMingzhong(zongmingzhong);
        }
        if(map.containsKey("pofang")){
            zongpofang+=new Double(shuXingVo.getPofang()*map.get("pofang")).intValue();
            shuXingVo.setPofang(zongpofang);
        }
//       }

        return shuXingVo;
    }
   //评分计算
   public int getPingfen(ShuXingVo shuXingVo,Map<String,Double> map){
       int zonggongji=shuXingVo.getGongji();
       int zongqixue=shuXingVo.getQixue();
       int zongshanbi=shuXingVo.getShanbi();
       int zonggedang=shuXingVo.getGedang();
       int zongbaoji=shuXingVo.getBaoji();
       int zongkangbao=shuXingVo.getKangbao();
       int zongmingzhong=shuXingVo.getMingzhong();
       int zongpofang=shuXingVo.getPofang();
//       for (Map<String,Double> map:maps) {
           if(map.containsKey("gongji")){
               zonggongji+=new Double(shuXingVo.getGongji()*map.get("gongji")).intValue();
           }
           if(map.containsKey("qixue")){
               zongqixue+=new Double(shuXingVo.getQixue()*map.get("qixue")).intValue();
           }
           if(map.containsKey("shanbi")){
               zongshanbi+=new Double(shuXingVo.getShanbi()*map.get("shanbi")).intValue();
           }
           if(map.containsKey("gedang")){
               zonggedang+=new Double(shuXingVo.getGedang()*map.get("gedang")).intValue();
           }
           if(map.containsKey("baoji")){
               zongbaoji+=new Double(shuXingVo.getBaoji()*map.get("baoji")).intValue();
           }
           if(map.containsKey("kangbao")){
               zongkangbao+=new Double(shuXingVo.getKangbao()*map.get("kangbao")).intValue();
           }
           if(map.containsKey("mingzhong")){
               zongmingzhong+=new Double(shuXingVo.getMingzhong()*map.get("mingzhong")).intValue();
           }
           if(map.containsKey("pofang")){
               zongpofang+=new Double(shuXingVo.getPofang()*map.get("pofang")).intValue();
           }
//       }
       int pingfen=zonggongji*5+zongqixue*1/6+(zongshanbi+zonggedang+zongbaoji+zongkangbao+zongmingzhong+zongpofang)*4;
       return pingfen;
   }


   //加成列表
   public  Map<String,String> getJiacheng(List<XiakePo> xiakePos){
       Map<String,String> map1=new HashMap<>();
       List<String> jibans=new ArrayList<>();
       List<String> shuxings=new ArrayList<>();
       List<Double>  shuzhis=new ArrayList<>();
       double sumgongji=0.0;
       double sumqixue=0.0;
       double sumshanbi=0.0;
       double sumgedang=0.0;
       double sumbaoji=0.0;
       double sumkangbao=0.0;
       double summingzhong=0.0;
       double sumpofang=0.0;
       map1.put("gongji",sumgongji+"");
       map1.put("qixue",sumgongji+"");
       map1.put("shanbi",sumgongji+"");
       map1.put("gedang",sumgongji+"");
       map1.put("baoji",sumgongji+"");
       map1.put("kangbao",sumgongji+"");
       map1.put("pofang",sumgongji+"");
       map1.put("mingzhong",sumgongji+"");

       List<XiakeDto> xiakeDtos=new ArrayList<>();
       for (XiakePo xiakePo:xiakePos) {
           XiakeDto xiakeDto=new XiakeDto();
           List<String> jibanList=new ArrayList<>();
           //前台传进来的六个侠客名字
           jibans.add(xiakePo.getName());
           List<Jiacheng> jiachengs=respostory.findByZhuxiakeAndQinmidu(xiakePo.getName(),convert(xiakePo.getQinmidu()));
           for (Jiacheng jiacheng:jiachengs ) {
               jibanList.add(jiacheng.getJibanxiake());
           }
           xiakeDto.setName(xiakePo.getName());
           xiakeDto.setQinmidu(convert(xiakePo.getQinmidu()));
           xiakeDto.setJibanList(jibanList);
           xiakeDtos.add(xiakeDto);
       }

//       boolean flag1=false;
//       boolean flag2=false;
//       if((jibans.contains("令狐冲")&&jibans.contains("大侠令狐冲")&&jibans.contains("风清扬"))||(jibans.contains("令狐冲")&&jibans.contains("大侠令狐冲")&&jibans.contains("东方不败"))){
//           flag1=true;
//           for (XiakePo xiakePo:xiakePos) {
//               if("令狐冲".equals(xiakePo.getName())){
//                   Qinmidulinghuchong=xiakePo.getQinmidu();
//               }
//               if("大侠令狐冲".equals(xiakePo.getName())){
//                   Qinmidudaxialinghuchong=xiakePo.getQinmidu();
//               }
//           }
//           if(Qinmidulinghuchong>Qinmidudaxialinghuchong){
//               jibans.remove("大侠令狐冲");
//           }else {
//               jibans.remove("令狐冲");
//           }
   //    }
//       if((jibans.contains("令狐冲")&&jibans.contains("大侠令狐冲")&&jibans.contains("东方不败"))){
//           flag2=true;
//           for (XiakePo xiakePo:xiakePos) {
//               if("令狐冲".equals(xiakePo.getName())){
//                   Qinmidulinghuchong=xiakePo.getQinmidu();
//               }
//               if("大侠令狐冲".equals(xiakePo.getName())){
//                   Qinmidudaxialinghuchong=xiakePo.getQinmidu();
//               }
//           }
//           if(Qinmidulinghuchong>Qinmidudaxialinghuchong){
//               jibans.remove("大侠令狐冲");
//           }else {
//               jibans.remove("令狐冲");
//           }
//       }



       for (XiakeDto xiakeDto:xiakeDtos) {
               //通过主侠客和亲密度查询加成列表
               Jiacheng jiacheng=respostory.findByZhuxiakeAndJibanxiakeAndQinmidu(xiakeDto.getName(),xiakeDto.getJibanList().get(0),xiakeDto.getQinmidu());
               if(("东方不败".equals(xiakeDto.getName())&&jibans.contains("令狐冲")&&jibans.contains("大侠令狐冲"))||("风清扬".equals(xiakeDto.getName())&&jibans.contains("令狐冲")&&jibans.contains("大侠令狐冲"))){
                   if(jibans.contains(xiakeDto.getJibanList().get(0))){
                       shuxings.add(jiacheng.getJiachengshuxing());
                       shuzhis.add(Double.valueOf(jiacheng.getJiachengshuzhi()));
                   }
               }else {
                   //如果羁绊侠客在六个名字中  就取出羁绊属性来
                   for (String jibanxiake : xiakeDto.getJibanList()) {
                       if (jibans.contains(jibanxiake)) {
                           shuxings.add(jiacheng.getJiachengshuxing());
                           shuzhis.add(Double.valueOf(jiacheng.getJiachengshuzhi()));
                       }
                   }
               }

//               //通过主侠客和亲密度查询加成列表
//               List<Jiacheng> jiachengs = respostory.findByZhuxiakeAndQinmidu(xiakePo.getName(), convert(xiakePo.getQinmidu()));
//               //如果羁绊侠客在六个名字中  就取出羁绊属性来   20200323  如果令狐冲和大侠令狐冲都在xiakePos中  取值较大的那个
//               for (Jiacheng jiacheng : jiachengs) {
//                   if (jibans.contains(jiacheng.getJibanxiake())) {
//                       shuxings.add(jiacheng.getJiachengshuxing());
//                       shuzhis.add(Double.valueOf(jiacheng.getJiachengshuzhi()));
//                   }
//               }


       }
       //羁绊属性相同的  对应数值相加
           for (int i = 0; i < shuxings.size(); i++) {
               if(shuxings.get(i).equals("攻击")){
                   double a=shuzhis.get(i);
                   sumgongji+=a;
                   map1.put("gongji",double2String(sumgongji)+"%");

               }
               if(shuxings.get(i).equals("气血")){
                   double a=shuzhis.get(i);
                   sumqixue+=a;
                   map1.put("qixue",double2String(sumqixue)+"%");

               }
               if(shuxings.get(i).equals("闪避")){
                   double a=shuzhis.get(i);
                   sumshanbi+=a;
                   map1.put("shanbi",double2String(sumshanbi)+"%");

               }
               if(shuxings.get(i).equals("格挡")){
                   double a=shuzhis.get(i);
                   sumgedang+=a;
                   map1.put("gedang",double2String(sumgedang)+"%");

               }
               if(shuxings.get(i).equals("暴击")){
                   double a=shuzhis.get(i);
                   sumbaoji+=a;
                   map1.put("baoji",double2String(sumbaoji)+"%");

               }
               if(shuxings.get(i).equals("抗暴")){
                   double a=shuzhis.get(i);
                   sumkangbao+=a;
                   map1.put("kangbao",double2String(sumkangbao)+"%");

               }
               if(shuxings.get(i).equals("命中")){
                   double a=shuzhis.get(i);
                   summingzhong+=a;
                   map1.put("mingzhong",double2String(summingzhong)+"%");

               }
               if(shuxings.get(i).equals("破防")){
                   double a=shuzhis.get(i);
                   sumpofang+=a;
                   map1.put("pofang",double2String(sumpofang)+"%");

               }
       }
       return map1;
   }


   //解决double精度丢失问题

    public static String double2String(Double dou){
       //截取小数点后两位  如果小数点前不等于0 则拼接到前面去dddddddd
        String a="";
        String b="";
        String doustr=dou.toString();
        if(!"0".equals(doustr.substring(0,1))){
            b=doustr.substring(0,1);
        }
        if(doustr.length()>=4){
            a=b+doustr.substring(2,4);
        }else{
            a=b+doustr.substring(2,3)+"0";
        }

        return a;
    }

    public static double  doubleUtil(Double param){
        BigDecimal a=new BigDecimal(Double.toString(param));
        return a.doubleValue();
    }
    public static double mul(double v1, double v2) {

        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
    //加成列表
    public  Map<String,Double> getJiachengDouble(List<XiakePo> xiakePos){
        List<Map<String,Double>> maps=new ArrayList<>();
        Map<String,Double> map1=new HashMap<>();
        List<String> jibans=new ArrayList<>();
        List<String> shuxings=new ArrayList<>();
        List<Double>  shuzhis=new ArrayList<>();
        double sumgongji=0.0;
        double sumqixue=0.0;
        double sumshanbi=0.0;
        double sumgedang=0.0;
        double sumbaoji=0.0;
        double sumkangbao=0.0;
        double summingzhong=0.0;
        double sumpofang=0.0;
        map1.put("gongji",sumgongji);
        map1.put("qixue",sumgongji);
        map1.put("shanbi",sumgongji);
        map1.put("gedang",sumgongji);
        map1.put("baoji",sumgongji);
        map1.put("kangbao",sumgongji);
        map1.put("pofang",sumgongji);
        map1.put("mingzhong",sumgongji);


        for (XiakePo xiakePo:xiakePos) {
            //前台传进来的六个侠客名字
            jibans.add(xiakePo.getName());
        }
        for (XiakePo xiakePo:xiakePos) {
            //通过主侠客和亲密度查询加成列表
            List<Jiacheng> jiachengs=respostory.findByZhuxiakeAndQinmidu(xiakePo.getName(),convert(xiakePo.getQinmidu()));
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
                sumgongji+=a;
                map1.put("gongji",Double.parseDouble(new DecimalFormat("#.00").format(sumgongji)));

            }
            if(shuxings.get(i).equals("气血")){
                double a=shuzhis.get(i);
                sumqixue+=a;
                map1.put("qixue",Double.parseDouble(new DecimalFormat("#.00").format(sumqixue)));

            }
            if(shuxings.get(i).equals("闪避")){
                double a=shuzhis.get(i);
                sumshanbi+=a;
                map1.put("shanbi",Double.parseDouble(new DecimalFormat("#.00").format(sumshanbi)));

            }
            if(shuxings.get(i).equals("格挡")){
                double a=shuzhis.get(i);
                sumgedang+=a;
                map1.put("gedang",Double.parseDouble(new DecimalFormat("#.00").format(sumgedang)));

            }
            if(shuxings.get(i).equals("暴击")){
                double a=shuzhis.get(i);
                sumbaoji+=a;
                map1.put("baoji",Double.parseDouble(new DecimalFormat("#.00").format(sumbaoji)));

            }
            if(shuxings.get(i).equals("抗暴")){
                double a=shuzhis.get(i);
                sumkangbao+=a;
                map1.put("kangbao",Double.parseDouble(new DecimalFormat("#.00").format(sumkangbao)));

            }
            if(shuxings.get(i).equals("命中")){
                double a=shuzhis.get(i);
                summingzhong+=a;
                map1.put("mingzhong",Double.parseDouble(new DecimalFormat("#.00").format(summingzhong)));

            }
            if(shuxings.get(i).equals("破防")){
                double a=shuzhis.get(i);
                sumpofang+=a;
                map1.put("pofang",Double.parseDouble(new DecimalFormat("#.00").format(sumpofang)));

            }
        }
        return map1;
    }


    @GetMapping(value = "/findbiaoshi")
    public  ResultVo getValue(Integer level) {
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


    public static  int convert(int qinmidu){
        if(qinmidu<4){
            qinmidu=0;
        }
        if(qinmidu>3&&qinmidu<8){
            qinmidu=4;
        }
        if(qinmidu>7&&qinmidu<12){
            qinmidu=8;
        }
        if(qinmidu>11&&qinmidu<16){
            qinmidu=12;        }
        if(qinmidu>15&&qinmidu<20){
            qinmidu=16;        }
        if(qinmidu>19&&qinmidu<24){
            qinmidu=20;
        }
        if(qinmidu>23&&qinmidu<28){
            qinmidu=24;
        }
        if(qinmidu>27&&qinmidu<32){
            qinmidu=28;        }
        if(qinmidu>31&&qinmidu<36){
            qinmidu=32;
        }
        if(qinmidu>35&&qinmidu<40){
            qinmidu=36;
        }
       return qinmidu;
    }



}
