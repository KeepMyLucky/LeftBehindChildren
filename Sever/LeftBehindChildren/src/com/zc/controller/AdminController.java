package com.zc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;
import com.zc.model.Admin;
import com.zc.model.AdminloginMessage;
import com.zc.model.Book;
import com.zc.model.Dynamic;
import com.zc.model.Message;
import com.zc.model.Score;
import com.zc.model.User;
import com.zc.model.delBookMessage;
import com.zc.model.delDynamicMessage;
import com.zc.model.delScoreMessage;
import com.zc.model.delUserMessage;
import com.zc.model.editBookMessage;
import com.zc.model.editUserMessage;
import com.zc.model.getBookListPageMessage;
import com.zc.model.getDynamicListPageMessage;
import com.zc.model.getScoreListPageMessage;
import com.zc.model.getUserListPageMessage;
import com.zc.model.getclassInListMessage;
import com.zc.model.getexamTypeListMessage;
import com.zc.model.overviewMessage;
import com.zc.model.overviewNumber;
import com.zc.model.updateScoreMessage;
import com.zc.service.AdminService;

@Controller
@RequestMapping("Admin")
public class AdminController {
	Integer offset;
	
	@Autowired
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("login")
	public String login(Admin admin, HttpServletRequest request, HttpServletResponse response) throws IOException {
		AdminloginMessage message = new AdminloginMessage();
		System.out.println("login");
		try {
			System.out.println("-login-" + admin.getUsername() + "," + "-login-" + admin.getPassword() + ".");
			Admin loginAdmin = null;
			loginAdmin = adminService.login(admin);
			if (loginAdmin != null) {
				message.setCode(Message.SUCCESS);
				message.setMsg("登录成功");
				request.setAttribute("loginAdmin", loginAdmin.getUsername());
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
	
	@SuppressWarnings("finally")
	@RequestMapping("getUserListPage")
	public String getUsers(Integer pageSize, Integer pageNumber, Integer uid, String username, HttpServletRequest request, HttpServletResponse response) throws IOException {
		getUserListPageMessage message = new getUserListPageMessage();
		System.out.println("pageSize="+pageSize);
		System.out.println("pageNumber="+pageNumber);
		System.out.println("uid="+uid);
		System.out.println("getUserListPage");
		//String转int
		//Integer.parseInt(pageNumber);
		offset=pageNumber;
		System.out.println(offset);
		int total=adminService.getUserListNumber(uid, username);
		System.out.println("username="+username);
		System.out.println("total="+total);
		try {
			List<User> rows=adminService.getUserListPage(uid, username, offset, pageSize);
			System.out.println(rows);
			message.setRows(rows);
			message.setTotal(total);
			if (rows.size() > 0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("加载成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("加载失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			return null;
		}
	}

	@RequestMapping("delUser")
	public void delUser(Integer uid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		delUserMessage message = new delUserMessage();
		System.out.println("delUid="+uid);
		try {
			int delResult =adminService.delete(uid);
			if (delResult==0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("删除成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("删除失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
		}
	}

	@RequestMapping("updateUser")
	public void updateUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		editUserMessage message = new editUserMessage();
		System.out.println("updateUser="+user.getLevel());
		try {
			int updateResult =adminService.updateUser(user);
			if (updateResult==0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("更新成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("更新失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("getDynamicListPage")
	public String getDynamics(Integer pageSize, Integer pageNumber, Integer did, Integer uid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		getDynamicListPageMessage message = new getDynamicListPageMessage();
		System.out.println("getDynamicListPage");
		System.out.println("did="+did);
		//String转int
		//Integer.parseInt(pageNumber);
		offset=pageNumber;
		int total=adminService.getDynamicListNumber(did, uid);
		try {
			List<Dynamic> rows=adminService.getDynamicListPage(uid, did, offset, pageSize);
			System.out.println(rows);
			message.setRows(rows);
			message.setTotal(total);
			if (rows.size() > 0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("加载成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("加载失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			return null;
		}
	}
	
	@RequestMapping("delDynamic")
	public void delDynamic(String did, HttpServletRequest request, HttpServletResponse response) throws IOException {
		delDynamicMessage message = new delDynamicMessage();
		System.out.println("delDid="+did);
		try {
			int delResult =adminService.deleteDynamic(did);
			if (delResult==0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("删除成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("删除失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
		}
	}
	
	@RequestMapping("updateDynamic")
	public void updateDynamic(Dynamic dynamic, HttpServletRequest request, HttpServletResponse response) throws IOException {
		editUserMessage message = new editUserMessage();
		System.out.println("updateDynamic="+dynamic.getDid());
		try {
			int updateResult =adminService.updateDynamic(dynamic);
			if (updateResult==0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("更新成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("更新失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("getBookListPage")
	public String getBookList(Integer pageSize, Integer pageNumber, Integer isbn, String keyword, HttpServletRequest request, HttpServletResponse response) throws IOException {
		getBookListPageMessage message = new getBookListPageMessage();
		System.out.println("getBookListPage");
		System.out.println("isbn="+isbn);
		//String转int
		//Integer.parseInt(pageNumber);
		offset=pageNumber;
		int total=adminService.getBookListNumber(isbn, keyword);
		try {
			List<Book> rows=adminService.getBookListPage(isbn, keyword, offset, pageSize);
			System.out.println(rows);
			message.setRows(rows);
			message.setTotal(total);
			if (rows.size() > 0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("加载成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("加载失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			return null;
		}
	}
	
	@RequestMapping("delBook")
	public void delBook(String isbn, HttpServletRequest request, HttpServletResponse response) throws IOException {
		delBookMessage message = new delBookMessage();
		System.out.println("delIsbn="+isbn);
		try {
			int delResult =adminService.deleteBook(isbn);
			if (delResult==0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("删除成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("删除失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
		}
	}
	
	@RequestMapping("updateBook")
	public void updateBook(Book book, HttpServletRequest request, HttpServletResponse response) throws IOException {
		editBookMessage message = new editBookMessage();
		System.out.println("updateBook="+book.getIsbn());
		try {
			int updateResult =adminService.updateBook(book);
			if (updateResult==0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("更新成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("更新失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
		}
	}
	
	/*@SuppressWarnings("finally")
	@RequestMapping("overviewNumber")
	public String overviewNumber(HttpServletRequest request, HttpServletResponse response) throws IOException {
		overviewMessage message = new overviewMessage();
		System.out.println("overviewNumber");
		try {
			overviewNumber number=adminService.getOverViewNumber();
			message.setOverviewNumber(number);
			if (number!=null) {
				message.setCode(Message.SUCCESS);
				message.setMsg("加载成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("加载失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			return null;
		}
	}*/
	
	@SuppressWarnings("finally")
	@RequestMapping("getexamType")
	public String getexamType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		getexamTypeListMessage message = new getexamTypeListMessage();
		System.out.println("getexamType");
		try {
			List<String> examTypes=adminService.getexamTypeList();
			message.setExamTypeList(examTypes);
			System.out.println(message);
			if (examTypes.size() > 0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("加载成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("加载失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			return null;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("getclassIn")
	public String getclassIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		getclassInListMessage message = new getclassInListMessage();
		System.out.println("getclassIn");
		try {
			List<String> classIns=adminService.getclassInList();
			message.setClassInList(classIns);
			System.out.println(message);
			if (classIns.size() > 0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("加载成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("加载失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			return null;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("getScoreListPage")
	public String getScoreList(Integer pageSize, Integer pageNumber, String examtype, String classin, String stuname, HttpServletRequest request, HttpServletResponse response) throws IOException {
		getScoreListPageMessage message = new getScoreListPageMessage();
		System.out.println("getScoreListPage");
		//String转int
		//Integer.parseInt(pageNumber);
		offset=pageNumber;
		int total=adminService.getScoreListNumber(examtype, classin, stuname);
		try {
			List<Score> rows=adminService.getScoreListPage(examtype, classin, stuname, offset, pageSize);
			System.out.println(rows);
			message.setRows(rows);
			message.setTotal(total);
			if (rows.size() > 0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("加载成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("加载失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			return null;
		}
	}
	
	@RequestMapping("updateScore")
	public void updateScore(Score score, HttpServletRequest request, HttpServletResponse response) throws IOException {
		updateScoreMessage message = new updateScoreMessage();
		System.out.println("updateScore="+score);
		try {
			int updateResult = adminService.updateScore(score);
			if (updateResult>0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("删除成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("删除失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
		}
	}
	
	@RequestMapping("delScore")
	public void delScore(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		delScoreMessage message = new delScoreMessage();
		System.out.println("delId="+id);
		try {
			int delResult =adminService.deleteScore(id);
			if (delResult>0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("删除成功");
				// return null;
			} else {
				message.setCode(Message.FAIL);
				message.setMsg("删除失败");
				// return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setCode(Message.FAIL);
			message.setMsg("有异常" + e.toString());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
		}
	}
	
	}
