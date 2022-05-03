package kr.human.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Ex12_TypeAdapter {
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Product{
		private int 	id;
		private String 	name;
		private transient String 	password; // 직렬화에서 제외하라!!!!
		private Date   	date;
	}
	
	public static void main(String[] args) {
		/*
		Gson gson = new Gson();
		Product product = new Product(1, "컴퓨터","1234", new Date());
		System.out.println(product);
		System.out.println(gson.toJson(product));
		*/
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Product.class, new ProductAdapter()); // 어뎁터 등록
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		Product product = new Product(1, "컴퓨터","1234", new Date());
		System.out.println(gson.toJson(product));
		
		// 파일에서 읽기
		try(FileReader fr = new FileReader("src/main/resources/Product.json")){
			Product p = gson.fromJson(fr, Product.class);
			System.out.println(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// Type Adapter란 저장/읽기시 모양을 변경을 줄 수 있다.
	// TypeAdapter 추상클래스를 상속받아 만든다.
	public static class ProductAdapter extends TypeAdapter<Product>{

		@Override // 저장할때 작동
		public void write(JsonWriter out, Product value) throws IOException {
			out.beginObject();
			out.name("id");
			out.value(value.getId());
			out.name("name");
			out.value(value.getName());
			out.name("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
			out.value(sdf.format(value.getDate())); // 저장 형식 변경
			out.endObject();
		}

		@Override // 읽을때 작동
		public Product read(JsonReader in) throws IOException {
			Product product = new Product();
			in.beginObject();
			String fieldName = "";
			while(in.hasNext()) {
				JsonToken token = in.peek(); // 1개 읽기
				if(token.equals(JsonToken.NAME)) { // Key라면
					fieldName = in.nextName(); // 이름을 읽고
					token = in.peek();
					switch (fieldName) {
					case "id":
						product.setId(in.nextInt());
						break;
					case "name":
						product.setName(in.nextString());
						break;
					case "date":
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
						try {
							product.setDate(sdf.parse(in.nextString()));
						} catch (ParseException | IOException e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
			in.endObject();
			return product;
		}
	}
}
