import java.io.*;

public class CheckWindowsLogin{
	   public static void main(String[] args) throws Exception {
        /*Process p;
        StringBuilder sb = new StringBuilder();

        p = Runtime.getRuntime().exec("quser");
        p.waitFor();

        BufferedReader reader
                = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        System.out.println(sb);*/

	EventLogIterator iter = new EventLogIterator("Application");         
while(iter.hasNext()) { 
    EventLogRecord record = iter.next(); 
    System.out.println(record.getRecordNumber() 
            + ": Event ID: " + record.getEventId() 
            + ", Event Type: " + record.getType() 
            + ", Event Source: " + record.getSource()); 
} 

    }
}