package kr.human.net1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


public class GsonEx03 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		try {
			// Map을 JSON 객체 만들기
			Map<String,String > map = new HashMap<>();
			map.put("name","한사람");
			map.put("age","33");
			map.put("gender","true");
			map.put("height","178.9");
			
			System.out.println(map);

			//문자열로 만들기
			String str = gson.toJson(map);
			System.out.println(str);
			//저장하기
			FileWriter fw = new FileWriter("src/main/resources/person.json");
			fw.write(str);
			//fw.flush();
			fw.close();
			
			//읽기
			Map map2 = gson.fromJson(str, Map.class
					..args...args...args..args...args..args...args..args...args....args...args....args.0)0;0
0	0	0	0S0y0s0t0e0m0.0o0u0t0.0p0r0i0n0t0l0n0(0m0a0p020)0;0
0	0
0	0	0}0 0c0a0t0c0h0 0(0J0s0o0n0S0y0n0t0a0x0E0x0c0e0p0t0i0o0n0 0|0 0J0s0o0n0I0O0E0x0c0e0p0t0i0o0n0 0|0 0I0O0E0x0c0e0p0t0i0o0n0 0e0)0 0{0
0	0	0	0e0.0p0r0i0n0t0S0t0a0c0k0T0r0a0c0e0(0)0;0
0	0	0}0
0	0}0
0}0
000000000000000000000000000000000000