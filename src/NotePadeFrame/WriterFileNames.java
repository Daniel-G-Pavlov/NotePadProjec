package NotePadeFrame;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriterFileNames {

    public WriterFileNames( String fileName)  throws FileNotFoundException{
        System.out.println(fileName + " 97");
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter( "NewFileNameSave.txt"));
            writer.write( fileName);
        }
        catch ( IOException e)
        {
        }
        finally
        {
            try
            {
                if ( writer != null)
                    writer.close( );
            }
            catch ( IOException e)
            {
            }
        }
    }
}
