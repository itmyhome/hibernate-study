package com.itmyhome.divideAndConquer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class AbstractNAV {
	public static List<String> readTickers() throws IOException {
//		final BufferedReader reader = new BufferedReader(new FileReader(
//				"G:\\gitRepository\\hibernate-study\\src\\main\\java\\com\\itmyhome\\divideAndConquer\\stocks.txt"));
		final BufferedReader reader = new BufferedReader(new InputStreamReader(AbstractNAV.class.getResourceAsStream("stocks.txt")));
		final List<String> stocks = new ArrayList<String>();

		String stockInfo = null;
		while ((stockInfo = reader.readLine()) != null) {

			stocks.add(stockInfo);
		}

		return stocks;
	}

	public void timeAndComputeValue() throws ExecutionException,
			InterruptedException, IOException {
		final long start = System.nanoTime();

		final List<String> stocks = readTickers();
		final double nav = computeNetAssetValue(stocks);

		final long end = System.nanoTime();

		final String value = new DecimalFormat("$##,##0.00").format(nav);
		System.out.println("Your net asset value is " + value);
		System.out.println("Time (seconds) taken " + (end - start) / 1.0e9);
	}

	public abstract double computeNetAssetValue(
			final List<String> stocks) throws ExecutionException,
			InterruptedException, IOException;
}
