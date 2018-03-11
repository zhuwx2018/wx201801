package com.wx.controller.system;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wx.common.ServerResponse;
import com.wx.util.EmailUtils;

/**
 *<p>Title: EmailController</p>
 *<p>Description:邮件发送 </p>
 * @author zhugf
 * @date 2018年3月3日
 */
@Controller
@RequestMapping("/email/")
public class EmailController {
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private VelocityEngine velocityEngine;
	
	/**
	 * 发送邮件
	 * @return
	 */
	@RequestMapping("send")
	public ServerResponse<?> send(){
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		simpleMailMessage.setFrom("2456025825@qq.com");
//		simpleMailMessage.setTo("2529000436@qq.com");
//		simpleMailMessage.setSubject("demo");
//		simpleMailMessage.setText("hello world");
//		
//		mailSender.send(simpleMailMessage);
		
		Map< String, Object> map = new HashMap<String,Object>();
		map.put("title", "欢迎页面");
		map.put("context", "欢迎使用邮箱！");
		
		String htmlText = "<html><head>"+
                "</head><body>"+
                "<h1>Hello,Nice to meet you!</h1>"+
                "<span style='color:red;font-size:36px;'>测试一下代码</span>"+
                "<img src='cid:default3.jpg'>"+
                "</body></html>";
		//使用Velocity模板
		String modleText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "veloctiyTemplate/welcome.html", "utf-8", map);
		String[] to = {"2529000436@qq.com","zhugfrap@163.com"};
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setText(modleText, true);
			helper.setFrom("2456025825@qq.com");
			helper.setSubject("welcome!!");
			
			FileSystemResource image = new FileSystemResource("C:\\Users\\zhugf\\Desktop\\default3.jpg");
			//FileSystemResource doc = new FileSystemResource("C:\\Users\\zhugf\\Desktop\\用户收集.xlsx");
			//helper.addAttachment("用户收集.xlsx", doc);
			//添加附件
			//helper.addAttachment(attachmentFilename, dataSource);
			//添加内联样式
			helper.addInline("default3.jpg", image);
			helper.setTo(to);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		mailSender.send(mimeMessage);
		
		return null;
	}

}
