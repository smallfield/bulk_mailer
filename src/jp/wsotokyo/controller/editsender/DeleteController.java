package jp.wsotokyo.controller.editsender;

import jp.wsotokyo.model.Receiver;
import jp.wsotokyo.model.Sender;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class DeleteController extends Controller {

    @Override
    public Navigation run() throws Exception {
        Sender sender = Datastore.get(Sender.class, asKey("id"));
        for (Receiver receiver : sender.getReceiverListRef().getModelList()) {
            Datastore.delete(receiver.getKey());
        }
        Datastore.delete(asKey("id"));
        return redirect(basePath);
    }
}
