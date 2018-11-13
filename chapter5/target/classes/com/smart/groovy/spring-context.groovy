import com.smart.groovy.LogDao
import com.smart.groovy.LogonService
import com.smart.groovy.UserDao
import com.smart.groovy.XmlUserDao
import com.smart.groovy.DbUserDao
import org.springframework.core.io.ClassPathResource

beans{
	//声明context命名空间
	xmlns context:"http://www.springframework.org/schema/context"
	
	//与注解混合使用，定义注解Bean扫描包路径
	context.'component-scan'('base-package':"com.smart.groovy"){
	
		//排除不需要扫描的包路径
		'exclude-filter'('type':"aspectj", 'expression':"com.smart.xml.*")
	}
	//读取app-conf.properties配置文件
	def stream;
	def config = new Properties();
	try{
		stream = new ClassPathResource('conf/app-conf.properties').inputStream
		config.load(stream);
	}finally{
		if(stream!=null){
			stream.close()
		}
	}
	//配置无参构造函数Bean
	logDao(LogDao){
		bean->
			bean.scope="prototype"
			bean.initMethod="init"
			bean.destroyMethod="destory"
			bean.lazyInit=true
	}
	
	//根据条件注入Bean
	if("db"==config.get("dataProvider")){
		userDao(DbUserDao)
	}else{
		userDao(XmlUserDao)
	}
	
	//配置有参构造函数注入Bean,参数是userDao
	logonService(LogonService,userDao){
		logDao=ref("logDao")//配置属性注入，引用Groovy定义Bean
		mailService = ref("mailService")//配置属性注入，引用定义注解
	}
}