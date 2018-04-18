package person.zxl.quart_learn.boot.mybatis.provider;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

public class Provider extends MapperTemplate {

	public Provider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	public String insertRecordInit(MappedStatement ms) {
		final Class<?> entityClass = getEntityClass(ms);
		EntityTable table = EntityHelper.getEntityTable(entityClass);
		// �?始拼sql
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ");
		sql.append(table.getName());
		sql.append("(");
		boolean first = true;
		for (EntityColumn column : table.getEntityClassColumns()) {
			if (column.isId()) {
				continue;
			}
			if (!first) {
				sql.append(",");
			}
			sql.append(column.getColumn());
			first = false;
		}
		sql.append(") values(");
		first = true;
		for (EntityColumn column : table.getEntityClassColumns()) {
			if (column.isId()) {
				continue;
			}
			if (!first) {
				sql.append(",");
			}
			first = false;
		}
		sql.append(")");

		return sql.toString();
	}
}
