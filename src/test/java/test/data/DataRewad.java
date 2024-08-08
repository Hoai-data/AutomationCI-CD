package test.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;


import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataRewad {
	public List<HashMap<String, String>> getJsondata() throws IOException {
		//lay du lieu tu tep purcherOrder de gan vo 
		
		String jsonContendv =  FileUtils.readFileToString(new File(System.getProperty("user.dir") +"\\src\\test\\java\\test\\data\\purcharseOrder.json"),StandardCharsets.UTF_8 );
	//Kết quả là data sẽ là một danh sách chứa các HashMap, trong đó mỗi HashMap chứa các cặp khóa-giá trị kiểu String.
		ObjectMapper mapper =  new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContendv, new TypeReference<List<HashMap<String, String>>>() {
		});
	//
		return data;
	}

}
