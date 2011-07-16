package jp.wsotokyo.controller.queue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import jp.wsotokyo.model.SendLog;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class SendmailController extends Controller {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public Navigation run() throws Exception {
        try {
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            String receiver_email = param("reciever_email");
            String receiver_name = param("receiver_name");
            String sender_email = param("sender_email");
            SendLog log = Datastore.get(SendLog.class, asKey("log"));

            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(sender_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                receiver_email,
                ""));
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            String jis = new String(log.getSubject().getBytes("iso-2022-jp"));
            OutputStream out = MimeUtility.encode(bao, "base64");
            out.write(jis.getBytes("iso-8859-1"));
            out.close();
            msg.setSubject("=?iso-2022-jp?B?"
                + bao.toString("iso-8859-1")
                + "?=");
            msg.setText(log.getText().replaceAll("%NAME%", receiver_name));
            Transport.send(msg);
        } catch (Exception ignore) {
            logger.log(Level.SEVERE, "sending mail error", ignore);
        }

        return null;
    }
}
