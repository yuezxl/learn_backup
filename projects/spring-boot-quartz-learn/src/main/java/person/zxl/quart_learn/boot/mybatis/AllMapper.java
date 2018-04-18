package person.zxl.quart_learn.boot.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface AllMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
