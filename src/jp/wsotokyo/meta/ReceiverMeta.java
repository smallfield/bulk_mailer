package jp.wsotokyo.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-05-14 01:13:45")
/** */
public final class ReceiverMeta extends org.slim3.datastore.ModelMeta<jp.wsotokyo.model.Receiver> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.Receiver, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.Receiver, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.Receiver> mailaddress = new org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.Receiver>(this, "mailaddress", "mailaddress");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.Receiver> name = new org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.Receiver>(this, "name", "name");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<jp.wsotokyo.model.Receiver, org.slim3.datastore.ModelRef<jp.wsotokyo.model.Sender>, jp.wsotokyo.model.Sender> senderRef = new org.slim3.datastore.ModelRefAttributeMeta<jp.wsotokyo.model.Receiver, org.slim3.datastore.ModelRef<jp.wsotokyo.model.Sender>, jp.wsotokyo.model.Sender>(this, "senderRef", "senderRef", org.slim3.datastore.ModelRef.class, jp.wsotokyo.model.Sender.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.Receiver, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.Receiver, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final ReceiverMeta slim3_singleton = new ReceiverMeta();

    /**
     * @return the singleton
     */
    public static ReceiverMeta get() {
       return slim3_singleton;
    }

    /** */
    public ReceiverMeta() {
        super("Receiver", jp.wsotokyo.model.Receiver.class);
    }

    @Override
    public jp.wsotokyo.model.Receiver entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jp.wsotokyo.model.Receiver model = new jp.wsotokyo.model.Receiver();
        model.setKey(entity.getKey());
        model.setMailaddress((java.lang.String) entity.getProperty("mailaddress"));
        model.setName((java.lang.String) entity.getProperty("name"));
        if (model.getSenderRef() == null) {
            throw new NullPointerException("The property(senderRef) is null.");
        }
        model.getSenderRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("senderRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jp.wsotokyo.model.Receiver m = (jp.wsotokyo.model.Receiver) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("mailaddress", m.getMailaddress());
        entity.setProperty("name", m.getName());
        if (m.getSenderRef() == null) {
            throw new NullPointerException("The property(senderRef) must not be null.");
        }
        entity.setProperty("senderRef", m.getSenderRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jp.wsotokyo.model.Receiver m = (jp.wsotokyo.model.Receiver) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jp.wsotokyo.model.Receiver m = (jp.wsotokyo.model.Receiver) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jp.wsotokyo.model.Receiver m = (jp.wsotokyo.model.Receiver) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        jp.wsotokyo.model.Receiver m = (jp.wsotokyo.model.Receiver) model;
        if (m.getSenderRef() == null) {
            throw new NullPointerException("The property(senderRef) must not be null.");
        }
        m.getSenderRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        jp.wsotokyo.model.Receiver m = (jp.wsotokyo.model.Receiver) model;
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
        jp.wsotokyo.model.Receiver m = (jp.wsotokyo.model.Receiver) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getMailaddress() != null){
            writer.setNextPropertyName("mailaddress");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getMailaddress());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getName());
        }
        if(m.getSenderRef() != null && m.getSenderRef().getKey() != null){
            writer.setNextPropertyName("senderRef");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getSenderRef(), maxDepth, currentDepth);
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected jp.wsotokyo.model.Receiver jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jp.wsotokyo.model.Receiver m = new jp.wsotokyo.model.Receiver();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("mailaddress");
        decoder = new org.slim3.datastore.json.Default();
        m.setMailaddress(decoder.decode(reader, m.getMailaddress()));
        reader = rootReader.newObjectReader("name");
        decoder = new org.slim3.datastore.json.Default();
        m.setName(decoder.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("senderRef");
        decoder = new org.slim3.datastore.json.Default();
        decoder.decode(reader, m.getSenderRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
        return m;
    }
}