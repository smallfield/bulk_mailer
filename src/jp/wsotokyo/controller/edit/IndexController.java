package jp.wsotokyo.controller.edit;

import jp.wsotokyo.meta.ReceiverMeta;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ReceiverMeta r = new ReceiverMeta();
        requestScope("list", Datastore.query(r).asList());
        return forward("index.jsp");
    }
}
