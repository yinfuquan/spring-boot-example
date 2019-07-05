package com.yin.springbootbeetlsql.config;

import org.beetl.sql.core.SQLManager;

public class SqlKit {
	static SQLManager $;

	private SqlKit() {
	}

	public static SQLManager $() {
		return $;
	}

	public static void $(SQLManager sqlManager) {
		$ = sqlManager;
	}

	public static<T> T mapper(Class<T> mapperInterface) {
		return $().getMapper(mapperInterface);
	}
}