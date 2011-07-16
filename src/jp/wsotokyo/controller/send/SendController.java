package jp.wsotokyo.controller.send;

import java.util.List;

import jp.wsotokyo.model.Receiver;
import jp.wsotokyo.model.SendLog;
import jp.wsotokyo.model.Sender;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions.Builder;
import com.google.appengine.api.taskqueue.TaskOptions.Method;

public class SendController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Sender sender = Datastore.get(Sender.class, asKey("sender"));
        List<Receiver> list = sender.getReceiverListRef().getModelList();

        // logging
        SendLog log = new SendLog();
        log.setReceivers(list);
        log.setText(request.getParameter("body"));
        log.setSubject(request.getParameter("subject"));
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(log);
        tx.commit();

        // メール作成
        for (Receiver receiver : list) {
            QueueFactory.getQueue("mail").add(
                Builder
                    .withUrl("/queue/sendmail")
                    .param("log", KeyFactory.keyToString(log.getKey()))
                    .param("receiver_name", receiver.getName())
                    .param("reciever_email", receiver.getEmail())
                    .param("sender_email", sender.getEmail())
                    .countdownMillis(5000)
                    .method(Method.GET));
        }
        requestScope("list", list);

        return forward("send.jsp");
    }
}
