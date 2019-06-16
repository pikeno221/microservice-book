package models;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = -5930904419691645745L;

    private String greeting;
    private Long time;
    private String ip;

    public ResponseDTO() {

    }

    public ResponseDTO(String greeting, Long time, String ip) {
        this.greeting = greeting;
        this.time = time;
        this.ip = ip;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
