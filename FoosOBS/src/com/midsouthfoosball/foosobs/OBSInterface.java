/**
Copyright 2019 Hugh Garner
Permission is hereby granted, free of charge, to any person obtaining a copy 
of this software and associated documentation files (the "Software"), to deal 
in the Software without restriction, including without limitation the rights 
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
copies of the Software, and to permit persons to whom the Software is 
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in 
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR 
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
OTHER DEALINGS IN THE SOFTWARE.  
**/
package com.midsouthfoosball.foosobs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OBSInterface {
	
	private String txtFilePath = "c:" + File.separator + "Temp";
	private String tableName;
	private String fileName;
	private String theFileName;

	public void setFilePath(String filePath) {
		this.txtFilePath = filePath;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getFilePath() {return this.txtFilePath;}
	public String getTableName() {return this.tableName;}

	public void setContents(String whichFile, String theContents) throws IOException {
		if (tableName.isEmpty()) {
			fileName = whichFile;
		} else {
			fileName = tableName + "_" + whichFile;
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(txtFilePath + File.separator + fileName));
		writer.write(theContents);
		writer.close();
	}

	public String getContents(String whichFile) throws IOException {
		String theContents = null;
		if (tableName.isEmpty()) {
			theFileName = txtFilePath + File.separator + whichFile;
		} else {
			theFileName = txtFilePath + File.separator + tableName + "_" + whichFile;
		}
		File theFile = new File(theFileName); 
		if (!theFile.exists()) {
			theContents = null;
		} else {
			try {
				BufferedReader br = new BufferedReader(new FileReader(theFileName));
				theContents = br.readLine();
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.print("io exception!");
			}
		}
		return theContents;
	}
}
