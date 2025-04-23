
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 项目进度
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiangmuJindu")
public class XiangmuJinduController {
    private static final Logger logger = LoggerFactory.getLogger(XiangmuJinduController.class);

    @Autowired
    private XiangmuJinduService xiangmuJinduService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XiangmuService xiangmuService;

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private XiaoxiService xiaoxiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("xiangmuJinduDeleteStart",1);params.put("xiangmuJinduDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xiangmuJinduService.queryPage(params);

        //字典表数据转换
        List<XiangmuJinduView> list =(List<XiangmuJinduView>)page.getList();
        for(XiangmuJinduView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiangmuJinduEntity xiangmuJindu = xiangmuJinduService.selectById(id);
        if(xiangmuJindu !=null){
            //entity转view
            XiangmuJinduView view = new XiangmuJinduView();
            BeanUtils.copyProperties( xiangmuJindu , view );//把实体数据重构到view中

                //级联表
                XiangmuEntity xiangmu = xiangmuService.selectById(xiangmuJindu.getXiangmuId());
                if(xiangmu != null){
                    BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiangmuId(xiangmu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmuJinduEntity xiangmuJindu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangmuJindu:{}",this.getClass().getName(),xiangmuJindu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XiangmuJinduEntity> queryWrapper = new EntityWrapper<XiangmuJinduEntity>()
            .eq("xiangmu_id", xiangmuJindu.getXiangmuId())
            .eq("xiangmu_jindu_name", xiangmuJindu.getXiangmuJinduName())
            .eq("xiangmu_jindu_types", xiangmuJindu.getXiangmuJinduTypes())
            .eq("xiangmu_jindu_delete", xiangmuJindu.getXiangmuJinduDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmuJinduEntity xiangmuJinduEntity = xiangmuJinduService.selectOne(queryWrapper);
        if(xiangmuJinduEntity==null){
            xiangmuJindu.setXiangmuJinduDelete(1);
            xiangmuJindu.setInsertTime(new Date());
            xiangmuJindu.setCreateTime(new Date());
            xiangmuJinduService.insert(xiangmuJindu);


            XiangmuEntity xiangmuEntity = xiangmuService.selectById(xiangmuJindu.getXiangmuId());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            DictionaryEntity dictionaryEntity = dictionaryService.selectOne(new EntityWrapper<DictionaryEntity>().eq("dic_code", "xiangmu_jindu_types").eq("code_index", xiangmuJindu.getXiangmuJinduTypes()));
            XiaoxiEntity xiaoxiEntity = new XiaoxiEntity();
            xiaoxiEntity.setCreateTime(new Date());
            xiaoxiEntity.setInsertTime(new Date());
            xiaoxiEntity.setYonghuId(xiangmuEntity.getYonghuId());
            String s1 = "在" + simpleDateFormat.format(new Date()) + "时间[项目进度表]中的[新增]方法中 增加了一条项目编号为["+xiangmuEntity.getXiangmuUuidNumber()+"],项目进度状态["+dictionaryEntity.getIndexName()+"]信息";
            xiaoxiEntity.setXiaoxiContent(s1);
            xiaoxiEntity.setXiaoxiName(s1);
            xiaoxiService.insert(xiaoxiEntity);


            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangmuJinduEntity xiangmuJindu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiangmuJindu:{}",this.getClass().getName(),xiangmuJindu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XiangmuJinduEntity> queryWrapper = new EntityWrapper<XiangmuJinduEntity>()
            .notIn("id",xiangmuJindu.getId())
            .andNew()
            .eq("xiangmu_id", xiangmuJindu.getXiangmuId())
            .eq("xiangmu_jindu_name", xiangmuJindu.getXiangmuJinduName())
            .eq("xiangmu_jindu_types", xiangmuJindu.getXiangmuJinduTypes())
            .eq("xiangmu_jindu_delete", xiangmuJindu.getXiangmuJinduDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmuJinduEntity xiangmuJinduEntity = xiangmuJinduService.selectOne(queryWrapper);
        if("".equals(xiangmuJindu.getXiangmuJinduFile()) || "null".equals(xiangmuJindu.getXiangmuJinduFile())){
                xiangmuJindu.setXiangmuJinduFile(null);
        }
        if(xiangmuJinduEntity==null){
            xiangmuJinduService.updateById(xiangmuJindu);//根据id更新




            XiangmuEntity xiangmuEntity = xiangmuService.selectById(xiangmuJindu.getXiangmuId());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            DictionaryEntity dictionaryEntity = dictionaryService.selectOne(new EntityWrapper<DictionaryEntity>().eq("dic_code", "xiangmu_jindu_types").eq("code_index", xiangmuJindu.getXiangmuJinduTypes()));
            XiaoxiEntity xiaoxiEntity = new XiaoxiEntity();
            xiaoxiEntity.setCreateTime(new Date());
            xiaoxiEntity.setInsertTime(new Date());
            xiaoxiEntity.setYonghuId(xiangmuEntity.getYonghuId());
            String s1 = "在" + simpleDateFormat.format(new Date()) + "时间[项目进度表]中的[修改]方法中 修改了一条项目编号为["+xiangmuEntity.getXiangmuUuidNumber()+"],项目进度状态["+dictionaryEntity.getIndexName()+"]信息";
            xiaoxiEntity.setXiaoxiContent(s1);
            xiaoxiEntity.setXiaoxiName(s1);
            xiaoxiService.insert(xiaoxiEntity);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<XiangmuJinduEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XiangmuJinduEntity xiangmuJinduEntity = new XiangmuJinduEntity();
            xiangmuJinduEntity.setId(id);
            xiangmuJinduEntity.setXiangmuJinduDelete(2);
            list.add(xiangmuJinduEntity);
        }
        if(list != null && list.size() >0){
            xiangmuJinduService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<XiangmuJinduEntity> xiangmuJinduList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XiangmuJinduEntity xiangmuJinduEntity = new XiangmuJinduEntity();
//                            xiangmuJinduEntity.setXiangmuId(Integer.valueOf(data.get(0)));   //项目 要改的
//                            xiangmuJinduEntity.setXiangmuJinduName(data.get(0));                    //进度标题 要改的
//                            xiangmuJinduEntity.setXiangmuJinduTypes(Integer.valueOf(data.get(0)));   //进度状态 要改的
//                            xiangmuJinduEntity.setXiangmuJinduFile(data.get(0));                    //进度相关文件 要改的
//                            xiangmuJinduEntity.setXiangmuJinduContent("");//照片
//                            xiangmuJinduEntity.setXiangmuJinduDelete(1);//逻辑删除字段
//                            xiangmuJinduEntity.setInsertTime(date);//时间
//                            xiangmuJinduEntity.setCreateTime(date);//时间
                            xiangmuJinduList.add(xiangmuJinduEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xiangmuJinduService.insertBatch(xiangmuJinduList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
