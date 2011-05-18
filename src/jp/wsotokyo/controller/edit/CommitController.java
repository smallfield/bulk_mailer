package jp.wsotokyo.controller.edit;

import jp.wsotokyo.model.Receiver;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

public class CommitController extends Controller {
    @Override
    public Navigation run() throws Exception {

        String email =asString("email");
        String name = asString("name");
        if (name.length() > 0
            && email.length() > 0
            && email
                .matches("^[a-z0-9_\\+-]+(\\.[a-z0-9_\\+-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2,4})$")) {
            // add when it's valid mailaddresses
            Receiver receiver = new Receiver();
            BeanUtil.copy(request, receiver);
            Transaction tx = Datastore.beginTransaction();
            Datastore.put(receiver);
            tx.commit();
        }
        return redirect(basePath);
    }
}
