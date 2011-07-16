package jp.wsotokyo.controller.editsender;

import jp.wsotokyo.meta.SenderMeta;
import jp.wsotokyo.model.Sender;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

public class CommitController extends Controller {

    private SenderMeta meta = SenderMeta.get();

    @Override
    public Navigation run() throws Exception {
        if (validate()) {
            // add when it's valid mailaddresses
            Sender sender = new Sender();
            BeanUtil.copy(request, sender);
            Transaction tx = Datastore.beginTransaction();
            Datastore.put(sender);
            tx.commit();
            return redirect(basePath);
        }
        return forward(basePath);
    }

    protected boolean validate() {
        Validators v = new Validators(request);
        v
            .add(
                meta.email,
                v.required(),
                v
                    .regexp("^[a-z0-9_\\+-]+(\\.[a-z0-9_\\+-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2,4})$"));
        v.add(meta.name, v.required());

        return v.validate();
    }

}
