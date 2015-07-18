package com.service;

import java.io.IOException;
import java.util.List;


public interface CVSService {
	public void writeListToCVSFile(List<List> list, String filePath) throws IOException;
}
