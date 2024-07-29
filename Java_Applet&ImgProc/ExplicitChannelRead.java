import java.io.*;
import java.nio.*;
import java.nio.channels.*;
public class ExplicitChannelRead
{
	public static void main(String args[])
	{
		FileInputStream fin;
		FileChannel fchan;
		long fsize;
		ByteBuffer mbuf;
		try
		{
			//First open a file for input
			fin = new FileInputStream("Test.txt");
			//Next obtain a channel to file
			fchan = fin.getChannel();
			//Now get the file size
			fsize = fchan.size();
			//Allocate a buffer to obtain a necessary site
			mbuf = ByteBuffer.allocate((int)fsize);
			//Read the file input the buffer
			fchan.read(mbuf);
			//rewind the buffer so that it can be read
			mbuf.rewind();
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