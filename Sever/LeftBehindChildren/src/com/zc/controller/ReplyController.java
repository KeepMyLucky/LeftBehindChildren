package com.zc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.zc.model.Reply;
import com.zc.model.Message;
import com.zc.model.getAllReplyMessage;
import com.zc.model.getReplyMessage;
import com.zc.service.ReplyService;

@Controller
// 定义该Controller的根访问路径Reply
@RequestMapping("Reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@SuppressWarnings("finally")
	@RequestMapping("addInfo")
	public String add(Reply reply, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("reply addInfo");
		try {
			System.out.println(reply.getUid());
			System.out.println(reply.getRuid());
			String str = replyService.addComment(reply);
			System.out.println(str);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "添加信息失败,具体异常:");
		} finally {
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("getAll")
	public String getAddInfoAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		getAllReplyMessage getAllReplymessage = new getAllReplyMessage();
		System.out.println("recving");
		try {
			List<Reply> replys = replyService.getAll();
			getAllReplymessage.setReplys(replys);
			if (replys.size() > 0) {
				getAllReplymessage.setCode(Message.SUCCESS);
				getAllReplymessage.setMsg("获取数据成功");
			} else {
				getAllReplymessage.setCode(Message.FAIL);
				getAllReplymessage.setMsg("获取数据失败");
			}
			request.setAttribute("addLists", replys);
		} catch (Exception e) {
			e.printStackTrace();
			getAllReplymessage.setCode(Message.FAIL);
			getAllReplymessage.setMsg("获取数据失败");
			request.setAttribute("InfoMessage", "信息载入失败，具体异常信息:" + e.getMessage());
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(getAllReplymessage));
			System.out.println(getAllReplymessage);
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("del")
	public String del(String rid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("del reply");
		System.out.println(rid);
		try {
			String str = replyService.delete(rid);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败，具体异常信息:" + e.getMessage());
		} finally {
			return null;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("delByCid")
	public String delByCid(String cid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("del reply");
		System.out.println(cid);
		try {
			String str = replyService.deleteByCid(cid);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败，具体异常信息:" + e.getMessage());
		} finally {
			return null;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("delByDid")
	public String delByDid(String did, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("delReplyByDid");
		System.out.println(did);
		try {
			String str = replyService.deleteByDid(did);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败，具体异常信息:" + e.getMessage());
		} finally {
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("modify")
	public String modify(String rid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(rid);
		getReplyMessage getReplymessage = new getReplyMessage();
		System.out.println("recving modify");
		try {
			Reply reply = replyService.findById(rid);
			getReplymessage.setReply(reply);
			if (reply != null) {
				getReplymessage.setCode(Message.SUCCESS);
				getReplymessage.setMsg("获取数据成功");
			} else {
				getReplymessage.setCode(Message.FAIL);
				getReplymessage.setMsg("获取数据失败");
			}
			request.setAttribute("add", reply);
			// return null;
		} catch (Exception e) {
			e.printStackTrace();
			getReplymessage.setCode(Message.FAIL);
			getReplymessage.setMsg("有异常" + e.toString());
			request.setAttribute("InfoMessage", "信息载入失败,具体异常信息:" + e.getMessage());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(getReplymessage));
			System.out.println(getReplymessage);
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("modifyAll")
	public String modifyAll(String cid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(cid);
		getAllReplyMessage getAllReplymessage = new getAllReplyMessage();
		System.out.println("recving modifyAll reply");
		try {
			List<Reply> replys = replyService.findByCid(cid);
			getAllReplymessage.setReplys(replys);
			if (replys.size() > 0) {
				getAllReplymessage.setCode(Message.SUCCESS);
				getAllReplymessage.setMsg("获取数据成功");
			} else {
				getAllReplymessage.setCode(Message.FAIL);
				getAllReplymessage.setMsg("获取数据失败");
			}
			request.setAttribute("add", replys);
			// return null;
		} catch (Exception e) {
			e.printStackTrace();
			getAllReplymessage.setCode(Message.FAIL);
			getAllReplymessage.setMsg("有异常" + e.toString());
			request.setAttribute("InfoMessage", "信息载入失败,具体异常信息:" + e.getMessage());
			// return null;
		} finally {
			// 发送结果
			Gson gson = new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(getAllReplymessage));
			System.out.println(getAllReplymessage);
			return null;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("update")
	public String update(Reply reply, HttpServletRequest request) {
		try {
			String str = replyService.update(reply);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "更新信息失败失败,具体异常信息:" + e.getMessage());
		} finally {
			return "result";
		}
	}
}