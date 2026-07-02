package com.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SqlLoader {

	public static Map<String, String> loadQueries(String resourcePath) throws Exception {

		Map<String, String> queries = new LinkedHashMap<>();

		InputStream inputStream = SqlLoader.class.getClassLoader().getResourceAsStream(resourcePath);

		if (inputStream == null) {
			throw new RuntimeException("SQL file not found: " + resourcePath);
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		String line;
		String currentQuery = null;
		StringBuilder sql = new StringBuilder();

		while ((line = reader.readLine()) != null) {

			line = line.trim();

			if (line.startsWith("-- name:")) {

				if (currentQuery != null) {
					queries.put(currentQuery, sql.toString().trim());
				}

				currentQuery = line.substring("-- name:".length()).trim();
				sql.setLength(0);

			} else {

				sql.append(line).append("\n");

			}
		}

		if (currentQuery != null) {
			queries.put(currentQuery, sql.toString().trim());
		}

		reader.close();

		return queries;
	}

}