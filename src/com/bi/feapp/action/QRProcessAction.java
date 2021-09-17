package com.bi.feapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

import com.bi.feapp.common.exception.*;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.simple.JSONObject;
import java.io.File;


/********************************************************
 *
 * This Action is response handler for generating QR code
 *
 ********************************************************/

public class QRProcessAction {


	private static final Logger logger = Logger.getLogger(QRProcessAction.class);

	/**
	 *
	 * @return nothing
	 */
	@SuppressWarnings("unchecked")
	protected
	ActionForward              execHelper                (ActionMapping       mapping,
														  ActionForm          form,
														  HttpServletRequest  request,
														  HttpServletResponse response)
	{

		String command = request.getParameter("command");

		if (command == null) {
			return doServerCheck(request, mapping);
		}

		switch (command) {
			case "server_status":    return doServerCheck(request, mapping);
			case "take_upload":   return doTakeUpload(request);
			default:
				logger.fatal("Invalid command \"" + command + "\" encountered");
				break;
		}

		return null;
	}

	/**
	 * Process Server Check
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	protected ActionForward doServerCheck(ActionMapping mapping, ActionForm form,
									   HttpServletRequest request, HttpServletResponse response)
	{

		String qrString;
		JSONObject res = new JSONObject();
		String filePath = "";//TODO: file can be from form
		try {
			qrString = readQR(filePath);
			logger.debug(" returned string --> " + qrString);

		} catch (Exception e) {
			res.put("is_ok", false);
			JSONWriter.WriteToHTTP(response, res);
			return null;
		}

		res.put("is_ok", true);
		res.put("qrcontent", qrString);
		// send them to client
		JSONWriter.WriteToHTTP(response, res);
		return null;
	}

	/**
	 * generate QR code file
	 *
	 */
	public static String readQR(String filePath){
		String qrCode = "";//TODO read content of QR file
		return qrCode;
	}

	/**
	 * Process take and upload
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	protected ActionForward doTakeUpload(ActionMapping mapping, ActionForm form,
										  HttpServletRequest request, HttpServletResponse response)
	{

		//TODO process take photo and upload photo
		return null;
	}

}
