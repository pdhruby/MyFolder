package kr.human.java0502;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HanjaEx {
	public static void main(String[] args) {
		List<HanjaVO> hanjaList = readHanja();
		System.out.println(hanjaList.size() + "개 읽음");
		Map<String, HanjaVO> map = new HashMap<>(); // 맵으로 저장
		for(HanjaVO vo : hanjaList) {
			map.put(vo.getH(), vo);
		}
		Scanner sc = new Scanner(System.in);
		String key = "";
		do {
			System.out.print("찾는 한자는(0은 종료)");
			key = sc.nextLine();
			if(key.charAt(0) == '0') break;
			if(map.containsKey(key)) {
				System.out.println("찾은 한자 : " + map.get(key));
			}else {
				System.out.println(key + "는 천자문에 없는 한자입니다.");
			}
		}while(!key.equals("0"));
		sc.close();
	}
	// hanja.txt파일을 읽어 리턴하는 메서드
	private static List<HanjaVO> readHanja(){
		List<HanjaVO> hanjaList = new ArrayList<>();
		try {
			List<String> lineList = Files.readAllLines(Paths.get("src/main/resources/chunja.txt"));
			for(String line : lineList ) {
				String[] ar = line.split("\\|");
				HanjaVO vo = new HanjaVO();
				vo.setIndex(Integer.parseInt(ar[0]));
				vo.setH(ar[1]);
				vo.setK(ar[2]);
				vo.setM(ar[3]);
				hanjaList.add(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hanjaList;
	}
}
