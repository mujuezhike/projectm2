package com.mujuezhike.projectm.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileReadToSqlTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("c:/data/www.txt")),
                 "UTF-8"));
		
		File f = new File("c:/data/www4.txt");
		OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f),"UTF-8"); 
        BufferedWriter bw = new BufferedWriter(write);
        
        
		String line = "";
		while((line = br.readLine())!=null) {
			
			String[] erjm = line.split(",");
			//String[] erjm = line.split("	");
			//System.out.println(line);
			String  mkm = "UPDATE `tracing`.`stores` SET `store_name`='"+erjm[2]+"', `store_address`='"+erjm[7]+"', `contacts`='"+erjm[3]+"', `phone_number`='"+erjm[6]+"'  WHERE  (`store_id`='"+erjm[1]+"');";
			System.out.println(mkm);
			bw.write(mkm);
			bw.newLine();
		};
		
		bw.flush();
		bw.close();
		
		br.close();
		
	}

}
