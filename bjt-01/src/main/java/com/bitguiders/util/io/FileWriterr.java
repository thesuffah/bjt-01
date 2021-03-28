package com.bitguiders.util.io;

import java.io.File;

public class FileWriterr {

	public void write() {
		System.out.println("test");
		String path = "D:\\workspaces\\bitguiders\\training\\bjt-01\\bjt-01\\src\\com\\bitguiders\\util\\io\\output\\o3\\e2";
		File file = new File(path);
		file.mkdirs();
	}
	public static void main(String[] args) {
		FileWriterr writerr = new FileWriterr();
		writerr.write();
	}

}
