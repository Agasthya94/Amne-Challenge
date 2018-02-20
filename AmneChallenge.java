/* 
Author: Agasthya Vidyanath Rao Peggerla
*/

import java.io.*;
import java.util.*;

class AmneChallenge{
	public static void main(String[] args) throws IOException{

		Map<String,Integer> rm = new HashMap<String,Integer>();

		// Map to store the window's result
		rm.put("ones",0);
		rm.put("c_ones",0);
		rm.put("minusones",0);
		rm.put("c_minusones",0);

		//Read the file name from command line
		String filename = args[0];
		FileReader fr = new FileReader(filename);
      	BufferedReader br=new BufferedReader(fr);

      	//Reading the 'N' and 'K' values

      	String num_win[] = br.readLine().trim().split(" ");
      	int n = Integer.parseInt(num_win[0]);
      	int k = Integer.parseInt(num_win[1]);

      	//Reading the values
      	String line[] = br.readLine().trim().split(" ");
      	int j =0;
      	int flag = 0;
      	int arr[] = new int[n];
      	arr[0] = 0;

      	for (int i=0;i<n-1 ;i++ ) {
      		//Slide the window
      		if((i-j) >= (k-1)){

      			// Print the window's result
      			int sum= rm.get("ones") + rm.get("c_ones") - rm.get("minusones") - rm.get("c_minusones");
      			System.out.println(sum);

      			//Make adjustments for next window
      			if(arr[j + 1] == 1){
      				rm.put("ones",rm.get("ones") - 1);
      				if(arr[j+1] == arr[j+2]){
      					rm.put("c_ones",rm.get("c_ones") - 1);
      				}
      			}

      			if(arr[j + 1] == -1){
      				rm.put("minusones",rm.get("minusones") - 1);
      				if(arr[j+1] == arr[j+2]){
      					rm.put("c_minusones",rm.get("c_minusones") - 1);
      				}
      			}

      			//Slide the window
      			j++;
      		}

      		//Compare with the next element and insert into the map for computation
      		if(line[i+1].compareTo(line[i]) > 0){
      			arr[i+1] = 1;

      			if(flag == 2){
      				rm.put("ones",rm.get("ones")+1);
      			}
   				else if (flag == 1) {
   					rm.put("ones",rm.get("ones")+1);
      				rm.put("c_ones",rm.get("c_ones")+1);
      				flag = 2;
      				}
   				else {
   					rm.put("ones",rm.get("ones")+1);
   					flag = 1;
      				}
      			}


      		else if(line[i+1].compareTo(line[i]) < 0){
      			arr[i+1] = -1;

      			if(flag == -2){
      				rm.put("minusones",rm.get("minusones")+1);
      			}
      			else if (flag == -1) {
      				rm.put("minusones",rm.get("minusones")+1);
      				rm.put("c_minusones",rm.get("c_minusones")+1);
      				flag = -2;
      				}
      				else {
      					rm.put("minusones",rm.get("minusones")+1);
      					flag = -1;
      				}

      			}
      			else{}
      		
      	}

      	// Result of last window.
      	int sum= rm.get("ones") + rm.get("c_ones") - rm.get("minusones") - rm.get("c_minusones");
      	System.out.println(sum);
	}
}