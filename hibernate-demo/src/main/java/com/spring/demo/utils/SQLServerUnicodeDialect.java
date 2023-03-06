
package com.spring.demo.utils;

import java.sql.Types;

import org.hibernate.dialect.SQLServer2008Dialect;

public class SQLServerUnicodeDialect extends SQLServer2008Dialect {

	public SQLServerUnicodeDialect() {
		super();
		registerColumnType(Types.NUMERIC, "decimal($1,0)");
		registerColumnType(Types.BIGINT, "decimal($1,0)");
		registerColumnType(Types.DOUBLE, "decimal($p,$s)");
	}
}
