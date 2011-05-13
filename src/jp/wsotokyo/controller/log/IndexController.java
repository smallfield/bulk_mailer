package jp.wsotokyo.controller.log;

import jp.wsotokyo.meta.SendLogMeta;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        SendLogMeta sl = new SendLogMeta();
        requestScope("list", Datastore.query(sl).sort(sl.sendDate.desc).asList());
        return forward("index.jsp");
    }
}
