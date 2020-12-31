package com.lzyblog.mail;
 
import java.io.ObjectInputStream.GetField;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.html.MinimalHTMLWriter;
 
public class SendMailText {
    //�����������ַ
    public static String senderAddress = "lzyblog24@163.com";
    //�ռ��������ַ
    public static String recipientAddress = "2312057536@qq.com";
    //�����������˻���
    public static String senderAccount = "lzyblog24@163.com";
    //�����������˻�����(�������������Ȩ��)
    public static String senderPassword = "EWJLZXEBZTAVSMII";
     
    public static void main(String[] args) throws Exception {
        //1�������ʼ��������Ĳ�������
        Properties props = new Properties();
        //�����û�����֤��ʽ����Ҫ������֤
        props.setProperty("mail.smtp.auth", "true");
        //���ô���Э��
        props.setProperty("mail.transport.protocol", "smtp");
        //���÷����˵�SMTP��������ַ����ʽsmtp.xxx.com
        props.setProperty("mail.smtp.host", "smtp.163.com");
        
        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        /*
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        */
        
       //2��������������Ӧ�ó�������Ļ�����Ϣ�� Session ����
        Session session = Session.getInstance(props);
        //���õ�����Ϣ�ڿ���̨��ӡ����
        session.setDebug(true);
        //3�������ʼ���ʵ������
        Message msg = getMimeMessage(session);
        //4������session�����ȡ�ʼ��������Transport
        Transport transport = session.getTransport();
        //���÷����˵��˻���������
        transport.connect(senderAccount, senderPassword);
        //�����ʼ��������͵������ռ��˵�ַ��message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(msg,msg.getAllRecipients());
         
        //���ֻ�뷢�͸�ָ�����ˣ���������д��
        //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});
         
        //5���ر��ʼ�����
        transport.close();
    }
     
    
    /**
     * ��ô���һ���ʼ���ʵ������
     * @param session
     * @return
     * @throws MessagingException
     * @throws AddressException
     */
    public static MimeMessage getMimeMessage(Session session) throws Exception{
        //1.����һ���ʼ���ʵ������
        MimeMessage msg = new MimeMessage(session);
        //2.From:���÷����˵�ַ
        msg.setFrom(new InternetAddress(senderAddress));
        
        
        
        /**
         * �����ռ��˵�ַ���������Ӷ���ռ��ˡ����͡����ͣ�����������һ�д�����д����
         * MimeMessage.RecipientType.TO:����
         * MimeMessage.RecipientType.CC������
         * MimeMessage.RecipientType.BCC������
         */
        //3.To:�ռ���
        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recipientAddress));
        //4.Subject�������ʼ�����
        msg.setSubject("�ʼ�����","UTF-8");
        //5.Content�������ʼ����ģ�����ʹ��HTML��ǩ��
        msg.setContent("�򵥵Ĵ��ı��ʼ���", "text/html;charset=UTF-8");
        //6.�����ʼ��ķ���ʱ��,Ĭ����������
        msg.setSentDate(new Date());
         //7.��������
        msg.saveChanges();
        return msg;
    }
 
}