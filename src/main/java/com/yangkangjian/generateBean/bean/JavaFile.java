package com.yangkangjian.generateBean.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.Logger;

import com.yangkangjian.generateBean.util.FileUtils;
import com.yangkangjian.generateBean.util.ProjectUtils;

/**
 * 此类代表一个生成一个Java类
 * 
 * @author Ubuntu
 *
 */
public class JavaFile {
	private static Logger log = Logger.getLogger(JavaFile.class);

	private String fileName;
	private Table table;
	private List<BeanField> fields;
	private List<BeanMethod> methods;

	private JavaFile() {
	}

	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * 根据Table信息将一个构建一个JavaFile文件实例，该实例是对存在磁盘上的一个.java文件的描述，如要生成，得到实例后调用
	 * bulidJavaFile方法;
	 * 
	 * @param table
	 * @return
	 */
	public static JavaFile bulid(Table table) {
		log.debug("构建JavaFile对象开始");
		JavaFile javaFile = new JavaFile();
		javaFile.table = table;
		javaFile.fileName = ProjectUtils.generateClassName(table.getName(), null);
		log.info("JavaFileName：" + javaFile.fileName);
		List<Column> columns = table.getColumns();
		int size = columns.size();
		log.info("字段数量:" + size);
		List<BeanField> fields = new ArrayList<BeanField>(size);
		// set和get方法
		List<BeanMethod> methods = new ArrayList<BeanMethod>(size);
		for (int i = 0; i < size; i++) {
			Column column = columns.get(i);
			BeanField field = new BeanField("private", column.getType(),
					ProjectUtils.generateFieldName(column.getName(), "_"));
			BeanMethod method = new BeanMethod("public", column.getType(),
					ProjectUtils.generateMehtodName(column.getName(), "_"));
			method.setParameterName(new String[] { field.getName() });
			fields.add(field);
			methods.add(method);
			log.info("构建字段:" + ToStringBuilder.reflectionToString(field, ToStringStyle.SIMPLE_STYLE));
			log.info("构建方法:" + ToStringBuilder.reflectionToString(method, ToStringStyle.SIMPLE_STYLE));
		}
		javaFile.fields = fields;
		javaFile.methods = methods;
		log.debug("构建JavaFile对象结束");
		return javaFile;
	}

	private BeanMethod generateBeanMethod(Column column) {
		return null;
	}

	private BeanField generateBeanField(Column column) {
		return null;
	}

	public void bulidJavaBeanFile() {
		log.info("构建JavaBean文件开始....");
		log.debug("fileNmae=" + fileName);
		if (StringUtils.isEmpty(fileName)) {
			log.error("fileName为空");
			throw new RuntimeException("fileName为空");
		}
		int fieldSize = fields.size();
		int methodSize = methods.size();
		log.debug("fieldSize=" + fieldSize);
		log.debug("methodSize=" + methodSize);
		if (fieldSize == 0 || methodSize == 0) {
			log.error("没有可构建的字段和方法");
			throw new RuntimeException("没有可构建的字段和方法");
		}
		try {
			String path = "D:" + File.separator + "temp" + File.separator + fileName + ".java";
			FileUtils.createFile(path);
			start(path);
		} catch (IOException e) {
			log.error("IO异常", e);
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error("未知异常", e);
			throw new RuntimeException(e);
		}
		log.info("构建JavaBean文件结束....");
	}

	private void start(String path) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			throw new FileNotFoundException("没有找到文件:" + file.getPath());
		}
		int fl = fields.size(), ml = methods.size();
		FileWriter writer = new FileWriter(file);
		writer.write("public class " + fileName + "{");
		writer.write("\n");
		writer.write("\n");

		for (int i = 0; i < fl; i++) {
			BeanField field = fields.get(i);
			writer.write("\t");
			writer.write(
					field.getModifierName() + "	" + field.getClazz().getSimpleName() + "  " + field.getName() + ";");
			writer.write("\n");
			writer.write("\n");
		}

		writer.write("\n");

		for (int i = 0; i < ml; i++) {
			BeanMethod method = methods.get(i);
			String modifier = method.getModifierName();
			String type = method.getReturnType().getSimpleName();
			String name = method.getName();
			String paramName=method.getParameterName()[0];
			writer.write("\t");
			writer.write(modifier + " void " + "set" + name + "(" + type + " " + paramName + "){");
			writer.write("\n");
			writer.write("\t\t");
			writer.write("this." + paramName + "=" + paramName + ";");
			writer.write("\n");
			writer.write("\t");
			writer.write("}");
			writer.write("\n");

			writer.write("\t");
			writer.write(modifier + " " + type + " " + "get" + name + "(){");
			writer.write("\n");
			writer.write("\t\t");
			writer.write("return" + " " + "this." + paramName + ";");
			writer.write("\n");
			writer.write("\t");
			writer.write("}");
			writer.write("\n");
		}

		writer.write("}");
		writer.flush();
		writer.close();
	}

	public enum JavaElementType {
		FIELD, METHOD, CLASS_NAME
	}
}
