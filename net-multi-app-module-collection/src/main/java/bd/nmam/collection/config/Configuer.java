package bd.nmam.collection.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class Configuer {
	@Value("${spring.datasource.name}")
	private String name;
	@Value("${spring.datasource.driver-class-name}")
	private String driver_class_name;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.druid.validationQuery}")
	private String validationQuery;
	@Value("${spring.datasource.druid.initialSize}")
	private String initialSize;
	@Value("${spring.datasource.druid.maxActive}")
	private String maxActive;
	@Value("${spring.datasource.druid.minIdle}")
	private String minIdle;
	@Value("${spring.datasource.druid.maxWait}")
	private String maxWait;
	@Value("${spring.datasource.druid.testOnBorrow}")
	private String testOnBorrow;
	@Value("${spring.datasource.druid.testOnReturn}")
	private String testOnReturn;
	@Value("${spring.datasource.druid.testWhileIdle}")
	private String testWhileIdle;
	@Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
	private String timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
	private String minEvictableIdleTimeMillis;
	@Value("${spring.datasource.druid.removeAbandoned}")
	private String removeAbandoned;
	@Value("${spring.datasource.druid.removeAbandonedTimeout}")
	private String removeAbandonedTimeout;
	@Value("${spring.datasource.druid.logAbandoned}")
	private String logAbandoned;
	private static DataSource dataSource;
	//-----------------------------------------------------------------------
	@Value("${spring.redis.timeout}")
	private long redis_timeout;
	@Value("${spring.redis.nodes}")
	private String redis_nodes;
	@Value("${spring.redis.maxIdle}")
	private int redis_maxIdle;
	@Value("${spring.redis.maxActive}")
	private int redis_maxActive;
	@Value("${spring.redis.maxTotal}")
	private int redis_maxTotal;
	@Value("${spring.redis.maxWaitMillis}")
	private long redis_maxWaitMillis;
	private static JedisCluster jedisCluster;
	//-----------------------------------------------------------------------
    @Bean(name = "rediSource")
    public JedisCluster initJedisCluster(){
    	String[] _nodes = redis_nodes.trim().split(",");
    	HashSet<HostAndPort> nodes = new HashSet<>();
    	for(String s : _nodes){
    		String[] hp = s.trim().split(":");
    		nodes.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
    	}
    	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    	jedisPoolConfig.setMaxIdle(redis_maxIdle);
    	jedisPoolConfig.setMaxTotal(redis_maxTotal);
    	jedisPoolConfig.setMaxWaitMillis(redis_maxWaitMillis);
    	JedisCluster jc = new JedisCluster(nodes, jedisPoolConfig);
    	Configuer.setJedisCluster(jc);
    	return jc;
    }
	@Bean(name = "dataSourceDruid")
	public DataSource initDataSourceDruid() throws Exception {
		Map<String, String> config = new HashMap<String, String>();
		config.put("driver_class_name", driver_class_name);
		config.put("url", url);
		config.put("username", username);
		config.put("password", password);
		config.put("removeAbandoned", removeAbandoned);
		config.put("minEvictableIdleTimeMillis", minEvictableIdleTimeMillis);
		config.put("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis);
		config.put("testWhileIdle", testWhileIdle);
		config.put("testOnReturn", testOnReturn);
		config.put("testOnBorrow", testOnBorrow);
		config.put("maxWait", maxWait);
		config.put("minIdle", minIdle);
		config.put("maxActive", maxActive);
		config.put("validationQuery", validationQuery);
		config.put("initialSize", initialSize);
		config.put("removeAbandonedTimeout", removeAbandonedTimeout);
		config.put("logAbandoned", logAbandoned);
		DataSource ds = DruidDataSourceFactory.createDataSource(config);
		Configuer.setDataSource(ds);
		return ds;
	}
	public static DataSource getDataSource() {
		return dataSource;
	}
	public static void setDataSource(DataSource dataSource) {
		Configuer.dataSource = dataSource;
	}
	public static JedisCluster getJedisCluster() {
		return jedisCluster;
	}
	public static void setJedisCluster(JedisCluster jedisCluster) {
		Configuer.jedisCluster = jedisCluster;
	}
}
