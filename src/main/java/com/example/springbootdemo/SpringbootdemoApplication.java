package com.example.springbootdemo;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class SpringbootdemoApplication {

	private static final Logger LOGGER = Logger.getLogger(SpringbootdemoApplication.class);

	private static final String PROJECT_PATH = System.getProperty("user.dir");
	private static String IO_TMP_PATH = PROJECT_PATH.concat("/data/tmp");

	/**
	 * 检查并清空 IO 临时文件夹
	 * @throws IOException
	 */
	private static void checkAndCleanIoTmp() throws IOException {
		File ioTmpDirectory = new File(IO_TMP_PATH);
		if (!ioTmpDirectory.exists() || !ioTmpDirectory.isDirectory()) {
			ioTmpDirectory.mkdirs();
			LOGGER.info(String.format("创建 IO 临时文件上传的文件目录：%s", IO_TMP_PATH));
		} else {
			LOGGER.info("IO 临时文件上传的文件目录已经存在");
		}
		FileUtils.cleanDirectory(ioTmpDirectory);
		System.setProperty("java.io.tmpdir", IO_TMP_PATH);
	}

	public static void main(String[] args) throws Exception {
		checkAndCleanIoTmp();
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}
