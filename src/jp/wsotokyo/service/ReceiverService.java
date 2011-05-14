package jp.wsotokyo.service;

import java.util.List;

import jp.wsotokyo.meta.ReceiverMeta;
import jp.wsotokyo.model.Receiver;

import org.slim3.datastore.Datastore;

public class ReceiverService {
    static ReceiverMeta r = new ReceiverMeta();

    public static List<Receiver> getList() {
        return Datastore.query(r).asList();
    }
}
