package jp.wsotokyo.controller.edit;

import jp.wsotokyo.meta.ReceiverMeta;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class DeleteController extends Controller {
    static ReceiverMeta rmeta = new ReceiverMeta();

    @Override
    public Navigation run() throws Exception {
        Datastore.delete(asKey("id"));
        return redirect(basePath);
    }
}
