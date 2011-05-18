package jp.wsotokyo.service;

import java.util.List;

import jp.wsotokyo.meta.SendLogMeta;
import jp.wsotokyo.model.SendLog;

import org.slim3.datastore.Datastore;

public class SendLogService {
    static SendLogMeta m = new SendLogMeta();

    public static List<SendLog> getList() {
        return Datastore.query(m).asList();
    }
}
