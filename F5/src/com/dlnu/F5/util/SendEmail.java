package com.dlnu.F5.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendEmail {
		
		public static void send(String receiveMail,String mess) throws AddressException, MessagingException, InterruptedException {

			// ����Properties �����ڼ�¼�����һЩ����
			Properties props = new Properties();
			// ��ʾSMTP�����ʼ���������������֤
			props.put("mail.smtp.auth", "true");
			// �˴���дSMTP������
			props.put("mail.smtp.host", "smtp.qq.com");
			// �˿ںţ�QQ����˿�587
			props.put("mail.smtp.port", "587");
			// �˴���д��д���˵��˺�
			props.put("mail.user", "1556654608@qq.com");
			// �˴���д16λSTMP����
			props.put("mail.password", "nmgksichsqzjjabb");

			// ������Ȩ��Ϣ�����ڽ���SMTP���������֤
			Authenticator authenticator = new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					// �û���������
					String userName = props.getProperty("mail.user");
					String password = props.getProperty("mail.password");
					return new PasswordAuthentication(userName, password);
				}
			};
			// ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
			Session mailSession = Session.getInstance(props, authenticator);
			// �����ʼ���Ϣ
			MimeMessage message = new MimeMessage(mailSession);
			// ���÷�����
			InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
			message.setFrom(form);

			// �����ռ��˵�����
			InternetAddress to = new InternetAddress(receiveMail);
			message.setRecipient(RecipientType.TO, to);

			message.setSubject("��������");

			message.setContent(mess, "text/html;charset=UTF-8");

			Transport.send(message);

		}
		



	
}
