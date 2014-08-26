package com.moravia.hs.util;

import javax.mail.MessagingException;

public class SendNotificationMail extends Thread{
	
	private String from;
	private String to;
	private String subject;
	private String triggerBy;
	private String link;
	private String linkText;
	private String type;
	private String requestState;
	private String title;
	
	
	public String getLinkText() {
		return linkText;
	}
	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getRequestState() {
		return requestState;
	}
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTriggerBy() {
		return triggerBy;
	}
	public void setTriggerBy(String triggerBy) {
		this.triggerBy = triggerBy;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void sendMail() {
		// TODO Auto-generated method stub
		String content =
				"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n" +
						"<html xmlns='http://www.w3.org/1999/xhtml'>\n" +
						"<head>\n" +
						"<title>From your Wave Account: Activity Report for June 15, 2014</title>\n" +
						"<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\n" +
						"<style>\n" +
						"a {\n" +
						"	color: #00929f;\n" +
						"	text-decoration: none;\n" +
						"}\n" +
						"a:hover {\n" +
						"	color: #007680 !important;\n" +
						"}\n" +
						".gs li {\n" +
						"	margin-left: 0px !important; /* GMAIL li left margin fix */\n" +
						"}\n" +
						".adcopy p {\n" +
						"	margin-top: 0px;\n" +
						"	margin-bottom: 0px;\n" +
						"}\n" +
						"</style>\n" +
						"</head>\n" +
						"<body style='background-color: #f1f1f1; margin:0; padding:0'>\n" +
						"	<table align='center' border='0' cellpadding='0' cellspacing='0'\n" +
						"		width='100%'>\n" +
						"		<tr>\n" +
						"			<td style='margin: 0px' bgcolor='#f1f1f1' width='100%'>\n" +
						"				<table width='650' cellpadding='0' cellspacing='0' align='center'\n" +
						"					border='0'>\n" +
						"					<tr>\n" +
						"						<td valign='top'>\n" +
						"							<!-- begin header -->\n" +
						"							<table width='650' cellpadding='0' cellspacing='0' align='center'\n" +
						"								border='0'\n" +
						"								style='margin-top:0px; margin-bottom:21px; font-size:11px'>\n" +
						"								<tr>\n" +
						"									<td></td>\n" +
						"								</tr>\n" +
						"							</table>\n" +
						"							<table width='650' cellpadding='0' cellspacing='0' border='0'\n" +
						"								align='center' style='background-color:#4a5a5b; padding: 15px;'>\n" +
						"								<tr>\n" +
						"									<td class='a1' valign='top'\n" +
						"										style='font-size:28px; font-family:Trebuchet MS, sans-serif;'>\n" +
						"										<span style='padding-left:20px; color:#fff'>Moravia HR\n" +
						"											System</span>\n" +
						"									</td>\n" +
						"								</tr>\n" +
						"							</table>\n" +
						"							<table width='650' cellpadding='0' cellspacing='0' border='0'\n" +
						"								align='center' style='padding:10px 5px; margin: 10px 0px;''>\n" +
						"							</table>\n" +
						"							<table width='650' cellpadding='0' cellspacing='0' border='0'\n" +
						"								align='center'\n" +
						"								style='background-color:#dce6eb; font-size:12px; color: #7c7c7c'>\n" +
						"								<tr>\n" +
						"									<td height='20'></td>\n" +
						"								</tr>\n" +
						"								<tr>\n" +
						"									<td valign='top'>\n" +
						"										<table width='650' cellpadding='0' cellspacing='0' border='0'\n" +
						"											align='center'>\n" +
						"											<tr>\n" +
						"												<td width='20'></td>\n" +
						"												<td valign='top'>\n" +
						"													<table width='650' cellpadding='0' cellspacing='0'\n" +
						"														border='0' align='center'>\n" +
						"														<tr>\n" +
						"															<td width='20'></td>\n" +
						"															<td valign='top'>\n" +
						"																<table width='400' cellpadding='0' cellspacing='0'\n" +
						"																	border='0' align='center'>\n" +
						"																	<tr>\n" +
						"																		<td class='a1' valign='top'\n" +
						"																			style='font-size:18px; color:gray; text-align: center; font-family:Trebuchet MS, sans-serif;'>\n" +
						"																			<span style='padding-right:10px'>" + title + "</span>\n" +
						"																		</td>\n" +
						"																	</tr>\n" +
						"																	<tr>\n" +
						"																		<td height='20'></td>\n" +
						"																	</tr>\n" +
						"																</table> <!-- finances overview table starts -->\n" +
						"																<table width='410' cellpadding='10' cellspacing='0'\n" +
						"																	border='1' align='center'\n" +
						"																	style='margin:0px;border:1px solid #ebebeb;padding-left:15px;width:100%;border-collapse:collapse; margin-bottom: 20px;'>\n" +
						"																	<!-- income row starts -->\n" +
						"																	<tr>\n" +
						"																		<td valign='bottom' align='left'\n" +
						"																			style='font-size:18px; font-family:Trebuchet MS, sans-serif;border-color:#ebebeb;border-left-color:#fff; white-space:nowrap;'>\n" +
						"																			<span\n" +
						"																			style='color:#1a2d39; padding-right:10px;font-size:14px; font-weight: bold;'>For\n" +
						"																				Details:</span><br />\n" +
						"																		</td>\n" +
						"																		<td valign='middle' align='left'\n" +
						"																			style='font-size:18px; font-family:Trebuchet MS, sans-serif;border-color:#ebebeb;'>\n" +
						"																			<span\n" +
						"																			style='display:block;font-size:14px;font-weight:bold;padding-top:5px;'>\n" +
						"																				<a\n" +
						"																				style='color:#00929f;text-decoration:none;font-weight:bold;'\n" +
						"																				href='" + link + "'>" + linkText + "</a>\n" +
						"																		</span>\n" +
						"																		</td>\n" +
						"																	</tr>\n" +
						"																	<tr>\n" +
						"																		<td valign='bottom' align='left'\n" +
						"																			style='font-size:18px; font-family:Trebuchet MS, sans-serif;border-color:#ebebeb;border-left-color:#fff; white-space:nowrap;'>\n" +
						"																			<span\n" +
						"																			style='color:#1a2d39; padding-right:10px;font-size:14px; font-weight: bold;'>Type:</span><br />\n" +
						"																		</td>\n" +
						"																		<td valign='middle'\n" +
						"																			style='font-size:18px; font-family:Trebuchet MS, sans-serif;border-color:#ebebeb;'>\n" +
						"																			<span\n" +
						"																			style='display:block; color:gray; font-size:14px;font-weight:bold;padding-top:5px;'>" + type + "</span>\n" +
						"																		</td>\n" +
						"																	</tr>\n" +
						"																	<tr>\n" +
						"																		<td valign='bottom' align='left'\n" +
						"																			style='font-size:18px; font-family:Trebuchet MS, sans-serif;border-color:#ebebeb;border-left-color:#fff; width: 80px;'>\n" +
						"																			<span\n" +
						"																			style='color:#1a2d39; padding-right:10px;font-size:14px; font-weight: bold;'>Trigger\n" +
						"																				By:</span><br />\n" +
						"																		</td>\n" +
						"																		<td valign='middle'\n" +
						"																			style='font-size:18px; font-family:Trebuchet MS, sans-serif;border-color:#ebebeb;'>\n" +
						"																			<span\n" +
						"																			style='display:block; color:gray; font-size:14px;font-weight:bold;padding-top:5px;'>" + triggerBy + "</span>\n" +
						"																		</td>\n" +
						"																	</tr>\n" +
						"																	<tr>\n" +
						"																		<td valign='bottom' align='left'\n" +
						"																			style='font-size:18px; font-family:Trebuchet MS, sans-serif;border-color:#ebebeb;border-left-color:#fff; width: 80px;'>\n" +
						"																			<span\n" +
						"																			style='color:#1a2d39; padding-right:10px;font-size:14px; font-weight: bold;'>State:</span><br />\n" +
						"																		</td>\n" +
						"																		<td valign='middle'\n" +
						"																			style='font-size:18px; font-family:Trebuchet MS, sans-serif;border-color:#ebebeb;'>\n" +
						"																			<span\n" +
						"																			style='display:block; color:gray; font-size:14px;font-weight:bold;padding-top:5px;'>" + requestState + "</span>\n" +
						"																		</td>\n" +
						"																	</tr>\n" +
						"																</table>\n" +
						"																<table width='400' cellpadding='0' cellspacing='0'\n" +
						"																	border='0' align='center'>\n" +
						"																	<tbody>\n" +
						"																		<tr>\n" +
						"																			<td height='20'></td>\n" +
						"																		</tr>\n" +
						"																	</tbody>\n" +
						"																</table>\n" +
						"															</td>\n" +
						"															<td width='20'></td>\n" +
						"														</tr>\n" +
						"													</table>\n" +
						"												</td>\n" +
						"												<td width='20'></td>\n" +
						"												<td valign='top'>&nbsp;</td>\n" +
						"												<td width='20'></td>\n" +
						"											</tr>\n" +
						"										</table>\n" +
						"									</td>\n" +
						"								</tr>\n" +
						"							</table>\n" +
						"							\n" +
						"							<table width='650' cellpadding='0' cellspacing='0' border='0'\n" +
						"								align='center' style='padding:10px 5px;'>\n" +
						"							</table>\n" +
						"							\n" +
						"							<table width='650' cellpadding='0' cellspacing='0' border='0'\n" +
						"								align='center'>\n" +
						"								<tr>\n" +
						"									<td align='center'\n" +
						"										style='font-family:Trebuchet MS, sans-serif; font-size:11px; color: #7c7c7c'>\n" +
						"										<p style='line-height:160%;'>\n" +
						"											This email was sent automatically to <a\n" +
						"												style='color:#00929f;text-decoration:none;font-weight:bold;'\n" +
						"												href='mailto:" + to + "'>" + to + "</a>\n" +
						"											from <a\n" +
						"												style='color:#00929f;text-decoration:none;font-weight:bold;'\n" +
						"												href='#'>Moravia HR System</a>, please do not reply. If you\n" +
						"											are not the receiver metioned in this email, please delete\n" +
						"											the email, thanks for your cooperation.\n" +
						"										</p>\n" +
						"									</td>\n" +
						"								</tr>\n" +
						"							</table> <!-- footer ends -->\n" +
						"						</td>\n" +
						"					</tr>\n" +
						"				</table>\n" +
						"			</td>\n" +
						"		</tr>\n" +
						"	</table>\n" +
						"</html>";
			
				try {
					new Mailer("smtp.moravia-it.com", "false", null, from, "").send(
							new String[] {to}, null, null, subject,
							content);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
	
	}
