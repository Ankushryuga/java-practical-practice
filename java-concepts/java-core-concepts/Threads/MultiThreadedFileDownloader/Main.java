
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;

public class Main{
    public static void main(String[] args) throws IOException {
        String url="http://example.com/largeFile.zip";  //replace with a real time larget file URL.
        String outputFileName="downloaded_file.zip";
        int numberOfThreads=4;

        //connect once to get file size.
        HttpURLConnection conn= (HttpsURLConnection) new URL(url).openConnection();
        int contentLength=conn.getContentLength();
        conn.disconnect();

        System.out.println("Total File Size: "+ contentLength+" bytes");

        //prepare local file.
        File outputFile=new File(outputFileName);
        if(!outputFile.exists()){
            outputFile.createNewFile();
        }

        RandomAccessFile raf=new RandomAccessFile(outputFile, "rw");
        raf.setLength(contentLength);
        raf.close();

        long chunkSize=contentLength/numberOfThreads;
        ExecutorService executor=Executors.newFixedThreadPool(numberOfThreads);
        for(int i=0;i<numberOfThreads;i++){
            long startByte=i*chunkSize;
            long endByte=i==numberOfThreads-1?contentLength-1:(startByte+chunkSize-1);
            executor.submit(new DownloadTask(url, startByte, endByte, i+1, outputFile));
        }
        executor.shutdown();
        while(!executor.isTerminated()){
            //wait for all threads/
        }
        System.out.println("Download complete: "+outputFileName);
    }
}

/**
 * 📌 Notes:
Range Header: We use the Range HTTP header to download specific parts of the file.

RandomAccessFile: Allows writing to specific positions in the file.

Thread Pool: Managed using ExecutorService.

✅ How to Test It:
Replace the placeholder URL with a real one that supports partial downloads (like a large .zip or .mp4).
 */