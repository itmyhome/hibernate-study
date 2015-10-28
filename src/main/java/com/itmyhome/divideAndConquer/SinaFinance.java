package com.itmyhome.divideAndConquer;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SinaFinance {
	public static double getPrice(final String ticker) throws IOException {
		final URL url = new URL("http://hq.sinajs.cn/list=" + ticker);

		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				url.openStream(), "gbk"));

		final String data = reader.readLine();
		final String[] dataItems = data.split(",");
		//第九个成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万
		final double priceIsTheLastValue = Double.valueOf(dataItems[9]);
		return priceIsTheLastValue;
	}
}
