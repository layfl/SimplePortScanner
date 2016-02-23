package ScanTools;

/**
 * Created by layfl on 23.02.2016.
 */
public class ScanResult {
    private String ip;
    private int port;
    private int timeout;
    private boolean status;


    public ScanResult(String ip, int port, boolean status, int timeout) {
        this.ip = ip;
        this.port = port;
        this.status = status;
        this.timeout = timeout;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
