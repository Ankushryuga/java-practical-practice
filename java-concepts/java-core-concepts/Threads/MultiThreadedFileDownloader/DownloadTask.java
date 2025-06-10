
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class DownloadTask implements Runnable{
    private final String fileURL;
    private final long startByte;
    private final long endByte;
    private final int partNumber;
    private final File outputFile;

    public DownloadTask(String fileURL, long startByte, long endByte, int partNumber, File outputFile){
        this.fileURL=fileURL;
        this.startByte=startByte;
        this.endByte=endByte;
        this.partNumber=partNumber;
        this.outputFile=outputFile;
    }

    @Override
    public void run(){
        try {
            HttpURLConnection conn=(HttpsURLConnection) new URL(fileURL).openConnection();
            String byteRange="bytes="+startByte+"-"+endByte;
            conn.setRequestProperty("Range", byteRange);
            conn.connect();
            try(InputStream in=conn.getInputStream();
                RandomAccessFile writer=new RandomAccessFile(outputFile, "rw"))
                {
                    writer.seek(startByte);
                    byte[] buffer=new byte[4096];
                    int bytesRead;
                    while((bytesRead= in.read(buffer))!=-1){
                        writer.write(buffer, 0, bytesRead);
                    }
                    System.out.println("Part "+ partNumber + " downloaded");
                }
                conn.disconnect();
        } catch (IOException e) {
            System.out.println("Error downloading part "+partNumber+" : "+e.getMessage());
        }
    }
}