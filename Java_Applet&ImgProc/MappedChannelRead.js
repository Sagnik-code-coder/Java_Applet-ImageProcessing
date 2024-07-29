import java.io.*;
import java.nio.*;
import java.nio.channels.*;
public class MappedChannelRead
{
	public static void main(String args[])
	{
		FileInputStream fin;
		FileChannel fchan;
		long fsize;
		MappedByteBuffer mbuf;
		try
		{
			//First open a file for input
			fin = new FileInputStream("Test.txt");
			//Next obtain a channel to file
			fchan = fin.getChannel();
			//Now get the file size
			fsize = fchan.size();
			//Now map the file into a buffer
			mbuf = fchan.map(FileChannel.MapMode.READ_ONLY,0,fsize);
			//read bytes from the buffer
			for(int i=0;i<fsize;i++)
			{
				System.out.print((char)mbuf.get());
				
			}
			System.out.println();
			fchan.close(); //close channel
			fin.close(); // close file
		}
		catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}
}
