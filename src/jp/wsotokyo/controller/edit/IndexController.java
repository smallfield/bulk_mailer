package jp.wsotokyo.controller.edit;

import jp.wsotokyo.service.ReceiverService;
import jp.wsotokyo.service.SenderService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        requestScope("list", ReceiverService.getList());
        requestScope("sender_list", SenderService.getList());
        return forward("index.jsp");
    }
}
