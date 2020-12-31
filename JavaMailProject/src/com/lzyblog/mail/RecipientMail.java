package com.lzyblog.mail;
 
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
 
public class RecipientMail {
    //�ռ��˵�ַ
    public static String recipientAddress = "xxx@163.com";
    //�ռ����˻���
    public static String recipientAccount = "xxx";
    //�ռ����˻�����
    public static String recipientPassword = "xxx";
     
    public static void main(String[] args) throws Exception {
        //1�������ʼ��������Ĳ�������
        Properties props = new Properties();
        //���ô���Э��
        props.setProperty("mail.store.protocol", "pop3");
        //�����ռ��˵�POP3������
        props.setProperty("mail.pop3.host", "pop3.163.com");
        //2��������������Ӧ�ó�������Ļ�����Ϣ�� Session ����
        Session session = Session.getInstance(props);
        //���õ�����Ϣ�ڿ���̨��ӡ����
        //session.setDebug(true);
         
        Store store = session.getStore("pop3");
        //�����ռ���POP3������
        store.connect("pop3.163.com", recipientAccount, recipientPassword);
        //����û����ʼ��˻���ע��ͨ��pop3Э���ȡĳ���ʼ��е�����ֻ��Ϊinbox
        Folder folder = store.getFolder("inbox");
        //���ö��ʼ��˻��ķ���Ȩ��
        folder.open(Folder.READ_WRITE);
         
        //�õ��ʼ��˻��������ʼ���Ϣ
        Message [] messages = folder.getMessages();
        for(int i = 0 ; i < messages.length ; i++){
            //����ʼ�����
            String subject = messages[i].getSubject();
            //����ʼ�������
            Address[] from = messages[i].getFrom();
            //��ȡ�ʼ����ݣ������ʼ����ݵ�html���룩
            String content = (String) messages[i].getContent();
        }
         
        //�ر��ʼ��ж���
        folder.close();
        //�ر����Ӷ���
        store.close();
    }
 
}