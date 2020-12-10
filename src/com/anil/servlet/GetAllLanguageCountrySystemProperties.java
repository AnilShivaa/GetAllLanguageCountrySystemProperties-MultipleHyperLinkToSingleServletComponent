package com.anil.servlet;

import javax.servlet.*;
import java.io.*;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.http.*;


public class GetAllLanguageCountrySystemProperties extends HttpServlet {

		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			res.setContentType("text/html");
			
			PrintWriter pw=res.getWriter();
			
			String link=req.getParameter("s1");
			
			Locale mylocla[]=Locale.getAvailableLocales();
			
			
			if(link.equalsIgnoreCase("conlink")) {
				pw.print("<b>Country are:</b>");
				for (Locale l : mylocla) {
					pw.print("<br><b>"+l.getDisplayCountry()+"</b>");
				}	
			}
			else if(link.equalsIgnoreCase("lanlink")) {
				pw.print("<b>Language are:</b>");
				for (Locale l : mylocla) {
					pw.print("<br><b>"+l.getDisplayLanguage()+"</b>");
				}	
			}
			else {
				pw.print("<b>System details :</b>");
				pw.print("<br><b>"+System.getProperties()+"</b></br>");
			}
						
			pw.print("<center><br><br><h3>Home</b></h3><a href=\"linkurl?s1=syslink\"><img src=\"images/home.png\" width=\"100px;\"height=\"140px\"></a>"
					+ "</center>");
			
			
			pw.close();
			
		}
		
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
		}
}
