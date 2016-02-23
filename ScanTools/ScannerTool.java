package ScanTools;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.*;

/**
 * Created by layfl on 23.02.2016.
 */
public class ScannerTool {

    private String ip;
    private int portFrom;
    private int portTo;

    private final int timeout = 200; /* ms */
    private final int max_threads = 5;

    private TreeMap<String, String> resultStatus;

    private final ExecutorService executorService = Executors.newFixedThreadPool(max_threads);

    public ScannerTool(final String ip, final int portFrom, final int portTo) {
        this.ip = ip;
        this.portFrom = portFrom;
        this.portTo = portTo;

        resultStatus = new TreeMap<>();
    }

    public void scan() {
        ArrayList<Future<ScanResult>> futures = new ArrayList<>();
        for (int i = portFrom; i < portTo; i++) {
            futures.add(scanPort(i));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Future<ScanResult> f : futures) {
            try {
                if (f.get().isStatus()) {
                    System.out.println("PORT = " + f.get().getPort());
                    resultStatus.put(String.valueOf(f.get().getPort()), "OPEN");
                }
            } catch (ExecutionException | InterruptedException ex) {
                System.out.println("ERROR! CANNOT CREATE ScanResult");
            }
        }

    }

    private Future<ScanResult> scanPort(int port) {
        return executorService.submit(() -> {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ip, port), timeout);
                socket.close();
                return new ScanResult(ip, port, true, timeout);

            } catch (Exception ex) {
                return new ScanResult(ip, port, false, timeout);
            }
        });
    }

    public TreeMap<String, String> getResultStatus() {
        return resultStatus;
    }

}
