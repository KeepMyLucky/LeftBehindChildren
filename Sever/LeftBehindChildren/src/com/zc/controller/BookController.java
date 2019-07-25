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
import com.zc.model.Book;
import com.zc.model.Message;
import com.zc.model.getAllBookMessage;
import com.zc.service.BookService;

@Controller
//定义该Controller的根访问路径Book
@RequestMapping("Book")
public class BookController {
	@Autowired
	private BookService bookService;

	public BookService getUserService() {
		return bookService;
	}

	public void setUserService(BookService bookService) {
		this.bookService = bookService;
	}
	@SuppressWarnings("finally")
	@RequestMapping("addInfo")
	public String add(Book book,HttpServletRequest request) {
		System.out.println("Book addInfo");
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
					book.setBookface(newfilename);
					if (file != null) {
						// 获取上传路径
						String path = request.getSession().getServletContext().getRealPath("/imgs/book") + "\\"
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
		    System.out.println(book.getIsbn());
		    String str=bookService.addBook(book);
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
		getAllBookMessage message=new getAllBookMessage();
		System.out.println("getAll book");
		try {
			List<Book> books=bookService.getAll();
			message.setBooks(books);
			if(books.size()>0) {
				message.setCode(Message.SUCCESS);
				message.setMsg("获取数据成功");
			}else {
				message.setCode(Message.FAIL);
				message.setMsg("获取数据失败");
			}
			request.setAttribute("addLists", books);
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
	@SuppressWarnings("finally")
	@RequestMapping("del")
	public String del(int id,HttpServletRequest request) {
		try {
			String str =bookService.delete(id);
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
			Book book=bookService.findById(id);
			request.setAttribute("add", book);
			return "modify";
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败,具体异常信息:"+e.getMessage());
			return "result";
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("update")
	public String update(Book book,HttpServletRequest request) {
		try {
			String str=bookService.update(book);
			request.setAttribute("InfoMessage", str);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "更新信息失败失败,具体异常信息:"+e.getMessage());
		}finally {
			return "result";
		}
	}

}
