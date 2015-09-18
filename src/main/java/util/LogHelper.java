package util;
//import org.testng.Reporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class LogHelper {
	protected static int doneStepsCount = 0; 
 	
	static public void initStepsCount(int cnt){	
 		doneStepsCount = cnt;
 	}
 	
 	public void logMe(){
 		String step = Thread.currentThread().getStackTrace()[2].getMethodName();
 		int cnt = doneStepsCount++;
 	    log(cnt + ". " + step);
	} 
 	
 	public void logMe(String msg){
 		String step = Thread.currentThread().getStackTrace()[2].getMethodName() + " : " + msg;

 		int cnt = doneStepsCount++;
 	    log(cnt + ". " + step);
	} 
 	
 	public void logMe(int i){
 		String step = Thread.currentThread().getStackTrace()[2].getMethodName() + " : " + i;
 		
 		int cnt = doneStepsCount++;
 	    log(cnt + ". " + step);
	} 
 	
 	public void logMe(double i){
 		String step = Thread.currentThread().getStackTrace()[2].getMethodName() + " : " + i;
 		
 		int cnt = doneStepsCount++;
 	    log(cnt + ". " + step);
	}
 	
 	public void logRaw(String step){
 		int cnt = doneStepsCount++;	
 		
 		log(cnt + ". ~" + step);
	} 
 	
  	public void logTimeStamp(String step){
		String strTime = getTimeStamp();
		
		log(strTime);
	}	
  	
  	public String getTimeStamp(){
  		DateFormat myFormat = new SimpleDateFormat("HH:mm:ss", new Locale("uk", "UA"));
		DateFormat.getInstance();	
		return  myFormat.format(new Date());
	}	
  	
	public void log(String message){
 		System.out.println(message);
 		
// 		Reporter.setEscapeHtml(false);
// 	    Reporter.log(message);
	} 
}
