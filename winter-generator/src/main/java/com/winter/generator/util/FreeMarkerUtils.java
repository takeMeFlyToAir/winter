package com.winter.generator.util;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.io.output.FileWriterWithEncoding;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * 类名:
 * 创建人: wdd
 * 创建时间: 2017/12/4
 */
public class FreeMarkerUtils {

    private static Configuration cfg = null;

    /**
     * 获取freemarker的配置*
     *
     * @param type freemarker本身支持classpath 1,目录和从ServletContext获取 2.
     * @return 返回Configuration对象
     */
    private static Configuration getConfiguration(int type) {
        if (null == cfg) {
            cfg = new Configuration(Configuration.VERSION_2_3_23);

            TemplateLoader templateLoader = new ClassTemplateLoader(FreeMarkerUtils.class, "/templates/generator");

            cfg.setTemplateLoader(templateLoader);

            cfg.setLocale(Locale.getDefault());

            cfg.setEncoding(Locale.getDefault(), "UTF-8");

            // 设置异常处理器//这样的话就可以${a.b.c.d}即使没有属性也不会出错
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

        }

        return cfg;
    }

    public static boolean generate(Map<String, Object> data, String templateFile, String targetFile) {
        FileWriterWithEncoding out = null;
        try {
            // 创建Template对象
            Configuration cfg = FreeMarkerUtils.getConfiguration(1);
            Template template = cfg.getTemplate(templateFile);
            File file = new File(targetFile);
            file.getParentFile().mkdirs();
            if (file.exists()) {
                file.delete();
            }
            // 生成静态页面
            out = new FileWriterWithEncoding(targetFile, "UTF-8");
            template.process(data, out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (TemplateException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
