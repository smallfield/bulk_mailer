package jp.wsotokyo.controller.edit;

import jp.wsotokyo.service.ReceiverService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        requestScope("list", ReceiverService.getList());
        return forward("index.jsp");
    }
}
