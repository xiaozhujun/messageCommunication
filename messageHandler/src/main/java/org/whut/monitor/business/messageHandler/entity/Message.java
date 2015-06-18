package org.whut.monitor.business.messageHandler.entity;

/**
 * Created by 涵 on 2015/4/22.
 */
public class Message {
    private long mId;
    private String mName;
    private String protocol;
    private String version;
    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
