package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet( name = "MyServlet", value = { "/xxx", "/yyy" })
//@WebServlet( name = "MyServlet", urlPatterns = { "/xxx", "/yyy" })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		log.info("service(req, res) invoked.");
		log.info("HelloServlet 요청");
	} // service

} // end class
