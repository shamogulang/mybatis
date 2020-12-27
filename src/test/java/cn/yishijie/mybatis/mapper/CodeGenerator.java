package cn.yishijie.mybatis.mapper;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    private static Logger logger = LoggerFactory.getLogger(CodeGenerator.class);
    public static void main(String[] args) throws Exception{
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        // 读取配置文件
        InputStream stream = CodeGenerator.class.getResourceAsStream("/generator/codeGenerator.xml");
        Configuration config = cp.parseConfiguration(stream);
        List<Context> contexts = config.getContexts();
        if(CollectionUtils.isEmpty(contexts)){
            logger.info("代码生成器的context为空！");
            return;
        }
        // 设置代码生成路径,modelOnly是否只生生成数据entity和xml
        if(!setCodePath(contexts, "true")){
            return;
        }
        // 支持覆盖原来生成的代码
        DefaultShellCallback callback = new DefaultShellCallback(Boolean.TRUE);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // 出发生成代码的动作
        myBatisGenerator.generate(null);
        if(!warnings.isEmpty()){
            for (String warning : warnings) {
                logger.warn("代码生成警告信息：{}", warning);
            }
        }
    }

    public static boolean setCodePath(List<Context> contexts, String modelOnly){
        // 获取项目的根路径
        String contextPath = System.getProperty("user.dir");
        contextPath = contextPath.replace("\\", "/");
        Context context = contexts.get(0);
        JavaClientGeneratorConfiguration javaCli = context.getJavaClientGeneratorConfiguration();
        JavaModelGeneratorConfiguration javaModelGen = context.getJavaModelGeneratorConfiguration();
        SqlMapGeneratorConfiguration sqlMapGen= context.getSqlMapGeneratorConfiguration();
        javaCli.setTargetProject(String.format(javaCli.getTargetProject(), contextPath));
        sqlMapGen.setTargetProject(String.format(sqlMapGen.getTargetProject(), contextPath));
        javaModelGen.setTargetProject(String.format(javaModelGen.getTargetProject(), contextPath));

        List<TableConfiguration> tableConfigurations = context.getTableConfigurations();
        if(CollectionUtils.isEmpty(tableConfigurations)){
            logger.error("没有需要生成的数据表，请指定相应的数据表！");
            return Boolean.FALSE;
        }

        for (TableConfiguration tableConfiguration : tableConfigurations) {
            tableConfiguration.addProperty("modelOnly", modelOnly);
        }

        return Boolean.TRUE;
    }
}
