package com.zc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.zc.model.Comment;
import com.zc.model.Message;
import com.zc.model.getAllCommentMessage;
import com.zc.model.getCommentMessage;
import com.zc.service.CommentService;

@Controller
//定义该Controller的根访问路径Dynamic
@RequestMapping("Comment")
public class CommentController {
	@Autowired
	private CommentService commentService;

	public CommentService getUserService() {
		return commentService;
	}

	public void setUserService(CommentService commentService) {
		this.commentService = commentService;
	}
	@SuppressWarnings("finally")
	@RequestMapping("addInfo")
	public String add(Comment comment,HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Comment add");
		try {
		System.out.println(comment.getUid());
		String str=commentService.addComment(comment);
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
		getAllCommentMessage getAllCommentmessage=new getAllCommentMessage();
		System.out.println("recving");
		try {
			List<Comment> comments=commentService.getAll();
			getAllCommentmessage.setComments(comments);
			if(comments.size()>0) {
				getAllCommentmessage.setCode(Message.SUCCESS);
				getAllCommentmessage.setMsg("获取数据成功");
			}else {
				getAllCommentmessage.setCode(Message.FAIL);
				getAllCommentmessage.setMsg("获取数据失败");
			}
			request.setAttribute("addLists", comments);
		}catch(Exception e) {
			e.printStackTrace();
			getAllCommentmessage.setCode(Message.FAIL);
			getAllCommentmessage.setMsg("获取数据失败");
			request.setAttribute("InfoMessage", "信息载入失败，具体异常信息:"+e.getMessage());
		}finally {
			//发送结果
			Gson gson=new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(getAllCommentmessage));
			System.out.println(getAllCommentmessage);
			return null;
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("del")
	public String del(String cid,HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("del comment");
		try {
			String str =commentService.delete(cid);
			request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败，具体异常信息:"+e.getMessage());
		}finally {
			return null;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("delByDid")
	public String delByDid(String did,HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("del comment");
		try {
			String str =commentService.deleteByDid(did);
			request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败，具体异常信息:"+e.getMessage());
		}finally {
			return null;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("modify")
	public String modify(String did,HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(did);
		getCommentMessage getcommentMessage=new getCommentMessage();
		System.out.println("recving modify");
		try {
			Comment comment=commentService.findById(did);
			getcommentMessage.setComment(comment);
			if(comment!=null) {
				getcommentMessage.setCode(Message.SUCCESS);
				getcommentMessage.setMsg("获取数据成功");
			}else {
				getcommentMessage.setCode(Message.FAIL);
				getcommentMessage.setMsg("获取数据失败");
			}
			request.setAttribute("add", comment);
			//return null;
		}catch (Exception e) {
			e.printStackTrace();
			getcommentMessage.setCode(Message.FAIL);
			getcommentMessage.setMsg("有异常"+e.toString());
			request.setAttribute("InfoMessage", "信息载入失败,具体异常信息:"+e.getMessage());
			//return null;
		}finally {
			//发送结果
			Gson gson=new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(getcommentMessage));
			System.out.println(getcommentMessage);
			return null;
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("modifyAll")
	public String modifyAll(String did,HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(did);
		getAllCommentMessage getAllCommentmessage=new getAllCommentMessage();
		System.out.println("recving modifyAll");
		try {
			List<Comment> comments=commentService.findByDid(did);
			getAllCommentmessage.setComments(comments);
			if(comments.size()>0) {
				getAllCommentmessage.setCode(Message.SUCCESS);
				getAllCommentmessage.setMsg("获取数据成功");
			}else {
				getAllCommentmessage.setCode(Message.FAIL);
				getAllCommentmessage.setMsg("获取数据失败");
			}
			request.setAttribute("add", comments);
			//return null;
		}catch (Exception e) {
			e.printStackTrace();
			getAllCommentmessage.setCode(Message.FAIL);
			getAllCommentmessage.setMsg("有异常"+e.toString());
			request.setAttribute("InfoMessage", "信息载入失败,具体异常信息:"+e.getMessage());
			//return null;
		}finally {
			//发送结果
			Gson gson=new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(getAllCommentmessage));
			System.out.println(getAllCommentmessage);
			return null;
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("update")
	public String update(Comment comment,HttpServletRequest request) {
		try {
			String str=commentService.update(comment);
			request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "更新信息失败失败,具体异常信息:"+e.getMessage());
		}finally {
			return "result";
		}
	}
}
