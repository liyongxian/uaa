package com.hollysys.hiadsp.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUtil
{
	public static Map<String, String> read2Map(String filePath) throws IOException
	{
		Map<String, String> stopWordMap = new HashMap<String, String>();

		File file = new File(filePath);
		BufferedReader reader = null;

		try
		{
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;

			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null)
			{
				stopWordMap.put(tempString.trim(), "");
			}
			reader.close();
		}
		finally
		{
			if (reader != null)
			{
				reader.close();
			}
		}

		return stopWordMap;
	}
}
