package jp.wsotokyo.controller.send;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import jp.wsotokyo.model.Receiver;
import jp.wsotokyo.model.SendLog;
import jp.wsotokyo.service.ReceiverService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;

public class SendController extends Controller {

    @Override
    public Navigation run() throws Exception {
        List<Receiver> list = ReceiverService.getList();

        // メール作成
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        String msgBody = request.getParameter("body");
        String subject = request.getParameter("subject");
        for (Receiver receiver : list) {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("office@wso-tokyo.jp"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                receiver.getEmail(),
                ""));
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            String jis = new String(subject.getBytes("iso-2022-jp"));
            OutputStream out = MimeUtility.encode(bao, "base64");
            out.write(jis.getBytes("iso-8859-1"));
            out.close();
            msg.setSubject("=?iso-2022-jp?B?"+bao.toString("iso-8859-1")+"?=");
            msg.setText(msgBody.replaceAll("%NAME%", receiver.getName()));
            Transport.send(msg);
        }
        requestScope("list", list);

        // logging
        SendLog log = new SendLog();
        log.setReceivers(list);
        log.setText(request.getParameter("body"));
        log.setSubject(request.getParameter("subject"));
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(log);
        tx.commit();

        return forward("send.jsp");
    }
}
