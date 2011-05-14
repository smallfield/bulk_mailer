package jp.wsotokyo.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-05-14 08:34:32")
/** */
public final class SenderMeta extends org.slim3.datastore.ModelMeta<jp.wsotokyo.model.Sender> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.Sender> email = new org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.Sender>(this, "email", "email");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.Sender, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.Sender, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.Sender> name = new org.slim3.datastore.StringAttributeMeta<jp.wsotokyo.model.Sender>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.Sender, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jp.wsotokyo.model.Sender, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final SenderMeta slim3_singleton = new SenderMeta();

    /**
     * @return the singleton
     */
    public static SenderMeta get() {
       return slim3_singleton;
    }

    /** */
    public SenderMeta() {
        super("Sender", jp.wsotokyo.model.Sender.class);
    }

    @Override
    public jp.wsotokyo.model.Sender entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jp.wsotokyo.model.Sender model = new jp.wsotokyo.model.Sender();
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jp.wsotokyo.model.Sender m = (jp.wsotokyo.model.Sender) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("email", m.getEmail());
        entity.setProperty("name", m.getName());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jp.wsotokyo.model.Sender m = (jp.wsotokyo.model.Sender) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jp.wsotokyo.model.Sender m = (jp.wsotokyo.model.Sender) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jp.wsotokyo.model.Sender m = (jp.wsotokyo.model.Sender) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jp.wsotokyo.model.Sender m = (jp.wsotokyo.model.Sender) model;
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
        jp.wsotokyo.model.Sender m = (jp.wsotokyo.model.Sender) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getEmail());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getName());
        }
        if(m.getReceiverListRef() != null){
            writer.setNextPropertyName("receiverListRef");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getReceiverListRef());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected jp.wsotokyo.model.Sender jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jp.wsotokyo.model.Sender m = new jp.wsotokyo.model.Sender();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("email");
        decoder = new org.slim3.datastore.json.Default();
        m.setEmail(decoder.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        decoder = new org.slim3.datastore.json.Default();
        m.setName(decoder.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("receiverListRef");
        decoder = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
        return m;
    }
}