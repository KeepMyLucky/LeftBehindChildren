package com.zc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.google.gson.Gson;
import com.zc.model.Dynamic;
import com.zc.model.Message;
import com.zc.model.getAllDynamicMessage;
import com.zc.model.getmyDynamicMessage;
import com.zc.model.searchMessage;
import com.zc.service.DynamicService;

@Controller
//定义该Controller的根访问路径Dynamic
@RequestMapping("Dynamic")
public class DynamicController {
	@Autowired
	private DynamicService dynamicService;

	public DynamicService getUserService() {
		return dynamicService;
	}

	public void setUserService(DynamicService dynamicService) {
		this.dynamicService = dynamicService;
	}
	@SuppressWarnings("finally")
	@RequestMapping("addInfo")
	public String add(Dynamic dynamic,HttpServletRequest request) {
		System.out.println("Dynamic addInfo");
		try {
			long startTime = System.currentTimeMillis();
			// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			// 检查form中是否有enctype="multipart/form-data"
			if (multipartResolver.isMultipart(request)) {
				// 将request变成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// 获取multiRequest 中所有的文件名
				@SuppressWarnings("rawtypes")
				Iterator iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 一次遍历所有文件
					MultipartFile file = multiRequest.getFile(iter.next().toString());
					// 获取文件名
					String oldfilename = file.getOriginalFilename();
					// 获取图片的扩展名
					String extensionName = oldfilename.substring(oldfilename.lastIndexOf(".") + 1);
					String newfilename = UUID.randomUUID().toString() + "." + extensionName;
					dynamic.setPic(newfilename);
					if (file != null) {
						// 获取上传路径
						String path = request.getSession().getServletContext().getRealPath("/imgs/dynamic") + "\\"
								+ newfilename;
						System.out.println(path);
						// String path="E:/springUpload"+file.getOriginalFilename();
						// 上传
						file.transferTo(new File(path));
					}
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("方法的运行时间：" + String.valueOf(endTime - startTime) + "ms");
		String str=dynamicService.addDynamic(dynamic);
		System.out.println(str);
		request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "添加信息失败,具体异常:");
		}finally {
			return null;
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("getAll")
	public String getAddInfoAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		getAllDynamicMessage getAllDynamicmessage=new getAllDynamicMessage();
		System.out.println("recving getAllDynamic");
		try {
			List<Dynamic> dynamics=dynamicService.getAll();
			getAllDynamicmessage.setDynamics(dynamics);
			if(dynamics.size()>0) {
				getAllDynamicmessage.setCode(Message.SUCCESS);
				getAllDynamicmessage.setMsg("获取数据成功");
			}else {
				getAllDynamicmessage.setCode(Message.FAIL);
				getAllDynamicmessage.setMsg("获取数据失败");
			}
			request.setAttribute("addLists", dynamics);
		}catch(Exception e) {
			e.printStackTrace();
			getAllDynamicmessage.setCode(Message.FAIL);
			getAllDynamicmessage.setMsg("获取数据失败");
			request.setAttribute("InfoMessage", "信息载入失败，具体异常信息:"+e.getMessage());
		}finally {
			//发送结果
			Gson gson=new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(getAllDynamicmessage));
			System.out.println(getAllDynamicmessage);
			return null;
		}
	}
	
	@RequestMapping("getmyDynamic")
	public void getmyDynamic(int uid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		getmyDynamicMessage message=new getmyDynamicMessage();
		System.out.println("recving getmyDynamicMessage"+uid);
		try {
			List<Dynamic> myDynamics=dynamicService.getmyDynamic(uid);
			message.setMyDynamics(myDynamics);
			if(myDynamics.size()>0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("获取数据成功");
			}else {
				message.setCode(Message.FAIL);
				message.setMsg("获取数据失败");
			}
			request.setAttribute("addLists", myDynamics);
		}catch(Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("获取数据失败");
			request.setAttribute("InfoMessage", "信息载入失败，具体异常信息:"+e.getMessage());
		}finally {
			//发送结果
			Gson gson=new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			System.out.println(message);
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("del")
	public String del(String did,HttpServletRequest request) {
		try {
			String str =dynamicService.delete(did);
			request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败，具体异常信息:"+e.getMessage());
		}finally {
			return "result";
		}
	}
	@RequestMapping("modify")
	public String modify(int id,HttpServletRequest request) {
		try {
			Dynamic dynamic=dynamicService.findById(id);
			request.setAttribute("add", dynamic);
			return "modify";
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败,具体异常信息:"+e.getMessage());
			return "result";
		}
	}
	@SuppressWarnings({ "finally", "static-access" })
	@RequestMapping("searchkey")
	public String searchkey(String searchkey,HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("searchkey");
		searchMessage message=new searchMessage();
		try {
			List<Dynamic> dynamics=dynamicService.findById(searchkey);
			if(dynamics.size()>0) {
				message.setDynamics(dynamics);
				message.setCode(message.SUCCESS);
				message.setMsg("查询到数据");
				request.setAttribute("add", dynamics);
			}else {
				message.setCode(message.FAIL);
				message.setMsg("没有查询到数据");
			}
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			message.setCode(message.FAIL);
			message.setMsg("查询数据失败");
			request.setAttribute("InfoMessage", "信息载入失败,具体异常信息:"+e.getMessage());
			return null;
		}finally {
			//发送结果
			Gson gson=new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			System.out.println(message);
			return null;
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("update")
	public String update(Dynamic dynamic,HttpServletRequest request) {
		try {
			String str=dynamicService.update(dynamic);
			request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "更新信息失败失败,具体异常信息:"+e.getMessage());
		}finally {
			return "result";
		}
	}
}
