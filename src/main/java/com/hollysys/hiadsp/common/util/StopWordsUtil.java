package com.hollysys.hiadsp.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StopWordsUtil
{
	private static Map<String, String> stopWordsMap = new HashMap<String, String>();

	/**
	 * 初始化停词工具类
	 * 
	 * @param dictionaryPath
	 *            停词路径
	 * @return
	 * 
	 * @throws IOException 
	 */
	public synchronized static Map<String, String> getInstance(
			String dictionaryPath) throws IOException
	{
		if (stopWordsMap.isEmpty())
		{
			stopWordsMap = readStopWords(dictionaryPath);
		}

		return stopWordsMap;
	}

	/**
	 * 读入停词
	 * 
	 * @return 停词表
	 * 
	 * @throws IOException 
	 */
	private static Map<String, String> readStopWords(String dictionaryPath) throws IOException
	{
		Map<String, String> stopWords = new HashMap<String, String>();

		stopWords = FileUtil.read2Map(dictionaryPath);

		return stopWords;
	}
}
