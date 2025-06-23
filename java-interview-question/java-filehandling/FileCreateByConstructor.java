import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Using createNewFile
 * File file = new File("d://test//testFile1.txt");

//Create the file
if (file.createNewFile()) { 
   System.out.println("File is created!");
} else {
   System.out.println("File already exists.");
} 
 */
public class FileCreateByConstructor{
    public static void main(String[] args){
        try{
            byte bWrite[]={65, 66, 67, 68, 69};
            OutputStream os=new FileOutPutStream("test.txt");
            for(int i=0;i<bWrite.length;i++){
                os.write(bWrite[i]);
            }
            os.close();
            InputStream is=new FileInptStream("test.txt");
            int size=is.available();
            for(int i=0;i<size;i++){
                System.out.println((char)is.read()+" ");
            }
            is.close();
        }catch(IOException e){
            System.out.print(e.getMessage());
        }
    }
}