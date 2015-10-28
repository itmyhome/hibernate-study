package com.itmyhome.divideAndConquer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SequentialNAV extends AbstractNAV {
	public double computeNetAssetValue(final List<String> stocks)
			throws IOException {
		double netAssetValue = 0.0;
		for (String ticker : stocks) {
			netAssetValue +=  SinaFinance.getPrice(ticker);
		}
		return netAssetValue;
	}

	public static void main(final String[] args) throws ExecutionException,
			IOException, InterruptedException {
		new SequentialNAV().timeAndComputeValue();
	}
}