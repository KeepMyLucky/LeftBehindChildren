package com.zc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.zc.model.Message;
import com.zc.model.Score;
import com.zc.model.addScoreMessage;
import com.zc.model.getAllScoreMessage;
import com.zc.model.getstuScoreMessage;
import com.zc.service.ScoreService;

@Controller
//定义该Controller的根访问路径Score
@RequestMapping("Score")
public class ScoreController {
	@Autowired
	private  ScoreService scoreService;

	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	@SuppressWarnings({ "finally", "static-access" })
	@RequestMapping("addInfo")
	public String add(Score score,HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Score addInfo");
		addScoreMessage message = new addScoreMessage();
		try {
		System.out.println(score.getId());
		System.out.println(score.getExamtype());
		String str=scoreService.addScore(score);
		if(str.equals("添加成功")) {
			message.setCode(message.SUCCESS);
		}else {
			message.setCode(message.FAIL);
		}
		System.out.println(str);
		request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			message.setCode(message.FAIL);
			message.setMsg("添加失败"+e.toString());
			request.setAttribute("InfoMessage", "添加信息失败,具体异常:");
		}finally {
			//发送结果
			Gson gson=new Gson();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(gson.toJson(message));
			return null;
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("getAll")
	public String getAddInfoAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		getAllScoreMessage message=new getAllScoreMessage();
		System.out.println("Score getAll");
		try {
			List<Score> scores=scoreService.getAll();
			message.setScores(scores);
			if(scores.size()>0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("获取数据成功");
			}else {
				message.setCode(Message.FAIL);
				message.setMsg("获取数据失败");
			}
			request.setAttribute("addLists", scores);
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
			return null;
		}
	}
	
	@RequestMapping("getstuScore")
	public void getstuScore(String classin, String stuname, HttpServletRequest request, HttpServletResponse response) throws IOException {
		getstuScoreMessage message=new getstuScoreMessage();
		System.out.println("Score getstuScore");
		try {
			List<Score> stuScores=scoreService.getstuScore(classin,stuname);
			message.setStuScores(stuScores);
			if(stuScores.size()>0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("获取数据成功");
			}else {
				message.setCode(Message.FAIL);
				message.setMsg("获取数据失败");
			}
			request.setAttribute("addLists", stuScores);
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
	public String del(int id,HttpServletRequest request) {
		try {
			String str =scoreService.delete(id);
			request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败，具体异常信息:"+e.getMessage());
		}finally {
			return null;
		}
	}
	@RequestMapping("modify")
	public String modify(int id,HttpServletRequest request) {
		try {
			Score score=scoreService.findById(id);
			request.setAttribute("add", score);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败,具体异常信息:"+e.getMessage());
		}
		return null;
	}
	@SuppressWarnings("finally")
	@RequestMapping("update")
	public String update(Score score,HttpServletRequest request) {
		try {
			String str=scoreService.update(score);
			request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "更新信息失败失败,具体异常信息:"+e.getMessage());
		}finally {
			return null;
		}
	}
}
