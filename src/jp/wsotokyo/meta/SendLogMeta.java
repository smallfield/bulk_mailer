package jp.wsotokyo.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-05-18 16:35:30")
/** */
public final class SendLogMeta extends org.slim3.datastore.ModelMeta<jp.wsotokyo.model.SendLog> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.SendLog, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.SendLog, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.SendLog, java.util.Date> sendDate = new org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.SendLog, java.util.Date>(this, "sendDate", "sendDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.SendLog> subject = new org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.SendLog>(this, "subject", "subject");

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<jp.wsotokyo.model.SendLog> text = new org.slim3.datastore.StringUnindexedAttributeMeta<jp.wsotokyo.model.SendLog>(this, "text", "text");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.SendLog, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.SendLog, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final SendLogMeta slim3_singleton = new SendLogMeta();

    /**
     * @return the singleton
     */
    public static SendLogMeta get() {
       return slim3_singleton;
    }

    /** */
    public SendLogMeta() {
        super("SendLog", jp.wsotokyo.model.SendLog.class);
    }

    @Override
    public jp.wsotokyo.model.SendLog entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jp.wsotokyo.model.SendLog model = new jp.wsotokyo.model.SendLog();
        model.setKey(entity.getKey());
        java.util.List<jp.wsotokyo.model.Receiver> _receivers = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("receivers"));
        model.setReceivers(_receivers);
        model.setSendDate((java.util.Date) entity.getProperty("sendDate"));
        model.setSubject((java.lang.String) entity.getProperty("subject"));
        model.setText(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("text")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jp.wsotokyo.model.SendLog m = (jp.wsotokyo.model.SendLog) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("receivers", serializableToBlob(m.getReceivers()));
        entity.setProperty("sendDate", m.getSendDate());
        entity.setProperty("subject", m.getSubject());
        entity.setUnindexedProperty("text", stringToText(m.getText()));
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jp.wsotokyo.model.SendLog m = (jp.wsotokyo.model.SendLog) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jp.wsotokyo.model.SendLog m = (jp.wsotokyo.model.SendLog) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jp.wsotokyo.model.SendLog m = (jp.wsotokyo.model.SendLog) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jp.wsotokyo.model.SendLog m = (jp.wsotokyo.model.SendLog) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        jp.wsotokyo.model.SendLog m = (jp.wsotokyo.model.SendLog) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getReceivers() != null){
            writer.setNextPropertyName("receivers");
            encoder = new org.slim3.datastore.json.Default();
            // jp.wsotokyo.model.Receiver is not supported.
        }
        if(m.getSendDate() != null){
            writer.setNextPropertyName("sendDate");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getSendDate());
        }
        if(m.getSubject() != null){
            writer.setNextPropertyName("subject");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getSubject());
        }
        if(m.getText() != null){
            writer.setNextPropertyName("text");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getText());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected jp.wsotokyo.model.SendLog jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jp.wsotokyo.model.SendLog m = new jp.wsotokyo.model.SendLog();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("receivers");
        decoder = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("sendDate");
        decoder = new org.slim3.datastore.json.Default();
        m.setSendDate(decoder.decode(reader, m.getSendDate()));
        reader = rootReader.newObjectReader("subject");
        decoder = new org.slim3.datastore.json.Default();
        m.setSubject(decoder.decode(reader, m.getSubject()));
        reader = rootReader.newObjectReader("text");
        decoder = new org.slim3.datastore.json.Default();
        m.setText(decoder.decode(reader, m.getText()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
        return m;
    }
}