package jp.wsotokyo.controller.edit;

import jp.wsotokyo.meta.ReceiverMeta;
import jp.wsotokyo.model.Receiver;
import jp.wsotokyo.model.Sender;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

public class CommitController extends Controller {
    private ReceiverMeta meta = ReceiverMeta.get();

    @Override
    public Navigation run() throws Exception {
        if (validate()) {
            // add when it's valid mailaddresses
            Receiver receiver = new Receiver();
            BeanUtil.copy(request, receiver);
            receiver.getSenderRef().setModel(
                Datastore.get(Sender.class, asKey("sender")));
            Transaction tx = Datastore.beginTransaction();
            Datastore.put(receiver);
            tx.commit();
        }
        return forward(basePath);
    }

    protected boolean validate() {
        Validators v = new Validators(request);
        v.add(meta.email, v.required());
        v.add(meta.name, v.required());
        v
            .add(
                meta.email,
                v
                    .regexp("^[a-z0-9_\\+-]+(\\.[a-z0-9_\\+-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2,4})$"));
        v.add("sender", v.required());
        return v.validate();
    }

}
