package jp.wsotokyo.service;

import java.util.List;

import jp.wsotokyo.meta.SenderMeta;
import jp.wsotokyo.model.Sender;

import org.slim3.datastore.Datastore;

public class SenderService {
    static SenderMeta m = new SenderMeta();

    public static List<Sender> getList() {
        return Datastore.query(m).asList();
    }
}
