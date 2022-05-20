package kr.human.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
class Some{
	int x,y;
}

public class Test {
	public static void main(String[] args) {
		IntArrayPrint.print(new Integer[] {1,2,3,4,5});
		StringArrayPrint.print("한놈,두식이,석삼".split(",")); 
		System.out.println();
		
		ArrayPrint.<Integer>print(new Integer[] {1,2,3,4,5}); 
		ArrayPrint.<String>print("한놈,두식이,석삼".split(",")); 
		ArrayPrint.<Some>print(new Some[] {new Some(1, 2),new Some(3, 4)});
	}
}
