package com.zc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.google.gson.Gson;
import com.zc.model.LoginMessage;
import com.zc.model.Message;
import com.zc.model.RegistMessage;
import com.zc.model.User;
import com.zc.model.getAllUserMessage;
import com.zc.model.getUserMessage;
import com.zc.model.updateUserMessage;
import com.zc.service.UserService;

@Controller
// 定义该Controller的根访问路径User
@RequestMapping("User")
public class UserController {
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings({ "finally", "static-access" })
	@RequestMapping("addInfo")
	public String addUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		RegistMessage Registmessage = new RegistMessage();
		System.out.println("recving UserAddInfo");
		/*for (int i = 20156000; i < 20156020; i++) {
			user.setUid(i);
			user.setPassword("111");
			user.setUsername("小丽");
			user.setLevel("0");
			user.setAvatar("avatar.png");
			userService.addInfo(user);
		}*/
		try {
			User checkUser = null;
			checkUser = userService.check(user.getUid());
			if (checkUser != null) {
				Registmessage.setCode(Registmessage.FAIL);
				Registmessage.setMsg("此用户名已被注册");
				// return null;
			} else {
				userService.addInfo(user);
				Registmessage.setCode(Registmessage.SUCCESS);
				Registmessage.setMsg("注册成功");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Registmessage.setCode(Registmessage.FAIL);
			Registmessage.setMsg("有异常" + e.toString());
			request.setAttribute("InfoMessage", "登录失败,具体异常信息:" + e.getMessage());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(Registmessage));
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("getAll")
	public String getAddInfoAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		getAllUserMessage getAllUsermessage = new getAllUserMessage();
		System.out.println("getAll users");
		try {
			List<User> users = userService.getAll();
			getAllUsermessage.setUsers(users);
			if (users.size() > 0) {
				getAllUsermessage.setCode(Message.SUCCESS);
				getAllUsermessage.setMsg("获取数据成功");
			} else {
				getAllUsermessage.setCode(Message.FAIL);
				getAllUsermessage.setMsg("获取数据失败");
			}
			request.setAttribute("addLists", users);
		} catch (Exception e) {
			e.printStackTrace();
			getAllUsermessage.setCode(Message.FAIL);
			getAllUsermessage.setMsg("获取数据失败");
			request.setAttribute("InfoMessage", "信息载入失败，具体异常信息:" + e.getMessage());
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(getAllUsermessage));
			System.out.println(getAllUsermessage);
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("del")
	public String del(int id, HttpServletRequest request) {
		try {
			String str = userService.delete(id);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败，具体异常信息:" + e.getMessage());
		} finally {
			return "result";
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("modify")
	public String modify(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(id);
		getUserMessage getUsermessage = new getUserMessage();
		System.out.println("recving modify user");
		try {
			User user = userService.findById(id);
			getUsermessage.setUser(user);
			if (user != null) {
				getUsermessage.setCode(Message.SUCCESS);
				getUsermessage.setMsg("获取数据成功");
			} else {
				getUsermessage.setCode(Message.FAIL);
				getUsermessage.setMsg("获取数据失败");
			}
			request.setAttribute("add", user);
			// return null;
		} catch (Exception e) {
			e.printStackTrace();
			getUsermessage.setCode(Message.FAIL);
			getUsermessage.setMsg("有异常" + e.toString());
			request.setAttribute("InfoMessage", "信息载入失败,具体异常信息:" + e.getMessage());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(getUsermessage));
			System.out.println(getUsermessage);
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("update")
	public String update(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("update user");
		System.out.println(user);
		try {
			String str = userService.update(user);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "更新信息失败失败,具体异常信息:" + e.getMessage());
		} finally {
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("updateUserByUid")
	public String update(int uid, String updatekind, String infor, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("update user");
		updateUserMessage updateUsermessage = new updateUserMessage();
		System.out.println(uid + updatekind + infor);
		try {
			if (updatekind.equals("loginusername")) {
				User user = new User();
				user.setUid(uid);
				user.setUsername(infor);
				if (userService.update(user) != null) {
					updateUsermessage.setCode(Message.SUCCESS);
					updateUsermessage.setMsg("获取数据成功");
				} else {
					updateUsermessage.setCode(Message.FAIL);
					updateUsermessage.setMsg("获取数据失败");
				}
			}
			if (updatekind.equals("loginuserpassword")) {
				User user = new User();
				user.setUid(uid);
				user.setPassword(infor);
				if (userService.update(user) != null) {
					updateUsermessage.setCode(Message.SUCCESS);
					updateUsermessage.setMsg("获取数据成功");
				} else {
					updateUsermessage.setCode(Message.FAIL);
					updateUsermessage.setMsg("获取数据失败");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			updateUsermessage.setCode(Message.FAIL);
			updateUsermessage.setMsg("获取数据失败");
			request.setAttribute("InfoMessage", "更新信息失败失败,具体异常信息:" + e.getMessage());
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(updateUsermessage));
			System.out.println(updateUsermessage);
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("updateUserAvatarByUid")
	public String updateAvatar(int uid, String avatar, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("update user avatar");
		updateUserMessage updateUsermessage = new updateUserMessage();
		try {
			long startTime = System.currentTimeMillis();
			// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
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
					String newfilename = uid + "." + extensionName;
					avatar = newfilename;
					if (file != null) {
						// 获取上传路径
						String path = request.getSession().getServletContext().getRealPath("/imgs/user") + "\\"
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
			User user = new User();
			user.setUid(uid);
			user.setAvatar(avatar);
			if (userService.update(user) != null) {
				updateUsermessage.setCode(Message.SUCCESS);
				updateUsermessage.setMsg("获取数据成功");
			} else {
				updateUsermessage.setCode(Message.FAIL);
				updateUsermessage.setMsg("获取数据失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			updateUsermessage.setCode(Message.FAIL);
			updateUsermessage.setMsg("获取数据失败");
			request.setAttribute("InfoMessage", "更新信息失败失败,具体异常信息:" + e.getMessage());
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(updateUsermessage));
			System.out.println(updateUsermessage);
			return null;
		}

		// List<String> l=new ArrayList<String>();
		// updateUserMessage updateUsermessage = new updateUserMessage();
		// try {
		// // 1. 创建工厂对象
		// FileItemFactory factory = new DiskFileItemFactory();
		// // 2. 文件上传核心工具类
		// ServletFileUpload upload = new ServletFileUpload(factory);
		// // 设置大小限制参数
		// upload.setFileSizeMax(10*1024*1024); // 单个文件大小限制
		// upload.setSizeMax(50*1024*1024); // 总文件大小限制
		// upload.setHeaderEncoding("utf-8"); // 对中文文件编码处理
		// // 判断
		// if (upload.isMultipartContent(request)) {
		// // 3. 把请求数据转换为list集合
		// List<FileItem> list = upload.parseRequest(request);
		// // 遍历
		// for (FileItem item : list){
		// // 判断：普通文本数据
		// if (item.isFormField()){
		// // 获取键名
		// String name = item.getFieldName();
		// System.out.println(name);
		// // 获取键值
		// String value = item.getString("utf-8");
		// System.out.println(value);
		// l.add(value);
		// }
		//
		// // 文件表单项
		// else {
		// /******** 文件上传 ***********/
		// // a. 获取文件名称
		// String name = item.getName();
		// // ----处理上传文件名重名问题----
		// // a1. 先得到唯一标记
		// String uuid = UUID.randomUUID().toString();
		// // a2. 拼接文件名
		// name = uuid + name;
		// // b. 得到上传目录
		// String basePath =
		// request.getSession().getServletContext().getRealPath("/imgs/user");
		// // c. 创建要上传的文件对象
		// File file = new File(basePath,name);
		// // d. 上传
		// item.write(file);
		// item.delete(); // 删除组件运行时产生的临时文件
		// System.out.println("上传成功");//上传文件完成
		// //赋值
		// avatar=name;
		// }
		// }
		// }
		// //获取数据
		// for(int i=0; i<l.size(); i++) {
		// uid=Integer.parseInt(l.get(0));
		// System.out.println(uid);
		// }
		// User user = new User();
		// //uid=20156203;
		// user.setUid(uid);
		// //avatar="me.jpg";
		// user.setAvatar(avatar);
		// if(userService.update(user) != null) {
		// updateUsermessage.setCode(Message.SUCCESS);
		// updateUsermessage.setMsg("获取数据成功");
		// }else {
		// updateUsermessage.setCode(Message.FAIL);
		// updateUsermessage.setMsg("获取数据失败");
		// }
		//
		// }catch (Exception e) {
		// e.printStackTrace();
		// updateUsermessage.setCode(Message.FAIL);
		// updateUsermessage.setMsg("获取数据失败");
		// request.setAttribute("InfoMessage", "更新信息失败失败,具体异常信息:"+e.getMessage());
		// }finally {
		// //发送结果
		// Gson gson=new Gson();
		// response.setContentType("text/json;charset=utf-8");
		// response.getWriter().write(gson.toJson(updateUsermessage));
		// System.out.println(updateUsermessage);
		// return null;
		// }
	}

	@SuppressWarnings("finally")
	@RequestMapping("login")
	public String login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		LoginMessage message = new LoginMessage();
		System.out.println("login");
		try {
			System.out.println("-login-" + user.getUid() + "," + "-login-" + user.getPassword() + ".");
			User loginUser = null;
			loginUser = userService.login(user);
			if (loginUser != null) {
				message.setCode(Message.SUCCESS);
				message.setMsg("登录成功");
				request.setAttribute("loginUser", loginUser.getUsername());
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("登录失败");
				request.setAttribute("loginUser", "登录失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			request.setAttribute("InfoMessage", "登录失败,具体异常信息:" + e.getMessage());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			return null;
		}
	}
	
	@SuppressWarnings({ "finally", "static-access" })
	@RequestMapping("findUserByUid")
	public String findUserByUid(int uid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		RegistMessage Registmessage = new RegistMessage();
		System.out.println("recving findUserByUid");
		try {
			User checkUser = null;
			checkUser = userService.check(uid);
			if (checkUser != null) {
				Registmessage.setCode(Registmessage.SUCCESS);
				Registmessage.setMsg("此用户名已被注册");
				// return null;
			} else {
				Registmessage.setCode(Registmessage.FAIL);
				Registmessage.setMsg("当前用户名可以使用");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Registmessage.setCode(Registmessage.FAIL);
			Registmessage.setMsg("有异常" + e.toString());
			request.setAttribute("InfoMessage", "登录失败,具体异常信息:" + e.getMessage());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(Registmessage));
			return null;
		}
	}
}
