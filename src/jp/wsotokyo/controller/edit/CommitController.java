package jp.wsotokyo.controller.edit;

import jp.wsotokyo.model.Receiver;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;

public class CommitController extends Controller {
    @Override
    public Navigation run() throws Exception {

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        if (name.length() > 0
            && email.length() > 0
            && email
                .matches("^[a-z0-9_\\+-]+(\\.[a-z0-9_\\+-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2,4})$")) {
            // add valid mailaddresses
            Receiver receiver = new Receiver();
            receiver.setMailaddress(email);
            receiver.setName(name);
            Transaction tx = Datastore.beginTransaction();
            Datastore.put(receiver);
            tx.commit();
        }
        return redirect(basePath);
    }
}