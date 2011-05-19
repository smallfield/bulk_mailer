package jp.wsotokyo.controller.editsender;

import jp.wsotokyo.service.SenderService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        requestScope("list", SenderService.getList());
        return forward("index.jsp");
    }
}
