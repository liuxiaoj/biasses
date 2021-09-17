package com.bi.feapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bi.feapp.service.welcomeService;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.json.simple.JSONObject;

import com.bi.feapp.dao.RequestHome;
import com.bi.feapp.vo.UserPeer;

import java.io.File;

public class WelcomeAction {

	/********************************************************************
	 * This action is for processing request displaying the first page
	 * where user can click SCAN QR CODE
	 */
	/********************************************************************

	 private static final Logger logger = Logger.getLogger(WelcomeAction.class);

	 /* *
	 * Helper
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	protected
	ActionForward              execHelper                (ActionMapping       mapping,
	                                                      ActionForm          form,
	                                                      HttpServletRequest  request,
	                                                      HttpServletResponse response)
	{
		File qrfile;
		JSONObject res = new JSONObject();

		try {
			qrfile = generateQR(request);
			logger.debug(" returned string --> " + str.toString());

		} catch (Exception e) {
			logger.fatal("Unable to build notes " + e.getMessage(), e);
			// build error notes
			res.put("is_ok", false);
			JSONWriter.WriteToHTTP(response, res);
			return null;
		}

		res.put("is_ok", true);
		res.put("notes", str.toString());
		// send them to client
		JSONWriter.WriteToHTTP(response, res);
		return null;
	}


}
