package com.yc.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yc.cinema.biz.HallBiz;
import com.yc.cinema.biz.MovieBiz;
import com.yc.cinema.biz.UserBiz;
@Controller
public class IndexAction {
	@Autowired    //根据类型到容器中获取指定的bean,设置到当前属性中
	private UserBiz ubiz;
	@Autowired    //根据类型到容器中获取指定的bean,设置到当前属性中
	private MovieBiz mbiz;
	@Autowired    //根据类型到容器中获取指定的bean,设置到当前属性中
	private HallBiz hbiz;

	public UserBiz getUbiz() {
		return ubiz;
	}

	public void setUbiz(UserBiz ubiz) {
		this.ubiz = ubiz;
	}

	public MovieBiz getMbiz() {
		return mbiz;
	}

	public void setMbiz(MovieBiz mbiz) {
		this.mbiz = mbiz;
	}

	public HallBiz getHbiz() {
		return hbiz;
	}

	public void setHbiz(HallBiz hbiz) {
		this.hbiz = hbiz;
	}

}
